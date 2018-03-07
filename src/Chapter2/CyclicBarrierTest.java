package Chapter2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Arry on 2017/10/16.
 */
public class CyclicBarrierTest {
    private final CyclicBarrier barrier;
    private final Worker[] workers;
    public CyclicBarrierTest() {
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("一起走");
            }
        });
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++){
            workers[i] = new Worker();
        }
    }

    private class Worker implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"跑起来");
            try {
                System.out.println(Thread.currentThread().getName()+"等着-----");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(){
        for (int i = 0; i < workers.length; i++){
            new Thread(workers[i]).start();
        }
    }
    public static void main(String[] args) {
        CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest();
        cyclicBarrierTest.start();
    }
}
