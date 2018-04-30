package MainClasses;

import java.util.ArrayList;
import java.util.Arrays;

public class Car extends Vehicle {

	private int numberOfDoors;
	private int numberOfSeats;
	private String engineType;
	private double engineSize;

	public Car(String licensePlate, int yearOfManufacture, String colour, double value, int numberOfDoors,
			int numberOfSeats, String engineType, double engineSize, int id) {
		super(licensePlate, yearOfManufacture, colour, value, "Car", id);
		this.numberOfDoors = numberOfDoors;
		this.numberOfSeats = numberOfSeats;
		this.engineSize = engineSize;
		this.engineType = engineType;
	}

	public int getDoors() {
		return numberOfDoors;
	}

	public int getSeats() {
		return numberOfSeats;
	}

	public double getEngineSize() {
		return engineSize;
	}

	public String getEngineType() {
		return engineType;
	}

	public void listAttributes() {
		super.listAttributes();
		System.out.println("Number of Doors: " + numberOfDoors);
		System.out.println("Number of Seats: " + numberOfSeats);
		System.out.println("Engine Size: " + engineSize + " litres");
		System.out.println("Engine Type: " + engineType);
	}
	
	@Override
	public ArrayList<InfoEntry> getInfo() {
		ArrayList<InfoEntry> list = new ArrayList<InfoEntry>();
		
		list.addAll(Arrays.asList(new InfoEntry("License Plate", licensePlate),
				new InfoEntry("Year of Manufacture", Integer.toString(yearOfManufacture)),
				new InfoEntry("Colour", colour), new InfoEntry("Value", Double.toString(value)),
				new InfoEntry("Number of Doors", Integer.toString(numberOfDoors)),
				new InfoEntry("Number of Seats", Integer.toString(numberOfSeats)),
				new InfoEntry("Engine Type", engineType), new InfoEntry("Engine Size", engineSize + " L"),
				new InfoEntry("Vehicle Type", vehicleType), new InfoEntry("Vehicle ID", Integer.toString(getID()))));

		return list;
	}
}
