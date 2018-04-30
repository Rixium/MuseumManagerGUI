package MainClasses;
import java.util.ArrayList;

public class Museum {

	private String museumName = "";
	private String museumType = "";
	private ArrayList<MuseumObject> museumObjects = new ArrayList<MuseumObject>();
	
	public Museum(String museumName, String museumType) {
		this.museumName = museumName;
		this.museumType = museumType;
	}
	
	public void addObject(MuseumObject object) {
		museumObjects.add(object);
	}
	
	public String getMuseumName() {
		return museumName;
	}
	
	public String getMuseumType() {
		return museumType;
	}
	
	public ArrayList<MuseumObject> getObjects() {
		return museumObjects;
	}
	
	public void listObjects() {
		System.out.println();
		for(int i = 0; i < museumObjects.size(); i++) {
			museumObjects.get(i).listAttributes();
			System.out.println();
		}
	}

	public void listObjectsByYear(int year) {
		System.out.println();
		for(int i = 0; i < museumObjects.size(); i++) {
			Vehicle vehicle = (Vehicle) museumObjects.get(i);
			if(vehicle.getYear() == year) {
				vehicle.listAttributes();
				System.out.println();
			}
		}
	}
	
	public void listObjectsByEngineSize(double engineSize) {
		System.out.println();
		for(int i = 0; i < museumObjects.size(); i++) {
			Vehicle vehicle = (Vehicle) museumObjects.get(i);
			
			switch(vehicle.getVehicleType()) {
				case "Bike":
					Bike b = (Bike) vehicle;
					if(b.getEngineSize() >= engineSize * 1000) {
						b.listAttributes();
						System.out.println();
					}
					break;
				case "Car":
					Car c = (Car) vehicle;
					if(c.getEngineSize() >= engineSize) {
						c.listAttributes();
						System.out.println();
					}
					break;
				default:
					break;
			}
			
		}
	}
	
	public ArrayList<ArrayList<InfoEntry>> getByNumberPlate(String numberPlate) {
		ArrayList<ArrayList<InfoEntry>> list = new ArrayList<ArrayList<InfoEntry>>();
		
		for(int i = 0; i < museumObjects.size(); i++) {
			Vehicle vehicle = (Vehicle) museumObjects.get(i);
			String plate = vehicle.getPlate().replaceAll("\\s", "").toLowerCase();
			if(plate.contains(numberPlate)) {
				list.add(vehicle.getInfo());
			}
		}
		
		return list;
	}
	
	public ArrayList<ArrayList<InfoEntry>> getByID(String id) {
		int idToSearch = Integer.parseInt(id);
		
		ArrayList<ArrayList<InfoEntry>> list = new ArrayList<ArrayList<InfoEntry>>();
		
		for(int i = 0; i < museumObjects.size(); i++) {
			Vehicle vehicle = (Vehicle) museumObjects.get(i);
			if(vehicle.getID() == idToSearch) {
				list.add(vehicle.getInfo());
			}
		}
		
		return list;
	}
	
	public ArrayList<ArrayList<InfoEntry>> getByColour(String colour) {
		ArrayList<ArrayList<InfoEntry>> list = new ArrayList<ArrayList<InfoEntry>>();
		
		for(int i = 0; i < museumObjects.size(); i++) {
			Vehicle vehicle = (Vehicle) museumObjects.get(i);
			if(vehicle.getColour().equalsIgnoreCase(colour)) {
				list.add(vehicle.getInfo());
			}
		}
		
		return list;
	}
	
	public ArrayList<ArrayList<InfoEntry>> getByPrice(String price) {
		double priceToSearch = Double.parseDouble(price);
		
		ArrayList<ArrayList<InfoEntry>> list = new ArrayList<ArrayList<InfoEntry>>();
		
		for(int i = 0; i < museumObjects.size(); i++) {
			Vehicle vehicle = (Vehicle) museumObjects.get(i);
			if(vehicle.getValue() == priceToSearch) {
				list.add(vehicle.getInfo());
			}
		}
		
		return list;
	}
	
	public ArrayList<ArrayList<InfoEntry>> getByYear(String year) {
		int yearToSearch = Integer.parseInt(year);
		
		ArrayList<ArrayList<InfoEntry>> list = new ArrayList<ArrayList<InfoEntry>>();
		
		for(int i = 0; i < museumObjects.size(); i++) {
			Vehicle vehicle = (Vehicle) museumObjects.get(i);
			if(vehicle.getYear() == yearToSearch) {
				list.add(vehicle.getInfo());
			}
		}
		
		return list;
	}
	
	public ArrayList<ArrayList<InfoEntry>> getByType(String type) {
		ArrayList<ArrayList<InfoEntry>> list = new ArrayList<ArrayList<InfoEntry>>();
		
		for(int i = 0; i < museumObjects.size(); i++) {
			Vehicle vehicle = (Vehicle) museumObjects.get(i);
			if(vehicle.getVehicleType().equalsIgnoreCase(type)) {
				list.add(vehicle.getInfo());
			}
		}
		
		return list;
	}
	
	private void listTypeAttributes(Vehicle vehicle) {
		switch(vehicle.getVehicleType()) {
		case "Bike":
			Bike b = (Bike) vehicle;
			b.listAttributes();
			break;
		case "Car":
			Car c = (Car) vehicle;
			c.listAttributes();
		default:
			break;
		}
	}
	
	public void listCars() {
		System.out.println();
		for(int i = 0; i < museumObjects.size(); i++) {
			Vehicle vehicle = (Vehicle) museumObjects.get(i);
			if(vehicle.getVehicleType() == "Car") {
				Car c = (Car) vehicle;
				c.listAttributes();
				System.out.println();
			}
		}
	}
	
	public void listBikes() {
		System.out.println();
		for(int i = 0; i < museumObjects.size(); i++) {
			Vehicle vehicle = (Vehicle) museumObjects.get(i);
			if(vehicle.getVehicleType() == "Bike") {
				Bike b = (Bike) vehicle;
				b.listAttributes();
				System.out.println();
			}
		}
	}
	
	public boolean removeObject(int id) {
		if(museumObjects.size() > id) {
			museumObjects.remove(id);
			for(int i = id; i < museumObjects.size(); i++) {
				museumObjects.get(i).setID(i);
			}
			return true;
		} else {
			return false;
		}
	}
	
	public void setMuseumName(String name) {
		this.museumName = name;
	}
}
