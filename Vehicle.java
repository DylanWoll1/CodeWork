import java.util.Arrays;

public abstract class Vehicle {
	protected Person[][] personsOnBoard;
	protected int numberOfRows;
	protected int maxSeatsPerRow;
	protected int [] numSeatsPerRow;

	public Vehicle(int numRows, int numSeatsPerRow) {
		this.numberOfRows = numRows;
		this.personsOnBoard = new Person[numberOfRows][numSeatsPerRow];
		this.numSeatsPerRow = new int[numRows];

		for (int i = 0; i < numRows; i++) {
			this.numSeatsPerRow[i] = numSeatsPerRow;
		}

		this.maxSeatsPerRow = numSeatsPerRow;

		for (int i = 0; i < this.personsOnBoard.length; i++) {
			for (int j = 0; j < this.personsOnBoard[i].length; j++) {
				this.personsOnBoard[i][j] = null;
			}
		}
	}

	public Vehicle(int[] numSeatsPerRow) {
		this.numberOfRows = numSeatsPerRow.length;
		this.personsOnBoard = new Person[numSeatsPerRow.length][];
		this.numSeatsPerRow = new int[numSeatsPerRow.length];
		this.maxSeatsPerRow = 0;
		for (int i = 0; i < numSeatsPerRow.length; i++) {
			this.numSeatsPerRow[i] = numSeatsPerRow[i];
			if (this.maxSeatsPerRow < numSeatsPerRow[i]) {
				this.maxSeatsPerRow = numSeatsPerRow[i];
			}
			this.personsOnBoard[i] = new Person[numSeatsPerRow[i]];
		}

		for (int i = 0; i < this.personsOnBoard.length; i++) {
			for (int j = 0; j < this.personsOnBoard[i].length; j++) {
				this.personsOnBoard[i][j] = null;
			}
		}
	}

	public Vehicle(Person driver, int[] numSeatsPerRow) {
		this.numberOfRows = numSeatsPerRow.length;
		this.personsOnBoard = new Person[numSeatsPerRow.length][];
		this.numSeatsPerRow = new int[numSeatsPerRow.length];
		this.maxSeatsPerRow = 0;
		for (int i = 0; i < numSeatsPerRow.length; i++) {
			this.numSeatsPerRow[i] = numSeatsPerRow[i];
			if (this.maxSeatsPerRow < numSeatsPerRow[i]) {
				this.maxSeatsPerRow = numSeatsPerRow[i];
			}
			this.personsOnBoard[i] = new Person[numSeatsPerRow[i]];
		}

		for (int i = 0; i < this.personsOnBoard.length; i++) {
			for (int j = 0; j < this.personsOnBoard[i].length; j++) {

				this.personsOnBoard[i][j] = null;
			}
		}

		if (driver.hasDriverLicense() == true) {
			this.personsOnBoard[0][0] = driver;
		}
	}

	public abstract boolean loadPassenger(Person p);

	public abstract int loadPassengers(Person[] peeps);

	public void setDriver(Person p) throws InvalidDriverException {
		if(p.hasDriverLicense()) {
		  this.personsOnBoard[0][0]= p;
		}
		else {
			throw new InvalidDriverException("Person Has No License");
		}
	}



	public Person getDriver() {
		return this.personsOnBoard[0][0];
	}

	public boolean hasDriver() {
		if (this.personsOnBoard[0][0] == null) {
			return false;
		}
		return true;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public int getMaxSeatsPerRow() {
		return maxSeatsPerRow;
	}

	public void setMaxSeatsPerRow(int maxSeatsPerRow) {
		this.maxSeatsPerRow = maxSeatsPerRow;
	}

	public int getNumberOfAvailableSeats() {
		return this.maxSeatsPerRow - numberOfRows;
		}

	public int getNumberOfAvailableSeatsInRow(int row) {
		return row;
	
	}
	
	public int getNumberOfPeopleOnBoard() {
		return maxSeatsPerRow;
		
	}

	public int getNumberOfPeopleInRow(int row) {
		return numberOfRows;
	}


	public Person getPersonInSeat(int row, int col) {
		if (row < 0 || row >= this.numberOfRows) {
			return null;
		}

		if (col < 0 || col >= this.personsOnBoard[row].length) {
			return null;
		}

		return this.personsOnBoard[row][col];
	}

	public int[] getLocationOfPersonInVehicle(Person p) {
		int [] ret=new int[2];;
		for(int i=0;i<this.numSeatsPerRow.length;i++){
		for(int j=0;j<this.numSeatsPerRow[i];j++){
		if(this.personsOnBoard[i][j].equals(p)){
		ret[0]=i;
		ret[1]=j;
		}
		}
		}  
		return ret;
		}


	public Person[] getPeopleInRow(int row) {
	  if (numberOfRows < 0 ||numberOfRows >= row) {
	  return null;		
	  }
	return null;
	}
	
	public Person[][] getPeopleOnBoard() {
		return personsOnBoard;
	}

	public boolean isPersonInVehicle(Person p) {
		return false;
		
			}

	public boolean isPersonDriver(Person p) {
		if(this.personsOnBoard[0][0]!=null && this.personsOnBoard[0][0].equals(p)){
			return true;
			}  
			return false;
			}
			}

