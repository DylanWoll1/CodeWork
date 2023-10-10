
import java.util.Scanner;

public class RecursionQuestion {

	public static int binarySearch(Car[] car, Car c) {
		System.out.println("Looking for Car: " + c.toString() + "\n");
		return bsHelper(car, c, 0, car.length, (car.length) / 2);
	}

	public static int bsHelper(Car[] car, Car c, int start, int last, int mid) {
		if (start > last) {
			System.out.println("Not Found");
			return -1;
		}

		else {
			if (car[mid].compareTo(c) == 1) {
				System.out.println("s=" + start + ", e=" + last + ", mid=" + mid);
				System.out.println("go right");
				return bsHelper(car, c, mid + 1, last, (mid + last) / 2);
			} else {
				if (car[mid].compareTo(c) == 0) {
					System.out.println("s=" + start + ", e=" + last);
					System.out.println("FOUND at " + mid);
					return mid;
				} else {
					System.out.println("s=" + start + ", e=" + last + ", mid=" + mid);
					System.out.println("go left");
					return bsHelper(car, c, start, mid - 1, (mid + start - 1) / 2);
				}
			}
		}
	}

	// do not remove main method or its content
	public static void main(String[] args) {
		Car[] cars = new Car[10];
		int[][] seatConfigurations = { new int[] { 2, 2 }, new int[] { 2, 3 }, new int[] { 2, 2, 3 },
				new int[] { 2, 3, 3 }, new int[] { 2, 3, 4 }, new int[] { 2, 4, 3 }, new int[] { 2, 3, 5 },
				new int[] { 2, 4, 4 }, new int[] { 2, 4, 5 }, new int[] { 3, 4, 5 } };
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(2, 4, seatConfigurations[i]);
		}
		Scanner kb = new Scanner(System.in);
		System.out.print("Looking for Car:"); // uncomment only when testing on your local system
		String[] input = kb.nextLine().split(" ");
		int[] rowSeats = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			rowSeats[i] = Integer.parseInt(input[i]);
		}

	}

}