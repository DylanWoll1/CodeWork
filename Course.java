public class Course {
// attributes 
	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept;
	private int numCredits ; 
	

// overloaded constructor 
	public Course(boolean isGraduateCourse , int courseNum , String courseDept, int numCredits) {
		this.isGraduateCourse = isGraduateCourse;
		this.courseNum= courseNum;
		this.courseDept = courseDept;
		this.numCredits = numCredits;
	}
public boolean isGraduateCourse() {
	if(isGraduateCourse == true) {
		return true;
	}
		return false;
}

public int getCourseNum () {
	return this.courseNum;
}

public String getCourseDept() {
	return this.courseDept;
}

public int getNumCredits() {
	return this.numCredits;
}

public String getCourseName() {
	if(isGraduateCourse == true) {
		return "G" + getCourseDept() + courseNum;
	}
	else {
		return "U" + getCourseDept()+ courseNum;
		
	}
}

public boolean equals(Object o) {
	if(o instanceof Course) {
		Course otherCourse = (Course) o;
	if( (this.isGraduateCourse == otherCourse.isGraduateCourse()   )	
 	&& (this.courseNum == otherCourse.getCourseNum() )
	&& (this.courseDept.contentEquals(otherCourse.getCourseDept()) )
	&& (this.numCredits == otherCourse.getNumCredits() )) {
		return true;

	}
	else {
		return false;
	}

	}
    return true;

}

// How Data Is Written
 @Override

public String toString() {
	 String isGraduate = "";
	 if(isGraduateCourse() == true) {
		 isGraduate = "Graduate";
	 }
	 else {
		 isGraduate = "Undergraduate";
	 }
 return String.format("Course: %3s-%3d | Number of Credits: %02d | " + isGraduate, this.courseDept,this.courseNum,this.numCredits);
 }

// The Comparison Of 2 Courses 

 public int compareTo(Course c) {
	if(this.courseNum > c.courseNum) {
		return 1;
	}
	else if (this.courseNum < c.courseNum) {
		return -1;
	}
	else {
     return 0;
}






























}
}