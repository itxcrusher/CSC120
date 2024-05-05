import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

public class Main
{
    public static final int NUM_ITEMS = 25;
    public static final int MIN_VALUE = -50;
    public static final int MAX_VALUE = 100;
    public static final int NUM_RUN = 5;

    /**
     * @return true if and only if the list is in sorted order
     * [i.e. if every element in the list is no smaller than the
     * element that preceeds it].
     */
    private boolean isSorted(ArrayList<Integer> aList)
    {
        for (int i = 1; i < aList.size(); i++) {
            if (aList.get(i).compareTo(aList.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> createList(int num, int min, int max)
    {
        Random rGen = new Random();
        ArrayList<Integer> toReturn = new ArrayList<Integer>();

        for (int i = 0; i < num; i++) {
            int value = rGen.nextInt(max - min + 1) + min;
            toReturn.add(value);
        }

        return toReturn;
    }

    /**
     * Creates and sorts a list of Integers.
     */
    public double go()
    {
        Sorter sorter = new Sorter();
        
        ArrayList<Integer> randomItems = createList(NUM_ITEMS, MIN_VALUE, MAX_VALUE);
        //System.out.println("Before (" + randomItems.size() + " items): " + randomItems);

        long startTime = System.nanoTime();

        sorter.mergeSort(randomItems);

        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;

        //System.out.println("After (" + randomItems.size() + " items): " + randomItems);

        double duration = elapsedTime/1000.0;
    
        //System.out.printf("Duration: %.3f milliseconds\n", elapsedTime/1000.0);
    
        if (! isSorted(randomItems)) {
            System.out.println("ERROR -- LIST DIDN'T GET SORTED");
        }
        return duration;
    }

//    public static void usingFileWriter() throws IOException
//    {
//
//
//        FileWriter fileWriter = new FileWriter("file.txt");
//        fileWriter.write();
//        fileWriter.close();
//    }

    
    public static void main(String[] args)
    {
        int i = 0;
        double res = 0;
        while (i < NUM_RUN){
            double duration = new Main().go();
            res += duration;

            i++;



        }
        double average = res/NUM_RUN;
        System.out.println("Average: " + average);

    }
}
