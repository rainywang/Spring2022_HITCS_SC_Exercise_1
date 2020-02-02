package exercise_3_6;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

public class Client {

	public static void main(String[] args) throws Exception {
		// 创建车场
		Map<Integer, Integer> lots = new HashMap<>();
		lots.put(1, 10);
		lots.put(2, 15);
		lots.put(3, 20);
		lots.put(4, 20);
		lots.put(5, 20);
		ParkingField pf = ParkingField.create(lots);

		System.out.println(pf);

		pf.parking("HA001", 10, 1, "Car");
		pf.parking("HA002", 10, 2, "Motor");
		pf.parking("HA003", 10, 3, "Plane");
		System.out.println(pf);

		pf.parking("HA004", 10, 4, "Car");
		pf.parking("HA005", 10, 5, "Motor");
		System.out.println(pf);
	}
}
