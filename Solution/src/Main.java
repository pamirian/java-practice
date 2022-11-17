public class Main{
    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread();
//        MyThread2 myThread2 = new MyThread2();
//        myThread1.start();
//        myThread2.start();
        new MyThread().start();
        new MyThread2().start();
    }
}
class MyThread extends Thread {

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);

        }
    }
}

class MyThread2 extends Thread {

    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);

        }
    }
}