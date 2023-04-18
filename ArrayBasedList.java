public class ArrayBasedList<I extends Comparable<? super I>> implements ListInterface<I> {

	private int INITIAL_ARRAY_SIZE = 100;

	private Object[] myArray = new Object[INITIAL_ARRAY_SIZE];
	private int numElements = 0;


	
@Override
public ListInterface<I> copy() {
    ListInterface<I> newList = new ArrayBasedList<>();
    for (int i = 0; i < this.numElements; i++) {
        newList.add(this.get(i));
    }
    return newList;
}



	@Override
	public int size() {
		return this.numElements;
	}

	@Override
	public boolean isEmpty() {
		return (this.numElements == 0);
	}

	@Override
	public void add(I element) {
		if (isArrayFull()) {
			this.resizeArray();
		}
		this.myArray[this.numElements++] = element;
	}

	@Override
	public void add(I element, int index) throws IndexOutOfBoundsException {
		if (isValidIndex(index)) {
			if (isArrayFull()) {
				this.resizeArray();
			}
			for (int i = this.numElements; i > index; i--) {
				this.myArray[i] = this.myArray[i - 1];
			}
			this.myArray[index] = element;
			this.numElements++;
		} else if (index == this.numElements) {
			this.add(element);
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}

	@Override
	public void addSorted(I element) {
	    int index = 0;
	    while (index < size() && element.compareTo(get(index)) >= 0) {
	        index++;
	    }
	    add(element, index);
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public I get(int index) throws IndexOutOfBoundsException {
		if (isValidIndex(index)) {
			return (I) this.myArray[index];
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}

	@Override
	public I replace(I element, int index) throws IndexOutOfBoundsException {
		if (isValidIndex(index)) {
			@SuppressWarnings("unchecked")
			I elementToReturn = (I) this.myArray[index];
			this.myArray[index] = element;
			return elementToReturn;
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}

	@Override
	public I remove(int index) throws IndexOutOfBoundsException {
		if (isValidIndex(index)) {
			@SuppressWarnings("unchecked")
			I element = (I) this.myArray[index];
			for (int i = index + 1; i < numElements; i++) {
				this.myArray[i - 1] = this.myArray[i];
			}
			this.numElements--;
			return element;
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}

	@Override
	public void removeAll() {
		this.numElements = 0;
	}

	/********************************/
	/* private methods */
	/********************************/

	private void resizeArray() {
		Object[] newArray = new Object[this.myArray.length * 2];
		for (int i = 0; i < this.myArray.length; i++) {
			newArray[i] = this.myArray[i];
		}
		this.myArray = newArray;
	}

	private boolean isArrayFull() {
		if (this.numElements >= this.myArray.length) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isValidIndex(int index) {
		if ((index >= 0) && (index < this.numElements)) {
			return true;
		} else {
			return false;
		}
	}

}