public class Doctor implements SeesPatients, Comparable <Doctor>{
 
	private static int numDoctors = 0;
	private String name = "";
	private int licenseNumber;
	private Patient patients[];
	private int numberOfPatients;
	
	public Doctor() {
		name = "";
		licenseNumber = numDoctors;
		numberOfPatients = 0;
		patients = new Patient[100];
		numDoctors++;
	}
	
	
	public Doctor(String name) {
	this.name = name;
	this.licenseNumber = numDoctors;
	this.numberOfPatients = 0;
	patients = new Patient [100];
	numDoctors++;
	}
	
public static int getNumDoctors() {
	return numDoctors;
}

public int getLicenseNumber() {
	return licenseNumber;
}

public String getName() {
		return name;		
}
	
public int getNumberOfPatients() {
	return numberOfPatients;
}

public String getPatientsAsString() {
	String p = "patients= ";
	if(numberOfPatients > 0) {
		p = p + patients [0].toString();
		for (int i = 1; i < numberOfPatients; i++) {
			p = p + ",";
					p = p + patients [i].toString();
		}
	}
	return p;
}

public void addPatient(Patient p) throws PatientException {
	if(numberOfPatients >= MAX_PATIENTS) {
	throw new PatientException("Too Many Patients");
    }
	if(isPatient(p)) {
		throw new PatientException("Too Many Patients");
	}
	else {
		patients[numberOfPatients]= p;
		numberOfPatients++;
	}
	
}

public String toString () {
	return String.format("Doctor: name= %20s | license number= %06d | %s ", name, licenseNumber,getPatientsAsString());}


public boolean equals (Object object) {
	if(object instanceof Doctor) {
		Doctor doc1 = (Doctor) object;
		if(this.name == doc1.name && this.numberOfPatients == doc1.numberOfPatients) {
			return true;
		}
	}
	return false;
}


public int compareTo(Doctor doctor) {
	if(doctor.numberOfPatients > this.numberOfPatients) {
		return -1;
	}
	else if (doctor.numberOfPatients < this.numberOfPatients) {
		return 1;
	}
	return 0;
}

@Override
public Patient[] getPatients() {
	return patients;
}

@Override
public boolean isPatient(Patient p) {
	for (int i = 0; i < numberOfPatients; i++) {
		if (patients[i].equals(p)) {
		return true;
		}
		}
		return false;
	}
	
	
	
	
	
}
	
	
	
