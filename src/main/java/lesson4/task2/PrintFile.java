package lesson4.task2;

import java.io.*;

public class PrintFile {
    public static void main(String[] args) throws IOException {
        run();
    }

    private static void run() throws IOException {
        byte[] bytes = new byte[1024];
        String filename = "src/main/java/lesson4/task2/text.txt";
        File file = new File(filename);

        FileInputStream fis = new FileInputStream(file);
        int countReadBytes;

        while ((countReadBytes = fis.read(bytes)) > 0){
            System.out.print(new String(bytes, 0, countReadBytes));
        }

        fis.close();
    }
}
