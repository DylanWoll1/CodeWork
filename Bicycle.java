

public class Bicycle extends Vehicle implements Comparable<Bicycle> {

	private double weight;

	public Bicycle() {
		super(1, 1);
		this.weight = 0;
	}

	public Bicycle(Person driver) {
		super(driver, new int[1]);
		this.weight = 0;
	}

	public Bicycle(Person driver, double weight) {
		super(driver, new int[1]);
		this.weight = weight;
	}

	public boolean equals(Object o) {
		Bicycle b = (Bicycle) o;
		if (Math.abs(b.getWeight() - this.weight) <= 0.5) {
			return true;
		}
		return false;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public void setDriver(Person p) throws InvalidDriverException {
		
		if (p.getAge() < 3){
			throw new InvalidDriverException("Too Young To Driver");
		}
	}

	public int compareTo(Bicycle b) {
		if (Math.abs(this.weight-b.weight) > 0.5) {
			if(this.weight > b.weight) {
				return 1;
			}
			else {
				return -1;
			}
		}
 return 0;
	}
	
	
	public String toString() {
		String ret = "";
		ret += String.format("Rider = %s", super.getDriver().getName());
		ret += String.format("\nWeight = %.2f", this.weight);
		return ret;
	}

	@Override
	public boolean loadPassenger(Person p) {
		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		return 0;
	}


}
