package practice.myServer;

public class Penguin extends Bird {

	private final String species;
	private final String color;
	private final int age;

	public Penguin( String species, String color, int age ) {

		this.species = species;
		this.color = color;
		this.age = age;
	}

	public String eat() {

		return "I like to eat fish";
	}

	public String talk() {

		return "I am a " + species + ", " + color + " in color and " + age + " years old";
	}

	@Override
	public String fly() {

		return "I can not fly because I'm a penguin";
	}
}
