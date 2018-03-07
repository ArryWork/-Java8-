package randomLinkedList;

/**
 * {1,2,3,4,5,3,5,#,2,#}
 * Created by Arry on 2017/11/20.
 */
public class RandomList {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode result = new RandomListNode(pHead.label);
        RandomListNode node = result;
        RandomListNode t = pHead;
        while (t.next != null) {
            node.next = new RandomListNode(t.next.label);
            node = node.next;
            t = t.next;
        }
        t = pHead;
        node = result;
        RandomListNode randomNode = result;
        while (t != null) {
            if (t.random != null) {
                int l = findRandomListNode(pHead, t);
                while (l-- > 0) {
                    node = node.next;
                }
                randomNode.random = node;
                node = result;
            }
            randomNode = randomNode.next;
            t = t.next;
        }
        return result;
    }

    public int findRandomListNode(RandomListNode pHead, RandomListNode head) {
        RandomListNode randomListNode = head.random;
        RandomListNode temp = pHead;
        int i = 0;
        while (temp.next != null) {
            if (temp == randomListNode) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return i;
    }

    public RandomListNode Clone2(RandomListNode pHead) {
        RandomListNode temp = pHead;
        RandomListNode result;
        while (temp != null) {
            RandomListNode randomListNode = new RandomListNode(temp.label);
            randomListNode.next = temp.next;
            temp.next = randomListNode;
            temp = randomListNode.next;
        }
        temp = pHead;
        while (temp != null) {
            RandomListNode node = temp.next;
            if (temp.random != null) {
                node.random = temp.random.next;
            }
            temp = node.next;
        }
//        result = getRandomListResult(pHead);

        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        temp = pHead;
        //拆分链表
        while (temp != null) {
            temp.next = temp.next.next;
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
            temp = temp.next;
        }

        return head;
    }

    private RandomListNode getRandomListResult(RandomListNode pHead) {
        RandomListNode t2 = pHead.next;
        RandomListNode result = t2;
        while (t2.next != null) {
            t2.next = t2.next.next;
            t2 = t2.next;
        }
        return result;
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        RandomListNode r5 = new RandomListNode(5);
        r1.next = r2;
        r1.random = r3;
        r2.next = r3;
        r2.random = r5;
        r3.next = r4;
        r4.next = r5;
        r4.random = r2;

        RandomList r = new RandomList();
//        r.Clone(r1);
        RandomListNode resutl = r.Clone2(r1);
        while (resutl != null) {
            System.out.println(resutl.label);
            resutl = resutl.next;
        }

    }
}
