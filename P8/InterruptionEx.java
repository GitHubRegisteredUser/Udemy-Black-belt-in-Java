package P8;

public class InterruptionEx {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starts");
        IntThread thread = new IntThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        thread.join();
        System.out.println("Main ends");
    }

}

class IntThread extends Thread {

    double sqrtSum = 0;

    public void run() {
        for (int i = 1; i < 1000000000; i++) {
            if (isInterrupted()) {
                System.out.println("Поток хотят прервать");
                System.out.println("Мы убедились, что состояние всех объектов нормальное, " +
                        "и решили завершить работу потока");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Поток хотят прервать во время сна. " +
                        "Давайте завершим его работу.");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }

}