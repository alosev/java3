package lesson3;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        run();
    }

    private static void run() throws IOException {
        String login = "mike";
        int countHistory = 100;
        String path =  "history/";
        String fileName = "history_" + login + ".his";

        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        file = new File(path + fileName);
        if(!file.exists()){
            file.createNewFile();
        }

        FileReader fr = new FileReader(file);
        BufferedReader brf = new BufferedReader(fr);

        String readStr;
        while ((readStr = brf.readLine()) != null){
            System.out.println(">>>" + readStr);
            countHistory--;
            if(countHistory < 1){
                break;
            }
        }
        brf.close();
        fr.close();

        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        while (true){
            String str = br.readLine();
            if(str.startsWith("/end")){
                break;
            }

            bw.write(str + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
        fw.close();

    }
}
