package question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MSQ2 {

	public static void main(String[] args) {

		/* 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력해주세요.
		ex) 거스름돈 : 2860원 / 500원 : 5개 / 100원 : 3개 / 50원 : 1개 / 10원 : 1개 */

		int change = 2860;

		int oman = 0;
		int man = 0;
		int ocheon = 0;
		int cheon = 0;
		int obaek = 0;
		int baek = 0;
		int osip = 0;
		int sip = 0;

		oman = change / 50000;
		man = change % 50000 / 10000;
		ocheon = change % 50000 % 10000 / 5000;
		cheon = change % 50000 % 10000 % 5000 / 1000;
		obaek = change % 50000 % 10000 % 5000 % 1000 / 500;
		baek = change % 50000 % 10000 % 5000 % 1000 % 500 / 100;
		osip = change % 50000 % 10000 % 5000 % 1000 % 500 % 100 / 50;
		sip = change % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 / 10;

		System.out.println(change + "의 거스름돈 : \n오만원권 : " + oman 
				+ "\n만원권 : " + man
				+ "\n오천원권 : " + ocheon
				+ "\n천원권 : " + cheon
				+ "\n오백원 : " + obaek
				+ "\n백원 : " + baek
				+ "\n오십원 : " + osip
				+ "\n십원 : " + sip);


		/* 1~5 사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요.
			ex) [1, 3, 3, 2, 1, 1, 4, 5, 5, 1, 3] ->[1, 3, 2, 4, 5] */
		System.out.println();
		
		Random random = new Random();

		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			int no = random.nextInt(5) + 1;
			arr[i] = no;
		}
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		Set<Integer> setArr = new HashSet<Integer>();
		for(int i : arr) {
			setArr.add(i);
		}
		List<Integer> listArr = new ArrayList<Integer>(setArr);
		Collections.sort(listArr);
		
		System.out.print("중복 제거 배열(정렬) : ");
		for(int i : listArr) {
			System.out.print(i + " ");
		}
		
//	    for(int i : setArr) {
//	    	System.out.println(i + " ");
//	    }
		
		
		/*
		HashMap hmap = new HashMap();
		for(int i = 0; i < arr.length; i++) {
			hmap.put(arr[i], arr[i]);
		}
		for(int i = 0; i < hmap.size(); i++) {
			System.out.println(hmap.values());
		}
		Set<Integer> keySet = hmap.keySet();
		keySet.toArray();

		for(int i : keySet) {
			System.out.print(i + " ");
		}*/
		/*for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();

		int length = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i-1] == arr[i]) {
				continue;
			} else {
				arr[length++] = arr[i]; 
			}
		}

		for(int i : arr) {
			System.out.print(i + " ");
		}*/

	}

}
