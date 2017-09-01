package Chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task1 {
    public void task2() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("F:/article.txt")), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split("[\\P{L}]+"));
        Stream<String> result = words.filter((word) -> {
            if (word.length() < 12) {
                System.out.println("bingo");
                return true;
            } else
                return false;
        });
        System.out.println(result.count());
    }
    public static void main(String[] args) throws IOException {
        new Task1().task2();
    }
}