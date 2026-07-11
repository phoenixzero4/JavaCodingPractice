package practice.myServer;

public abstract class Bird implements Animal {

	String species;
	String color;
	int age;

	public String eat() {

		return "I like to eat bugs";
	}

	public String talk() {

		return "I am a " + species + ", " + color + " in color and " + age + " years old";
	}

	public String fly() {

		return "I am flying";
	}

}
