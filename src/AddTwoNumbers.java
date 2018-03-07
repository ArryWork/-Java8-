import java.util.List;
import java.util.Scanner;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * @author Arry
 * @date 2017/10/27
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0);
        ListNode tail = sumList;
        int addNum = 0;
        while (l1 != null || l2 != null || addNum!=0){
            int temp = (l1==null?0:l1.val) + (l2==null?0:l2.val)+ addNum;
            int sum = temp%10;
            addNum = temp/10;
            ListNode node = new ListNode(sum);
            tail.next = node;
            tail = tail.next;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return sumList.next;
    }

    public static void main(String[] args) {
        ListNode l1 = linkListNode(2);
        ListNode l2 = linkListNode(1);
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode result = a.addTwoNumbers(l1,l2);
        ListNode t = result;
        while (t!=null){
            System.out.println(t.val);
            t = t.next;
        }

    }

    private static ListNode linkListNode(int t) {
        Scanner sc = new Scanner(System.in);
        ListNode tail = null;
        ListNode l1 = null;
        for (int i = 0; i < t; i++){
            if (l1==null){
                l1 = new ListNode(sc.nextInt());
                tail = l1;
            }else {
                tail.next = new ListNode(sc.nextInt());
                tail=tail.next;
            }
        }
       return l1;
    }
}
