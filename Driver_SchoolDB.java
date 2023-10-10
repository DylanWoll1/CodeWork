import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Driver_SchoolDB {

private static ArrayList<Course> courses = new ArrayList<Course>();
private static ArrayList<Student> student = new ArrayList<Student>();
private static ArrayList<Faculty> facData = new ArrayList<Faculty>();
private static ArrayList<GeneralStaff> genStaff = new ArrayList<GeneralStaff>();

public static void main(String [] args) {
	String fileName = "SchoolDB_Inital.txt";
	String input = "";
	
try {
	BufferedReader buff = new BufferedReader (new FileReader(fileName));
	
	input = buff.readLine();
	while(input != null) {
		input = input.trim();
		System.out.println(input);
		if(input.contains("//")) {
			input = input.substring(0, input.indexOf("//")-1);
		}
   String [] info = input.split(":");
   if(info[0].trim().equalsIgnoreCase("Course")) {
	   courseBuild(info[1]);
   }
if (info[0].trim().equalsIgnoreCase("Student")) {
	if(info.length == 2) {
		studentBuild(info[1]);
	}
	else {
		studentBuild("");
	}
	
}
	if(info[0].trim().equalsIgnoreCase("Faculty")) {
		if(info.length == 1) {
			facultyBuild("");
		}
		else {
			facultyBuild(info[1]);
		}
	}
	
	if(info[0].trim().equalsIgnoreCase("GeneralStaff")) {
		if(info.length == 1) {
			gStaffBuild("");
		}
		else {
			gStaffBuild(info[1]);
		}
		}
	input = buff.readLine();
}
buff.close();
}
catch (Exception e) {
	e.printStackTrace();
	return;
}

System.out.println();
System.out.println("*");
System.out.println("SCHOOL DATABASE INFO:");
System.out.println("");
System.out.println("*");
System.out.println("COURSES:");
	
	for (Course course : courses) {
		System.out.println(course.toString());
	}
	System.out.println("*");
	System.out.println("*");
	
	System.out.println("PERSONS:");
	
	System.out.println("*");
	System.out.println("*");
	
	System.out.println("EMPLOYESS:");
	
	System.out.println("*");
	System.out.println("*");
	
	System.out.println("GENERAL STAFF:");
	for(GeneralStaff staff : genStaff) {
		System.out.println(staff.toString());
	}
	
	System.out.println("*");
	System.out.println("*");
	
	System.out.println("FACULTY");
	for(Faculty faculty : facData) {
		System.out.println(faculty.toString());
	}
	
	System.out.println("*");
	System.out.println("*");

	System.out.println("STUDENTS:");
	for(Student student: student) {
		System.out.println(student.toString());
	}
	
	System.out.println("*");
	System.out.println("*");
	System.out.println();
}

private static boolean isMajor(String major) {
	if(major.equals("Math")) {
		return true;
	}
	else if (major.equals("JST")) {
		return true;
	}
	else {
		return false;
	}
}
private static void courseBuild(String course) {
	if(course.trim().isEmpty()) {
		return;
	}
	
	String [] courseInfo = course.split(",");
	boolean isGraduateCourse = false;
	int courseNum = 0 , numCredits = 0;
	String courseDept = "";
	if("true".equalsIgnoreCase(courseInfo[0].trim())) {
		isGraduateCourse = true;
	}
	
	try {
		courseNum = Integer.parseInt(courseInfo[1].trim());
		courseDept = courseInfo[2].trim();
		numCredits = Integer.parseInt(courseInfo[3].trim());
		courses.add(new Course(isGraduateCourse,courseNum,courseDept,numCredits));
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
private static void studentBuild(String info) {
	if(info.trim().isEmpty()) {
		student.add(new Student());
		return;
	}
	String [] studentInfo = info.split(",");
	String major = "undeclared", name = "";
	boolean isGraduate = false;
	int birthYear = 0;
	
	try {
		for(String data : studentInfo) {
			data = data.trim();
			if("true".equalsIgnoreCase(data)) {
				isGraduate = true;
				continue;
			}
       if("false".equalsIgnoreCase(data)) {
    	   isGraduate = false;
    	   continue;
       }
       if(isMajor(data)) {
    	   major = data;
    	   continue;
       }
       if(data.length() >= 4) {
    	   try {
    		   birthYear = Integer.parseInt(data);
    	   } catch (Exception e) {
    		   name = data;
    	   }
       }
	}
		student.add(new Student(name,birthYear,major,isGraduate));
	} catch (Exception e) {
		e.printStackTrace();
	}
}
private static void facultyBuild(String info) {
	if(info.trim().isEmpty()) {
		facData.add(new Faculty());
		return;
	}
	
	String [] facultyInfo = info.split(",");
	String major = "", name = "";
	boolean isTenured = false;
	int birthYear = 0;
	
	try {
		for (String data : facultyInfo) {
			data = data.trim();
			if("true".equalsIgnoreCase(data)) {
				isTenured = true;
				continue;
			}
			if("false".equalsIgnoreCase(data)) {
				isTenured = false;
				continue;
			}
	if (data.length() == 3) {
		major = data;
		continue;
	}
		if(data.length() == 4) {
			try {
				birthYear = Integer.parseInt(data);
			} catch (Exception e) {
				name = data;
			}
		}
	}
	facData.add(new Faculty(name,birthYear,major,isTenured));
	} catch (Exception e) {
		e.printStackTrace();
	}
}


private static void gStaffBuild (String info) {
	if(info.trim().isEmpty()) {
		genStaff.add(new GeneralStaff());
		return;
	}
	String [] staffInfo = info.split(",");
	String duty = "" , name = "", dept = "";
	int birthYear = 0;
	
	if(staffInfo.length == 1) {
		duty = staffInfo[0];
	}else if(staffInfo.length ==2) {
		dept = staffInfo[0];
		duty = staffInfo[1];
} 
else if(staffInfo.length == 3) {
try {
birthYear = Integer.parseInt(staffInfo[0]);

}

catch(Exception e) {

}
dept = staffInfo[1];
duty = staffInfo[2];




//https://youtu.be/8w_i5aithb4  (YOUTUBE LINK IS HERE)


}
}
}