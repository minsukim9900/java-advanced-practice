package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV4 {

    public static void main(String[] args) throws InterruptedException {
        log("start");
        SumTask task1 = new SumTask(1, 50);

        Thread thread1 = new Thread(task1, "thread-1");

        thread1.start();

        thread1.join(1000);
        log(thread1.getState());

        log("task1.result: " + task1.result);
        log("end");
    }

    private static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result;


        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            result = cal(startValue, endValue);
            log("작업 완료");
        }

        private int cal(int startValue, int endValue) {
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
