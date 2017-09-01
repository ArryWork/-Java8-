package Chapter2;

import java.util.stream.IntStream;

/**
 * Created by Arry on 2017/9/1.
 */
public class Task4 {
    public static void task4(){
        int value[] = {1,4,9,16};
        long startTime = System.nanoTime();
        IntStream intStream = IntStream.of(value);
        long endTime = System.nanoTime();
        System.out.println(String.format(" %d ms.", (endTime - startTime) / 1000000));
        intStream.forEach(System.out::print);

    }

    public static void main(String[] args) {
        new Task4().task4();
    }
}
