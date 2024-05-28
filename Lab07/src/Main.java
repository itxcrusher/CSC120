/*
 * Author’s Name: Ali Hamza
 * Honor Code: I hereby affirm that I have carried out all my academic endeavours with full academic honesty.
 * */
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    
    public static void getMinTests(Tester t)
    {
        t.testSection("Testing getMin and getMinIndex");
        
        ListProcessor lp = new ListProcessor();
        
        String[] strings = {"b", "e", "a", "d", "g", "k", "c", "r", "t", "v", "a", "c", "b"};

        ArrayList<String> originalList = new ArrayList<String>(Arrays.asList(strings));
        ArrayList<String> myList = new ArrayList<String>(originalList);
        // makes a copy of originalList

        
        String smallest = lp.getMin(myList);
        t.assertEquals("The minimum of a list of strings is the first in alphabetical order",
                       "a",
                       smallest);

        t.assertEquals("getMin should not modify myList",
                       originalList,
                       myList);

        t.assertEquals("getMinIndex should return the index of the first occurrence of the min element",
                       2,
                       lp.getMinIndex(myList));
    }

    public static void sortTests(Tester t)
    {
        t.testSection("Testing sort");
        
        ListProcessor lp = new ListProcessor();
        
        String[] strings = {"b", "e", "a", "d", "g", "k", "c", "r", "t", "v", "a", "c", "b"};

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(strings));

        lp.sort(myList);

        String[] sortedStrings = {"a", "a", "b", "b", "c", "c", "d", "e", "g", "k", "r", "t", "v"};
        ArrayList<String> sortedList = new ArrayList<String>(Arrays.asList(sortedStrings));
        t.assertEquals("sort puts list in alphabetic order",
                       sortedList,
                       myList);
    }

    public static void main(String [] args)
    {
        Tester t = new Tester();
        getMinTests(t);
        sortTests(t);

        t.finishTests();
    }
}
