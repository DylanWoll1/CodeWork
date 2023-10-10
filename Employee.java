public class Employee extends Person {

// attributes 	
 private String deptName;
 private static int numEmployees = 0;
 private int employeeID = 0;

// Constructor 
 Employee(){
	 super("",0);
	 deptName = "";
	 numEmployees ++;
	 employeeID = numEmployees;
 }
 public Employee (String deptName) {
	 super("",0);
	 this.deptName = deptName;
	 this.employeeID = ++this.numEmployees;
 }

// overloaded
Employee(String name, int birthYear, String deptName){
	super(name,birthYear);
	this.deptName = deptName;
	numEmployees++;
	employeeID = numEmployees;
}

// Retrieving data 
public String getDeptName() {
	return deptName;
}

public static int getNumEmployees() {
	return numEmployees;
}

public int getEmployeeID() {
	return employeeID;
}

public void setDeptName(String newDeptName) {
	deptName = newDeptName;
}

@Override 

public boolean equals (Object o) {
	if(o instanceof Employee) {
		Employee otherEmployee = (Employee)o;
		if( (this.getName().contentEquals(otherEmployee.getName()) )
			&& (this.getBirthYear() == otherEmployee.getBirthYear())
			&& (this.getDeptName().contentEquals(otherEmployee.getDeptName()))
			&& (this.getEmployeeID() == otherEmployee.getEmployeeID())) {
			
			return true;
		}
	}
return false;
}
// String 

@Override 
public String toString() {
	 return super.toString() + String.format(" Employee: Department: %20s | Employee Number: %3d",getDeptName(),getEmployeeID());
}

// comparison 
@ Override 
public int compareTo(Person p) {
	if(p instanceof Employee) {
		Employee otherEmployee = (Employee)p;
		if(this.getEmployeeID() > otherEmployee.getEmployeeID()) {
			return 1;
		}
		if(this.getEmployeeID() < otherEmployee.getEmployeeID()) {
			return -1;
		}
	}
	else {
		return super.compareTo(p);
	}
	return 0;
}

























}
