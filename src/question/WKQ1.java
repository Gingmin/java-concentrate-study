package question;

import java.util.Scanner;

public class WKQ1 {

	public static void main(String[] args) {
		/* 2020.12.17 완규형 문제 */
		/* 몸풀기 문제 

if 문과 switch 문을 사용하여 각각 만드시오
1~ 12 정수를 입력받아 
3~5를 입력받았을땐 봄
6~8를 입력받았을땐 여름
9~11를 입력받았을떈 가을 
12~2를 입력받았을땐 겨울을 출력하시오

찐 문제 
삼각형의 변의 길이를 나타내는 정수 3개를 입력받아 이 3개의 수로 삼각형을 만들수 있는지 판별하라. 삼각형이 되려면 두변의 합이 다른 한변의 합보다 커야 한다. */

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력(1~12) : ");
		int no = sc.nextInt();
		
	    if(no <= 12 && no >= 1) {
	    	
	    	if(no >= 3 && no <= 5) {
	    		System.out.println("봄");
	    	} else if(no >= 6 && no <= 8) {
	    		System.out.println("여름");
	    	} else if(no >= 9 && no <= 11) {
	    		System.out.println("가을");
	    	} else {
	    		System.out.println("겨울");
	    	}
	    } else {
	    	System.out.println("잘못 입력");
	    }
	    	
	    System.out.print("정수 하나 입력(1~12) : ");
	    int no2 = sc.nextInt();
	    
	    switch(no2) {
	     case 3 : case 4 : case 5 :
	    	 System.out.println("봄"); break;
	     case 6 : case 7 : case 8 :
	    	 System.out.println("여름"); break;
	     case 9 : case 10 : case 11 :
	    	 System.out.println("가을"); break;
	     case 12 : case 1 : case 2 :
	    	 System.out.println("겨울"); break;
	     default : System.out.println("잘못");
	    }
	    
	    System.out.print("삼각형 변1 : ");
	    int a = sc.nextInt();
	    System.out.print("삼각형 변2 : ");
	    int b = sc.nextInt();
	    System.out.print("삼각형 변3 : ");
	    int c = sc.nextInt();
	    sc.nextLine();
	   
	    if(a + b > c && b + c > a && c + a > b) {
	    	System.out.println("삼각형 가능");
	    } else {
	    	System.out.println("불가능");
	    }

	}

}
