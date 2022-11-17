public class Main5 {
    public static void main(String[] args) {
        System.out.println("HI!");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        }).start();

        new Thread(()-> System.out.println("hello!")).start();

        System.out.println("hi!");

    }

}
