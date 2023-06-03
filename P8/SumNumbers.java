package P8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumNumbers {

    private static long value = 1000000000;
    private static long sum = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService eS = Executors.newFixedThreadPool(10);
        List<Future<Long>> fResults = new ArrayList<>();
        long valueDivBy10 = value / 10;
        for (int i = 0; i < 10; i++) {
            long from = valueDivBy10 * i + 1;
            long to = valueDivBy10 * (i + 1);
            PartialSum task = new PartialSum(from, to);
            Future<Long> fPartSum = eS.submit(task);
            fResults.add(fPartSum);
        }
        for (Future<Long> result : fResults) {
            sum += result.get();
        }
        eS.shutdown();
        System.out.println("Total sum = " + sum);
    }

}

class PartialSum implements Callable<Long> {

    long from;
    long to;
    long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    public Long call() {
        for (long i = from; i <= to; i++) {
            localSum += i;
        }
        System.out.println("Sum from " + from + " to " + to + " = " + localSum);
        return localSum;
    }

}
