import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Arry on 2017/8/30.
 */
public class HashMapTest {
    public static void main(String[] args) {
        List<String > wordList = new ArrayList<>();
        wordList.add("asdfasdf");
        wordList.add("123efasdf");
        Stream<String> words = wordList.stream();
        wordList.add("test");
        words.forEach(System.out::println);
    }
}
