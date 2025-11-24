package vn.io.tunaa.dsa.week9.heap_and_priority_queue.ex2__priority_queue_implementations_using_linked_list;

public class SimpleSortedLinkedPriorityQueue<E extends Comparable<E>> implements SimpleLinkedPriorityQueue<E> {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head = null;
    private int size = 0;

    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);

        if (size == 0) {
            head = newNode;
        } else if (size == 1) {
            if (head.data.compareTo(element) > 0) {
                newNode.next = head;
                head = newNode;
            } else {
                head.next = newNode;
            }
        } else {
            Node<E> current = head;

            if (current.data.compareTo(element) > 0) {
                newNode.next = head;
                head = newNode;
            } else {
                while (current.next != null) {
                    if (current.next.data.compareTo(element) > 0) {
                        newNode.next = current.next;
                        current.next = newNode;

                        break;
                    } else {
                        current = current.next;
                    }
                }

                if (current.data.compareTo(element) < 0) {
                    current.next = newNode;
                }
            }
        }

        size++;
    }

    @Override
    public E extractMin() {
        E tmp = head.data;
        head = head.next;

        size--;
        return tmp;
    }

    @Override
    public E peek() {
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) sb.append(" -> ");
        }
        sb.append("]");
        return sb.toString();
    }
}