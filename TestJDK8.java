import java.io.File;
import java.util.Arrays;

public class TestJDK8 {
    public static void main(String args[]) {
        
        // read all non hidden files
        Arrays.stream(new File(".").listFiles(f -> !f.isHidden())).forEach(file -> System.out.println(file));

        

    }
}