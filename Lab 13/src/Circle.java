public class Circle extends Shape{
private int radius;

Circle (String color, int radius) {
	super.setColor(color);
	this.radius = radius;
}

double getRadius() {
	return radius;
}

void setRadius(int radius) {
	this.radius = radius;
}

public String toString() {
	String output = "SHAPE INFO\nShape: Circle\nColor: "+ super.getColor() + "\nRadius: " + radius + 
			"\nArea: " + calculateArea() +"\n";
	return output;
}

double calculateArea() {
	double area = Math.PI*radius*radius;
	return area;
}


}
