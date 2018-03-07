import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Arry on 2017/9/7.
 */
public class ArrayListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList());

    public boolean putIfExist(E x){
        synchronized (list){
            boolean absent = !list.contains(x);
            if (absent)
                list.add(x);
            return absent;
        }
    }
}
