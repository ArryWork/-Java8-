import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arry on 2017/9/18.
 */
public class SetTest {
    public static void main(String[] args) {
        File file = new File("C:\\windows");
        if (file.isDirectory()) {
            Arrays.stream(file.list()).filter(name->name.contains("App")).forEach(System.out::println);
        }
        System.out.println(System.getProperty("user.home"));

        String date1 = "2017-01-01";
        String date2 = "2017-09-03";
        System.out.println(date1.compareTo(date2));
    }
}
