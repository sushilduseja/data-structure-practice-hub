import java.util.*;

/**
Fill in the TODOs to make a conflating queue such that slow consumers only receive most recent value for a key
*/
public class ConflatingQueueTest4 {

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

    }

    static class ConflatingQueue<K, V> {
      List<Map<K, V>> mapList = new ArrayList<>();
        void offer(KeyValue<K,V> keyValue) {
            for (Map<K, V> m : mapList) {
              if (m.containsKey(keyValue.k)) {
                mapList.remove(m);
              } 
            }

            Map<K, V> mtemp = new HashMap<>();
            mtemp.put(keyValue.k, keyValue.v);
            mapList.add(mtemp);

        }

        KeyValue<K,V> take() {
            KeyValue<K, V> keyValue = null;
            Map<K, V> mtemp = mapList.remove(mapList.size()-1);
            for (K k : mtemp.keySet()) {
              V v = mtemp.get(k);
              keyValue = new KeyValue<>(k, v);
            }

            return keyValue;
        }

        boolean isEmpty() {
            return mapList.size()==0;
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
