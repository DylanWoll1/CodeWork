package HW5;
	import java.util.Scanner;
		public class PatternTwo {
	
		public static void main(String[] args) {

	        Scanner scnr = new Scanner(System.in);
	        System.out.print("Please enter a number 1...9 : ");
	        int yourNum = scnr.nextInt();

	        for (int i = 1; i <= yourNum; i++) {
	            System.out.println();
	            for (int n = yourNum; n > i; n--) {
	                System.out.print("  ");
	            }
	            for (int j = i; j >= 1; j--) {
	                System.out.print(" ");
	                System.out.print (j);




	            }
	        }
	        System.out.println();






	    }

	

	}


