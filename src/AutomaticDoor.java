import java.util.Scanner;

/**
 * n个employees 每a秒进一个
 * clients 按数组进
 * 门开d秒
 * Created by Arry on 2017/10/26.
 *
 * Input
 * The first line contains four integers n, m, a and d (1 ≤ n, a ≤ 109, 1 ≤ m ≤ 105, 1 ≤ d ≤ 1018) —
 * n the number of the employees,
 * m the number of the clients,
 * a the moment of time when the first employee will come
 * d the period of time in which the door closes.
 * The second line contains integer sequence t1, t2, ..., tm (1 ≤ ti ≤ 1018) — moments of time when clients will come. The values ti are given in non-decreasing order.
 *
 */
public class AutomaticDoor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        int m = scan.nextInt();
        long a = scan.nextLong();
        long d = scan.nextLong();
        long[] arr = new long[m];
        for(int i = 0; i < m; i++) {
            arr[i] = scan.nextLong();
        }
        long number = n + m;
        long ei = a;
        int ci = 0;
        int openTimes = 0;
        while (number > 0) {
            openTimes++;
            long close;
            if (ci >= arr.length || ei<arr[ci]){
                number--;
                close = ei + d;
                ei += a;
                while (ei <= close){
                        ei += a;
                        number --;
                    }
                    while ( ci < arr.length &&arr[ci] <= close ){
                        ci++;
                        number --;
                    }
            }else if (arr[ci]<ei){
                number--;
                close = arr[ci] + d;
                ci++;
                while (ei <= close){
                        ei += a;
                        number --;
                    }
                while (ci < arr.length && arr[ci] <= close){
                        ci++;
                        number --;
                }
            }
        }
        System.out.println(openTimes);
    }
}
