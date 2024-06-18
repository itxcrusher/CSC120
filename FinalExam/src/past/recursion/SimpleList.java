package past.recursion;

public class SimpleList<E>
{
    /**
     * Constructs an empty SimpleList
     */
    public SimpleList(){}

    /**
     * Appends an element to the list.
     *
     * @param toAdd the element to append.
     */
    public void add (E toAdd){
        return;
    }

    /**
     * Gets an element from a given position in the list.
     *
     * @param index the index of the element to get.
     *
     * @return the element at the given index. If the index is for a
     * position beyond the end of the list, returns null.
     */
    public E get(int index){
        return null;
    }

    /**
     * Gets a sublist of the list.
     *
     * @param startingIndex the position in the list to start from
     *
     * @return a sub-list of the list, starting at startingIndex and
     * going until the end of the list. If the startingIndex is beyond
     * the end of the list, returns an empty list.
     */
    public SimpleList<E> subList(int startingIndex){
        return null;
    }

    /**
     * Swaps two elements in the list. If either of the given indexes
     * is beyond the end of the list, has no effect.
     *
     * @param i the index of one of the elements to swap.
     * @param j the index of one of the elements to swap.
     */
    public void swap(int i, int j){
        return;
    }
}