package exercise_6_6;

import java.util.Comparator;

public class CitationComparator implements Comparator<Paper> {

	@Override
	public int compare(Paper o1, Paper o2) {
		if (o1.getCitation() > o2.getCitation())
			return -1;
		if (o1.getCitation() < o2.getCitation())
			return 1;
		return 0;
	}
}
