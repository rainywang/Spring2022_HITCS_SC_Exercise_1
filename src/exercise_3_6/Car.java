package exercise_3_6;

public class Car implements Parkable {

	private String plate;
	private int width;
	
	public Car(String plate, int width) {
		this.plate = plate;
		this.width = width;
	}

	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public String getPlate() {
		return plate;
	}
	
	@Override
	public boolean equals(Object car) {
		if(car == null)
			return false;
		if(!(car instanceof Car))
			return false;
		Car c = (Car)car;
		if(c.plate == this.plate && c.width == this.width)
			return true;
		else
			return false;
	}
	
}
