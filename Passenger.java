abstract class Passenger implements Eater {
// attributes 
	private String name;
	private int birthYear;
	private double weight;
	private double height;
	private char gender;
	private int numCarryOn;
	private int caloriesConsumed;
	private int caloriesAccumulator;
	
	// default
public Passenger() {
   this.name = "";
   this.birthYear = 1900;
   this.weight = 0.0;
   this.gender = 'u';
   this.numCarryOn = 0;
   this.height = 0.0;
   this.caloriesConsumed = 0;
   this.caloriesAccumulator=0;
}
// overloaded constructor
public Passenger(String name,int birthYear,double weight,double height,char gender,int numCarryOn) {
  this.name = name;
  this.birthYear = birthYear;
  if(weight<0) {
		this.weight = -1;
	}
	else {
 this.weight = weight;
	}
  if((gender == 'f')||(gender=='m')){
		this.gender = gender;
	}
	else {
	this.gender = 'u';
	}
      if(numCarryOn>2) 
	  this.numCarryOn = 2;

      else if(numCarryOn<0) {
	  this.numCarryOn = 0;
      }
	  else {
	  	this.numCarryOn = numCarryOn;
	  }
  this.height = height;
    if(height<0) {
		this.height = -1.0;
	}
		else {
			this.height= height;
	}
}

public double getHeight() {
	return this.height;
}

public void setHeight(double height) {
	if(height<0) {
		this.height = -1.0;
	}
		else {
			this.height= height;
	}
}

public double calculateBMI(){
	double BMI = (this.getWeight()*703)/(this.getHeight()*this.getHeight());
return BMI;
}

public int calculateAge(int currentYear) {
 int age = currentYear - this.birthYear;
	
 if(age<0) {
	 age = -1;
 }
return age;
}

public boolean isMale () {
	return this.getGender() == 'M'|| this.getGender() == 'm';
}

public boolean isFemale () {
return this.getGender() == 'F'|| this.getGender() == 'f';
}

public void setGender(char gender) {
	if((gender == 'f')||(gender=='m')){
		this.gender = gender;
	}
	else {
	this.gender = 'u';
	}
}

public void setName(String name) {
	this.name=name;
}

public void setBirthYear(int birthYear) {
	this.birthYear = birthYear;
}

public void setWeight(double weight) {
if(weight < 0) {
	this.weight = -1;
}
else {
	this.weight = weight;
}
}

public void setNumCarryOn(int numCarryOn) {
if(numCarryOn>2) 
this.numCarryOn = 2;

if(numCarryOn<0)
this.numCarryOn = 0;

else {
	this.numCarryOn = numCarryOn;
}
}

public String getName() {
	return this.name;
}

public double getWeight() {
	return this.weight;
}

public int getBirthYear() {
	return this.birthYear;
}

public char getGender() {
	return this.gender;
}

public int getNumCarryOn() {
	return this.numCarryOn;
}

public void gainWeight() {
	this.weight++;
}
public void gainWeight(double weight) {
	this.weight += weight;
	if(Double.compare(this.weight, 0.0)<0) {
		this.weight = 0.0;
	}
	}


public void loseWeight() {
this.weight = this.weight - 1;
if(Double.compare(this.weight, 0.0)<0) {
	this.weight = 0.0;
}
	
	
	
	
}

public void loseWeight(double weight) {
 if(this.weight-weight < 0) {
	 this.weight = 0.0;
 }
 else {
	 this.weight = this.weight - weight;
 }
}

public void setCaloriesConsumed(int caloriesConsumed) {
	this.caloriesConsumed = caloriesConsumed;
}

public void setCaloriesAccumulator(int caloriesAccumulator) {
	this.caloriesAccumulator = caloriesAccumulator;
}

public int getCaloriesConsumed() {
	return caloriesConsumed;
}

public int getCaloriesAccumulator() {
	return caloriesAccumulator;
}

public abstract double metabolizeAccumulatedCalories();


public void printDetails() {
	System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f |Height:%10.2f| Gender: %c | NumCarryOn: %2d\n",this.getName(),this.getBirthYear(),this.getWeight(),this.getHeight(),this.getGender(),this.getNumCarryOn());
}

// @Override 
public String toString() 
{
String s = String.format("Name: %20s | Year of Birth: %4d | Weight: %10.2f |  Height: %10.2f | Gender: %c | NumCarryOn: %2d\n",this.name,this.birthYear,this.weight,this.height,this.gender,this.numCarryOn);
return s;
}

//@Override 
public boolean equals (Object o) 
{
if(o==this) return true; 

Passenger p = (Passenger) o;
if((p.birthYear==this.birthYear)&&(p.gender==this.gender)&&(p.name== this.name)&&(Math.abs(p.weight-this.weight)<0.5)&&(Math.abs(p.height-this.height)<0.5))
	return true;
else {
	return false;
}
}
}


