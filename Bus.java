
public class Bus extends Car {

	public Bus(int[] numSeatsPerRow) {
		super(2, 2 * numSeatsPerRow.length - 1, numSeatsPerRow);
	}

	public Bus(Person driver, int[] numSeatsPerRow) {
		super(2, 2 * numSeatsPerRow.length - 1, driver, numSeatsPerRow);
	}

	public boolean canOpenDoor(Person p) {
		return false;
		
		}
	

	public boolean canOpenWindow(Person p) {
		return false;
		  
	    }
	

	public String toString() {
		return super.toString();
	}

	@Override
	public String departure() {
		return super.departure() + "The Bus\n";
	}

	@Override
	public String arrival() {
		return super.arrival() + "Off the Bus\n";
	}

	public String doNotDisturbTheDrive() {
		return super.doNotDisturbTheDriver() + "On the Bus\n";
	}
}
