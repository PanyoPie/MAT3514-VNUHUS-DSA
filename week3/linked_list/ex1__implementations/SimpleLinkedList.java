package vn.io.tunaa.dsa.week3.linked_list.ex1__implementations;

public class SimpleLinkedList<T> {

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    public int size;

    /**
     * Thêm phần tử mới vào cuối danh sách
     * @param data phần tử cần thêm
     */
    public void add(T data) {
        addAt(size(), data);
    }

    /**
     * Thêm phần tử vào vị trí chỉ định (0-based)
     * @param index vị trí cần thêm (0 ≤ index ≤ size)
     * @param data phần tử cần thêm
     */
    public void addAt(int index, T data) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (head == null) {
            head = new Node(data);
            return;
        }

        Node node = new Node(data);
        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;

        size++;
    }

    /**
     * Lấy phần tử tại vị trí index (0-based)
     * @param index vị trí cần lấy
     * @return phần tử tại vị trí index
     */
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Gán giá trị mới cho phần tử tại vị trí index
     * @param index vị trí cần gán
     * @param data giá trị mới
     */
    public void set(int index, T data) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = data;
    }

    /**
     * Xóa phần tử tại vị trí index
     * @param index vị trí cần xóa
     */
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;
        }

        size--;
    }

    /**
     * Trả về số phần tử trong danh sách
     * @return số lượng phần tử
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        }

        int count = 1;
        Node current = head;
        while (current.next != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    /**
     * Kiểm tra danh sách có rỗng hay không
     * @return true nếu rỗng, false nếu có phần tử
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Kiểm tra xem danh sách có chứa phần tử cụ thể không
     * @param data phần tử cần kiểm tra
     * @return true nếu có, false nếu không
     */
    public boolean contains(T data) {
        if (isEmpty()) {
            return false;
        }

        Node current = head;
        for (int i = 0; i < size() - 1; i++) {
            if (current.data.equals(data)) {
                return true;
            }

            current = current.next;
        }

        if (current.data.equals(data)) {
            return true;
        }

        return false;
    }

    /**
     * Tìm vị trí (index) đầu tiên của phần tử trong danh sách
     * @param data phần tử cần tìm
     * @return vị trí nếu tìm thấy, -1 nếu không có
     */
    public int indexOf(T data) {
        if (isEmpty()) {
            return -1;
        }

        Node current = head;
        for (int i = 0; i < size() - 1; i++) {
            if (current.data.equals(data)) {
                return i;
            }

            current = current.next;
        }

        if (current.data.equals(data)) {
            return size() - 1;
        }

        return -1;
    }

    /**
     * Xóa toàn bộ danh sách, đưa về trạng thái rỗng
     */
    public void clear() {
        head = null;
    }

    /**
     * Trả về chuỗi biểu diễn danh sách liên kết, dùng để in ra
     * @return chuỗi dạng [a, b, c]
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        Node node = head;

        while (node != null) {
            stringBuilder.append(node.data);

            if (node.next != null) {
                stringBuilder.append(", ");
            }

            node = node.next;
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}