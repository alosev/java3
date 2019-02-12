package lesson4.task3;

import java.io.*;
import java.util.*;

public class MakeFile {
    public static void main(String[] args) throws IOException {
        run();
    }

    private static void run() throws IOException {
        String path = "src/main/java/lesson4/task3/";

        String outFilePath = path + "out.txt";
        File outFile = new File(outFilePath);
        if(!outFile.exists()){
            boolean result = outFile.createNewFile();
            if(!result){
                throw new FileNotFoundException("Не удалось создать исходящий файл");
            }
        }

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));

        ArrayList<String> filenames =
                new ArrayList<>(
                        Arrays.asList(
                                "file1.txt",
                                "file2.txt",
                                "file3.txt",
                                "file4.txt",
                                "file5.txt"
                        ));

        File file;
        String filepath;
        BufferedInputStream bis;

        for (String filename: filenames) {
            filepath = path + filename;
            file = new File(filepath);

            if(file.exists()){
                bis = new BufferedInputStream(new FileInputStream(file));
                bos.write(bis.readAllBytes());
                bos.flush();
                bis.close();
            }
        }

        bos.close();

    }
}
