package exercise_6_6;

public class Paper {

	private String title;
	private int year;
	private String journal;
	private int citation;

	public Paper(String t, int y, String j, int c) {
		this.title = t;
		this.year = y;
		this.journal = j;
		this.citation = c;
	}

	public int increaseCitation(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("Please give a positive number!");

		this.citation += n;
		return this.citation;
	}

	public int decreaseCitation(int n) {
		if (this.citation < n)
			throw new IllegalArgumentException("Too large decreasing number!");

		if (n <= 0)
			throw new IllegalArgumentException("Please give a positive number!");

		this.citation -= n;
		return this.citation;
	}

	public int getCitation() {
		return this.citation;
	}

	public String getTitle() {
		return this.title;
	}
}
