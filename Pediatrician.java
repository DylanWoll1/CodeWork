public class Pediatrician extends Doctor{
	private boolean hasPrivatePractice = false;
	private String hospitalName = "";
	
	
public Pediatrician(String name) {
    super(name);
	}
	
public Pediatrician (String name,boolean hasPrivatePractice,String hospitalName) {
	super(name);
	this.hasPrivatePractice = hasPrivatePractice;
	this.hospitalName = hospitalName;
}

public boolean hasPrivatePractice() {
	return hasPrivatePractice;
}

public String getHospitalName() {
	return hospitalName;
}
	
public void setHospitalName(String hospitalName) {
	this.hospitalName = hospitalName;
}
	
public void addPatient(Patient p) throws PatientException {
	int currYear = 2022;
	if(currYear - p.getBirthYear()< 18) {
		super.addPatient(p);
	}
	else {
		throw new PatientException ("Too Old");
	}
	
}


public String toString() {
return super.toString() + String.format("\nPediatrician: %s | hospital name=%15s", (hasPrivatePractice ? "has private practice" : "does not have private practice"), hospitalName);
}

public boolean equals (Object o) {
	if (o instanceof Pediatrician) {
		Pediatrician ped = (Pediatrician) o;
		if(this.hasPrivatePractice = ped.hasPrivatePractice && this.hospitalName == ped.hospitalName) {
			return true;
		}
	}
	return false;
}
	
	
	
	
}

	
	
	
