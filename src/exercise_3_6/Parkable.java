package exercise_3_6;

public interface Parkable {
	
	public static Parkable create(String plate, int width, String type) {
		if(type=="Car")
			return new Car(plate, width);
		if(type=="Plane")
			return null;//TODO
		if(type=="Motor")
			return new Motor(plate, width);
		
		return null;
	}
	
	public int getWidth();
	public String getPlate();
	
}
