package question;

import java.util.Calendar;
import java.util.StringTokenizer;

public class MKQ3 {

	public static void main(String[] args) {

		/* 1. 문제 푼 날짜를 Calendar를 통해 구한다. getInstance(), get() 사용 */
		/* 2. String 문자열 a를 "10/20"로 초기화한다. 
		 * 3. StringTokenizer로 10과 20을 분리하고 String 배열에 담는다.(while, hasMoreTokens(), nextToken() 사용)*/
		/* 4. StringBuilder 타입에 각 변수를 담는다.
		 * 5. 두 문자열을 합치고 String 타입으로 다시 형변환한다.
		 * 6. 그걸 다시 int형으로 형변환하여 result라는 변수명에 담는다. 그 후 날짜와 결과를 출력한다.  */
		
		/* 1 */
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		
		/* 2 */
		String a = "10/20";
		
		/* 3 */
		StringTokenizer st = new StringTokenizer(a, "/");
		String[] arr = new String[2];
		
		while(st.hasMoreTokens()) {
			for(int i = 0; i < arr.length; i++) {
				arr[i] = st.nextToken();
			}
		}
		
		/* 4 */
		StringBuilder sb = new StringBuilder();
		StringBuilder A = new StringBuilder(arr[0]);
		StringBuilder B = new StringBuilder(arr[1]);
		
		/* 5 */
		sb.append(A).append(B);
		String stt = String.valueOf(sb);
		
		/* 6 */
		int result = Integer.parseInt(stt);
		
		System.out.println(year + "년 " + month + "월 " + day + "일 " + hour + "시 " + min + "분");
		System.out.println("결과 : " + result);
		
		/* 결과
		 * 
		 * 2020년 11월 25일 10시 6분
		      결과 : 1020
		 * */
	}

}
