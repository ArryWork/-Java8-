package GetNumberOfK;

/**
 *
 */
public class GetNumberOfk {

    public int getNumberOfK(int[] array, int k) {
        if (array.length == 0)
            return 0;
        int first = getFirstK(array, k, 0, array.length - 1);
        int last = getLastK(array, k, 0, array.length - 1);
        if (last>-1 && first>-1)
            return last - first + 1;
        else
            return 0;
    }

    public int getFirstK(int[] array, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid = (end + start) / 2;
        if (array[mid] == k) {
            if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
                return mid;
            } else {
                return getFirstK(array, k, start, mid - 1);
            }
        } else if (array[mid] > k) {
            return getFirstK(array, k, start, mid - 1);
        } else {
            return getFirstK(array, k, mid + 1, end);
        }
    }

    public int getLastK(int[] array, int k, int start, int end) {
        if (start > end)
            return 0;
        int mid = (start + end) / 2;
        if (array[mid] == k) {
            if ((mid == array.length - 1)||array[mid + 1] > k) {
                return mid;
            }else if (array[mid + 1] == array[mid]) {
                return getLastK(array, k, mid + 1, end);
            }
        } else if (array[mid] < k) {
            return getLastK(array, k, mid + 1, end);
        } else {
            return getLastK(array, k, start, mid-1);
        }

        return 0;
    }

    public static void main(String[] args) throws IllegalAccessException {
        GetNumberOfk o = new GetNumberOfk();
        int[] a = {1, 1, 1, 1, 2};
        int t = o.getNumberOfK(a, 3);
        System.out.println(t);
    }
}
