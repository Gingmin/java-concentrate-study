package question;

public class Application {

	public static void main(String[] args) {
		
		Calculator ca = new Calculator();
		ca.checkMethod();
		System.out.println("1부터 10까지의 합 : " + ca.sum1to10());
		ca.checkMathNumber(10, 20);
		System.out.println("10과 20의 합 : " + ca.sumTwoNumber(10, 20));
		System.out.println("10과 5의 차 : " + ca.minusTwoNumber(10, 5));
	}

}
