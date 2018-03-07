package NumberForOnce;

/**
 * num1,num2分别为长度为1的数组。传出参数
 将num1[0],num2[0]设置为返回结果
 */
public class NumberAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int i = 0;
        for (int j=i+1;j<array.length;j++){
            if (array[i]==array[j]&&i!=j){
                i++;
                j=0;
            }else if (j==array.length-1&&array[j]!=array[i]){
                num1[0] = array[i];
                i++;
            }
        }
        for (int j=0;j<array.length;j++){
            if (array[i]==array[j]&&i!=j){
                i++;
                j=0;
            }else if ((j==array.length-1&&array[j]!=array[i]&&num1[0]!=array[j])||i==j){
                num2[0] = array[i];
            }
        }
    }

    public static void main(String[] args) {
        NumberAppearOnce a = new NumberAppearOnce();
        int[] s = {1,1,1,1,4,6};
        int[] n = new int[1];
        int[] n2 = new int[1];

        a.FindNumsAppearOnce(s,n,n2);
        System.out.println(n);
        System.out.println(n2);
    }
}
