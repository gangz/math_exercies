package cn.emergentdesign.homework;

import java.util.ArrayList;
import java.util.Random;

public class MathProducer {
	private Random r;
	public static void main(String[] args) {
		MathProducer producer = new MathProducer();
		producer.run();
	}

	private void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				QuestionItem questionItem = makeQuestion();
				String s = questionItem.toString();
				System.out.println(s.substring(1,s.length()-1)+"=");
			} catch (Exception e) {
			}
		}
	}

	public MathProducer() {
		r = new Random();
	}
	
	private  QuestionItem makeQuestion() throws Exception {
		QuestionItemFactory factory = new QuestionItemFactory();
		QuestionItem questionItem = factory.produce();
		questionItem.setResult(new IntegerOperand(r.nextInt(1000)));
		produceQuestion(questionItem,false);
		QuestionItem q2 = factory.produce();
		q2.setResult(questionItem);
		produceQuestion(q2,true);
		questionItem.setOp2(q2);
		return questionItem;
	}

	private void produceQuestion(QuestionItem questionItem, boolean forceResult) throws Exception {
		if (questionItem instanceof MulQuestionItem) {
			IntegerOperand factor = findFactor(questionItem.getResult().intValue());
			if (factor!=null) 
				questionItem.setOp2(findFactor(questionItem.getResult().intValue()));
			else {
				if (forceResult) throw new Exception();
				questionItem.setOp1(new IntegerOperand(r.nextInt(100)));
				questionItem.setOp2(new IntegerOperand(r.nextInt(100)));
			}
		}else {
			int limit = 1000;
			if (questionItem instanceof AddQuestionItem) {
				limit = questionItem.getResult().intValue();
			}
			questionItem.setOp2(new IntegerOperand(r.nextInt(limit)));
		}
		questionItem.complete();
	}

	private IntegerOperand findFactor(Integer result) {
		ArrayList<Integer> s = new ArrayList<>(); 
		for (int i=2;i<=result-1;i++) {
			if (result/i==0) s.add(i);
		}
		if (s.size()>0) {
			int pos = r.nextInt(s.size()-1);
			return new IntegerOperand(s.get(pos));
		}else {
			return null;
		}
	}
}
