package MainClasses;

public class MuseumObject {

	protected String objectType = "";
	private int objectID;
	
	public MuseumObject(int id) {
		this.objectID = id;
	}
	
	public String getType() {
		return objectType;
	}
	
	public void listAttributes() {
		
	}
	
	public int getID() {
		return objectID;
	}
	
	public void setID(int id) {
		this.objectID = id;
	}
	
}
