package question;

import java.util.Scanner;

public class WKQ1 {

	public static void main(String[] args) {
		/* 2020.12.17 �ϱ��� ���� */
		/* ��Ǯ�� ���� 

if ���� switch ���� ����Ͽ� ���� ����ÿ�
1~ 12 ������ �Է¹޾� 
3~5�� �Է¹޾����� ��
6~8�� �Է¹޾����� ����
9~11�� �Է¹޾����� ���� 
12~2�� �Է¹޾����� �ܿ��� ����Ͻÿ�

�� ���� 
�ﰢ���� ���� ���̸� ��Ÿ���� ���� 3���� �Է¹޾� �� 3���� ���� �ﰢ���� ����� �ִ��� �Ǻ��϶�. �ﰢ���� �Ƿ��� �κ��� ���� �ٸ� �Ѻ��� �պ��� Ŀ�� �Ѵ�. */

		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ϳ� �Է�(1~12) : ");
		int no = sc.nextInt();
		
	    if(no <= 12 && no >= 1) {
	    	
	    	if(no >= 3 && no <= 5) {
	    		System.out.println("��");
	    	} else if(no >= 6 && no <= 8) {
	    		System.out.println("����");
	    	} else if(no >= 9 && no <= 11) {
	    		System.out.println("����");
	    	} else {
	    		System.out.println("�ܿ�");
	    	}
	    } else {
	    	System.out.println("�߸� �Է�");
	    }
	    	
	    System.out.print("���� �ϳ� �Է�(1~12) : ");
	    int no2 = sc.nextInt();
	    
	    switch(no2) {
	     case 3 : case 4 : case 5 :
	    	 System.out.println("��"); break;
	     case 6 : case 7 : case 8 :
	    	 System.out.println("����"); break;
	     case 9 : case 10 : case 11 :
	    	 System.out.println("����"); break;
	     case 12 : case 1 : case 2 :
	    	 System.out.println("�ܿ�"); break;
	     default : System.out.println("�߸�");
	    }
	    
	    System.out.print("�ﰢ�� ��1 : ");
	    int a = sc.nextInt();
	    System.out.print("�ﰢ�� ��2 : ");
	    int b = sc.nextInt();
	    System.out.print("�ﰢ�� ��3 : ");
	    int c = sc.nextInt();
	    sc.nextLine();
	   
	    if(a + b > c && b + c > a && c + a > b) {
	    	System.out.println("�ﰢ�� ����");
	    } else {
	    	System.out.println("�Ұ���");
	    }

	}

}
