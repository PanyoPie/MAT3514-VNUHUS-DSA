package vn.io.tunaa.dsa.week7.revision._1_2.ex2__queue_and_tree;

public interface QueueInterface<T> {
    public void enqueue(T element);

    public T dequeue();

    public boolean isEmpty();
}