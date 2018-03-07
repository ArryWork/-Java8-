public class Sum {
    public static void main(String[] args) {
        long t1,t2,t3;
        System.out.println(t1 = System.nanoTime());

        System.out.println(sum(100));
        System.out.println(t2 = System.nanoTime());
        System.out.println(sum2(100));
        System.out.println(t3 = System.nanoTime());

        System.out.println(t2-t1);
        System.out.println(t3-t2);
    }
    public static int sum(int s ){
        int result = 0;
        if (s%2==0){
            result = s/2*(s-1)+s;
        }else {
            result = ((1 + s) / 2) * s;
        }
        return result;
    }

    public static int sum2(int s){
        if (s==0)
            return 0;
        return s+sum2(s-1);
    }
}
