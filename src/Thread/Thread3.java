package Thread;

public class Thread3 {
    static class myThread implements Runnable {
        String string;
        int count;

        public myThread(String abc,int i) {
            this.string = abc;
            this.count = i;
        }

        @Override
        public void run() {
            System.out.print(string.charAt(count));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread thread1 = new Thread(new myThread("abc",i));
            Thread thread2 = new Thread(new myThread("def",i));
            Thread thread3 = new Thread(new myThread("ghi",i));
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
            thread3.join();
            System.out.println();
        }
    }
}
