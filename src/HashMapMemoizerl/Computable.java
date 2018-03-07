package HashMapMemoizerl;

/**
 * Created by Arry on 2017/10/17.
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
