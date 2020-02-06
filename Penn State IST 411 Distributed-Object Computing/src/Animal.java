import java.io.Serializable;

public class Animal implements Serializable {

	private String species, commonName, name;
	private int age;
	private double weight;

	public Animal() {

	}

	public Animal(String pSpecies, String pCommonName, String pName, int pAge, double pWeight) {
		setSpecies(pSpecies);
		setCommonName(pCommonName);
		setName(pName);
		setAge(pAge);
		setWeight(pWeight);
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
