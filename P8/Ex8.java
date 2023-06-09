package P8;

public class Ex8 extends Thread {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRun1());
        Ex8 thread2 = new Ex8();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("The end!");
    }

}

class MyRun1 implements Runnable {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}