package vn.io.tunaa.dsa.revision_2526_1st_midterm_1_2.ex2__queue_and_tree;

public interface QueueInterface<T> {
    public void enqueue(T element);

    public T dequeue();

    public boolean isEmpty();
}