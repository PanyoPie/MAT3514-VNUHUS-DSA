package vn.io.tunaa.dsa.week9.heap_and_priority_queue.ex3__priority_queue_implementations_using_heap;

public class HeapPriorityQueue<E extends Comparable<E>> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] heap;
    private int size;

    @SuppressWarnings("unchecked")
    public HeapPriorityQueue() {
        heap = (E[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Thêm một phần tử mới vào heap.
     *
     * @param element phần tử cần chèn
     * @throws IllegalArgumentException nếu phần tử là null
     */
    public void insert(E element) {
        if (size >= heap.length) {
            enlarge();
        }

        heap[size] = element;
        percolateUp(size);
        size++;
    }

    /**
     * Lấy (nhưng không xóa) phần tử nhỏ nhất trong heap.
     *
     * @return phần tử nhỏ nhất hoặc null nếu heap rỗng
     */
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return heap[0];
    }

    /**
     * Lấy và xóa phần tử nhỏ nhất trong heap.
     *
     * @return phần tử nhỏ nhất hoặc null nếu heap rỗng
     */
    public E extractMin() {
        if (isEmpty()) {
            return null;
        }

        E tmp = heap[0];
        size--;
        heap[0] = heap[size];
        heap[size] = null;

        percolateDown(0);

        return tmp;
    }

    /**
     * Kiểm tra xem heap có rỗng không.
     *
     * @return true nếu heap rỗng, false nếu có phần tử
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Trả về số lượng phần tử hiện có trong heap.
     *
     * @return số phần tử trong heap
     */
    public int size() {
        return size;
    }

    private void swap(int a, int b) {
        E tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    /**
     * Hàm hỗ trợ đưa phần tử lên trên để duy trì tính chất của heap.
     *
     * @param index vị trí phần tử mới chèn
     */
    private void percolateUp(int index) {
        while (index > 0 && heap[(index - 1) / 2].compareTo(heap[index]) > 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * Hàm hỗ trợ đưa phần tử xuống dưới để duy trì tính chất của heap.
     *
     * @param index vị trí phần tử cần đưa xuống
     */
    private void percolateDown(int index) {
        while (true) {
            int i = 2 * index + 1;
            int j = i + 1;
            int b = index;

            if (i < size && heap[i].compareTo(heap[b]) < 0) {
                b = i;
            }

            if (j < size && heap[j].compareTo(heap[b]) < 0) {
                b = j;
            }

            if (b == index) {
                break;
            }

            swap(index, b);
            index = b;
        }
    }

    /**
     * Tăng gấp đôi dung lượng mảng khi hết chỗ.
     */
    @SuppressWarnings("unchecked")
    private void enlarge() {
        int newCapacity = heap.length * 2;
        E[] newHeap = (E[]) new Comparable[newCapacity];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }

    /**
     * Trả về chuỗi biểu diễn các phần tử trong heap theo thứ tự mảng.
     *
     * @return chuỗi chứa các phần tử của heap
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < heap.length; i++) {
            sb.append(heap[i]);
            if (i < heap.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}