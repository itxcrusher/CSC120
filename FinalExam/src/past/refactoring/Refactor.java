package past.refactoring;

import java.util.ArrayList;
import java.util.Collections;

public class Refactor {
    private ArrayList<Card> contents;
    private int topIndex = 0;
    private static final String[] SUITS = {"S", "H", "C", "D"};
    private boolean shuffled;

    public Refactor() {
        initializeContents();
        topIndex = 0;
        shuffled = false;
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
            Card toReturn;
            if(shuffled){
                int randomIndex = getRandomIndex(topIndex, contents.size());
                swap(topIndex, randomIndex);
            }
            toReturn = contents.get(topIndex);
            topIndex++;
            return toReturn;
        }
    }

    public void shuffle() {
        if(!shuffled){
            Collections.shuffle(contents.subList(topIndex, contents.size()));
            shuffled = true;
        }
    }

    public int size() {
        return contents.size() - topIndex;
    }
    private int getRandomIndex(int low, int high){
        return 0;
    }
    private void swap(int i, int j){
        return;
    }
}