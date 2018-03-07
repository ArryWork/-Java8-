package publicNode;

import java.util.List;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 *
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int l1 = 0;
        int l2 = 0;
        ListNode t1 = pHead1;
        ListNode t2 = pHead2;
        while (t1!=null){
            l1++;
            t1 = t1.next;
        }
        while (t2!=null){
            l2++;
            t2 = t2.next;
        }
        if (l1>=l2){
            return find(pHead1,pHead2,l1-l2);
        }
        else {
            return find(pHead2,pHead1,l2-l1);
        }
    }
    public ListNode find(ListNode longList,ListNode shortList,int n){
        ListNode t1 = longList;
        ListNode t2 = shortList;
        while (n>0){
            t1=t1.next;
            n--;
        }
        while (t1!=null&&t2!=null){
            if (t1==t2){
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node4.next = node9;
        node8.next = node4;
        FindFirstCommonNode f = new FindFirstCommonNode();
        f.FindFirstCommonNode(node0, node5);
    }
}