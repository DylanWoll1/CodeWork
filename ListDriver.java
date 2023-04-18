
public class ListDriver implements ListDriverInterface {

	public ListInterface<java.lang.Integer> createList(ListDriverInterface.ListType listType, ListDriverInterface.TestType forTestType) {
	    ListInterface<Integer> newList = null;
	    
	    if (listType == ListDriverInterface.ListType.ArrayBasedList) {
	        newList = new ArrayBasedList<>();
	    } else if (listType == ListDriverInterface.ListType.LinkedList) {
	        newList = new LinkedList<>();
	    } else {
	        throw new IllegalArgumentException("Invalid list type specified: " + listType);
	    }
	    
	    if (forTestType == ListDriverInterface.TestType.AddSortedOdd) {
	        // add sorted odd
	    } else if (forTestType == ListDriverInterface.TestType.AddSortedEven) {
	        initializeList(newList, 1, 9999, 2);
	    } else if (forTestType == ListDriverInterface.TestType.AddAll || forTestType == ListDriverInterface.TestType.AddAllAtIndexZero) {
	        // add all
	    } else if (forTestType == ListDriverInterface.TestType.RemoveAllEven) {
	        initializeList(newList, 1, 10000, 1);
	    } else if (forTestType == ListDriverInterface.TestType.RemoveAllOdd) {
	        initializeList(newList, 1, 10000, 1);
	    }
	    
	    return newList;
	}


	public ListInterface<Integer> initializeList(ListInterface<Integer> list, int firstNumber, int lastNumber,
			int increment) {
		if (increment == 0) {

			return list;
		}
		for (int i = firstNumber; i <= lastNumber; i += increment) {
			list.add(i);
		}
		return list;
	}

	public double memoryUsage() {
	    Runtime runtime = Runtime.getRuntime();
	    long usedMemory = runtime.totalMemory() - runtime.freeMemory();
	    double usedMemoryInMB = usedMemory / (1024.0 * 1024.0);
	    return usedMemoryInMB;
	}

	
	
	
	
	
	@Override
	public Object[] runTestCase(ListDriverInterface.ListType listType, ListDriverInterface.TestType testType, int numberOfTimes) {
	   
	    Object[] results = new Object[numberOfTimes];
	    
	    if (testType == ListDriverInterface.TestType.AddSortedOdd) {
	        for (int i = 0; i < numberOfTimes; i++) {
	        }
	    } else if (testType == ListDriverInterface.TestType.AddSortedEven) {
	        for (int i = 0; i < numberOfTimes; i++) {
	        }
	    } else if (testType == ListDriverInterface.TestType.AddAll) {
	        for (int i = 0; i < numberOfTimes; i++) {
	        }
	    } else if (testType == ListDriverInterface.TestType.AddAllAtIndexZero) {
	        for (int i = 0; i < numberOfTimes; i++) {
	        }
	    } else if (testType == ListDriverInterface.TestType.RemoveAllEven) {
	        for (int i = 0; i < numberOfTimes; i++) {
	        }
	    } else if (testType == ListDriverInterface.TestType.RemoveAllOdd) {
	        for (int i = 0; i < numberOfTimes; i++) {
	        }
	    }
	    
	    return results;
	}
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
}