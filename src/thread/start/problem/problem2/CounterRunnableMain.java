package thread.start.problem.problem2;

public class CounterRunnableMain {
    public static void main(String[] args) {

        Thread thread = new Thread(new CounterRunnable());
        thread.start();
    }
}
