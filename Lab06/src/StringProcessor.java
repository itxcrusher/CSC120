public class StringProcessor
{
    /**
     * Constructs a string by inserting a given character after the
     * first occurrence of another given character in a given
     * string.
     *
     * @param s the given string
     * @param before the character after which to insert (and which
     * will occur before the inserted text in the resulting string).
     * @param toInsert the character to insert
     * @return the newly constructed string
     */
    public String insertAfter(String s, char before, char toInsert)
    {
        return insertAfter(s, before, String.valueOf(toInsert));
    }
	
    /**
     * Constructs a string by inserting a given string after the
     * first occurrence of a given character in a given string.
     *
     * @param s the given string
     * @param before the character after which to insert (and which
     * will occur before the inserted text in the resulting string).
     * @param toInsert the string to insert
     * @return the newly constructed string
     */
    public String insertAfter (String s, char before, String toInsert)
    {
        int insertPosition = s.indexOf(before) + 1;
        String begin = s.substring(0, insertPosition);
        String end = s.substring(insertPosition); 
        return begin + toInsert + end;
    }

    /**
     * Constructs a string by removing all instances of a given
     * character from a given string.
     *
     * @param s the given string
     * @param toRemove the character to remove
     * @return the newly constructed string
     */
    public String removeAll(String s, char toRemove)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != toRemove) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
	
    /**
     * Constructs a string by removing the first occurrence of a given
     * character from a given string.
     *
     * @param s the given string
     * @param toRemove the character to remove
     * @return the newly constructed string
     */
    public String removeOnce(String s, char toRemove)
    {
        return removeOnce(s, toRemove, 1);
    }

    /**
     * Constructs a string by removing a particular occurrence of a given
     * character from a given string.
     *
     * @param s the given string
     * @param toRemove the character to remove
     * @param whichOne the indication of which occurrence to remove. 1
     * indicates to remove the first occurrence, 3 means to remove the
     * third.
     * @return the newly constructed string
     */
    public String removeOnce(String s, char toRemove, int whichOne)
    {
        int index = indexOfOccurrence(s, toRemove, whichOne);
        if (index == -1) {
            return s;
        }
        return s.substring(0, index) + s.substring(index + 1);
    }

    /**
     * Constructs a string by replacing the first occurrence of a
     * given character with a given replacement in a given string.
     *
     * @param s the given string
     * @param toReplace the character to replace
     * @param replacement the character with which to replace 
     * @return the newly constructed string
     */
    public String replaceOnce(String s, char toReplace, char replacement)
    {
        int index = s.indexOf(toReplace);
        if (index == -1) {
            return s;
        }
        return s.substring(0, index) + replacement + s.substring(index + 1);
    }


    /**
     * Constructs a string by replacing the last occurrence of a
     * given character with a given replacement in a given string.
     *
     * @param s the given string
     * @param toReplace the character to replace
     * @param replacement the character with which to replace 
     * @return the newly constructed string
     */
    public String replaceLast(String s, char toReplace, char replacement)
    {
        int index = indexOfLastOccurrence(s, toReplace);
        if (index == -1) {
            return s;
        }
        return s.substring(0, index) + replacement + s.substring(index + 1);
    }

    /**
     * Constructs a string by prepending a character to the beginning
     * of a given string.
     *
     * @param s the given string
     * @param prefix the character to add
     * @return the newly constructed string
     */
    public String prepend(String s, char prefix)
    {
        return prepend(s, String.valueOf(prefix));
    }
	
    /**
     * Constructs a string by prepending a string to the beginning
     * of a given string.
     *
     * @param s the given string
     * @param prefix the string to add
     * @return the newly constructed string
     */
    public String prepend(String s, String prefix)
    {
        return prefix + s;
    }
	

    /**
     * Constructs a string by appending a character to the end
     * of a given string.
     *
     * @param s the given string
     * @param suffix the character to add
     * @return the newly constructed string
     */
    public String append(String s, char suffix)
    {
        return append(s, String.valueOf(suffix));
    }
	
    /**
     * Constructs a string by appending a string to the end
     * of a given string.
     *
     * @param s the given string
     * @param suffix the string to add
     * @return the newly constructed string
     */
    public String append(String s, String suffix)
    {
        return s + suffix;
    }

    /**
     * Gives the index of a character a string.
     *
     * @param s the given string
     * @param toFind The character to find.
     * @param whichOne The copy of the character to find. 1 indicates 
     * we are searching for the first one, 2 the second one, etc...
     * @return the index in the string of the appropriate copy of toFind. 
     */
    private int indexOfOccurrence(String s, char toFind, int whichOne)
    {
        int position = -1;
		
        while (whichOne >= 1) {
            position = s.indexOf(toFind, position+1);
            whichOne --;
        }
		
        return position;
    }

    /**
     * Finds the index of the last occurrence of a given character in
     * a string.
     *
     * @param s the given string.
     * @param toFind the character to find.
     * @return the index of the last copy of toFind.
     */
    private int indexOfLastOccurrence(String s, char toFind)
    {
        int count = 1;
        while (indexOfOccurrence(s, toFind, count) != -1) {
            count ++;
        }
        return indexOfOccurrence(s, toFind, count-1);
    }

}
