package Thread;

public class ThreadPrint {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(() -> System.out.println("A"));
            thread.start();
            thread.join();
            Thread thread2 = new Thread(() -> System.out.println("B"));
            thread2.start();
            thread2.join();
            Thread thread3 = new Thread(() -> System.out.println("C"));
            thread3.start();
            thread3.join();
        }
    }
}
