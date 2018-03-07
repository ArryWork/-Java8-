package HashMapMemoizerl;

import java.util.HashMap;

/**
 * 使用HashMap来创建缓存
 * 对compute方法加锁
 * Created by Arry on 2017/10/17.
 */
public class Memoizerl1<A, V> implements Computable<A, V>{
    private final HashMap<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizerl1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            return result;
        }
        return result;
    }
}

