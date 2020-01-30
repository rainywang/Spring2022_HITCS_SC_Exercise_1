package exercise_6_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Author {

	private String name;
	private List<Paper> papers = new ArrayList<>();

	public Author(String name) {
		this.name = name;
	}

	public void addPaper(Paper p) {
		papers.add(p);
		Collections.sort(papers, new CitationComparator());
	}

	public void modifyCitation(Paper p, int number, boolean increase) {
		if (increase)
			p.increaseCitation(number);
		else
			p.decreaseCitation(number);
		
		Collections.sort(papers, new CitationComparator());
	}

	public int calcHIndex() {
		String input = "";
		for (Paper p : papers) {
			input += p.getCitation() + ",";
		}
		return HIndex.calcHIndex(input);
	}

	@Override
	public String toString() {
		String content = "Author:\t" + this.name + "\n";
		for (Paper p : papers) {
			content += p.getTitle() + ":\t" + p.getCitation() + "\n";
		}
		content += "HIndex:\t" + calcHIndex();

		return content;
	}

	public static void main(String[] args) {
		Author a = new Author("Zhang San");
		Paper p1 = new Paper("What is Software?", 2019, "Journal of HIT", 10);
		Paper p2 = new Paper("A Novel Coronavirus", 2020, "Science", 100);
		Paper p3 = new Paper("Study in HIT", 2018, "Nature", 5);
		Paper p4 = new Paper("A Bad Spring Festival", 2020, "Journal of HIT", 0);

		a.addPaper(p1);
		a.addPaper(p2);
		a.addPaper(p3);
		a.addPaper(p4);

		System.out.println(a);

		a.modifyCitation(p3, 2, false);
		a.modifyCitation(p4, 1, true);

		System.out.println(a);
	}
}
