package ru.samsung.itschool.book.androidquest;

public class Character {
	public int K;//уровень
	public int A;//золото
	public int R;// репутация
	public int S;// здоровье
	public String name;

	public Character(String name) {
		K = 1;
		A = 100;
		R = 20;
		S = 100;
		this.name = name;
	}

}
