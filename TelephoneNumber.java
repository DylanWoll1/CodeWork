package HW5;
import java.util.Scanner;
public class TelephoneNumber {	

			public static void main(String[] args) {
				
				Scanner scan = new Scanner(System.in);
				int numCount = 0;
				int tempCount = 0;
				
				System.out.println("Please enter a telephone number using letters : ");
				
				String origPhoneNumber = scan.nextLine();
				String phoneNumber = origPhoneNumber.toLowerCase();
				String realPhoneNumber = "";
				String editedNumber = "";
				
				for(int i = 0; i < phoneNumber.length(); i++) {
					if(tempCount > 8) {
						break;
					}
					else if(phoneNumber.charAt(i) == ' ') {
						continue;
					}
					else {
					editedNumber += phoneNumber.charAt(i);
					}
				}
				
				phoneNumber = editedNumber;
				
					
				for(int i = 0; i < phoneNumber.length(); i++) {
					
					if(numCount == 3) {
						realPhoneNumber += "-";
					}
					
					if(phoneNumber.charAt(i) == 'a' || phoneNumber.charAt(i) == 'b' || phoneNumber.charAt(i) == 'c') {
						realPhoneNumber += "2";
						numCount++;
					}
					else if(phoneNumber.charAt(i) == 'd' || phoneNumber.charAt(i) == 'e' || phoneNumber.charAt(i) == 'f') {
						realPhoneNumber += "3";
						numCount++;
					}
					else if(phoneNumber.charAt(i) == 'g' || phoneNumber.charAt(i) == 'h' || phoneNumber.charAt(i) == 'i') {
						realPhoneNumber += "4";
						numCount++;
					}
					else if(phoneNumber.charAt(i) == 'j' || phoneNumber.charAt(i) == 'k' || phoneNumber.charAt(i) == 'l') {
						realPhoneNumber += "5";
						numCount++;
					}
					else if(phoneNumber.charAt(i) == 'm' || phoneNumber.charAt(i) == 'n' || phoneNumber.charAt(i) == 'o') {
						realPhoneNumber += "6";
						numCount++;
					}
					else if(phoneNumber.charAt(i) == 'p' || phoneNumber.charAt(i) == 'q' || phoneNumber.charAt(i) == 'r' || phoneNumber.toLowerCase().charAt(i) == 's' ) {
						realPhoneNumber += "7";
						numCount++;
					}
					else if(phoneNumber.charAt(i) == 't' || phoneNumber.charAt(i) == 'u' || phoneNumber.charAt(i) == 'v') {
						realPhoneNumber += "8";
						numCount++;
					}
					else if(phoneNumber.charAt(i) == 'w' || phoneNumber.charAt(i) == 'x' || phoneNumber.charAt(i) == 'y' || phoneNumber.toLowerCase().charAt(i) == 'z') {
						realPhoneNumber += "9";
						numCount++;
					}
					else if(phoneNumber.charAt(i) == ' ') {
						continue;
					}
					else {
						realPhoneNumber += "";
					}
					
					if(numCount == 7) {
						break;
					}
				}
				//-------
				System.out.println(realPhoneNumber);

			}
		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


