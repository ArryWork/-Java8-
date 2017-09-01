import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Arry on 2017/9/1.
 */
public class ThreadTaskPractice {
    private final int CORENUM = Runtime.getRuntime().availableProcessors();
    class MyThread extends Thread{
        int id;
        int[] result;
        List<String> codes;
        MyThread(int id,int[] result, List<String> codes){
            this.id = id;
            this.result = result;
            this.codes = codes;
        }
        @Override
        public void run(){
            int count = 0;
            for (int i = 0; i < codes.size()/CORENUM ; i++){
                if ((i * CORENUM + id) < codes.size() && codes.get(i * CORENUM + id).length() > 12)
                    count++;
            }
            result[id] = count;
            System.out.println("处理器："+id+"计算完成");
        }
    }
    public void  task1() throws InterruptedException, IOException {
        String contents = new String(Files.readAllBytes(Paths.get("F:/article.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        int[] result = new int[CORENUM];
        Thread[] threads = new Thread[CORENUM];
        for (int i = 0; i < CORENUM; i++) {
            threads[i] = new Thread(new MyThread(i,result , words));
            threads[i].start();
        }
        for (int i = 0; i < CORENUM; i++) {
            threads[i].join();
        }
        int total = 0;
        for (int i = 0; i < CORENUM; i++)
            total += result[i];
        System.out.println(total);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new ThreadTaskPractice().task1();
    }
 }
