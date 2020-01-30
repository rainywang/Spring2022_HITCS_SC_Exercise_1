package exercise_6_6;

import java.util.ArrayList;
import java.util.List;

public class HIndex {
	
	//representation (rep)
	//private final List<Integer> citations;

	//construction method
	public HIndex(/*String input*/) {
	//	citations = dealInput(input);
	}

	//private static method
	private static List<Integer> dealInput(String input) {
		
		if(input == null || input.length() == 0)
			throw new IllegalArgumentException("Empty input");
		
		List<Integer> citations = new ArrayList<>();
		
		String[] strs = input.split(",");
		
		for (int i = 0; i < strs.length; i++) {
			if(! strs[i].matches("[0-9]+")) 
				throw new IllegalArgumentException(strs[i] + " is illegal");

			citations.add(Integer.parseInt(strs[i]));
		}
		
		return citations;
	}

	//public static method
	public static int calcHIndex(String input) {

		List<Integer> citations = dealInput(input);
		
		// in order to reuse code, first transform List into an array
		int[] citationsInArray = new int[citations.size()];
		for (int i = 0; i < citations.size(); i++)
			citationsInArray[i] = citations.get(i);

		// sorting
		sort(citationsInArray);

		// calculate h-index
		int hindex = 0;
		for (int j = 0; j < citationsInArray.length; j++) {
			if (citationsInArray[j] >= j + 1)
				hindex = j + 1;
			else
				break;
		}
		return hindex;
	}

	//private method
	private static void sort(int[] citations) {
		int number = citations.length;
		for (int i = 0; i < number - 1; i++) {
			for (int j = 0; j < number - 1; j++) {
				if (citations[j] < citations[j + 1]) {
					int temp = citations[j + 1];
					citations[j + 1] = citations[j];
					citations[j] = temp;
				}
			}
		}
	}
	
	//main() as a client
	public static void main(String[] args) {

		String[] inputs = new String[] {"10", "0,11,32,1"};
		for(int i=0;i<inputs.length;i++) {
			//HIndex h = new HIndex(inputs[i]);
			System.out.println(HIndex.calcHIndex(inputs[i]));
		}
	}
}
