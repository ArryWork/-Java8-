package Chapter2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Arry on 2017/9/1.
 */
public class Task6 {
    public Stream<Character> characterStream(String s) {
        return IntStream.range(0,s.length()).mapToObj(s::charAt);
    }
    public void task6() {
        characterStream("323").forEach(System.out::println);
    }
    public static void main(String[] args) {
//        new Task6().task6();
        System.out.println(Stream.of(1,2,3).limit(1).spliterator().estimateSize());
        System.out.println(Stream.iterate(1, x -> x).limit(1).spliterator().estimateSize());

    }


}
