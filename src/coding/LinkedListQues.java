package coding;

import java.util.LinkedList;

public class LinkedListQues<T> {

    private Node head;
    private Node tail;

    class Node {
        T item;
        Node next;

        Node (T item) {
            this.item = item;
            this.next = null;
        }
    }

    public void addNode(T item) {
        Node node = new Node(item);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = new Node(item);
            tail = tail.next;
        }
    }

    public void printMe() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.item + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    private void findMiddleNode() {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.item);
    }

    public static void main(String[] args) {
        LinkedListQues<Integer> llq = new LinkedListQues<>();
        llq.addNode(1);
        llq.addNode(2);
        llq.addNode(3);

        llq.findMiddleNode();
        llq.printMe();
    }
}
