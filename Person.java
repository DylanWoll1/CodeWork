import java.util.Objects;

public class Person {
	private String name;
	private boolean hasDriverLicense;
	private int age;
	private int height;

	public Person(String name, boolean hasDriverLicense, int age, int height) {
		this.name = name;
		this.hasDriverLicense = hasDriverLicense;
		this.age = age;
		this.height = height;
	}

	public String getName() {
		return this.name;
	}

	public boolean hasDriverLicense() {
		return this.hasDriverLicense;
	}

	public int getAge() {
		return this.age;
	}

	public int getHeight() {
		return this.height;
	}

	public Person clone() {
		Person ret = new Person(name, hasDriverLicense, age, height);
		return ret;

	}

	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Person person = (Person) o;
	    return age == person.age &&
	           Objects.equals(name, person.name) &&
	           Objects.equals(hasDriverLicense, person.hasDriverLicense)&&
	           Objects.equals(height,person.height);
	  }
	

	public String toString() {
		return String.format("Person [name= %10s | age= %02d | height= %02d | has license/no license]", name, age,
				height, hasDriverLicense);
	}

}
