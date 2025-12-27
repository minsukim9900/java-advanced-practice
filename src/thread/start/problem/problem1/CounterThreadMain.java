package thread.start.problem.problem1;


import static util.MyLogger.log;

public class CounterThreadMain {
    public static void main(String[] args) {
        log("main() start");

        CounterThread thread = new CounterThread();
        thread.start();

        log("main() end");
    }
}
