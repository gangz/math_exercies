package cn.emergentdesign.homework;

public class MulQuestionItem extends QuestionItem {

	@Override
	char getOp() {
		return 'x';
	}

	@Override
	protected void complete() {
		if (this.getResult()!=null && this.getOp2()!=null && this.getOp1()==null) {
			this.setOp1(new IntegerOperand(this.getResult().value()/this.getOp2().value()));
		}
		else if (this.getOp1()!=null & this.getOp2()!=null && this.getResult()==null) {
			this.setResult(new IntegerOperand(this.getOp1().value()*this.getOp2().value()));
		}else if (this.getOp1()!=null & this.getOp2()==null && this.getResult()!=null) {
			this.setOp2(new IntegerOperand(this.getResult().value()/this.getOp1().value()));
		}			
	}
}
