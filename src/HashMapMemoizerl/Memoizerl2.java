package HashMapMemoizerl;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用ConcurrentHashMap代替HashMap
 * 无需对compute方法进行加锁，
 * 但是有可能会重复 计算》存入缓存
 * Created by Arry on 2017/10/17.
 */
public class Memoizerl2<A, V> implements Computable<A, V> {
    private final Computable<A,V> c;
    private final ConcurrentHashMap<A,V> cache = new ConcurrentHashMap<>();

    public Memoizerl2(Computable c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null){
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
