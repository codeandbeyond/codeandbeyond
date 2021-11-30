package com.optum.fs.rest.service.util.amazon.company.preparation;

import java.util.TreeMap;

public class NStraightHands {
    public static void main(String[] args) {
        NStraightHands nStraightHands = new NStraightHands();
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int W = 3;
        boolean result = nStraightHands.isNStraightHand(hand, W);
        System.out.println(result);
    }

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        TreeMap<Integer, Integer> countCards = new TreeMap<>();

        for (int card : hand) {
            if (!countCards.containsKey(card)) {
                countCards.put(card, 1);
            } else {
                countCards.put(card, countCards.get(card) + 1);
            }
        }

        while (countCards.size() > 0) {
            int minValue = countCards.firstKey();
            for (int card = minValue; card < minValue + W; card++) {
                if (!countCards.containsKey(card)) {
                    return false;
                } else if (countCards.get(card) == 1) {
                    countCards.remove(card);

                } else {
                    countCards.replace(card, countCards.get(card) - 1);
                }

            }
        }

        return true;
    }
}
