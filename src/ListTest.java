import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arry on 2017/9/5.
 */
public class ListTest {


    private void task(){
        List<Person> l = new ArrayList(20);
        Person p = new Person();
        l.add(p);
        for (int i = 0; i < 20 ;i++){
            Person t = new Person();
            l.add(t);
        }

    }

    public static void main(String[] args) {
        ListTest test = new ListTest();
        test.task();
        System.out.println(0x80000000);

    }
}
