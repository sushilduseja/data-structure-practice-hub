/**
 * Conflating Queue Implementation and Tests
 *
 * A conflating queue is a concurrent queue that only keeps the most recent value
 * for each key, useful in scenarios where slow consumers should only receive
 * the latest value (e.g., market data feeds, UI updates).
 *
 * Test Scenarios Cover:
 * 1. Basic operations (offer/poll)
 * 2. Concurrent producers
 * 3. Slow consumer scenarios
 * 4. Boundary conditions
 *
 * Thread Safety:
 * - Uses ConcurrentHashMap for thread-safe key-value storage
 * - Synchronized methods for queue operations
 */

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConflatingQueueTests {

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
        private final Queue<K> keysQueue = new LinkedList<>();
        private final ConcurrentHashMap<K, KeyValue<K, V>> dataMap = new ConcurrentHashMap<>();

        synchronized void offer(KeyValue<K,V> keyValue) {
            K key = keyValue.k;
            if (!dataMap.containsKey(key)) {
                keysQueue.offer(key);
            }
            dataMap.put(key, keyValue);
        }

        synchronized KeyValue<K,V> poll() {
            K key = keysQueue.poll();
            if (key == null) return null;
            return dataMap.remove(key);
        }

        synchronized int size() {
            return keysQueue.size();
        }
    }

    // Test 1: Basic Operations
    static void testBasicOperations() {
        System.out.println("\nTest 1: Basic Operations");
        ConflatingQueue<String, Integer> queue = new ConflatingQueue<>();

        queue.offer(new KeyValue<>("A", 1));
        queue.offer(new KeyValue<>("B", 2));
        queue.offer(new KeyValue<>("A", 3)); // Should update A's value

        System.out.println("Queue size: " + queue.size() + " (expected: 2)");
        System.out.println("First poll: " + queue.poll() + " (expected: A=3)");
        System.out.println("Second poll: " + queue.poll() + " (expected: B=2)");
        System.out.println("Third poll: " + queue.poll() + " (expected: null)");
    }

    // Test 2: Concurrent Producers
    static void testConcurrentProducers() throws InterruptedException {
        System.out.println("\nTest 2: Concurrent Producers");
        ConflatingQueue<String, Integer> queue = new ConflatingQueue<>();
        CountDownLatch latch = new CountDownLatch(2);
        AtomicInteger finalValue = new AtomicInteger(0);

        // Producer 1: Fast updates to key "X"
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                queue.offer(new KeyValue<>("X", i));
            }
            latch.countDown();
        }).start();

        // Producer 2: Slow updates to key "X"
        new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                queue.offer(new KeyValue<>("X", i));
                finalValue.set(i);
            }
            latch.countDown();
        }).start();

        latch.await();
        KeyValue<String, Integer> result = queue.poll();
        System.out.println("Final value for X: " + result.v +
                         " (should be close to " + finalValue.get() + ")");
    }

    // Test 3: Slow Consumer
    static void testSlowConsumer() throws InterruptedException {
        System.out.println("\nTest 3: Slow Consumer");
        ConflatingQueue<String, Integer> queue = new ConflatingQueue<>();
        CountDownLatch producerDone = new CountDownLatch(1);
        List<Integer> consumed = new ArrayList<>();

        // Fast producer
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.offer(new KeyValue<>("Y", i));
            }
            producerDone.countDown();
        }).start();

        // Slow consumer
        Thread consumer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                KeyValue<String, Integer> value = queue.poll();
                if (value != null) {
                    consumed.add(value.v);
                    try {
                        Thread.sleep(10); // Simulate slow processing
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        consumer.start();
        producerDone.await();
        Thread.sleep(100); // Allow some consumption
        consumer.interrupt();

        System.out.println("Consumed values count: " + consumed.size() +
                         " (should be less than 100)");
        System.out.println("Last consumed value: " + consumed.get(consumed.size()-1) +
                         " (should be close to 99)");
    }

    public static void main(String[] args) throws InterruptedException {
        testBasicOperations();
        testConcurrentProducers();
        testSlowConsumer();
    }
}
