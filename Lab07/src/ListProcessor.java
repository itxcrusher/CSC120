import java.util.ArrayList;

public class ListProcessor
{
    /**
     * Swaps elements i and j in the given list.
     */
    private void swap(ArrayList<String> aList, int i, int j)
    {
        String tmp = aList.get(i);
        aList.set(i, aList.get(j));
        aList.set(j, tmp);
    }

    /**
     * Finds the minimum element of a list, returns it.
     *
     * @param aList the list in which to find the minimum element.
     * @return the minimum element of the list.
     */
    public String getMin(ArrayList<String> aList) {
        return getMin(aList, 0, aList.size() - 1);
    }

    /**
     * Finds the minimum element of a list recursively, returns it.
     *
     * @param aList the list in which to find the minimum element.
     * @param start starting index
     * @param end ending index
     * @return the minimum element of the list.
     */
    private String getMin(ArrayList<String> aList, int start, int end) {
        if (start == end) {
            return aList.get(start);
        }
        String minRest = getMin(aList, start + 1, end);
        return aList.get(start).compareTo(minRest) < 0 ? aList.get(start) : minRest;
    }

    /**
     * Finds the minimum element of a list, returns the index of that element.
     *
     * @param aList the list in which to find the minimum element.
     * @return the index of the minimum element in the list.
     */
    public int getMinIndex(ArrayList<String> aList) {
        return getMinIndex(aList, 0, aList.size() - 1);
    }

    /**
     * Finds the minimum element of a list recursively, returns the index of that element.
     *
     * @param aList the list in which to find the minimum element.
     * @param start starting index (used for recursion)
     * @param end ending index (used for recursion)
     * @return the index of the minimum element in the list.
     */
    private int getMinIndex(ArrayList<String> aList, int start, int end) {
        if (start == end) {
            return start;
        }

        int minIndexRest = getMinIndex(aList, start + 1, end);

        String minElement = aList.get(minIndexRest);
        if (aList.get(start).compareTo(minElement) < 0) {
            return start;
        } else if (aList.get(start).equals(minElement)) {
            return start;
        } else {
            return minIndexRest;
        }
    }

    /**
     * Sorts the entire list using selection sort recursively.
     *
     * @param aList the list to sort
     */
    public void sort(ArrayList<String> aList) {
        sortSublist(aList, 0);
    }

    /**
     * Sorts the portion of 'aList' from index 'start' to the end of 'aList'.
     * The list is sorted in place.
     *
     * @param aList the list to sort
     * @param start the index of the first element of interest
     */
    private void sortSublist(ArrayList<String> aList, int start) {
        if (start >= aList.size()) {
            return;
        }
        int minIndex = getMinIndex(aList, start, aList.size() - 1);
        swap(aList, start, minIndex);
        sortSublist(aList, start + 1);
    }
}