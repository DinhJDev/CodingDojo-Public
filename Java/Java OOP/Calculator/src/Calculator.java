
public class Calculator {
	double operandOne;
	double operandTwo;
	String operation;
	double result;
	String plusSign = "+";
	String minusSign = "-";
	
	
	public void performOperation() {
		if (operation == plusSign) {
			result = operandOne + operandTwo;
		} else if (operation == minusSign) {
			result = operandOne - operandTwo;
		}
	}
	
	public double getResults() {
		return result;
	}
	
	public void setOperandOne(double n) {
		operandOne = n;
	}
	
	public void setOperation(String s) {
		operation = s;
		
	}
	
	public void setOperandTwo(double n) {
		operandTwo = n;
	}
}
