package task2;

import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("/Users/manu/Desktop/3.txt", true);
        FileWriteThread thread1 = new FileWriteThread("Thread1", fileWriter);
        FileWriteThread thread2 = new FileWriteThread("Thread2", fileWriter);
        FileWriteThread thread3 = new FileWriteThread("Thread3", fileWriter);
        thread1.join();
        thread2.join();
        thread3.join();
        fileWriter.flush();
        fileWriter.close();
    }

}


class FileWriteThread extends Thread {

    private final FileWriter fileWriter;

    public FileWriteThread(String threadName, FileWriter fileWriter) {
        this.fileWriter = fileWriter;
        this.setName(threadName);
        this.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                fileWriter.write(this.getName() + ": " + i + "\n");
                Thread.sleep(20);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



