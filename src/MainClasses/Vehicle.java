package MainClasses;

import java.util.ArrayList;

public class Vehicle extends MuseumObject {

	protected String licensePlate;
	protected int yearOfManufacture;
	protected String colour;
	protected double value;
	protected String vehicleType;
	
	public Vehicle(String licensePlate, int yearOfManufacture,
			String colour, double value, String vehicleType, int id) {
		super(id);
		this.licensePlate = licensePlate;
		this.yearOfManufacture = yearOfManufacture;
		this.colour = colour;
		this.value = value;
		this.objectType = "Vehicle";
		this.vehicleType = vehicleType;
	}
	
	public String getPlate() {
		return licensePlate;
	}
	
	public int getYear() {
		return yearOfManufacture;
	}
	
	public String getColour() {
		return colour;
	}
	
	public double getValue() {
		return value;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	
	public ArrayList<InfoEntry> getInfo() {
		return new ArrayList<InfoEntry>();
	}
	
	public void listAttributes() {
		super.listAttributes();
		System.out.println("==============================");
		System.out.println("ID: " + this.getID() + " | " + objectType + " | " + vehicleType);
		System.out.println("==============================");
		System.out.println("License plate: " + licensePlate);
		System.out.println("Year: " + yearOfManufacture);
		System.out.println("Colour: " + colour);
		System.out.println("Value: " + value);
	}

}
