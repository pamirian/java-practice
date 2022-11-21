package task4;
public class Main {

    public static void main(String[] args) {
        Queue q = new Queue();
        new Producer(q);
        new Consumer(q);
    }
}

class Queue {
    private int n;

    public synchronized int get() {
        System.out.println("Получено: " + n);
        return n;
    }

    public synchronized void put(int n) {
        this.n = n;
        System.out.println("Отправлено: " + n);
    }
}

class Producer implements Runnable {

    private Queue q;

    public Producer(Queue q) {
        this.q = q;
        new Thread(this, "Поставщик").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }

}

class Consumer implements Runnable {

    private Queue q;

    public Consumer(Queue q) {
        this.q = q;
        new Thread(this, "Потребитель").start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }

}