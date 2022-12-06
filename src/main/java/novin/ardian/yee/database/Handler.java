package novin.ardian.yee.database;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Novin on 06/12/2022
 * @project Learn-Java-Database
 */
public class Handler {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        try {
            testException(-1);
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        } catch (IOException exception){
            exception.printStackTrace();
        } finally {
            System.out.println("uwauuu");
        }
        testException(15);
    }

    public static void testException(int i) throws FileNotFoundException, IOException{
        if (i<0){
            FileNotFoundException exception = new FileNotFoundException("Ga boleh negative integer " + i);
            throw exception;
        } else if (i > 10) {
            throw new IOException("Hanya boleh index - 0 sampai 10");
        }
    }
}
