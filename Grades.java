package HW5;
	import java.util.Scanner;

		public class Grades {
   
public static void main (String []arr) {
Scanner scnr = new Scanner(System.in);
	
    int A = 0;
    	int Aminus = 0;
    		int BPlus = 0;
    			int B = 0;
    				int BMinus = 0;
    					int CPlus = 0;
    						int C = 0;
    							int CMinus = 0;
    								int D = 0;
    									int F = 0;
    										int totalGrades = 0;

    System.out.println("Enter a grade:");
    int grade = scnr.nextInt();

    while(grade >= 0) {
        if( (100 >= grade) && (grade >= 93) ) {
            A++;
        }
        else if((93 > grade) && (grade >= 90) ) {
            Aminus++;
        }
        else if( (90 > grade) && (grade >= 87) ) {
            BPlus++;
        }
        else if( (87 > grade) && (grade >= 83) ) {
            B++;
        }
        else if( (83 > grade) && (grade >= 80) ) {
            BMinus++;
        }
        else if( (80 > grade) && (grade >= 77) ) {
            CPlus++;
        }
        else if( (77 > grade) && (grade >= 73) ) {
            C++;
        }
        else if( (73 > grade) && (grade >= 70) ) {
            CMinus++;
        }
        else if( (70 > grade) && (grade >= 60) ) {
            D++;
        }
        else {
            F++;
        }
        totalGrades++;
        System.out.println("Enter a grade: ");
        grade = scnr.nextInt();
    }

    	System.out.println("Total number of grades = " + totalGrades);
    		System.out.println("Number of A's  = " + A);
    			System.out.println("Number of A-'s = " + Aminus);
    				System.out.println("Number of B+'s = " + BPlus);
    					System.out.println("Number of B's  = " + B);
    						System.out.println("Number of B-'s = " + BMinus);
    							System.out.println("Number of C+'s = " + CPlus);
    								System.out.println("Number of C's  = " + C);
    									System.out.println("Number of C-'s = " + CMinus);
    										System.out.println("Number of D's  = " + D);
    											System.out.println("Number of F's  = " + F);

	}
}