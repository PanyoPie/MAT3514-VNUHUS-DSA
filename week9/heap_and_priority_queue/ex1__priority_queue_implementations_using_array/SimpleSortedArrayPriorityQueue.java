package vn.io.tunaa.dsa.week9.heap_and_priority_queue.ex1__priority_queue_implementations_using_array;

public class SimpleSortedArrayPriorityQueue<E extends Comparable<E>> implements SimpleArrayPriorityQueue<E> {

    private final int DEFAULT_CAPACITY = 2;
    private E[] data = (E[]) new Comparable[DEFAULT_CAPACITY];
    private int size = 0;


    @Override
    public void insert(E element) {
        if (size >= data.length) {
            enlarge();
        }

        int i = size - 1;
        while (i >= 0 && element.compareTo(data[i]) < 0) {
            data[i + 1] = data[i];
            i--;
        }

        data[i + 1] = element;
        size++;
    }

    @Override
    public E extractMin() {
        E tmp = data[0];

        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        return tmp;
    }

    @Override
    public E peek() {
        return data[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void enlarge() {
        int newCapacity = data.length * 2;
        E[] newData = (E[]) new Comparable[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}