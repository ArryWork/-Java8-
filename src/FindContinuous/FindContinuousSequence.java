package FindContinuous;

import java.util.ArrayList;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int small = 1;
        int big = 2;
        int currentSum = small+big;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(new Integer(small));
        list.add(new Integer(big));
        while (big < sum){
            if (currentSum == sum) {
                result.add(new ArrayList<>(list));
                currentSum-=small;
                list.remove(0);
                small++;
            }else
            if (currentSum < sum){
                big++;
                currentSum+=big;
                list.add(big);
            }else if (currentSum>sum){
                currentSum-=small;
                list.remove(0);
                small++;
            }
        }
        return result;
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int length = array.length;
        ArrayList<Integer> result = new ArrayList<>();
        if (length==0)
            return result;
        int i;
        int j;
        for (i=0,j=length-1;i!=j;){
            int s = array[i]+array[j];
            if (s > sum){
                j--;
            }else if(s < sum){
                i++;
            }else if (s == sum){
                result.add(array[i]);
                result.add(array[j]);
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        FindContinuousSequence 是=new FindContinuousSequence();
        是.findContinuousSequence(15);
    }
}
