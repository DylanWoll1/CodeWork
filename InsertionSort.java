
public class InsertionSort implements SortInterface {

    @Override
    public void sort(Integer[] arrayToSort) {
        int n = arrayToSort.length;

        for (int i = 1; i < n; ++i) {
            int key = arrayToSort[i];
            int j = i - 1;

            /* Move elements of array[0..i-1], that are greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arrayToSort[j] > key) {
                arrayToSort[j + 1] = arrayToSort[j];
                j = j - 1;
            }
            arrayToSort[j + 1] = key;
        }
    }
}
