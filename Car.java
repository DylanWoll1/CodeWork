import java.util.Arrays;

public class Car extends Vehicle implements Comparable<Car>, Announcements {

	private int numDoors;
	private int numWindows;

	public Car(int numDoors, int numWindows) {
		super(2, 2);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}

	public Car(int numDoors, int numWindows, int numSeatsPerRow) {
		super(2, numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;

	}

	public Car(int numDoors, int numWindows, int[] numSeatsPerRow) {
		super(numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;

	}

	public Car(int numDoors, int numWindows, Person driver, int[] numSeatsPerRow) {
		super(driver, numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}

	public boolean canOpenDoor(Person p) {
		if(p.getAge()<=5) {
			return false;
		}
		if(maxSeatsPerRow == 0 || maxSeatsPerRow== numberOfRows-1) {
		if(numberOfRows<numDoors/2) {
			
			return true;
		}else {
			return false;
		}
		}else {
			return false;
		}
}

	public boolean canOpenWindow(Person p) {
	
		  if (p.getAge() <= 2) {
		    return false;
		  }

		 
		  if (maxSeatsPerRow == 0 || maxSeatsPerRow == numberOfRows - 1) {
		    // Check if the row has a window
		    if (numberOfRows < numWindows / 2) {
		      return true;
		    } else {
		      return false;
		    }
		  } else {
		    return false;
		  }
		}

	public int getNumDoors() {
		return this.numDoors;
	}

	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}

	public int getNumWindows() {
		return this.numWindows;
	}

	public void setNumWindows(int numWindows) {
		this.numWindows = numWindows;
	}

	public boolean equals(Object o) {
		 if (this == o) return true;
		    if (o == null || getClass() != o.getClass()) return false;
		    Car car = (Car) o;
		    return numDoors == car.numDoors &&
		           numWindows == car.numWindows &&
		           numberOfRows == car.numberOfRows &&
		           Arrays.equals(numSeatsPerRow, car.numSeatsPerRow);
	}
	public String toString() {
		return "Car: number of doors= %02d | number of windows = %02d | number of rows= %02d | seats per row= %s | names of people on board= %s\n";
	}

	public int compareTo(Car c) {
		  if (c instanceof Car) {
		    Car otherCar = (Car) c;
		    if (this.numberOfRows < otherCar.numberOfRows) {
		      return -1;
		    } else if (this.numberOfRows > otherCar.numberOfRows) {
		      return 1;
		    } else {
		      return 0;
		    }
		  } else {
		    throw new ClassCastException("Cannot compare objects of different types.");
		  }
		}
	@Override
	public String departure() {
		return "All Aboard\n";
	}

	@Override
	public String arrival() {
		return "Everyone Out\n";
	}

	@Override
	public String doNotDisturbTheDriver() {
		return "No Backseat Driving\n";

	}

	@Override
	public boolean loadPassenger(Person p) {
		if (p.getAge() >= 5 && p.getHeight() >= 36) {
			for (int i = 0; i < super.getNumberOfRows(); i++) {
				if (super.getNumberOfAvailableSeatsInRow(i) != 0) {
					super.getPeopleOnBoard()[i][super.getNumberOfPeopleInRow(i)] = p;
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		int ret = 0;
		for (int i = 0; i < peeps.length; i++) {
			if (this.loadPassenger(peeps[i]) == true) {
				ret++;
			}
		}

		return ret;
	}

}
