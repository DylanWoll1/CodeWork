
public class GeneralStaff extends Employee {

	private String duty;
	
	public GeneralStaff() {
		this.duty = "";
	}
	public GeneralStaff (String duty) {
		this.duty = duty;
	}
	
	public GeneralStaff(String deptName,String duty) {
		super(deptName);
		this.duty = duty;
	}
	
	public GeneralStaff(String name, int birthYear, String deptName , String duty) {
		super(name,birthYear,deptName);
		this.duty = duty;
	}
	
	public String getDuty() {
		return this.duty;
	}
	
	
public boolean equals(Object obj) {
		boolean verify = false;
		if(obj instanceof GeneralStaff) {
			GeneralStaff compare = (GeneralStaff)obj;
			if(super.getName() == compare.getName()&&
			super.getBirthYear() == compare.getBirthYear()&&
			super.getDeptName() == compare.getDeptName() &&
			this.duty == compare.getDuty()) {
				verify = true;
			}
			else {
				verify = false;
			}
		}
		return verify;
	}
	
	public String toString() {
		String display = "";
		return display += super.toString() + String.format(" GeneralStaff: Duty: %10s",getDuty());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
