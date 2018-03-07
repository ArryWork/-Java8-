


import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Arry on 2017/8/29.
 */
public class OptionTest {
    public static void main(String[] args) {
        OptionTest o = new OptionTest();
        o.testGroup();
    }
    public void testGroup(){
        Person[]  persons= {new Person("张三","1",12),new Person("李四","1",11),new Person("王五","1",12),
                new Person("陈六","1",13),new Person("尤七","1",13)};
        int[] a = {1,2,4,5,6,7,8};
        main:
        for (Person person: persons){
            for (int b : a){
                System.out.println(b);
                if (b==3)
                   continue main;
            }
            System.out.println(person);
        }
    }
}
