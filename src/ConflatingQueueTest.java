import java.util.*;
import java.util.concurrent.*;

/**
 Fill in the TODOs to make a conflating queue such that slow consumers only receive most recent value for a key
 */
public class ConflatingQueueTest {

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

        Queue<K> keysQueue = new LinkedList<>();
        ConcurrentHashMap<K,KeyValue<K, V>> dataMap = new ConcurrentHashMap<>();

        void offer(KeyValue<K,V> keyValue) {
            K key = keyValue.k;
            if(!dataMap.containsKey(key)){
                keysQueue.add(key);
            }
            dataMap.put(key,keyValue);
        }

        KeyValue<K,V> take() {
            K key = keysQueue.poll();
            return dataMap.remove(key);
        }

        boolean isEmpty() {
            return keysQueue.size() == 0;
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



//import java.util.*;
//
//class ConflatingQueueTest {
//    static class KeyValue<K, V> {
//        final K k;
//        final V v;
//        KeyValue(K k, V v) {
//            this.k = k;
//            this.v = v;
//        }
//        public String toString() {
//            return "[key=" + k + ", value=" + v + "]";
//        }
//    }
//
//    static class ConflatingQueue<K, V> {
//        List<KeyValue<K, V>> list;
//        public ConflatingQueue() {
//            this.list = new LinkedList<KeyValue<K, V>>();
//        }
//
//        void offer(KeyValue<K, V> keyValue) {
//            int mark = -1;
//
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i).k.equals(keyValue.k)) {
//                    mark = i;
//                }
//            }
//            if (mark != -1) {
//                list.remove(mark);
//                list.add(mark, keyValue);
//            } else {
//                this.list.add(keyValue);
//            }
//        }
//
//        KeyValue<K, V> take() {
//            if (!list.isEmpty()) {
//                KeyValue<K, V> res = list.get(0);
//                list.remove(res);
//                return res;
//            }
//            return null;
//        }
//
//        boolean isEmpty() {
//            return list.isEmpty();
//        }
//    }
//
//    public static void main(String... args) throws InterruptedException {
//
//        ConflatingQueue<String, Double> conflatingQueue = new ConflatingQueue<>();
//
//        check(true, conflatingQueue.isEmpty());
//        conflatingQueue.offer(new KeyValue<>("GBPUSD", 4d));
//        check(false, conflatingQueue.isEmpty());
//        conflatingQueue.offer(new KeyValue<>("EURGBP", 5d));
//        check(false, conflatingQueue.isEmpty());
//        conflatingQueue.offer(new KeyValue<>("GBPUSD", 3d));
//        check(false, conflatingQueue.isEmpty());
//        check(new KeyValue<>("GBPUSD", 3d), conflatingQueue.take());
//        check(false, conflatingQueue.isEmpty());
//        check(new KeyValue<>("EURGBP", 5d), conflatingQueue.take());
//        check(true, conflatingQueue.isEmpty());
///*
//        //check it blocks when empty
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        Runnable r = () -> {
//            conflatingQueue.take();
//            countDownLatch.countDown();
//        };
//        Thread t = new Thread(r);
//        countDownLatch.await(2, TimeUnit.SECONDS);
//        t.start();
//        check(true, countDownLatch.getCount() == 1);*/
//        System.out.println("All ok");
//
//    }
//
//    private static <K, V> void check(KeyValue<K, V> expected, KeyValue<K, V> actual) {
//        if (expected.k.equals(actual.k) && expected.v.equals(actual.v)) {
//
//        } else {
//            throw new IllegalArgumentException("wrong KV [expected=" + expected + ", actual=" + actual + "]");
//        }
//    }
//
//    private static void check(boolean expected, boolean actual) {
//        if (expected != actual) {
//            throw new IllegalArgumentException("wrong boolean [expected=" + expected + "]");
//        }
//    }
//}
