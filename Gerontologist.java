public class Gerontologist extends Doctor {

	private boolean performsHouseCalls = true;
	private double visitFee = 0.0;
	
	
	public Gerontologist (String name) {
		super(name);
	}
	
 public Gerontologist (String name, boolean performsHouseCalls, int visitFee) {
	 super(name);
	 this.performsHouseCalls = performsHouseCalls;
	 this.visitFee = visitFee;
 }
 
 public boolean performsHouseCalls() {
	 return performsHouseCalls;
 }

 public double getVisitFee() {
	 return visitFee;
 }
	
 public void setPerformsHouseCalls(boolean performsHouseCalls) {
	 this.performsHouseCalls = performsHouseCalls;
 }
 
 public void setVisitFee(double visitFee){
	 this.visitFee = visitFee;
 }
	
 public void addPatient (Patient p) throws PatientException {
	 int currYear = 2022;
	 if(currYear - p.getBirthYear()> 65) {
		 super.addPatient(p);
	 }
	 else {
		 throw new PatientException ("Too Young");
	 }
 }
 
 public String toString () {
super.toString();
return String.format( "\nGerontologist: %s | visit fee=%02.2f", (performsHouseCalls ? "performs house calls" : "no house calls"), visitFee);
 }
 
 public boolean equals(Object o) {
	 if(o instanceof Gerontologist) {
		 Gerontologist ger = (Gerontologist) o;
		 if(this.performsHouseCalls == ger.performsHouseCalls && this.visitFee == ger.visitFee)
		 
		 {
			 return true;
		 }
	 }
	 return false;
 }
}
