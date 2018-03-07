package HashMapMemoizerl;

import java.util.concurrent.*;

/**
 * 使用FutureTask，来减少重复计算
 * 首先检查某个计算任务是否开始，如果还没开始就启动一个futureTask来进行计算
 * 如果已经开始，则等待计算结果。
 * Created by Arry on 2017/10/17.
 */
public class Memoizerl3<A,V> implements Computable<A,V>{
    private final Computable<A,V> c;
    private final ConcurrentHashMap<A,Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

    public Memoizerl3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> result = cache.get(arg);
        if (result == null){
            Callable callable = (Callable<V>) () -> c.compute(arg);
            FutureTask<V> futureTask = new FutureTask<>(callable);
            result = cache.putIfAbsent(arg,result);
            if (result == null) {
                result = futureTask;
                futureTask.run();
            }
        }
        try {
            return result.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
