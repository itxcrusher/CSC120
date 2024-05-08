/*
 * Author’s Name: Ali Hamza
 * Honor Code: I hereby affirm that I have carried out all my academic endeavours with full academic honesty.
 * */

public class SimonSaysGame
{	
    private String phrase;
	
    public SimonSaysGame(String startingWord)
    {
        phrase = startingWord;
    }

    public void playGame()
    {
        StringProcessor sp = new StringProcessor();
		
        System.out.println(phrase);
		
        phrase = sp.insertAfter(phrase, 'U', 'L');
        step("Add an L after the U");
		
        phrase = sp.removeAll(phrase, 'I');
        step("Remove all the Is");
		
        phrase = sp.replaceOnce(phrase, 'F', 'O');
        phrase = sp.replaceOnce(phrase, 'M', 'O');
        step("Replace the F and M with O");
		
        phrase = sp.prepend(phrase, 'E');
        step("Add an E to the beginning");
				
        phrase = sp.removeOnce(phrase, 'L');
        phrase = sp.removeOnce(phrase, 'E');
        phrase = sp.removeOnce(phrase, 'G');
        phrase = sp.removeOnce(phrase, 'O', 2);
        phrase = sp.prepend(phrase, "LEGO");
        step("Put the L, first E, G, and the second O "
             + "at the beginning of the word in LEGO order");
		
        phrase = sp.replaceLast(phrase, 'E', 'P');
        step("Replace the last E with a P");
		
        phrase = sp.append(phrase, 'S');
        step("Add an S to the end");

        phrase = sp.insertAfter(phrase, 'S', 'E');
        step("Add an E after the S");
		
        phrase = sp.insertAfter(phrase, 'O', ' ');
        step("Add a space after the first O");
				
        phrase = sp.removeOnce(phrase, 'P');
        phrase = sp.removeOnce(phrase, 'E', 2);
        phrase = sp.removeOnce(phrase, 'R');
        phrase = sp.insertAfter(phrase, ' ', "PER");
        step("Move the P, the second E and the R to the beginning"
             + " of the second word, in PER order.");
		
        phrase = sp.removeOnce(phrase, 'U');
        step("Remove the U");

        phrase = sp.removeOnce(phrase, 'S');
        phrase = sp.insertAfter(phrase, 'R', 'S');
        step("Move the S to after the R");
    }
	
    public String getPhrase()
    {
        return phrase;
    }
	
    private void step(String msg)
    {
        System.out.println(msg + ".");
        System.out.println("   " + phrase);
    }
	
    public static void main (String [] args)
    {
        SimonSaysGame game = new SimonSaysGame("MINI FIGURE");
        game.playGame();
        System.out.println("Final result: " + game.getPhrase());
    }
}
