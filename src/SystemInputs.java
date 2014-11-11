import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SystemInputs {

    public static InputStream stdin;
    public static InputStream fileIn;

    static {
        stdin = System.in;
    }


    public static InputStream readFromFile(String filepath) {
        try {
            return new FileInputStream(filepath);
        }catch(FileNotFoundException e){
            System.out.printf("File not found: %s",filepath);
        }
        return null;
    }


}
