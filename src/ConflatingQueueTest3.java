import java.util.*;
import java.util.concurrent.*;

/**
 Fill in the TODOs to make a conflating queue such that slow consumers only receive most recent value for a key
 */
public class ConflatingQueueTest3 {

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
        private Map<K, KeyValue<K, V>> entries = new ConcurrentHashMap<K, KeyValue<K, V>>();
        private List<K> keys = new ArrayList<K>();

        void offer(KeyValue<K,V> keyValue) {
            this.entries.put(keyValue.k, keyValue);
            keys.add(keyValue.k);
        }

        KeyValue<K,V> take() {
            K key = keys.remove(keys.size() -1);
            return entries.remove(key);
        }

        boolean isEmpty() {
            return entries.isEmpty();
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

        //check it blocks when empty
        /*CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable r = () -> {
            conflatingQueue.take();
            countDownLatch.countDown();
        };
        Thread t = new Thread(r);
        countDownLatch.await(2, TimeUnit.SECONDS);
        t.start();
        check(true, countDownLatch.getCount() == 1);*/

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
