import java.io.File;
import java.util.Arrays;

public class TestJDK8 {
    public static void main(String args[]) {
        
        // let's do some execution perf checks
        long startTime = System.nanoTime();

        // read all non hidden files
        Arrays.stream(new File(".").listFiles(f -> !f.isHidden())).forEach(file -> System.out.println(file));
        long midTime = System.nanoTime();

        // convert to a List so Collection thus stream() is available
        // note that this one uses parallelStream - makes it consistently twice faster - on my dual core
        Arrays.asList(new File(".").listFiles(f -> !f.isHidden())).parallelStream()
                .forEach(file -> System.out.println(file));

        long endTime = System.nanoTime();

        System.out.println("1 : "+(midTime-startTime+"\n2 : "+(endTime-midTime)));
    }
}