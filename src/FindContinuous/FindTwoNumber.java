package FindContinuous;

public class FindTwoNumber {
    public void twoNumber(int[] array,int[] n1,int[] n2,int target){
        int length = array.length;
        int i;
        int j;
        for (i=0,j=length-1;i!=j;){
            int sum = array[i]+array[j];
            if (sum > target){
                j--;
            }else if(sum < target){
                i++;
            }else if (sum == target){
                n1[0] = array[i];
                n2[0] = array[j];
                break;
            }
        }
    }

    public static void main(String[] args) {
        FindTwoNumber findTwoNumber = new FindTwoNumber();
        int[] a = {1,2,4,7,11,15};
        int[] n1 = new int[1];
        int[] n2 = new int[1];
        findTwoNumber.twoNumber(a ,n1 ,n2,15);
        System.out.println(n1[0]);
        System.out.println(n2[0]);
    }
}
