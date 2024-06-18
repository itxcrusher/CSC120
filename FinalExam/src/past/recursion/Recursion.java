package past.recursion;

public class Recursion<E>
{
    /**
     * Constructs an empty SimpleList
     */
    public Recursion(){}

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

    public static class SimpleListProcessor {
        public boolean same(SimpleList<String> a, SimpleList<String> b) {
            if (a.get(0) == null && b.get(0) == null) {
                return true;
            }
            if (a.get(0) == null || b.get(0) == null) {
                return false;
            }
            String elementA = a.get(0);
            String elementB = b.get(0);
            return elementA.equals(elementB) && same(a.subList(1), b.subList(1));
        }

        public boolean same2(SimpleList<String> a, SimpleList<String> b) {
            return same2(a, b, 0);
        }
        private boolean same2(SimpleList<String> a, SimpleList<String> b, int index) {
            if (a.get(index) == null && b.get(index) == null) {
                return true;
            } else if (a.get(index) == null || b.get(index) == null) {
                return false;
            }
            String elementA = a.get(index);
            String elementB = b.get(index);
            return elementA.equals(elementB) && same2(a, b, index + 1);
        }
    }
}