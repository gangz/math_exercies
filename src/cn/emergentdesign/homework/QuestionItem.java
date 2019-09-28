package cn.emergentdesign.homework;

public abstract class QuestionItem implements Operand{
	private Operand result;
	private Operand op1;
	private Operand op2;
	abstract char getOp();
	public Operand getResult() {
		return result;
	}
	public void setResult(Operand result) {
		this.result = result;
	}
	public Operand getOp1() {
		return op1;
	}
	public void setOp1(Operand op1) {
		this.op1 = op1;
	}
	public Operand getOp2() {
		return op2;
	}
	public void setOp2(Operand op2) {
		this.op2 = op2;
	}
	protected abstract void complete();
	

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("(").append(getOp1()).append(getOp()).append(getOp2()).append(")");
		return sb.toString();
	}
	
	@Override
	public int intValue() {
		return result.intValue();
	}

	@Override
	public int value() {
		return result.value();
	}
}
