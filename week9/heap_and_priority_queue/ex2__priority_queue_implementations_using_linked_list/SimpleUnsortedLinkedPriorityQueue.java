package vn.io.tunaa.dsa.week9.heap_and_priority_queue.ex2__priority_queue_implementations_using_linked_list;

public class SimpleUnsortedLinkedPriorityQueue<E extends Comparable<E>> implements SimpleLinkedPriorityQueue<E> {

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

        if (size != 0) {
            newNode.next = head;
        }

        head = newNode;
        size++;
    }

    @Override
    public E extractMin() {
        if (size == 0) {
            return null;
        }

        if (size == 1) {
            E tmp = head.data;

            head = null;
            size--;

            return tmp;
        }


        E minData = head.data;

        Node<E> current = head;
        while (current.next != null) {
            if (minData.compareTo(current.next.data) > 0) {
                minData = current.next.data;
            }

            current = current.next;
        }

        current = head;

        if (current.data.equals(minData)) {
            head = head.next;
            size--;
            return minData;
        }

        while (current.next != null) {
            if (current.next.data.equals(minData)) {
                current.next = current.next.next;
                break;
            }

            current = current.next;
        }

        size--;
        return minData;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }

        if (size == 1) {
            return head.data;
        }

        E minData = head.data;

        Node<E> current = head;
        while (current.next != null) {
            if (minData.compareTo(current.next.data) > 0) {
                minData = current.next.data;
            }

            current = current.next;
        }

        return minData;
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