package vn.io.tunaa.dsa.revision_2526_1st_midterm_2_2.ex2__dictionary;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class DictList<T> implements ListInterface<T> {
    private final ArrayList<T> words = new ArrayList<>();

    @Override
    public void add(T data) {
        words.add(data);
    }

    @Override
    public T get(int i) {
        return words.get(i);
    }

    @Override
    public int size() {
        return words.size();
    }

    @Override
    public boolean isEmpty() {
        return words.isEmpty();
    }
}