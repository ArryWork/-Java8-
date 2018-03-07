package FindGreatestSumOfSubArray;

import java.util.ArrayList;

public class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {
        int greatSumary = array[0];
        int sumary = array[0];
        for (int i = 1; i < array.length; i++){
            if (sumary <=0){
                sumary = array[i];
            }else {
                sumary += array[i];
            }
            if (sumary>greatSumary){
                greatSumary = sumary;
            }
        }
        return greatSumary;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {2,8,1,5,9};
        int result = s.FindGreatestSumOfSubArray(a);
        System.out.println(result);
    }
}