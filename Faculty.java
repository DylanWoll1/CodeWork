
public class Faculty extends Employee{
 // attributes
	private Course [] coursesTaught;
	private int numCoursesTaught;
	private boolean isTenured;
	
	// construct 
	public Faculty () {
		super();
		this.coursesTaught = new Course [100];
		this.numCoursesTaught = 0;
		this.isTenured = false;
	}
	
	public Faculty (boolean isTenured) {
		super();
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	//overloaded
	
	public Faculty (String deptName, boolean isTenured) {
		super(deptName);
		this.coursesTaught = new Course [100];
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}

	public Faculty (String name, int birthYear,String deptName, boolean isTenured) {
		super(name,birthYear,deptName);
		this.coursesTaught = new Course [100];
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	public boolean isTenured() {
		return this.isTenured;
	}
	
	public int getNumCoursesTaught() {
		return this.numCoursesTaught;
	}
	public void setIsTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}
	public  void addCourseTaught(Course course) {
		if(getNumCoursesTaught () < 100){
			this.coursesTaught[this.numCoursesTaught++] = course;
		}
}	

public void addCoursesTaught(Course [] course) {
		if(getNumCoursesTaught() < 100) {
			for(int i = 0; i < course.length; i++) {
				this.coursesTaught[this.numCoursesTaught++] = course[i];
				if(getNumCoursesTaught() >= 100) {
					break;
				}
			}
		}
	}
	
public Course getCourseTaught(int index) {
	if(index >= 0 && index < getNumCoursesTaught()) {
		return this.coursesTaught[index];
	}
	else {
		return null;
	}
}
	
public String getCourseTaughtAsString (int index) {
	if(index >= 0 && index < getNumCoursesTaught()) {
		return this.coursesTaught[index].toString();
	}
	else {
		return "";
	}
}
	
	public String getAllCoursesTaughtAsString() {
		String result = "";
		for(int i = 0; i < getNumCoursesTaught();i++) {
			result += getCourseTaughtAsString(i);
			result += ", ";
		}
	return result = result.substring(0,result.length());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Faculty) {
			Faculty newObj = (Faculty) obj;
			if(super.equals(obj)&& super.equals(newObj)) {
				if(((Faculty)obj).coursesTaught == newObj.coursesTaught &&((Faculty)obj).numCoursesTaught==newObj.numCoursesTaught) {
					return true;
					
				}
			}
		}
	return false;
	}
	
@Override 

public String toString() {
    String tenured = "";
    if(isTenured) {
    	tenured = "Is Tenured";
    }
    else {
    	tenured = "Not Tenured";
    }
	return super.toString() + String.format(" Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",tenured,numCoursesTaught,getAllCoursesTaughtAsString());
    
}
	
@Override 

public int compareTo(Person p) {
	int sortCoursesTaught = -2;
	if(p instanceof Faculty) {
		Faculty compare = (Faculty) p;
		if(getNumCoursesTaught() > compare.getNumCoursesTaught()) {
			sortCoursesTaught = 1;
		}
		else if (getNumCoursesTaught() < compare.getNumCoursesTaught()) {
			sortCoursesTaught = -1;
		}
		else {
			sortCoursesTaught = 0;
		}
	}
	return sortCoursesTaught;
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
