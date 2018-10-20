package linkedlist;

public class ReverseListNew {

   static class Node{
        int val;
        Node next;
        Node(int item) {
            this.val = item;
            this.next = null;
        }
    }

    /***
     * 找出链表中环入口的位置，返回该位置的值，如果没有环返回-1
     * 这里为了说明例子，假定节点的值都是正数，所以返回值用-1表示没环情况
     * */
   public static int checkLoop(Node head) {
       if(head == null || head.next == null) {
           return -1;
       }
       Node fast = head.next.next;
       Node slow = head.next;
        Node meet = null;
       while (fast!=null && fast.next!=null) {
           if(fast.val == slow.val) {
               meet = fast;
               break;
           }
           fast = fast.next.next;
           slow = slow.next;
       }

       if(meet == null)
          return  -1;

       while (head.val!= meet.val) {
           head = head.next;
           meet = meet.next;
       }
       return  meet.val;
   }
    public static void main(String[] args) {

        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;  ///node1是环的入口，所以函数返回1
        node4.next = node5;

        System.out.println(checkLoop(node));
    }
}
