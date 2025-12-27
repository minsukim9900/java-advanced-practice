package thread.start.problem.problem1;

import static util.MyLogger.log;

public class CounterThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            log("value :" + (i + 1));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
