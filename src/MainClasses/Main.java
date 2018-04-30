package MainClasses;
import java.util.Scanner;

public class Main {

	/* This program allows you to name a museum. Once the museum has been made,
	 * it allows you to add objects to the museum. You can also use the menu to list
	 * objects of a certain year, engine size, and all cars and bikes.
	 */
	
	private Scanner scanner = new Scanner(System.in);
	
	public Main() {
		
		System.out.println();
		System.out.print("Enter a museum name: ");
		String name = scanner.nextLine();
		
		Museum museum = new Museum(name, "Vehicle");

		int selection;

			System.out.println();
			selection = listMenuAndGetSelection();
			
			switch(selection) {
			case 1:
				// Add vehicle
				addVehicleToMuseum(museum);
				break;
			case 2:
				// List by year
				System.out.println("Input year to list: ");
				int year = scanner.nextInt();
				System.out.println(Colours.WHITEBG + Colours.BLACKFG);
				museum.listObjectsByYear(year);
				break;
			case 3:
				// List by engine size >= 1 litres
				System.out.println("Enter engine size in litres: ");
				double size = scanner.nextDouble();
				System.out.println(Colours.WHITEBG + Colours.BLACKFG);
				museum.listObjectsByEngineSize(size);
				break;
			case 4:
				// List all cars
				System.out.println(Colours.WHITEBG + Colours.BLACKFG);
				museum.listCars();
				break;
			case 5:
				// List all bikes
				System.out.println(Colours.WHITEBG + Colours.BLACKFG);
				museum.listBikes();
				break;
			case 6:
				// Remove item from museum
				System.out.println("Input object ID: ");
				int id = scanner.nextInt();
				System.out.println(Colours.WHITEBG + Colours.BLACKFG);
				museum.removeObject(id);
				break;
			case 7:
				// List all items
				System.out.println(Colours.WHITEBG + Colours.BLACKFG);
				museum.listObjects();
				break;
			case 8:
				// List vehicle by number plate
				System.out.println("Input known number plate characters: ");
				scanner.nextLine();
				String plateChars = scanner.nextLine();
				plateChars = plateChars.replaceAll("\\s", "");
				System.out.println(Colours.WHITEBG + Colours.BLACKFG);
				break;
			default:
				System.out.println("Invalid selection.");
				break;
			}
			
			System.out.println(Colours.RESETALL);
			
	}
	
	private int listMenuAndGetSelection() {
		System.out.println("===========================");
		System.out.println("Menu");
		System.out.println("===========================");
		System.out.println("1: Add Vehicle to Museum");
		System.out.println("2: List Vehicles by Year");
		System.out.println("3: List Vehicles of a certain engine size: ");
		System.out.println("4: List all Cars");
		System.out.println("5: List all Bikes");
		System.out.println("6: Remove item from Museum");
		System.out.println("7: List all vehicles");
		System.out.println("8: Find Vehicle by number plate: ");
		System.out.println();
		System.out.print("Selection: ");
		int selection = scanner.nextInt();
		System.out.println();
		return selection;		
	}
	
	private void addVehicleToMuseum(Museum museum) {
		System.out.print("Enter a vehicle type (B for Bike, C for Car): ");
		String type = scanner.next().toLowerCase();
		scanner.nextLine();
		System.out.print("Enter license plate number: ");
		String licensePlate = scanner.nextLine().toUpperCase();
		
		System.out.print("Enter year of manufacture: ");
		int manufactureYear = scanner.nextInt();
		
		System.out.print("Input colour: ");
		String colour = scanner.next();
		
		System.out.print("Enter value: ");
		double value = scanner.nextDouble();
		
		Vehicle vehicle = null;
		
		switch(type) {
			case "c":
				System.out.print("Enter number of doors: ");
				int doors = scanner.nextInt();
				System.out.print("Enter number of seats: ");
				int seats = scanner.nextInt();
				System.out.print("Enter engine type (P for Petrol, D for Diesel): ");
				String engineType = scanner.next().toLowerCase();
				System.out.print("Enter engine size in litres: ");
				double engineSize = scanner.nextDouble();
				
				switch(engineType) {
					case "p":
						engineType = "Petrol";
						break;
					case "d":
						engineType = "Diesel";
						break;
					default:
						break;
				}
				
				vehicle = new Car(licensePlate, manufactureYear, colour, value, doors, seats, engineType, engineSize, museum.getObjects().size());
				
				break;
			case "b":
				System.out.print("Enter bike type (S for Sports, T for Tourer, Tr for Trials): ");
				String bikeType = scanner.next().toLowerCase();
				System.out.print("Enter engine size in cubic centimetres: ");
				engineSize = scanner.nextDouble();
				
				switch(bikeType) {
					case "s":
						bikeType = "Sports";
						break;
					case "t":
						bikeType = "Tourer";
						break;
					case "tr":
						bikeType = "Trials";
						break;
					default:
						break;
				}
				vehicle = new Bike(licensePlate, manufactureYear, colour, value, bikeType, engineSize, museum.getObjects().size());
				
				break;
			default:
				break;
		}
		System.out.println();
		System.out.println(Colours.WHITEBG + Colours.BLACKFG);
		System.out.println(String.format("Adding new %s to %s of type %s.", vehicle.getType(), museum.getMuseumName(), vehicle.getVehicleType()));
		System.out.println(Colours.WHITEBG + Colours.RESETALL);
		museum.addObject(vehicle);
		System.out.println();
	}
}
