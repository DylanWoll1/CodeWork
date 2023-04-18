
public class Array {
 public static int sum(int[] arr) {

int sum = 0;

for (int i = 0; i < arr.length; i++) {

sum = sum + arr[i];

}

return sum;

}

// method to calculate the sum of array with elements

public static int sum(int[] arr, int intFirstIndex, int intLastIndex) {

int sum = 0;

for (int i = intFirstIndex; i <= intLastIndex; i++) {
if((intFirstIndex <0)||(intLastIndex < 0)){
        return (-666);
}
	sum = sum + arr[i];

}

return sum;

}

// method to calculate the average of array

public static double average(int[] arr) {

double total = arr.length;

return sum(arr) / total;

}

// method to calculate the average of array with elements

public static double average(int[] arr, int intFirstIndex, int intLastIndex) {

double totalElements = intLastIndex - intFirstIndex;
if((intFirstIndex < 0)||(intLastIndex < 0)) {
	return (-666.0);
	
}
return sum(arr, intFirstIndex, intLastIndex) / (totalElements+1);

}

// method to calculate the maxvalue of array

public static int maxValue(int[] arr) {

int max = arr[0]; 

for (int i = 0; i < arr.length; i++) {

if(arr[i] > max) 

max = arr[i]; 

}

return max;

}

// method to calculate the maxvalue of array with elements

public static int maxValue(int[] arr,int intFirstIndex, int intLastIndex) {

int max = arr[0]; 
if((intFirstIndex < 0)||(intLastIndex < 0)) {
	return(-666);
}
for (int i = intFirstIndex; i <= intLastIndex; i++) {

if(arr[i] > max) 

max = arr[i]; 

}

return max;

}

// // method to find the index of first max value

public static int indexOfFirstMaxValue(int[] arr) {

int max = maxValue(arr);

for (int i = 0; i < arr.length; i++) {

if(arr[i] == max) 

return i;

}

return -1; 

}

// method to find the index of first max value with elements

public static int indexOfFirstMaxValue(int[] arr, int intFirstIndex, int intLastIndex) {

int max = maxValue(arr,intFirstIndex,intLastIndex);
if((intFirstIndex < 0)||(intLastIndex < 0)) {
	return(-1);
}
for (int i = intFirstIndex; i <= intLastIndex; i++) {

if(arr[i] == max) 

return i;

}

return -1; 

}

// method to calculate the elements having number below average

public static int numberOfBelowAverageElements(int[] arr) {

double average = average(arr);

int count=0;

for (int i = 0; i < arr.length; i++) {

if(arr[i] < average) 

count++;

}

return count; 

}

// method to calculate the elements having number below average with elements

public static int numberOfBelowAverageElements(int[] arr, int intFirstIndex, int intLastIndex) {

double average = average(arr,intFirstIndex,intLastIndex);

int count=0;
if((intFirstIndex<0)||(intLastIndex<0)) {
	return(-666);
}
for (int i = intFirstIndex; i <= intLastIndex; i++) {

if(arr[i] < average) 

count++;

}

return count; 

}

// method to rotate the elements

public static int rotateElement(int[] arr) {

// create a temporary array

int[] intArray = new int[arr.length];

// array traversal

for (int i = 0; i < arr.length; i++) {

if(i==(arr.length-1)) {

intArray[i]=arr[0];

}else {

intArray[i]=arr[i+1];

}

}

for (int i = 0; i < intArray.length; i++) {

System.out.print(intArray[i]+" ");

}

return 0; 

}

// method to reverse the array

public static void reverseArray(int[] arr) {

int[] b = new int[arr.length];

int j = arr.length;

for (int i = 0; i < arr.length; i++) {

b[j - 1] = arr[i];

j = j - 1;

}

// printing the reversed array

for (int k = 0; k < arr.length; k++) {

System.out.print(b[k]+" ");

}

}

// method to ratate the elements with count

public static int rotateElement(int[] arr,int rotationCount) {

for(int i = 0; i <= rotationCount; i++){ 

int j, last; 

//Stores the last element of array 

last = arr[arr.length-1]; 

for(j = arr.length-1; j > 0; j--){ 

//Shift element of array by one 

arr[j] = arr[j-1]; 

} 

//Last element of array will be added to the start of array. 

arr[0] = last; 

} 

for (int i = 0; i < arr.length; i++) {

System.out.print(arr[i]+" ");

}

return 0; 

}

public static void main(String[] args) {

int[] myArray = { 45, 22, 18, 89, 82, 79, 15, 69, 100, 55, 48, 72, 16, 98, 57, 75, 44, 32, 21, 14, 7, 16, 49, 58, 72 };

System.out.println("Sum of whole array = " + sum(myArray));

System.out.println("Sum of elements 12-18 = " + sum(myArray, 12, 18));

System.out.println("Average of whole array = " + average(myArray));

System.out.println("Average of elements 12-18 = " + average(myArray, 12, 18));

System.out.println("Max of whole array = " + maxValue(myArray));

System.out.println("Max of whole elements 12-18 = " + maxValue(myArray,12,18));

System.out.println("Index of first Max of whole array = " + indexOfFirstMaxValue(myArray));

System.out.println("Index of first Max of elements 12-18 = " + indexOfFirstMaxValue(myArray,12,18));

System.out.println("Count of elements below average of whole array = " + numberOfBelowAverageElements(myArray));

System.out.println("Count of elements below average of elements 12-18 = " + numberOfBelowAverageElements(myArray,12,18));

System.out.println("\nRotating once ");

rotateElement(myArray);

System.out.println("\n\nRotating 5 more times : ");

rotateElement(myArray,5);

System.out.println("\n\nReversing the array : ");

reverseArray(myArray);

}

}