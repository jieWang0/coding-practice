package linkedlist;


/**
 * 单双链表的操作都一样，需要额外两个变量：pre和curNext
 * 每次先更新curNext保存好下一个元素的指针，然后进行翻转更新，最后再将pre更新
 * */
public class ReverseList {

    class Node {
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    public static Node reverseSingle(Node listA) {
        if(listA == null) {
            return null;
        }
        Node pre = null;
        Node curNext = null;

        while (listA!=null) {

            curNext = listA.next;
            listA.next = pre;
            pre = listA;
            listA = curNext;
        }

        return pre;
    }

    class DoubleNode {
        int value;
        DoubleNode next;
        DoubleNode last;
        DoubleNode(int value){
            this.value = value;
        }
    }
    public static DoubleNode reverseDoule(DoubleNode head) {
        if(head ==null)
            return null;
        DoubleNode pre = null;
        DoubleNode curNext = null;
        while(head!=null) {
            curNext = head.next;
            head.next = pre;
            head.last = curNext;
            pre = head;
            head = curNext;
        }

        return pre;

    }


}
