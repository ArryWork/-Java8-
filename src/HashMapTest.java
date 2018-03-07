import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Arry on 2017/8/30.
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<MapKey,String> map = new HashMap<MapKey, String>();
        Map<Integer,String> map2 = new HashMap<>();
        //第一阶段
        for (int i = 0; i < 6; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
            map2.put(i, "A");
        }



        //第二阶段
        for (int i = 6; i < 10; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
            map2.put(i, "A");
        }



        //第三阶段
        for (int i = 10; i < 50; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
            map2.put(i, "A");
        }



        //第四阶段
        map.put(new MapKey("X"), "B");
        map.put(new MapKey("Y"), "B");
        map.put(new MapKey("Z"), "B");

        System.out.println(map);

        int a = 19;
        int b = a&(a-1);
        System.out.println(b);
    }
}
