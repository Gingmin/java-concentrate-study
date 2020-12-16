package question;

public class Calculator {

	public void checkMethod() {
		System.out.println("호출 확인");
	}
	
	public int sum1to10() {
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		return sum;
	}
	
	public void checkMathNumber(int a, int b) {
		int result = (a > b) ? a: b;
		System.out.println("두 수 중 큰 수는 : " + result);
	}
	
	public int sumTwoNumber(int a, int b) {
		return a + b;
	}
	
	public int minusTwoNumber(int a, int b) {
		return a - b;
	}
}
