package cn.emergentdesign.homework;

public class IntegerOperand implements Operand {
	Integer value;
	public IntegerOperand(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return value.toString();
	}
	@Override
	public int intValue() {
		return value;
	}
	@Override
	public int value() {
		return value;
	}
}
