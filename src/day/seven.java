package day;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class seven {

	public static void main(String[] args) {

		/* 12-22
		<<String>>
		
		compareTo() 사전 순 비교 같으면 0, 작으면 음수, 크면 양수(앞에서 뒤에를 빼라)
		str2.compareTo(str3)
		
		compartToIgnore()
		
		concat() 문자열 합치기
		str2.concat(str5)
		
		indexOf() 문자열 특정 문자 탐색 - 인덱스 값 반환, 없으면 -1
		
		lastIndexOf() 뒤에서 탐색
		
		trim() 앞 뒤 공백 제거 (원본 영향x)
		
		toLowerCase() 소문자로 변환
		toUpperCase() 대문자로 변환
		원본 영향x
		
		subString() 문자열의 일부를 잘라 새로운 문자열 만듦 (원본 영향x)
		
		replace() 문자열에서 기존문자열을 대체할 문자로 변경 후 반환
		
		length() 길이 반환
		
		isEmpty() 길이가 0이면 true, 아니면 false(0인 거는 null과는 다르다)
		
		
		split() StringTokenizer
		구분자로 문자열 분리
		
		split() 
		정규표현식(문자열패턴) 
		split("[*#/ ]")
		비정형화된 문자열 분리는 좋지만 정규표현식을 이용하여 속도가 느리다.
		
		StringTokenizer
		구분자 문자열
		모든 문자를 구분자로 하여 문자열 분리
		정형화된 문자열 패턴 분리에 좋다
		split() 보다 빠르다
		구분자를 생략하는 경우 공백이 기본 구분자
		
		String emp1 "100/홍길동/서울/영업부";
		String[] empArr1 = emp1.split("/");
		
		마지막 구분자 사이에 값이 존재하지 않는 경우 이후 값도 추출하고 싶을 때
		몇 개의 토큰을 분리할지 한계설정 가능(인자로 / 음수로 넣으면 값이 없을 때 빈 문자열 생성)
		split("/", -1);
		
		Stringtokenizer 이용
		hasMoreTokens(); 다음 문자가 있는지 확인 T/F
		nextToken(); String 타입 반환(꺼내고 나면 재사용 불가)
		비어있는 값 무시
		*/
//		StringTokenizer colorStringTokenizer = new StringTokenizer(colorStr, "*/# "); 
		/*
		탈출문자
		\n 개행
		\t 탭
		\' 작은따옴표
		\" 큰따옴표"
	    \\ 역슬래쉬
	    
	    탈출 문자 사용 안하는
	    ~ ` ! @ # % - _ = ; : ' \ " , < > /
	       탈출 문자 사용 하는 특수문자
	       $ ^ * ( ) + | { } [ ] . ?
		
	    <<StringBuilder>>
			문자열 객체를 만드는 방법
			리터럴 형태 - ""
			새로운 인스턴스 - new String("")
			문자열 불변 : 문자열에 + 연산 - 문자열은 불변이기에 수정이 아닌 새로운 문자열 할당
			따라서 문자열 변경이 자주 되면 성능에서 좋지 않다.
			
			StringBuilder
			가변
			append()로 합치면 기존 인스턴스 수정
			잦은 문자열 변경이 일어나는 경우 사용
			
			
		+ 연산으로 문자열을 합치면, 각 글자에 해당하는 String 객체를 생성하고 각 객체의 필드에 있는 char[]배열을
		합쳐 새로운 String객체를 반환하는 방식이었다고 한다.
		그 과정에서 많은 객체 생성 - 많은 메모리 - GC 더 많은 일
		그래서 StringBuilder 를 사용했다.
		
		JDK 1.5버전부터 문자열 + 연산이 StringBuilder의 append로 컴파일된다.
		성능엔 큰 차이 x
		하지만 반목문에서 문자열 + 연산을 하면 StringBuilder 인스턴스를 반복 루프시 생성 - 성능좋지x
		
		for(int i = 0; i < 10, i++) {
			str4 += new StringBuilder(str1).append(str1).toString();
		}
		이렇게 사용할 것
		StringBuilder sb = new StringBuilder(str4)
		for(int i = 0; i < 10; i++) {
			sb.append(str1).toString();
		}
		
		StringBuilder의 자주 사용되는 메소드
		메소드 체이닝 가능
		sb2.append("1").append("2").append("3").append("4");
		
		capacity() 용량 정수형 반환 기본16
		
		append() 인자를 문자열로 변환 후 문자열의 마지막에 추가
		기본 용량을 초과하는 경우 (기존 문자열 + 1) * 2
		
		delete() 시작 인덱스와 종료 인덱스 이용 문자열에서 원하는 문자열 제거
		deleteCharAt() 문자 하나 제거
		원본에 영향을 미침
		
		insert() 인자로 전달된 값을 문자열로 변환 후 지정한 인덱스 위치에 추가
		
		reverse() 역순 재배열 */
	/*	
		Wrapper
		상황에 따라 기본 타입의 데이터를 인스턴스화 해야 하는 경우들이 발생
		이 때 기본 타입의 데이터를 먼저 인스턴스로 변환 후 사용해야 하는데
		8가지에 해당하는 기본 타입의 데이터를 인스턴스화 할 수 있도록 하는 클래스를 래퍼클래스
		
		byte          Byte
		short         Short
		int           Integer
		long          Long
		float         Float
		double        Double
	    char          Character
	    boolean       Boolean
		
	         박싱(Boxing)과 언박싱(Boxing)
		 박싱(Boxing) - 기본 타입을 래퍼클래스의 인스턴스로 인스턴스화 하는 것
		 언박싱(UnBoxing) - 래퍼클래스 타입의 인스턴스를 기본 타입으로 변경하는 것
		 
		 박싱 방법 - Wrapper.valueOf(); (Integer.valueOf()) 
		          toString() : 필드 값을 문자열로 반환하는 메소드 - 까지 써줘야 반환받은 값 출력 가능
		          String i = Integer.valueOf(4).toString();
		 언박싱 방법 - 기본자료형Value();(byteValue(), intValue())
		
		오토 박싱(AutoBoxing)과 오토 언박싱(AutoUnBoxing)은
		JDK 1.5부터 박싱과 언박싱이 필요한 상황에서 자바 컴파일러가 이를 자동으로 처리해준다.
		이런 자동화된 박싱과 언박싱을 오토박싱, 오토 언박싱이라고 부른다.
		 
		Integer boxingNumber1 = new Integer(intValue);			//인스턴스화 - 박싱(Boxing)
		Integer boxingNumber2 = Integer.valueOf(intValue);		//static 메소드 이용
		
		int unBoxingNumber1 = boxingNumber1.intValue();			//언박싱(UnBoxing)
		
		기본 타입과 래퍼클래스 타입은 == 연산으로 비교가 가능하다.
		System.out.println("int와 Integer 비교 : " + (inum == integerNum1));
		
		생성자를 이용해 생성한 인스턴스의 경우 ==로 비교하지 못한다.
		단, 오토박싱을 이용해서 생성한 값은 ==로 비교 가능하다.
		
		Integer integerNum1 = new Integer(20);
		Integer integerNum2 = new Integer(20);
		Integer integerNum3 = 20;
		Integer integerNum4 = 20;
		System.out.println("Integer와 Integer 비교 : " + (integerNum1 == integerNum2)); //false
		System.out.println("Integer와 Integer 비교 : " + (integerNum1 == integerNum3)); //false
		System.out.println("Integer와 Integer 비교 : " + (integerNum3 == integerNum4)); //true
		
		
		래퍼클래스 타입의 인스턴스를 비교할 때는 equals()를 사용해야 한다.
		System.out.println("equals() : " + (integerNum1.equals(integerNum2)));
		}
	
	    parsing  - 문자열값을 기본 자료형 값으로 변경하는 것
	    int i = Integer.parseInt("4");
	    
	    Character는 parsing기능을 제공하지 않는다.
		char ch = "abc".charAt(0);
	    
	    
	    <<Calendar>>
	    Date 클래스
	    JDK 1.0 부터 날짜를 취급하기 위해 사용되던 Date클래스(Deprecated)
	    Date date = new Date()
	    기본생성자로 인스턴스를 생성하게 되면 운영체제 상의 날짜/시간 정보를 이용해서 인스턴스 생성
	    
	    사용방법
	    getTime() 1970년 1월 1일 자정 이후 지난 시간을 millisecond로 계산해서 long타입으로 반환
	    date.getTime();
	    
	    Calendar
	    Calendar는 abstract클래스라 인스턴스 생성x
	    
	    두 가지 방법
	    1. getInstance static메소드
	    2. GregorianCalendar 클래스 이용 인스턴스 생성
	    
	    1. getInstance
	    Calendar calendar = Calendar.getInstance();
	    
	    2. GregorianCalendar
	    Calendar gregorianCalendar = new GregorianCalendar();
	    
	    년, 월, 일, 시, 분, 초 정보를 이용해서 인스턴스를 생성 
		2014년 9월 18일 16시 42분 00초
		int year = 2014;
		int month = 8;		//월은 0 ~ 11월로 사용하기 때문에 8은 9월을 의미한다.
		int dayOfMonth = 18;
		int hour = 16;
		int min = 42;
		int second = 0;
		
		Calendar birthDay = new GregorianCalendar(year, month, dayOfMonth, hour, min, second); */
	/*	
		상황에 따라 특정 일자를 기준으로 한 Date 타입의 인스턴스가 필요한 경우도 있다.
		먼저 GregorianCalendar를 이용해서 특정 날짜/시간 정보로 인스턴스를 생성한 후
		1970년 1월 1일 자정을 기준으로 지난 시간을 millisecond로 계산해서 long형으로 반환하는 메소드가 있다.
		Date date = new Date(birthDay.getTimeInMillis());
		
		Date date2 = 
				new Date(
						new GregorianCalendar(year, month, dayOfMonth, hour, min, second).getTimeInMillis());
		
		생성한 인스턴스의 필드 정보를 Calendar 클래스의 get() 메소드로 반환받을 수 있다.
		int birthYear = birthDay.get(Calendar.YEAR);
		int birthMonth = birthDay.get(Calendar.MONTH);
		int birthDayOfMonth = birthDay.get(Calendar.DAY_OF_MONTH);
		
		
		이런 식으로 사용
	    Calendar cal = Calendar.getInstance();
	       
        int year = cal.get(Calendar.YEAR);
        int mon = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
       
        System.out.println("현재시간");
        System.out.println(year + "년 "+ mon+"월 "+day+"일");
        System.out.println(hour + "시 "+ min+"분 "+sec+"초"); 

        Calendar.set() - 날짜 설정하기
        
            Calendar calendar = Calendar.getInstance();    // 현재 시간을 받음.
            
        calendar.set(Calendar.YEAR , 2000);
        calendar.set(Calendar.MONTH , Calendar.JUNE);
        calendar.set(Calendar.DAY_OF_MONTH , 28);
            
        calendar.set(Calendar.HOUR_OF_DAY , 14);
        calendar.set(Calendar.MINUTE , 25);
        calendar.set(Calendar.SECOND , 19);
                 
            System.out.println("Year : " + cal.get(Calendar.YEAR));
            System.out.println("Month : " + (cal.get(Calendar.MONTH)+1) ); //괄호 안쪽에 연산을 해줌
            System.out.println("Day of Month : " + cal.get(Calendar.DAY_OF_MONTH));        
            System.out.println("Sun(1) ~ Sat(7) : " + cal.get(Calendar.DAY_OF_WEEK));            
            System.out.println("Hour(0 ~ 23): " + cal.get(Calendar.HOUR_OF_DAY));
            System.out.println("Minute(0 ~ 59): " + cal.get(Calendar.MINUTE));
            System.out.println("Second(0 ~ 59): " + cal.get(Calendar.SECOND));
            
            System.out.println( cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH)+1)
                               + "월 " + cal.get(Calendar.DAY_OF_MONTH) + "일");
            
            System.out.println( cal.get(Calendar.HOUR_OF_DAY) + "시 " + cal.get(Calendar.MINUTE)
                               + "분 " + cal.get(Calendar.SECOND) + "초");
                     
        }
         
        ------------------------------------------------------------
        result
         
        Year : 2000
        Month : 6
        Day of Month : 28
        Sun(1) ~ Sat(7) : 3
        Hour(0 ~ 23): 14
        Minute(0 ~ 59): 25
        Second(0 ~ 59): 19
        1994년 6월 28일
        14시 25분 19초

        
        Calendar.set( 설정할 곳 , 설정할 값)
              한번에도 가능
       Calendar.set( YEAR 값 , MONTH 값 , DAY 값 , HOUR_OF_DAT 값 , MINUTE 값 , SECOND 값)

       
       
       Calendar.add() - 날짜 더하기
        
           Calendar cal = Calendar.getInstance();    
           cal.set(1994 , Calendar.JUNE , 28 , 14 , 25 , 19);  // 1994년 6월 28일 14시 25분 19초
           
           System.out.println("Before add");
           System.out.println( cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH)+1)
                              + "월 " + cal.get(Calendar.DAY_OF_MONTH) + "일");
           System.out.println( cal.get(Calendar.HOUR_OF_DAY) + "시 " + cal.get(Calendar.MINUTE)
                              + "분 " + cal.get(Calendar.SECOND) + "초");
           
           
           cal.add(Calendar.YEAR , 22);        // 2016년 6월 28일
           cal.add(Calendar.MONTH , -3);       // 2016년 3월 28일
           cal.add(Calendar.DAY_OF_MONTH , 5); // 2016년 4월 2일
           
           cal.add(Calendar.MINUTE , 40);      // 2016년 4월 2일 15시 5분 19초
           
           System.out.println("After add");
           
           System.out.println( cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH)+1)
                              + "월 " + cal.get(Calendar.DAY_OF_MONTH) + "일");
           System.out.println( cal.get(Calendar.HOUR_OF_DAY) + "시 " + cal.get(Calendar.MINUTE)
                              + "분 " + cal.get(Calendar.SECOND) + "초");
                    
       }
       ------------------------------------------------------------
       result
        
       Before add
       1994년 6월 28일
       14시 25분 19초
       After add
       2016년 4월 2일
       15시 5분 19초

        Calendar.add( 더할 곳 , 더할 값)

            1 . cal.add(Calendar.MONTH , -3); 빼기 가능

          2. cal.add(Calendar.DAY_OF_MONTH , 5); 
            2016년 3월 28일에 5일을 더하면 2016년 4월 2일로 MONTH값도 같이 바뀌는
                        부분 - roll 함수와 차이점 */

/*
       Calendar.roll() - 그 부분만 날짜 더하기

           Calendar cal = Calendar.getInstance();    
           cal.set(1994 , Calendar.JUNE , 28 , 14 , 25 , 19);  // myCal 설정 시간
           
           System.out.println("Before add");
           
           System.out.println( cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH)+1)
                              + "월 " + cal.get(Calendar.DAY_OF_MONTH) + "일");
           System.out.println( cal.get(Calendar.HOUR_OF_DAY) + "시 " + cal.get(Calendar.MINUTE)
                              + "분 " + cal.get(Calendar.SECOND) + "초");
           
           cal.add(Calendar.YEAR , 22);        // 2016년 6월 28일
           cal.add(Calendar.MONTH , -3);       // 2016년 3월 28일
           cal.roll(Calendar.DAY_OF_MONTH , 5); // 2016년 3월 2일
           cal.roll(Calendar.MINUTE , 40);      // 2016년 3월 2일 14시 5분 19초
           System.out.println("After add");
           System.out.println( cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH)+1)
                              + "월 " + cal.get(Calendar.DAY_OF_MONTH) + "일");
           System.out.println( cal.get(Calendar.HOUR_OF_DAY) + "시 " + cal.get(Calendar.MINUTE)
                              + "분 " + cal.get(Calendar.SECOND) + "초");
                    
       }
       ------------------------------------------------------------
       result
        
       Before add
       1994년 6월 28일
       14시 25분 19초
       After add
       2016년 3월 2일
       14시 5분 19초

        Calendar.roll( 더할 곳 , 더할 값)

        1. cal.add(Calendar.DAY_OF_MONTH , 5); // 2016년 4월 2일 

                             ------->  cal.roll(Calendar.DAY_OF_MONTH , 5); // 2016년 3월 2일

        2. cal.add(Calendar.MINUTE , 40);      // 15시 5분 19초

                             ------->  cal.roll(Calendar.MINUTE , 40);      // 14시 5분 19초

         roll() add() 함수와 다른점 - 올림 (분이 올리가면 시간이 바뀌는 것)X 
         3월 28일에 5일을 더하면 add() 함수는 4월 2일 / roll() 함수는 3월 2일
        
        [출처] [예제로 보는 함수 - java]Calendar.set() - 날짜 설정하기, Calendar.add() - 날짜 더하기, Calendar.roll() - 그 부분만 날짜 더하기|작성자 광레기 */
        
	}

}
