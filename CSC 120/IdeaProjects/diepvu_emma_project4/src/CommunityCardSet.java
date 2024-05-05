import java.util.ArrayList;


public class CommunityCardSet {
    private ArrayList<Card> CommunitySet;
    /**
     * Create a community set as an array list of cards with different methods
     */
    public CommunityCardSet(){

        CommunitySet = new ArrayList<Card>();
    }

    /**
     *
     * @param toAdd card added to the community set
     */
    public void addCardToCommunity(Card toAdd){
        CommunitySet.add(toAdd);

    }

    /**
     * remove first card in the community
     */
    public void removeCardFromCommunity(){
        CommunitySet.remove(0);
    }

    /**
     * @return print out better representation of the community as an array list of cards
     */
    public String toString(){
        return CommunitySet.toString();
    }

    /**
     * @return the array list of cards from community object
     */

    public ArrayList<Card> getCommunityList(){
        return new ArrayList<Card>(this.CommunitySet);
    }

    private ArrayList<Integer> getValueOfCommunity(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(Card c: this.CommunitySet){
            res.add(c.getValue());
        }
        return res;
    }

    private ArrayList<String> getSuitOfCommunity(){
        ArrayList<String> res = new ArrayList<String>();
        for(Card c: this.CommunitySet){
            res.add(c.getSuit());
        }
        return res;
    }

    /**
     * Check community sets are identical (if decide to change the game by having different community sets)
     * @param other other community set
     * @return true if they are identical, else return false
     */

    public boolean equals(Object other){
        if(other == null){
            return false;
        } else if(other == this){
            return true;
        } else if(!(other instanceof CommunityCardSet)){
            return false;
        } else{
            CommunityCardSet otherCommunity = (CommunityCardSet) other;

            return otherCommunity.getValueOfCommunity().equals(getValueOfCommunity())
                    && otherCommunity.getSuitOfCommunity().equals(getSuitOfCommunity());
        }

    }

}
