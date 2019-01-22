import java.util.Scanner;

public class FruitSalad {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int fruitLength = Integer.parseInt(args[0]);
		Fruit[] fruitArray = new Fruit[fruitLength];
		while (true) {
			System.out.println("1. Add");
			System.out.println("2. Remove");
			System.out.println("3. Cut ingredients");
			System.out.println("4. Start over");
			System.out.println("5. Print ingredients");
			System.out.println("6. Finish");
			System.out.println("Choice: ");
			int choice = input.nextInt();
			if (choice==1) {
				add(fruitArray, input);
			}
			else if (choice==2) { 
				remove(fruitArray, input);
			}
			else if (choice==3) {
				cut(fruitArray);
			}
			else if (choice==4) {
				restart(fruitArray);
			}
			else if (choice==5) {
				display(fruitArray);
			}
			else if (choice==6) {
				System.exit(0);
			}
		}
	}

	public static void add(Fruit[] a, Scanner s) {
		System.out.println("Do you know the weight? ('yes'/'no'): ");
		String knowWeight = s.next();
		if (knowWeight.equalsIgnoreCase("yes")) {
			System.out.println("What is the weight of the fruit? ");
			int weight = s.nextInt();
			s.nextLine();
			System.out.println("What is the name of the fruit? ");
			String name = s.nextLine();
			System.out.println("What is the color of the fruit? ");
			String color = s.nextLine();
			System.out.println("Is the fruit cut? ('true'/'false'): ");
			boolean cut = s.nextBoolean();
			Fruit fruit1 = new Fruit(name, color, weight, cut);
			for (int i = 0; i < a.length; i++) {
				if (a[i]==null) {
					a[i] = fruit1;
					break;
				}
			}

		}
		else if (knowWeight.equalsIgnoreCase("no")){
			s.nextLine();
			System.out.println("What is the name of the fruit? ");
			String name = s.nextLine();
			System.out.println("What is the color of the fruit? ");
			String color = s.nextLine();
			Fruit fruit1 = new Fruit(name, color);
			for (int i = 0; i < a.length; i++) {
				if (a[i]==null) {
					a[i] = fruit1;
					break;
				}
			}
		}


	}

	public static void remove(Fruit[] f, Scanner s) {
		s.nextLine();
		System.out.println("Which fruit would you like to remove? ");
		String name = s.nextLine();
		for (int i = 0; i < f.length; i++) {
			if (f[i].getName().equalsIgnoreCase(name)) {
				f[i] = null;
				break;
			}
			else {
				System.out.println("Fruit was not found.");
			}
		}
	}

	public static void cut(Fruit[] f) {
		for (int i = 0; i < f.length; i++) {
			if (f[i]!=null) {
				if (f[i].isCut()==false) {
					f[i].setCut(f[i].isCut());
				}
			}
		}
	}

	public static void restart(Fruit[] f) {
		for (int i = 0; i < f.length; i++) {
			f[i] = null;
		}
	}

	public static void display(Fruit[] f) {
		for (int i = 0; i < f.length; i++) {
			if (f[i]!=null) {
				System.out.println("Fruit: " + f[i].getName());
				System.out.println("Color: " + f[i].getColor());
				System.out.println("Weight: " + f[i].getWeight());
				System.out.println("Cut: " + f[i].isCut());
				System.out.println(" ");
			}
		}
	}
}
