import java.util.ArrayList;

/**
 * basic sorting algorithms.  bubble, insertion, and quick sort based on:
 *  http://danishmujeeb.com/blog/2014/01/basic-sorting-algorithms-implemented-in-python
 *  The functions called xxxxxSort are sorting functions.  For each
 *  of them, there's a single list as input, and when the function is
 *  complete, the list should now be in sorted order.
 */
public class Sorter
{
    private void swap(ArrayList<Integer> aList, int pos1, int pos2)
    {
        Integer temp = aList.get(pos1);
        aList.set(pos1, aList.get(pos2));
        aList.set(pos2, temp);
    }
    
    public void bubbleSort(ArrayList<Integer> items)
    {
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size() - 1 - i; j++) {
                if(items.get(j).compareTo(items.get(j+1)) > 0) {
                    swap(items, j, j+1);
                }
            }
        }
    }

    public void insertionSort(ArrayList<Integer> items)
    {
        for (int i = 1; i < items.size(); i++) {
            int j = i;
            while(j > 0 && items.get(j).compareTo(items.get(j-1)) < 0) {
                swap(items, j, j-1);
                j --;
            }
        }
    }

    /**
     * Partitions around a pivot element. After partition, all
     * elements less than the pivot element are before the pivot
     * index, and the remaining elements are at or after the pivot
     * index.
     * @return index of the pivot element.
     */
    private int partition(ArrayList<Integer> items, int first, int last)
    {
        Integer pivot = items.get(last);
        int i = first  - 1;
        for (int j = first; j < last; j++)
        {
            if (items.get(j) <= pivot) {
                i++;

                swap(items, i, j);
            }
        }
        swap(items, i+1, last);

        return i+1;
    } 

    private void quickSort(ArrayList<Integer> items, int first, int last)
    { 
        if (last - first + 1 > 1) {
            int pivotIndex = partition(items, first, last);
            
            quickSort(items, first, pivotIndex-1);
            quickSort(items, pivotIndex+1, last);
        }
    }

    public void quickSort(ArrayList<Integer> items)
    {
        quickSort(items, 0, items.size() - 1);
    }


    private void merge(ArrayList<Integer> items, int first, int middle, int last)
    {
        ArrayList<Integer> beforeSublist = new ArrayList<Integer>(items.subList(0, first));
        ArrayList<Integer> afterSublist = new ArrayList<Integer>(items.subList(last+1, items.size()));

        
        ArrayList<Integer> newList = new ArrayList<Integer>();
        
        int i = first;
        int j = middle + 1;

        while (i <= middle && j <= last) {
            if (items.get(i).compareTo(items.get(j)) < 0) {
                newList.add(items.get(i));
                i++;
            } else {
                newList.add(items.get(j));
                j++;
            }
        }

        while (i <= middle) {
            newList.add(items.get(i));
            i++;
        }
        while (j <= last) {
            newList.add(items.get(j));
            j++;
        }

        items.clear();
        items.addAll(beforeSublist);
        items.addAll(newList);
        items.addAll(afterSublist);
    } 
    
    private void mergeSort(ArrayList<Integer> items, int first, int last)
    {
        if (last > first) {
            int middle = (last + first) / 2;
            mergeSort(items, first, middle);
            mergeSort(items, middle+1, last);
            merge(items, first, middle, last);
        }
    }


    public void mergeSort(ArrayList<Integer> items)
    {
        mergeSort(items, 0, items.size() - 1);
    }
}

