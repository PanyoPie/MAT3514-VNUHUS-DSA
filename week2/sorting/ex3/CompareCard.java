package vn.io.tunaa.dsa.week2.sorting.ex3;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        int rank1 = c1.getRankIndex();
        int rank2 = c2.getRankIndex();

        if (rank1 != rank2) {
            return rank1 - rank2;
        }

        int suit1 = c1.getSuitIndex();
        int suit2 = c2.getSuitIndex();
        return suit1 - suit2;
    }
}