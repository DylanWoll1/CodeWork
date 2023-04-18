import java.util.Arrays;
import java.util.Random;

public class SortDriver implements SortDriverInterface {

	public Integer[] createArray(ArrayType arrayType, int arraySize) {
	    Integer[] array = new Integer[arraySize];
	    if (arrayType == ArrayType.Equal) {
	        Arrays.fill(array, 1);
	    } else if (arrayType == ArrayType.Random) {
	        Random random = new Random();
	        for (int i = 0; i < arraySize; i++) {
	            array[i] = random.nextInt();
	        }
	    } else if (arrayType == ArrayType.Increasing) {
	        for (int i = 0; i < arraySize; i++) {
	            array[i] = i;
	        }
	    } else if (arrayType == ArrayType.Decreasing) {
	        for (int i = 0; i < arraySize; i++) {
	            array[i] = arraySize - i - 1;
	        }
	    } else if (arrayType == ArrayType.IncreasingAndRandom) {
	        for (int i = 0; i < arraySize * 0.9; i++) {
	            array[i] = i;
	        }
	        Random random = new Random();
	        for (int i = (int) (arraySize * 0.9); i < arraySize; i++) {
	            array[i] = random.nextInt();
	        }
	    }
	    return array;
	}

	public Object[] runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes) {
	    
	    Object[] output = new Object[numberOfTimes * 2 + 1];

	    TestTimes testTimes = new TestTimes();

	    for (int i = 0; i < numberOfTimes; i++) {
	        Integer[] unsortedArray = createArray(arrayType, arraySize);

	        Integer[] unsortedArrayCopy = Arrays.copyOf(unsortedArray, unsortedArray.length);

	        long startTime = System.nanoTime();

	        if (sortType == SortType.BubbleSort) {
	            BubbleSort bubbleSort = new BubbleSort();
				bubbleSort.sort(unsortedArray);
	        } else if (sortType == SortType.InsertionSort) {
	            InsertionSort insertionSort = new InsertionSort();
				insertionSort.sort(unsortedArray);
	        } else if (sortType == SortType.SelectionSort) {
	            SelectionSort selectionSort = new SelectionSort();
				selectionSort.sort(unsortedArray);
	        } else {
	            throw new IllegalArgumentException("Invalid sort type: " + sortType);
	        }

	        long endTime = System.nanoTime();

	        long testTime = endTime - startTime;
	        testTimes.addTestTime(testTime);

	        Integer[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);

	        output[i * 2] = unsortedArrayCopy;
	        output[i * 2 + 1] = sortedArray;
	    }
	    output[numberOfTimes * 2] = testTimes;

	    return output;
	}


	public static void main(String[] args) {
	    SortDriver sortDriver = new SortDriver();
	    ArrayType arrayType = ArrayType.Equal;
	    int arraySize = 10000;
	    int numberOfTimes = 10;
	    SortType sortType = SortType.InsertionSort;

	    Object[] result = sortDriver.runSort(sortType, arrayType, arraySize, numberOfTimes);
	    TestTimes testTimes = (TestTimes) result[numberOfTimes * 2];

	    System.out.println( sortType + " , " + arrayType + ",  " + arraySize);
	    double[] allTestTimes = testTimes.getTestTimes();
	    System.out.println("All test times: " + Arrays.toString(allTestTimes) + "   " + testTimes.getAverageTestTime());
	}
}
