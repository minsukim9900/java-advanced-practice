package thread.bounded.main;

import thread.bounded.*;

import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ConsumerFirstBoundedMain {
    public static void main(String[] args) {
        // 1BoundedQueue 선택
        BoundedQueue queue = new BoundedQueueV3(2);
        consumerFirst(queue);
    }

    private static void consumerFirst(BoundedQueue queue) {
        log("== [소비사 먼저 실행] 시작, " + queue.getClass().getSimpleName() + " ==");
        List<Thread> threads = new ArrayList<>();
        startConsumer(queue, threads);
        printAllState(queue, threads);
        startProducer(queue, threads);
        printAllState(queue, threads);
        log("== [소비사 먼저 실행] 종료, " + queue.getClass().getSimpleName() + " ==");
    }


    private static void startProducer(BoundedQueue queue, List<Thread> threads) {
        log("생산자 시작");

        for (int i = 1; i <= 3; i++) {
            Thread producer = new Thread(new ProducerTask(queue, "data" + i), "producer" + i);
            threads.add(producer);
            producer.start();
            sleep(100);
        }
    }

    private static void startConsumer(BoundedQueue queue, List<Thread> threads) {
        log("소비자 시작");
        for (int i = 1; i <= 3; i++) {
            Thread consumer = new Thread(new ConsumerTask(queue), "consumer" + i);
            threads.add(consumer);
            consumer.start();
            sleep(100);
        }
    }

    private static void printAllState(BoundedQueue queue, List<Thread> threads) {
        log("현재 상태 출력, 큐 데이터: " + queue);

        for (Thread thread : threads) {
            log(thread.getName() + ": " + thread.getState());
        }
    }
}
