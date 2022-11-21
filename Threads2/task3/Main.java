package task3;

public class Main {

    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller caller1 = new Caller(target, "Добро пожаловать");
        Caller caller2 = new Caller(target, "в синхронизированный");
        Caller caller3 = new Caller(target, "метод");
        try {
            caller1.t.join();
            caller2.t.join();
            caller3.t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class CallMe {
    public void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {

    private String msg;
    private CallMe target;
    Thread t;

    public Caller(CallMe target, String msg) {
        this.target = target;
        this.msg = msg;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        target.call(msg);
    }
}
