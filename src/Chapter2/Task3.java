package Chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Arry on 2017/9/1.
 */
public class Task3 {
    public static void main(String[] args) throws IOException {
        new Task3().task3();
    }
    public static void task3() throws IOException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        String contents = new String(Files.readAllBytes(Paths.get("F:/article.txt")), StandardCharsets.UTF_8);
        Stream<String> words1 = Stream.of(contents.split("[\\P{L}]+"));
        long startTime = System.nanoTime();
        long count1= words1.filter(word->word.length()>12).count();
        long endTime = System.nanoTime();

        System.out.println("非并行运行时间"+String.format("count1 = %d in %d ms.",count1, (endTime - startTime) / 1000000));
        Stream<String> words2 = Stream.of(contents.split("[\\P{L}]+"));
        long fstartTime = System.nanoTime();
        words2.parallel().filter(word->word.length()>12).count();
        long fendTime = System.nanoTime();
        System.out.println("并行运行时间"+String.format("count1 = %d in %d ms.",count1, (fendTime - fstartTime) / 1000000));

    }

}
