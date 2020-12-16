package cardgame;

public class Extract {

	public static void main(String[] args) {

		Card[] deck = new Card[Card.ALL_NUMBER];

		int k = 0;
		for(int i = 0; i < Card.KIND; i++) {
			for(int j = 0; j < Card.CARD_NUMBER; j++) {
				deck[k++] = new Card(i, j);
			}
		}
		System.out.println(deck[40]);
	}
}
