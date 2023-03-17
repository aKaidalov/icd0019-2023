package collections.simulator;

import java.util.*;

public class Hand implements Iterable<Card>, Comparable<Hand> {

    private final int SAME_SUITS_IN_STRAIGHT_FLUSH = 5;
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return cards.toString();
    }

    public HandType getHandType() {

        if (containsStraightFlush()){
            return  HandType.STRAIGHT_FLUSH;
        } else if (containsFourOfAKind()){
            return  HandType.FOUR_OF_A_KIND;
        } else if (containsFullHouse()){
            return  HandType.FULL_HOUSE;
        } else if (containsFlush()){
            return  HandType.FLUSH;
        } else if (containsStraight()){
            return  HandType.STRAIGHT;
        } else if (containsTrips()){
            return  HandType.TRIPS;
        } else if (containsTwoPairs()){
            return  HandType.TWO_PAIRS;
        } else if (containsOnePair()){
            return  HandType.ONE_PAIR;
        }
        throw new IllegalStateException("programming error");
    }

    public boolean containsStraightFlush() {
        int totalSameSuits = containsSameSuits();
        if (totalSameSuits == SAME_SUITS_IN_STRAIGHT_FLUSH) {
            List<Card> cardsAreSorted = Arrays.sort(cards);
            return true;
        }
        return false;
    }
    public boolean containsFourOfAKind() {
        return true;
    }
    public boolean containsFullHouse() {
        return true;
    }
    public boolean containsFlush() {
        return true;
    }
    public boolean containsStraight() {
        return true;
    }
    public boolean containsTrips() {
        return true;
    }
    public boolean containsTwoPairs() {
        return true;
    }
    public boolean containsOnePair() {
        return true;
    }

    public int containsSameSuits() {
        int sum = 0;
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getSuit() == cards.get(i + 1).getSuit()){
                sum += 1;
            }
        }
        return sum;
    }

    public List<Card> sortCards() {
        List<Card> cardsToSort = new ArrayList<>();
        // need to make a list of value.ordinal() and sort values
        // and create new list, but with sequential order
        // maybe need to use Card.compareTo()

        return cardsToSort;
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    @Override
    public int compareTo(Hand other) {
        return 0;
    }
}
