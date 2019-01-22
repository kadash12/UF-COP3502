
public class Lab13 {
	
public static void main (String args[]) {
	Shape s = new Circle("purple", 5);
	System.out.println(s.toString());
	s = new Rectangle("gray", 11, 8);
	System.out.println(s.toString());
	s = new Triangle("orange", 5, 10);
	System.out.println(s.toString());
}

}
