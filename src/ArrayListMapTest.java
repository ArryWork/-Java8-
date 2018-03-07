import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayListMapTest {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        String[] a = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        for (String v : a) {
            if (v.compareTo("4") < 0) {
                List<String> list = map.get("a");
                if (list == null) {
                    list = new ArrayList<>();
                    map.put("a", list);
                }
                list.add(v);
            } else {
                List<String> list = map.get("b");
                if (list == null) {
                    list = new ArrayList<>();
                    map.put("b", list);
                }
                list.add(v);
            }
        }

        System.out.println("a_b".substring(0,"a_b".indexOf('_')));
    }
}
