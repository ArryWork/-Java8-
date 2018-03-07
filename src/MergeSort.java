public class MergeSort {
    public int[] mergeSort(int[] a){
        int[] copy = new int[a.length];
        for (int i=0; i < a.length; i++){
            copy[i] = a[i];
        }
        inverse(a,copy,0,a.length-1);
        return a;
    }

    private void inverse(int[] a, int[] copy, int low, int high) {
        if (low==high){
            return;
        }
        int mid = (high-low)/2+low;
        int p = low;
        int q = mid+1;
        int hcopy = low;
        inverse(a,copy,p,mid);
        inverse(a,copy,mid+1,high);
        while (p<=mid&&q<=high){
            if (a[p]>a[q]){
                copy[hcopy++] = a[q++];
            }else {
                copy[hcopy++] = a[p++];
            }
        }
        for (;p<=mid;p++){
            copy[hcopy++] = a[p++];
        }
        for (;q<=high;q++){
            copy[hcopy++] = a[q++];
        }
        for (int j=0;j<copy.length;j++){
            a[j] = copy[j];
        }
    }

    public static void main(String[] args) {
        int[] a = {7,5,6,4};
        MergeSort m = new MergeSort();
        int[] t = m.mergeSort(a);
        for (int s:
            t) {
            System.out.print(s);
        }
    }
}
