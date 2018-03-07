package Chapter2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Arry on 2017/9/5.
 */
public class ThousandsThread {
    AtomicLong total = new AtomicLong();
    public class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0 ; i < 100000 ; i++) {
                total.incrementAndGet();
            }
        }
    }
    LongAdder longAdder = new LongAdder();
    long t1;
    public class LongAdderThread extends Thread{
        @Override
        public void run() {
            for (int i = 0 ; i < 100000 ; i++) {
                longAdder.increment();
            }
        }
    }
    private  void task() throws InterruptedException {
        for (int i = 0; i <1000; i++){
            Thread t = new Thread(new MyThread());
            t.start();
            t.join();
        }
    }
    private  void task2() throws InterruptedException {
        for (int i = 0; i <1000; i++){
            Thread t = new Thread(new LongAdderThread());
            t.start();
            t.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        ThousandsThread t = new ThousandsThread();
        t.task();
        long end = System.nanoTime();
        System.out.println(t.total);
        System.out.println(String.format(" %d ms.", (end - start) / 1000000));

        start = System.nanoTime();
        t.task2();
        end = System.nanoTime();
        System.out.println(t.total);
        System.out.println(String.format(" %d ms.", (end - start) / 1000000));

    }
}
