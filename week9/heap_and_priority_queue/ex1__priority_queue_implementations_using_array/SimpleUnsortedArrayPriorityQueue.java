package vn.io.tunaa.dsa.week9.heap_and_priority_queue.ex1__priority_queue_implementations_using_array;

public class SimpleUnsortedArrayPriorityQueue<E extends Comparable<E>> implements SimpleArrayPriorityQueue<E> {

    private final int DEFAULT_CAPACITY = 2;
    private E[] data = (E[]) new Comparable[DEFAULT_CAPACITY];
    private int size = 0;


    @Override
    public void insert(E element) {
        if (size >= data.length) {
            enlarge();
        }

        data[size] = element;
        size++;
    }

    private int getMinIndex() {
        int minIndex = 0;

        for (int i = 1; i < size; i++) {
            if (data[i].compareTo(data[minIndex]) < 0) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    @Override
    public E extractMin() {
        int minIndex = getMinIndex();

        E tmp = data[minIndex];
        data[minIndex] = data[size - 1];
        data[size - 1] = tmp;

        return data[--size];
    }

    @Override
    public E peek() {
        return data[getMinIndex()];
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