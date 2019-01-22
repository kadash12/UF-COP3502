public abstract class Shape {
private String color;

String getColor() {
	return color;
}

void setColor(String color) {
	this.color = color;
}

public String toString() {
	String newColor = getColor();
	return newColor;
}

abstract double calculateArea();

}
