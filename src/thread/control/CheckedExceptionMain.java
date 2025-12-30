package thread.control;

import util.ThreadUtils;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new CheckRunnable(), "CheckedExceptionMain");
        thread.start();
    }

    static class CheckRunnable implements Runnable {

        @Override
        public void run() {
            ThreadUtils.sleep(1000);
        }
    }
}
