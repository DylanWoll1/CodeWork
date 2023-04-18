package Calculator;
import java.util.Scanner;
public class DateConverter {

	public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	System.out.println("Enter 4 integers representing dayNumber monthNumber date year:");
	
	boolean validDayOfWeek = true;
	boolean validMonth = true;
	boolean validDayOfMonth= true; 
	boolean validYear = true;
	
	
	int dayNumber = input.nextInt();
	int monthNumber = input.nextInt();
	int date = input.nextInt();
	int year = input.nextInt();
	
	String dayNames  = "";
	String monthNames ="";
	
	if((dayNumber <= 7) && (dayNumber > 0)){
	  if(dayNumber == 1 ) {
	    dayNames = "Sunday";
	  }
	  else if(dayNumber == 2 ) {
		  dayNames = "Monday";
		  }
	  else if(dayNumber == 3 ) {
		  dayNames = "Tuesday";
		  }
	  else if(dayNumber == 4 ) {
		  dayNames = "Wednesday";
		  }
	  else if(dayNumber == 5 ) {
		  dayNames = "Thursday";
		  }
	  else if(dayNumber == 6 ) {
		  dayNames = "Friday";
		  }
	  else if(dayNumber == 7 ) {
		  dayNames = "Saturday";
	  }
	else { 
		System.out.println("Invalid day number: " + dayNumber + ", please enter a number from 1..7.");
	validDayOfWeek = false;
	}
	}
	
	  if((monthNumber > 0) && (monthNumber <= 12)){
		 if(monthNumber == 1 ) {
		  monthNames = "January";
		  }
		 else if(monthNumber == 2) {
			 monthNames = "February";
			  }
		 else if(monthNumber == 3 ) {
			  monthNames = "March";
			  }
		 else if(monthNumber == 4 ) {
			  monthNames = "April";
			  }
		 else if(monthNumber == 5 ) {
			  monthNames = "May";
			  }
		 else if(monthNumber == 6 ) {
			  monthNames = "June";
			  }
		 else if(monthNumber == 7 ) {
			  monthNames = "July";
			  }
		 else if(monthNumber == 8 ) {
			  monthNames = "August";
			  }
		 else if(monthNumber == 9 ) {
			  monthNames = "September";
			  }
		 else if(monthNumber == 10 ) {
			  monthNames = "October";
			  }
		 else if(monthNumber == 11 ) {
			  monthNames = "November";
			  }
		 else if(monthNumber == 12 ) {
			  monthNames = "December";
			  }
  	  else {
  		  validMonth = false;
  		  	System.out.println("Invalid month number: " + monthNumber + ", please enter a number from 1..12.");	
	}
    }
	  if ((date < 1) && ( date > 31)) {	
	System.out.println("Invalid date number :"+ date + ", please enter a number from 1..31.");
	validDayOfMonth = false;
	}	
	
	
	 if ((monthNumber == 2) && (date >= 29)&&(year % 4 == 0)){
		  System.out.println("Invalid date: " + year + " is not a leap year, February does not have " + date + " days, please enter a valid date."); 	
	     validYear =false;
	     validDayOfMonth = false;
	}
	
	else if ((monthNumber == 2) && (date > 29)){
		System.out.println("Invalid date: "+ monthNames +", does not have " + date + " days, please enter a valid date.");
		validMonth = false;
		}
	
	else if ((monthNumber == 4) && (date > 30)){	
		System.out.println("Invalid date: " + monthNames + ", does not have 31 days, please enter a valid date.");
		validDayOfMonth =false;
	}
	else if ((monthNumber == 6) && (date > 30)){	
		System.out.println("Invalid date: " + monthNames + ", does not have 31 days, please enter a valid date.");
		validDayOfMonth =false;
	}
	else if ((monthNumber == 9) && (date > 30)){	
		System.out.println("Invalid date: " + monthNames + ", does not have 31 days, please enter a valid date.");
		validDayOfMonth =false;
	}
	else if ((monthNumber == 11) && (date > 30)){	
		System.out.println("Invalid date: " + monthNames + ", does not have 31 days, please enter a valid date.");
             validDayOfMonth =false;
	}
	 
	if(validDayOfWeek && validDayOfMonth && validYear && validMonth){
	System.out.println(dayNumber +" "+ monthNumber +" "+ date + " "+ year +" is "+ dayNames+ " " + monthNames + " " + date + ", " + year);
}
	

	}
}