
package task1;

import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        new FileWriteThread("Thread1", "/Users/manu/Desktop/1.txt");
        new FileWriteThread("Thread2", "/Users/manu/Desktop/1.txt");
        new FileWriteThread("Thread3", "/Users/manu/Desktop/1.txt");
    }

}

class FileWriteThread extends Thread {

    private String fileName;

    public FileWriteThread(String threadName, String fileName) {
        this.fileName = fileName;
        this.setName(threadName);
        this.start();
    }

    @Override
    public void run() {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            for (int i = 0; i < 10; i++) {
                fileWriter.write(this.getName() + ": " + i + "\n");
                Thread.sleep(20);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
