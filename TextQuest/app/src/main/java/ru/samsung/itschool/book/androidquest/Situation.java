package ru.samsung.itschool.book.androidquest;

public class Situation {

	public Situation[] direction;
	public String subject;
	public String text;
	public int dK;
	public int dA;
	public int dR;
	public int dS;

	public Situation(String subject, String text, int variants, int dk, int da,
			int dr, int ds) {
		this.subject = subject;
		this.text = text;
		dK = dk;
		dA = da;
		dR = dr;
		dS = ds;

		direction = new Situation[variants];
	}

}
