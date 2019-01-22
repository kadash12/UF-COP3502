public class Triangle extends Shape {
private int base;
private int height;

Triangle(String color, int base, int height) {
	super.setColor(color);
	this.base = base;
	this.height = height;
}

int getBase() {
	return base;
}

void setBase(int base) {
	this.base = base;
}

int getHeight() {
	return height;
}

void setHeight(int height) {
	this.height = height;
}
public String toString() {
	String output = "SHAPE INFO\nShape: Triangle\nColor: "+ super.getColor() + "\nBase: " + getBase() + "\nHeight: " 
			+ getHeight() + "\nArea: " + calculateArea() +"\n";
	return output;
}
double calculateArea() {
	double area = .5*getHeight()*getBase();
	return area;
}
}
