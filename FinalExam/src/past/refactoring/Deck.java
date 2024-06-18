package past.refactoring;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> contents;
    private int topIndex = 0;
    private static final String[] SUITS = {"S", "H", "C", "D"};

    public Deck() {
        initializeContents();
        topIndex = 0;
    }

    private void initializeContents() {
        contents = new ArrayList<Card>();
        for (String suit : SUITS) {
            for (int rank = 2; rank <= 14; rank++) {
                contents.add(new Card(rank, suit));
            }
        }
    }

    public Card deal() {
        if (size() == 0) {
            return null;
        } else {
            Card toReturn = contents.get(topIndex);
            topIndex++;
            return toReturn;
        }
    }

    public void shuffle() {
        Collections.shuffle(contents.subList(topIndex, contents.size()));
    }

    public int size() {
        return contents.size() - topIndex;
    }
}