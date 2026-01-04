package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class CasMainV2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());

        int resultValue1 = increamentAndGet(atomicInteger);
        System.out.println("resultValue1 = " + resultValue1);

        int resultValue2 = increamentAndGet(atomicInteger);
        System.out.println("resultValue2 = " + resultValue2);
    }

    private static int increamentAndGet(AtomicInteger atomicInteger) {
        int getValue = 0;
        boolean result;

        do {
            getValue = atomicInteger.get();
            log("getValue = " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result: " + result);
        } while(!result);

        return getValue + 1;
    }
}
