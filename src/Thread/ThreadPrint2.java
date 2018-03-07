package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrint2 {
    public static int times = 0;
    public static void main(String[] args) {

        final Lock lock = new ReentrantLock();
        Thread a = new Thread(new PrintThread("abc", lock, 0));
        Thread b = new Thread(new PrintThread("def", lock, 1));
        Thread c = new Thread(new PrintThread("ghi", lock, 2));

        a.start();
        b.start();
        c.start();
    }

    static class PrintThread implements Runnable {
        private String name;
        private Lock lock;
        private Integer flag;

        public static int count = 0;

        public static int MAX = 9;

        public PrintThread(String name, Lock lock, Integer flag) {
            this.name = name;
            this.lock = lock;
            this.flag = flag;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                if (count >= MAX) {
                    lock.unlock();
                    return;
                }
                if (count % 3 == flag) {
                    System.out.print("第"+times+"次: "+name.charAt(count / 3) + " ");
                    count++;
                }
                times++;
                lock.unlock();
            }
        }
    }

}
