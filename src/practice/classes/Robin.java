package practice.myServer;

public class Robin extends Bird {

	String species;
	String color;
	int age;

	public Robin( String species, String color, int age ) {

		this.species = species;
		this.color = color;
		this.age = age;
	}

	public String eat() {

		return "I like to eat bugs";
	}

	public String talk() {

		return "I am a " + species + ", " + color + " in color and " + age + " years old";
	}

	public String fly() {

		return "I can fly because I'm a robin";
	}
}
