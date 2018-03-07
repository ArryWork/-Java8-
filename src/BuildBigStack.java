import java.util.Arrays;

public class BuildBigStack {
    public void adjustStack(int[] ints, int pos){
        int temp = ints[pos];
        int child;
        int length = ints.length;
        for (; pos*2<length; pos = child){
            child = pos*2+1;
            if (child+1<length && ints[child]<ints[child+1]){
                child++;
            }
            if (ints[child]>temp){
                ints[pos] = ints[child];
            }else {
                break;
            }
        }
        ints[pos] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        BuildBigStack b = new BuildBigStack();
        for (int i = 6/2-1; i >= 0; i--) {
            b.adjustStack(a, i);
        }
        int[] t = {6,5,3,4,2,1,7};
        for (int i = 7/2-1;i>=0;i--){
            b.adjustStack(t,i);
        }
        Arrays.stream(t).forEach(System.out::println);
    }
}
