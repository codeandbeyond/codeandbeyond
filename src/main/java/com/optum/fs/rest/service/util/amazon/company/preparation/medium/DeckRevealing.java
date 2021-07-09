package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DeckRevealing {
    public static void main(String[] args) {
        int[] deck = {17,13,11,2,3,5,7};
        DeckRevealing deckRevealing = new DeckRevealing();
        deckRevealing.deckRevealedIncreasing(deck);
    }
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList();
        for (int i = 0; i < N; ++i)
            index.add(i);

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card: deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }

        return ans;
    }
}
