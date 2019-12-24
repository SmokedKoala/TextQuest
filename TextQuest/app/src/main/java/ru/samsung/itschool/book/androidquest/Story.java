package ru.samsung.itschool.book.androidquest;

import java.util.Scanner;

public class Story  {

	private Situation my_story;
	public Situation current_situation;
	public Character S;
	public Character A;

	Story() {
		my_story = new Situation(
				"Таверна",
				"Прибыв в деревню, Геральт нашёл таверну "
						+ ".\n"
						+ "(1)поговорить с трактирщиком\n"
						+ "(2)просмотреть доску объявлений в поиске работы\n"
						+ "(3)сыграть в гвинт\n"
						+ "(4)продолжить путь\n",
				4, 0, 0, 0, 0);
		my_story.direction[3]=new Situation(
				"длинная дорога",
				"Геральт отправился дальше в следующую деревню "
						+ "\n",

				0, 0, 0, 0, 0);
//		my_story.direction[4]=new Situation(
//				"нехватка средств",
//				"Геральт не может позволить себе это "
//						+ "\n",
//				0, 0, 0, 0, 0);
//		my_story.direction[5]=new Situation(
//				"смерть",
//				"Геральт переоценил свои силы, и мир лишился хорошего ведьмака\n "
//						+ "\n",
//				0, 0, 0, 0, 0);
		my_story.direction[0] = new Situation(
				"трактирщик",
				"у этого старика можно выпить "
						+ "\n"
				        + "(1)выпить\n"
						+ "(2)вернуться\n",

				2, 0, 0, 0, 0);
		my_story.direction[0].direction[0] = new Situation(
				"неплохая выпивка",
				"для этих земель, у трактирщика оказался неплохой ассортимент\n"
				+ "выпив Вызимского тёмного, Геральт был готов продолжить путь\n "
				+"(1) вернуться",
				1,0,-20,0,+50
		);
		 my_story.direction[0].direction[0].direction[0] = my_story;
		my_story.direction[0].direction[1] = my_story;
		my_story.direction[1] = new Situation(
				"доска объявлений",
				"старый кусок дерева с несколькими заявками\n"
						+ "просмотрев несколько, Геральт нашёл объявление об утопцах\n"
						+ "(1)принять\n"
						+ "(2)отказаться\n",
				2, 0, -0, 0,0);
		my_story.direction[1].direction[1] = my_story;
		my_story.direction[1].direction[0] = new Situation(
				" легкие деньги",
				"расправиться с этими тварями не составило труда\n"
						+ "уничтожив гнездо тварей, ведьмак вернулся за наградой\n "
						+"(1) вернуться",
				1,0,+200,+50,-25
		);
		my_story.direction[1].direction[0].direction[0] = my_story;
		my_story.direction[2] = new Situation(
				"гвинт",
				"игроки сидят за дальним столом\n "
						+ "оценив ведьмака взглядом, они пригласили Геральта сыграть\n"
						+ "(1)согласиться\n"
						+"(2)отказаться\n",
				2, 0, -0, -0,0);
		my_story.direction[2].direction[1] = my_story;
		my_story.direction[2].direction[0] = new Situation(
				"проигрыш",
				"Геральт проиграл 100 золотых\n"
				+"\n"
				+"(1)вернуться",
				1, 0,-100,-10,0);
		my_story.direction[2].direction[0].direction[0] = my_story;
		current_situation = my_story;
	}

	public void go(int num) {
		if (num <= current_situation.direction.length)
			current_situation = current_situation.direction[num - 1];
		else
			System.out.println("Вы можете выбирать из "
					+ current_situation.direction.length + " вариантов");
	}

	public boolean isEnd() {
		return current_situation.direction.length == 0;
	}
}