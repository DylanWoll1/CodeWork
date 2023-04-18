import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class ArrayBasedQueue<E> implements QueueInterface<E> {

	private int MAX_ARRAY_SIZE = 10_000;
	private int INVALID_INDEX = -1;
	private Object[] array = new Object[MAX_ARRAY_SIZE];
	private int head = INVALID_INDEX;
	private int tail = INVALID_INDEX;
	
	private int count = 0;
	
	
	public ArrayBasedQueue() {
		this.array = new Object[MAX_ARRAY_SIZE];
	}
	
	public ArrayBasedQueue(int size) {
		this.array = new Object[size];
	}
	
	
	
	
	@Override
	public String toString() {
           String s = new String ("ArrayBasedQueue:\n");
           s = s + "Count = " + this.count + "\n";
           s = s + "Head = " + this.head + "\n";
           s = s + "Tail = " + this.tail + "\n{";
           int curIndex = 0;
           while(curIndex < this.count) {
        	   int realIndex = this.realIndexAt(this.head, curIndex);
               s = s + this.array[realIndex];
               if(curIndex != this.count-1) {
                   s = s + ", ";
               }
               curIndex++;
        	   }
           return s;
           }
	

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> iterator() {
		Vector <E> vector = new Vector <E>(this.count);
		int curIndex = 0;
		while(curIndex<this.count) {
			int realIndex = this.realIndexAt(this.head, curIndex);
			vector.add((E) this.array[realIndex]);
			curIndex++;
		}
		ElementIterator <E> elementIterator = new ElementIterator<E>(vector);
		return elementIterator;
	}

	@Override
	public boolean isEmpty() {
		return (this.count == 0);
	}

	@Override
	public int size() {
		return this.count;
	}
	@Override
	public QueueInterface<E> copy() {
	    ArrayBasedQueue<E> copy = new ArrayBasedQueue<E>(this.array.length);
	    copy.head = this.head;
	    copy.tail = this.tail;
	    copy.count = this.count;
	    System.arraycopy(this.array, 0, copy.array, 0, this.array.length);
	    return copy;
	}

	@Override
	public void enqueue(E element) throws IllegalStateException, NullPointerException {
		if (element != null) {
			if (this.isEmpty()) {
				System.out.println("array length = " + this.array.length);
				System.out.println("element = " + element);
				this.array[0] = element; 
				this.head = 0;
				this.tail = 0;
				this.count++;
			} else {
				if (!this.arrayIsFull()) {
					this.tail = this.incrementIndex(this.tail);
					this.array[this.tail] = element;
					this.count++;
				} else {
					throw new IllegalStateException("Unable to add element to ArrayBasedQueue due to space limitations");
				}
			}
		} else {
			throw new NullPointerException("Unable to add a null element to the queue, operation is not allowed");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		if (!this.isEmpty()) {
			return (E) this.array[this.head];
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E dequeue() {
		if (!this.isEmpty()) {
			E element = (E) this.array[this.head];
			this.head = this.incrementIndex(this.head);
			this.count--;
			return element;
		} else {
			return null;
		}
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
	    if (index < 0) {
	        throw new NoSuchElementException("Invalid index = " + index + " Index must be non-negative.");
	    }
	    if (this.isValidIndex(index)) {
	        if (index == 0) {
	            E element = this.dequeue();
	            return element;
	        } else if (index == this.count - 1) {
	            @SuppressWarnings("unchecked")
	            E element = (E) this.array[this.tail];
	            this.tail = this.decrementIndex(this.tail);
	            this.count--;
	            return element;
	        } else {
	            int realIndex = this.realIndexAt(this.head, index);
	            @SuppressWarnings("unchecked")
	            E element = (E) array[realIndex];
	            int currIndex = index;
	            while(currIndex < this.count) {
	                int destIndex = this.realIndexAt(this.head, currIndex);
	                int sourceIndex = this.realIndexAt(this.head, currIndex+1);
	                this.array[destIndex]= this.array[sourceIndex];
	                currIndex++;
	            }
	            this.tail = this.decrementIndex(this.tail);
	            this.count--;
	            return element;
	        }
	    } else {
	        throw new NoSuchElementException("Invalid index = " + index + " Queue only has " + this.count + " elements.");
	    }
	}


	@Override
	public void removeAll() {
		this.count = 0;
		this.head = INVALID_INDEX;
		this.tail = INVALID_INDEX;
	}

	
	
	private boolean arrayIsFull() {
		return (this.count == this.array.length);
	}
	
	private int incrementIndex(int index) {
		return ++index % this.array.length;
	}
	
	private int realIndexAt(int head, int index) {
	    int realIndex = (head + index) % this.array.length;
	    if (realIndex < 0) {
	        realIndex += this.array.length;
	    }
	    return realIndex;
	}

	
	private boolean isValidIndex (int index) {
		return (index < this.count);
	}
	
	private int decrementIndex(int index) {
		if (index == 0) {
			return this.array.length - 1;
		} else {
			return --index;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
