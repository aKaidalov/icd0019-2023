package collections.simulator;

import java.util.*;

public class Hand implements Iterable<Card>, Comparable<Hand> {

    private static final int SAME_SUITS_IN_ANY_FLUSH = 5;
    private static final int NUMBER_OF_VALUES = 5;
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return cards.toString();
    }

    public HandType getHandType() {

        List<Card> cardsAreSorted = sortCards();
        int cache = containsSameValues(cardsAreSorted).get(0);
        int wereBreaks = containsSameValues(cardsAreSorted).get(1);
        int streak = containsSameValues(cardsAreSorted).get(2); // need for FOUR_OF_A_KIND

        if (containsStraightFlush(cardsAreSorted)){
            return  HandType.STRAIGHT_FLUSH;
        } else if (containsFourOfAKind(streak)){
            return  HandType.FOUR_OF_A_KIND;
        } else if (containsFullHouse(cache, wereBreaks)){
            return  HandType.FULL_HOUSE;
        } else if (containsFlush()){
            return  HandType.FLUSH;
        } else if (containsStraight(cardsAreSorted)){
            return  HandType.STRAIGHT;
        } else if (containsTrips(cache, wereBreaks)){
            return  HandType.TRIPS;
        } else if (containsTwoPairs(cache, wereBreaks)){
            return  HandType.TWO_PAIRS;
        } else if (containsOnePair(cache, wereBreaks)){
            return  HandType.ONE_PAIR;
        } else {
            return  HandType.HIGH_CARD;
        }
    }

    public boolean containsStraightFlush(List<Card> cardsAreSorted) {
        if (containsSameSuits() == SAME_SUITS_IN_ANY_FLUSH) {
            return isSequential(cardsAreSorted);
        }
        return false;
    }
    public boolean containsFourOfAKind(int streak) {
        return streak == 4;
    }
    public boolean containsFullHouse(int cache, int wereBreaks) {
        return cache == 5 && wereBreaks == 1;
    }
    public boolean containsFlush() {
        return containsSameSuits() == SAME_SUITS_IN_ANY_FLUSH;
    }
    public boolean containsStraight(List<Card> cardsAreSorted) {
        return cardsAreSorted.size() == NUMBER_OF_VALUES
                && (isSequential(cardsAreSorted) || compareCardsToBabyStraight());
    }

    public boolean containsTrips(int cache, int wereBreaks) {
        return cache == 3 && wereBreaks == 0;
    }
    public boolean containsTwoPairs(int cache, int wereBreaks) {
        return cache == 4;
    }
    public boolean containsOnePair(int cache, int wereBreaks) {
        return cache == 2;
    }


    public int containsSameSuits() {
        int sum = 1;    // 1 because "i" starts from 0
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getSuit() == cards.get(i + 1).getSuit()){
                sum += 1;
            }
        }
        return sum;
    }

    public List<Integer> containsSameValues(List<Card> list) {
        List<Integer> result = new ArrayList<>();
        int sameCards = 0;
        int cache = 0;  // if there will be full house, it returns 5 (breaks on pair and adds later 3 = 2 + 3)
        int wasBreak = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getValue() == list.get(i + 1).getValue()){
                if (sameCards == 0) {
                    sameCards += 1; // means that the first card is also the same
                }

                sameCards += 1;

                if (i + 1 == list.size() - 1) { // if some group of cards locates at the end of the hand
                    cache += sameCards;
                }
            } else if (list.get(i).getValue() != list.get(i + 1).getValue() && sameCards > 0) {
                cache += sameCards;
                wasBreak += 1;
                sameCards = 0;
            }
        }
        result.addAll(List.of(cache, wasBreak, sameCards));
        return result;
    }

    public List<Card> sortCards() {
        List<Card> cardsToSort = copyCards();
        Card temp;
        for (int i = 0; i < cardsToSort.size(); i++) {
            for (int j = 0; j < cardsToSort.size() - 1 - i; j++) {
                if (cardsToSort.get(j).getValue().ordinal() > cardsToSort.get(j + 1).getValue().ordinal()){
                    temp = cardsToSort.get(j);
                    cardsToSort.set(j, cardsToSort.get(j + 1));
                    cardsToSort.set(j + 1, temp);
                }
            }
        }

        return cardsToSort;
    }
    private List<Card> copyCards() {
        List<Card> cardsCopy = new ArrayList<>();
        for (Card card : cards) {
            cardsCopy.add(card);
        }
        return cardsCopy;
    }

    public boolean isSequential(List<Card> cardsAreSorted) {
        for (int i = 0; i < cardsAreSorted.size() - 1; i++) {
            Card currentCard = cardsAreSorted.get(i);
            Card nextCard = cardsAreSorted.get(i + 1);
            if (nextCard.compareTo(currentCard) != 1
                    || nextCard.getValue().ordinal() - currentCard.getValue().ordinal() != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean compareCardsToBabyStraight() {
        List<Card.CardValue> cardValues = copyValues();
        List<Card.CardValue> hardCode = Arrays.asList(Card.CardValue.A, Card.CardValue.S2, Card.CardValue.S3
                , Card.CardValue.S4, Card.CardValue.S5);

        return compareValues(cardValues, hardCode);
    }

    public boolean compareValues(List<Card.CardValue> cardValues, List<Card.CardValue> hardCode) {
        for (int i = 0; i < NUMBER_OF_VALUES; i++) {
            if (cardValues.get(i) != hardCode.get(i)){
                return false;
            }
        }
        return true;
    }

    private List<Card.CardValue> copyValues() {
        List<Card.CardValue> cardValues = new ArrayList<>();
        for (Card card : cards) {
            cardValues.add(card.getValue());
        }
        return cardValues;
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
