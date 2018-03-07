package HashMapMemoizerl;

import java.math.BigInteger;

/**
 * Created by Arry on 2017/10/17.
 */
public class ExpensiveFunction implements Computable<String, BigInteger>{
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}
