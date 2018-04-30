package MainClasses;

import java.util.ArrayList;
import java.util.Arrays;

public class Bike extends Vehicle{

	private String bikeType;
	private double engineSize;
	
	public Bike(String licensePlate, int yearOfManufacture, 
			String colour, double value, String bikeType, double engineSize, int id) {
		super(licensePlate, yearOfManufacture, colour, value, "Bike", id);
		this.bikeType = bikeType;
		this.engineSize = engineSize;
	}
	
	public String getBikeType() {
		return bikeType;
	}
	
	public double getEngineSize() {
		return engineSize;
	}


	public void listAttributes() {
		super.listAttributes();
		System.out.println("Bike Type: " + bikeType);
		System.out.println("Engine Size: " + engineSize + "cc");
	}
	
	@Override
	public ArrayList<InfoEntry> getInfo() {
		ArrayList<InfoEntry> list = new ArrayList<InfoEntry>();
		
		list.addAll(Arrays.asList(new InfoEntry("License Plate", licensePlate),
				new InfoEntry("Year of Manufacture", Integer.toString(yearOfManufacture)),
				new InfoEntry("Colour", colour), new InfoEntry("Value", Double.toString(value)),
				new InfoEntry("Bike Type", bikeType),
				new InfoEntry("Engine Size", engineSize + " cc"),
				new InfoEntry("Vehicle Type", vehicleType),
				new InfoEntry("Vehicle ID", Integer.toString(getID()))));

		return list;
	}
	
	
}
