public class Main4 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);

        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Main4());
        thread1.start();
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);

        }
    }

}
