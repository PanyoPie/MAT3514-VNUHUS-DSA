package vn.io.tunaa.dsa.week2.sorting.ex3;

public class Card implements Comparable<Card> {
    private String rank;
    private String suit;

    private static final String[] RANKS = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
    private static final String[] SUITS = {"Bích", "Tép", "Rô", "Cơ"};

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getRankIndex() {
        for (int i = 0; i < RANKS.length; i++) {
            if (RANKS[i].equals(rank)) {
                return i;
            }
        }

        return -1;
    }

    public int getSuitIndex() {
        for (int i = 0; i < SUITS.length; i++) {
            if (SUITS[i].equals(suit)) {
                return i;
            }
        }

        return -1;
    }

    public static Card[] newDeck() {
        Card[] deck = new Card[52];
        int index = 0;

        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index] = new Card(rank, suit);
                index++;
            }
        }

        return deck;
    }

    @Override
    public int compareTo(Card other) {
        int rank1 = this.getRankIndex();
        int rank2 = other.getRankIndex();

        if (rank1 != rank2) {
            return rank1 - rank2;
        }

        int suit1 = this.getSuitIndex();
        int suit2 = other.getSuitIndex();
        return suit1 - suit2;
    }

    @Override
    public String toString() {
        return String.format("[%s %s]", rank, suit);
    }
}
