
public class SearchDriver  {
	
	
	public int[] getListOfNumbers() {
	    int[] list = new int[10000000];
	    for (int i = 0; i < 10000000; i++) {
	        list[i] = i + 1;
	    }
	    return list;
	}
	
	
	public int[] getTargets() {
	    int[] targets = new int[]{500, 10000, 100000, 1000000, 5000000, 7500000, 10000000};
	    return targets;
	}
	
	public TestTimes runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
	    TestTimes testTimes = new TestTimes();
	    long startTime, endTime;
	    LinearSearch linearSearch = new LinearSearch();

	    for (int i = 0; i < numberOfTimes; i++) {
	        startTime = System.nanoTime();
	        linearSearch.search(listOfNumbers, target);
	        endTime = System.nanoTime();

	        testTimes.addTestTime(endTime - startTime);
	    }
	    return testTimes;
	}

	public TestTimes runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
	    TestTimes testTimes = new TestTimes();
	    long startTime, endTime;
	    BinarySearch binarySearch = new BinarySearch();

	    for (int i = 0; i < numberOfTimes; i++) {
	        startTime = System.nanoTime();
	        binarySearch.search(listOfNumbers, target);
	        endTime = System.nanoTime();

	        testTimes.addTestTime(endTime - startTime);
	    }
	    return testTimes;
	}

}
