package novin.ardian.yee.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Novin on 06/12/2022
 * @project Learn-Java-Database
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Novins\\Programming\\Java\\Learn-Java-Database\\src\\main\\java\\novin\\ardian\\yee\\database\\dataa.txt");
        BufferedReader bufferedReader;

        bufferedReader = new BufferedReader(new FileReader(file));
        while (true){
            String line = bufferedReader.readLine();
            if (line == null){
                break;
            }
            System.out.println(line);
        }
    }
}
