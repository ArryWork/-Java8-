
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
        Stream<Person> personStream = Arrays.stream(persons);
        Map<String,IntSummaryStatistics> ageToPerson;
        ageToPerson = personStream.collect(
                Collectors.groupingBy(Person::getEmail,
                        Collectors.summarizingInt(Person::getSex)));
        System.out.println(ageToPerson.get("1").getAverage());
    }
}
