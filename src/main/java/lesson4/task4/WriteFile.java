package lesson4.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        run();
    }

    private static void run() throws IOException {
        String path = "src/main/java/lesson4/task4/";
        String fileName = "text1.txt";

        int pageSize = 1800;
        int page = 2;

        String filePath = path + fileName;
        File file = new File(filePath);
        if(!file.exists()){
            throw new FileNotFoundException("Файл не найден");
        }

        RandomAccessFile raf = new RandomAccessFile(file, "r");

        byte[] buff = new byte[pageSize];
        raf.seek((page - 1) * pageSize);

        int countWrite = raf.read(buff);
        System.out.println(new String(buff, 0, countWrite));

        raf.close();

    }
}
