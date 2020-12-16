package cardgame;

public class Card {

	/* 트럼프 카드덱을 만드는 문제다.
	 * 클래스 두 개를 만든 후
	 * 첫 번째 클래스의 필드에는 static final을 사용하여 SPADE = 1, DIAMOND = 2, HEART = 3, CLOVER = 4
	 * KIND = 4, CARD_NUMBER = 13, ALL_NUMBER = 52, int = num, int = kind를 만들고
	 * 생성자의 매개변수는 int kind, int num을 받는 생성자를 만들고 static이 아닌 필드 두 개를 초기화해준다.
	 * toString을 오버라이딩하여 카드 값을 반환하는 메소드를 작성한다.
	 * 	@Override
	    public String toString() {
		    String[] kind = new String[] {"스페이드", "다이아몬드", "하트", "클로버"};
		    String numbers = "0123456789XJQK";
		사용 
		*/
	/* 다른 클래스(메인메소드)에서는 첫번째 클래스에서 만든 필드값을 이용해 52 크기의 첫번째 클래스 타입의 객체 배열을 생성하고 
	 * 스페이드부터 13개씩 (다이아 13개, 하트 13개, 클로버 13개) 순서대로 값을 대입한다.
	 * 이중 for문을 사용하고 전 클래스의 생성자를 통해 객체를 생성해야함을 유의(모양은 4개, 카드는 13개씩)
	 * 그 후 아무거나 원하는 카드를 뽑는 출력문을 작성하여라.*/ 
	
	public static final int SPADE = 1;
	public static final int DIAMOND = 2;
	public static final int HEART = 3;
	public static final int CLOVER = 4;
	public static final int KIND = 4;
	public static final int CARD_NUMBER = 13;
	public static final int ALL_NUMBER = 52;
	public int num;
	public int kind;
	
	public Card(int kind, int num) {
		this.num = num;
		this.kind = kind;
	}
	
	@Override
	public String toString() {
		String[] kind = new String[] {"스페이드", "다이아몬드", "하트", "클로버"};
		String numbers = "0123456789XJQK";
		
		return "kind : " + kind[this.kind]
				+ ", numbers : " + numbers.charAt(this.num);
	}
}
