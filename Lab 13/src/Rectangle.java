public class Rectangle extends Shape {
private int height;
private int width;

Rectangle(String color, int height, int width) {
		super.setColor(color);
		this.height = height;
		this.width = width;
}

int getHeight() {
	return height;
}

void setHeight(int height) {
	this.height = height;
}

int getWidth() {
	return width;
}

void setWidth(int width) {
	this.width = width;
}

public String toString() {
	String output = "SHAPE INFO\nShape: Rectangle\nColor: "+ super.getColor() + "\nWidth: " + getWidth() + "\nHeight: " 
			+ getHeight() + "\nArea: " + calculateArea() +"\n";
	return output;
}

double calculateArea() {
	double area = getWidth()*getHeight();
	return area;
}
}
