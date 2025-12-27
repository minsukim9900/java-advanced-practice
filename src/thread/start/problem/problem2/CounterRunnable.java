package thread.start.problem.problem2;

import static util.MyLogger.log;

public class CounterRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            log("value: " + (i + 1));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
