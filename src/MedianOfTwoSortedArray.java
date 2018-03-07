/**
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * Created by Arry on 2017/10/31.
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int totalLength = nums1.length + nums2.length;
        int pre = 0;
        int cur = 0;
        int i=0 ,j=0;
        if (nums1[0] <= nums2[0]){
            cur = nums1[0];
            i++;
        }else {
            cur = nums2[0];
            j++;
        }
        int mid = totalLength/2;
        while (i + j <= mid){
            if (j >= nums2.length || ((i < nums1.length) && nums1[i] <= nums2[j])){
                pre = cur;
                cur = nums1[i];
                i++;
            }
            if (i >= nums2.length || ((j < nums2.length) && nums1[i] >= nums2[j] )){
                pre = cur;
                cur = nums2[j];
                j++;
            }
        }
        result = totalLength%2==0 ?(pre + cur)/2.0:cur;
        return result;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArray m = new MedianOfTwoSortedArray();
        int[] a = {};
        int[] b = {3, 4};
        double result = m.findMedianSortedArrays(a, b);
        System.out.println(result);
    }
}
