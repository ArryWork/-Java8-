package Thread;
public class JoinTester02 implements Runnable {
    Thread thread;

    public JoinTester02(Thread thread) {
        this.thread = thread;
    }
    @Override
    public void run() {
//        synchronized (thread) {
            System.out.println("getObjectLock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("ReleaseObjectLock");
//        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new JoinTester01("Three"));
        Thread getLockThread = new Thread(new JoinTester02(thread));

        getLockThread.start();
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main finished!");
    }

}
