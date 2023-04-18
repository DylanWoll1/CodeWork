import java.util.Random;

public class QueueDriver implements QueueDriverInterface {

    private static final int QUEUE_SIZE = 10000;
    private static final int MAX_RANDOM_DEQUEUE = 100;

    public QueueInterface<String> createQueue(QueueType queueType, TestType testType) {
        QueueInterface<String> queue = null;

        switch (queueType) {
            case ArrayBasedQueue:
                queue = new ArrayBasedQueue<>();
                break;
            case LinkedQueue:
                queue = new LinkedQueue<>();
                break;
        }

        if (testType == TestType.Dequeue || testType == TestType.DequeueRandom) {
            for (int i = 1; i <= QUEUE_SIZE; i++) {
                queue.enqueue("String " + i);
            }
        }

        return queue;
    }

    public Object[] runTestCase(QueueType queueType, TestType queueTestType, int numberOfTimes) {
        Object[] results = new Object[numberOfTimes * 2 + 1];

        TestTimes testTimes = new TestTimes();

        for (int i = 0; i < numberOfTimes; i++) {
            QueueInterface<String> queue = createQueue(queueType, queueTestType);
            QueueInterface<String> queueCopy = copyQueue(queue);

            long startTime = System.nanoTime();

            switch (queueTestType) {
                case Enqueue:
                    for (int j = 1; j <= QUEUE_SIZE; j++) {
                        queue.enqueue("String " + j);
                    }
                    break;
                case Dequeue:
                    while (!queue.isEmpty()) {
                        queue.dequeue();
                    }
                    break;
                case DequeueRandom:
                    Random random = new Random();
                    int maxDequeue = Math.min(queue.size(), MAX_RANDOM_DEQUEUE);
				for (int j = 0; j < maxDequeue; j++) {
                        int index = random.nextInt(queue.size());
                        queue.dequeue(index);
                    }
                    while (!queue.isEmpty()) {
                        queue.dequeue();
                    }
                    assert queue.size() == 0 : "Queue still has elements remaining after DequeueRandom test";
                    break;
                    }

            long endTime = System.nanoTime();
            long testTime = endTime - startTime;
            testTimes.addTestTime(testTime);

            QueueInterface<String> queueAfterTest = copyQueue(queue);

            results[i * 2] = queueCopy;
            results[i * 2 + 1] = queueAfterTest;
        }

        results[numberOfTimes * 2] = testTimes;

        return results;
    }

    private QueueInterface<String> copyQueue(QueueInterface<String> queue) {
        QueueInterface<String> copy = null;

        if (queue instanceof ArrayBasedQueue) {
            copy = new ArrayBasedQueue<>();
        } else if (queue instanceof LinkedQueue) {
            copy = new LinkedQueue<>();
        }

        for (String element : queue) {
            copy.enqueue(element);
        }

        return copy;
    }
}

