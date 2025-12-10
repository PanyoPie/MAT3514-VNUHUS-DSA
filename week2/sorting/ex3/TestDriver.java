package vn.io.tunaa.dsa.week2.sorting.ex3;

import vn.io.tunaa.dsa.week2.sorting.ex2.SortComparable;

import java.util.Arrays;

public class TestDriver {
    public static void main(String[] args) {
        Card[] deck = Card.newDeck();
        Card[] deck1 = deck.clone();
        Card[] deck2 = deck.clone();
        Card[] deck3 = deck.clone();
        Card[] deck4 = deck.clone();
        Card[] deck5 = deck.clone();
        Card[] deck6 = deck.clone();

        System.out.println("Bộ bài ban đầu:");
        System.out.println(Arrays.toString(deck));
        System.out.println();

        Arrays.sort(deck1, new CompareCard());

        System.out.println("Bộ bài sau khi sắp xếp:");
        System.out.println(Arrays.toString(deck1));
        System.out.println();

        SortComparable.bubbleSort(deck2);

        System.out.println("Bộ bài sau khi sắp xếp bằng Bubble Sort:");
        System.out.println(Arrays.toString(deck2));
        System.out.println();

        SortComparable.insertionSort(deck3);

        System.out.println("Bộ bài sau khi sắp xếp bằng Insertion Sort:");
        System.out.println(Arrays.toString(deck3));
        System.out.println();

        SortComparable.selectionSort(deck4);

        System.out.println("Bộ bài sau khi sắp xếp bằng Selection Sort:");
        System.out.println(Arrays.toString(deck4));
        System.out.println();

        SortComparable.quickSort(deck5, 0, deck5.length - 1);

        System.out.println("Bộ bài sau khi sắp xếp bằng Quick Sort:");
        System.out.println(Arrays.toString(deck5));
        System.out.println();

        SortComparable.mergeSort(deck6, 0, deck6.length - 1);

        System.out.println("Bộ bài sau khi sắp xếp bằng Merge Sort:");
        System.out.println(Arrays.toString(deck6));
        System.out.println();
    }
}