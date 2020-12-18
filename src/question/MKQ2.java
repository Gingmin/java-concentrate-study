package question;

import java.util.Arrays;

public class MKQ2 {

	public static void main(String[] args) {

		/* 정변배열과 가변배열 배열의 복사 */
		/* 2행 2열의 arr1 정변배열과 1행 2열/ 2행 3열의 arr2 가변배열을 만들고
		 * 인덱스는 1부터 대입.
		 * arr1Copy에는 정변배열을 얕은복사하고
		 * arr2Copy에는 가변배열을 깊은복사하고
		 * 각각(배열 4개)의 해쉬코드를 출력하여 주소값을 확인하고
		 * 향상된 for문을 사용하여 복사가 잘 되었는지 확인하여라
		 * */
		
		int[][] arr1 = new int[2][2];
		arr1[0][0] = 1;
		arr1[0][1] = 2;
		arr1[1][0] = 3;
		arr1[1][1] = 4;

		int[][] arr2 = new int[2][];
		arr2[0] = new int[2];
		arr2[1] = new int[3];
		arr2[0][0] = 1;
		arr2[0][1] = 2;
		arr2[1][0] = 3;
		arr2[1][1] = 4;
		arr2[1][2] = 5;

		int[][] arr1Copy = arr1;
		
		int[][] arr2Copy = arr2.clone();
		
		System.out.println("arr1의 hashCode : " + arr1.hashCode());
		System.out.println("arr1Copy의 hashCode : " + arr1Copy.hashCode());
		for(int i[] : arr1) {
			for(int j : i) {
				System.out.print(j + " ");
			}
		}
		System.out.println();
		for(int i[] : arr1Copy) {
			for(int j : i) {
				System.out.print(j + " ");
			}
		}
		System.out.println();
		System.out.println();

		System.out.println("arr2의 hashCode : " + arr2.hashCode());
		System.out.println("arr2Copy의 hashCode : " + arr2Copy.hashCode());
		for(int i[] : arr2) {
			for(int j : i) {
				System.out.print(j + " ");
			}
		}
		System.out.println();
		for(int i[] : arr2Copy) {
			for(int j : i) {
				System.out.print(j + " ");
			}
		}
	}

}
