
public class Fruit {
	private String name;
	private String color;
	private int weight;
	private boolean cut;

	public Fruit(String name, String color, int weight, boolean cut) {
		this.name = name;
		this.color = color;
		this.weight = weight;
		this.cut = cut;
	}

	public Fruit(String name, String color) {
		this.name = name;
		this.color = color;
		this.weight = 1;
		this.cut = false;
	}

	int getWeight() {
		return weight;
	}

	void setWeight(int weight) {
		this.weight = weight;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getColor() {
		return color;
	}

	void setColor(String color) {
		this.color = color;
	}

	boolean isCut() {
		return cut;
	}

	void setCut(boolean cut) {
		this.cut = true;
	}
}
