package Chapter2;

import java.util.stream.Stream;

/**
 * Created by Arry on 2017/9/1.
 */
public class Task5 {
    /**
     * Stream.iterate 方法有seed和f()组成。 第一个值为seed，第二个值为f(seed),第三个值为f(f(seed))
     */
    private static void task5(){
      lcg(25214903917L,11,1<<48,System.currentTimeMillis()).limit(5).forEach(System.out::println);
    }
    public static Stream<Long> lcg(long a,long c, long m,long seed){
       return Stream.iterate(seed, v->(a*v+c)%m);
    }

    public static void main(String[] args) {
        new Task5().task5();
    }
}
