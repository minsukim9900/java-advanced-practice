package thread.sync.problem;

import static util.MyLogger.log;

public class SyncTest2Main {

    public static void main(String[] args) {
        MyCounter myCounter = new MyCounter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                myCounter.count();
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
        //
        // 정답은 1000, 지역변수는 스택 영역에 있고 이 메모리 공간은 다른 스레드와 공유하지 않는다.
    }

    private static class MyCounter {

        public void count() {
            int localValue = 0;
            for (int i = 0; i < 1000; i++) {
                localValue++;
            }
            log("결과: " + localValue);
        }
    }
}
