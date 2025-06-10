import java.util.*;
import java.util.concurrent.*;

/**
 Fill in the TODOs to make a conflating queue such that slow consumers only receive most recent value for a key
 */
public class ConflatingQueueTest2 {

    static class KeyValue<K, V> {
        final K k;
        final V v;

        KeyValue(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public String toString() {
            return "[key=" + k + ", value=" + v + "]";
        }

        K getKey(){
            return k;
        }


        V getValue(){
            return v;
        }

        public boolean equals(Object o){
            if (o==null )
                return false ;

            if ( o.getClass().equals(this.getClass()) ){
                KeyValue keyVal = (KeyValue) o;
                if(keyVal.getKey().equals(this.getKey())){

                    return true;
                }

            }

            return false ;

        }

        public int hashcode(){
            return k.hashCode();
        }


    }

    static class ConflatingQueue<K, V> {
        LinkedBlockingQueue<K> blockingQueue= new LinkedBlockingQueue<K>();
        ConcurrentHashMap<K,KeyValue<K,V>> hashMap = new ConcurrentHashMap<K,KeyValue<K,V>>();

        boolean  offer(KeyValue<K,V> keyValue) {
            if(keyValue ==null ||  keyValue.getKey()==null)
                return false ;

            hashMap.put(keyValue.getKey(),keyValue);
            if(!blockingQueue.contains(keyValue.getKey()))
                blockingQueue.offer(keyValue.getKey());
            return true ;
        }

        KeyValue<K,V> take() throws InterruptedException{
            K key =blockingQueue.poll(2,TimeUnit.SECONDS);
            return hashMap.get(key);
        }

        boolean isEmpty() {
            return blockingQueue.isEmpty();

        }
    }

    public static void main(String... args) throws InterruptedException {

        ConflatingQueue<String, Double> conflatingQueue = new ConflatingQueue<>();

        check(true, conflatingQueue.isEmpty());
        conflatingQueue.offer(new KeyValue<>("GBPUSD", 4d));
        check(false, conflatingQueue.isEmpty());
        conflatingQueue.offer(new KeyValue<>("EURGBP", 5d));
        check(false, conflatingQueue.isEmpty());
        conflatingQueue.offer(new KeyValue<>("GBPUSD", 3d));
        check(false, conflatingQueue.isEmpty());
        check(new KeyValue<>("GBPUSD", 3d), conflatingQueue.take());
        check(false, conflatingQueue.isEmpty());
        check(new KeyValue<>("EURGBP", 5d), conflatingQueue.take());

        check(true, conflatingQueue.isEmpty());



        System.out.println("Correct implementation!");
    }

    private static<K,V> void check(KeyValue<K,V> expected, KeyValue<K,V> actual) {
        if (expected.k.equals(actual.k) && expected.v.equals(actual.v)) {

        } else {
            throw new IllegalArgumentException("wrong KV [expected=" + expected + ", actual=" + actual + "]");
        }
    }

    private static void check(boolean expected, boolean actual) {
        if (expected != actual) {
            throw new IllegalArgumentException("wrong boolean [expected=" + expected + "]");
        }
    }
}
