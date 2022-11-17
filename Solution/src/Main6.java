public class Main6{

    public static void main(String[] args) {
        myThread6 myThread1 = new myThread6();
        myThread1.setName("My thread");
        myThread1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name of main6 - " + myThread1.getName() + ", Priority of main6 = " + myThread1.getPriority());


        myThread6 myThread2 = new myThread6();
        System.out.println("Name of main6 - " + myThread2.getName() + ", Priority of main6 = " + myThread2.getPriority());

        Thread thread = new Thread(new myThread7());
        thread.run(); // неправильно
        thread.start();
        System.out.println("Method main(), thread name = " + Thread.currentThread().getName());

    }
}
class myThread6 extends Thread {
    public  void run(){
        System.out.println("Hello!");
    }
}

class myThread7 implements Runnable{
    public  void run(){
        System.out.println("Method run(), thread name = " + Thread.currentThread().getName());
    }
}
