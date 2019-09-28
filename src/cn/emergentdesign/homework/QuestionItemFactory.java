package cn.emergentdesign.homework;

import java.util.Random;

public class QuestionItemFactory {
	private Random random;
	public QuestionItemFactory() {
		random = new Random();
	}
	public QuestionItem produce() {
		QuestionItem r = null;
		int op = random.nextInt(4);
		switch(op) {
			case 0:
				r = new AddQuestionItem();
				break;
			case 1:
				r = new SubQuestionItem();
				break;
			case 2:
				r = new MulQuestionItem();
				break;
			case 3:
				r = new DivQuestionItem();
				break;
			default:
				break;
		}
		return r;
	}
}
