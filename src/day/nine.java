package day;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class nine {

	public static void main(String[] args) {

		/*12.24*/

		/*
		# 1. 예외처리

		- if문으로 모든 예외를 처리할 수 있을 것 같지만 그렇지 않다. 예외처리를 사용하게 되면 더욱 편하게 프로그래밍 할 수 있다.

		---

		## 1-1 오류와 예외

		> 예외와 오류를 잘 구분하자

		- 오류 : 코드를 컴파일하려고 할 때 컴파일 에러를 발생시킨다. 엄빌히 말하면 문법상 오류 (Syntax Error)
		시스템 상에서 프로그램에 심각한 문제를 발생하여 실행중인 프로그램이 종료되는 것을 말한다.
		이러한 오류는 개발자가 미리 예측하여 처리하는 것이 불가능하며, 오류에 대한 처리는 할 수 없다.
		- 예외 : 자바 문법에 맞게 작성하여 컴파일에 문제가 없더라도, 실행되면서 예상치 못하게 에러
		오류와 마찬가지로 실행중인 프로그램을 비정상적으로 종료시키지만 발생할 수 있는 상황을 미리 예측하고 처리할 수 있는 미약한 오류들을 말한다. 개발자는 이러한 예외에 대해 예외처리를 통해 예외 상황을 적절히 처리하여 코드의 흐름을 컨트롤 할 수 있다.
		- 예외는 즉 컴파일 과정에서 문제가 없으나 런타임 시 오류 사항들

		---

		## 1-2 예외 처리 방법

		> 그럼 어떻게 예외를 처리할까?

		- 어떤 에러가 발생할지 알고 있다면 Exception 클래스를 직접 명시, 아니면 Exception으로 한번에 처리

		---

		### 1-2-1 try ~ catch

		```java
		try {
		     예외가 생길 가능성이 있는 코드 작성
		} catch(예외발생 클래스명 e){
		     예외처리 코드
		}
		```

		```java
		public static void main(String[] args){ 

		  int num1, num2; 
		  num1 = 12;
		  num2 = 0; 
		  try { 
		     System.out.println(num1/num2); 
		  } catch (Exception e) { 
		     System.out.println("0으로는 값을 나눌 수가 없습니다."); } 
		  }
		```

		- 0으로는 값을 나눌 수 없다는 출력문이 나온다.
		- try-catch 문울 사용하지 않는다면 - Exception in thread 'main' java.lang.ArtimeticException 이라고 에러가 발생할 것
		- 어떤 에러인지 알았으니 catch 부분을 다음과 같이 쓸 수 있다.
		- catch (ArtimeticException e) {}
		- 이런 식으로 어떤 에러인지 안다면 에러에 대해 예외처리가 각각 처리가 가능하다.

		```java
		public static void main(String[] args) {
		       int num1, num2;
		       int [] intArrayList = {0, 1, 2};
		       
		       num1 = 12;
		       num2 = 0;
		       
		       try {
		            //System.out.println(num1/num2);
		            System.out.println(intArrayList[3]);
		       } catch (ArithmeticException e) {
		            System.out.println("0으로는 값을 나눌 수가 없습니다.");
		       } catch (ArrayIndexOutOfBoundsException e) {
		       	    System.out.println("배열의 범위를 넘어섰습니다.");
		       }
		  }
		```

		- finally - 예외 발생 여부와 상관없이 실행할 내용

		---

		### 1-2-2 throws

		- 자신을 호출하는 메소드에 예외처리의 책임을 넘긴다.
		- 호출하는 곳에서 예외 처리를 해야 한다.

		```java
		public static void nanum(int a, int b) throws ArithmeticException { 
		    System.out.println(a/b); 
		} 
		public static void main(String[] args) { 
		    int num1, num2; 
		    num1 = 10; num2 = 0; 

		    try { 
		       nanum(num1,num2); 
		    } catch (ArithmeticException e){ 
		        System.out.println("0으로 나눌 수는 없어요..");  
		     } 
		}

		```

		- nanum이라는 메소드 뒤에 thorws, ArithmeticException 예외가 발생하면 이 메소드를 사용하는곳에서 예외처리를 넘겨주라는 뜻
		- main부분에서 nanum메소드를 호출할때 try-catch문을 이용하여 예외처리
		- 0으로 나눌 수 없다는 출력문이 나오며 정상적 예외처리
		- 만약 모든 메소드에서 throws를 이용해 예외를 떠넘기다 보면 최초 호출 지점인 main() 메소드 내부로 예외가 던져진다. main()마저 예외를 떠넘기면 jvm의 예외처리기까지 도달하고 프로그램이 종료된다.
		- 이렇게 되면 예외 처리를 하지 않은 것이나 다름없다. 의도적인 경우가 아니면 throws는 많은 생각과 필요에 의해 사용해야 한다.

		> 그런데 굳이 왜 try-catch를 진작에 써도 되는데 throws를 이용하여 두번 일하게 만드나?

		- 1) 한가지 예외상황에 대해 각각 불러오는 곳에서 다른 방법으로 예외처리를 하고싶을때 사용
		- 2) 메소드 선언부에 선언된 throws문을 통해 해당 API를 사용했을 때 어떤 예외가 발생할 수 있는지를 예측 가능
		- java.api 공식 문서 선언부에 IOException이 던져진다.

		```java
		public int read() throws IOException
		```

		- 3) 현재 메서드 내에서 예외를 처리할 필요가 없다고 판단했을 경우
		- 예외 처리에는 많은 코드가 필요하다. 이는 코드를 읽기 어렵게 만들고 불필요한 코드를 많이 추가하게 된다. 이것은 버그로 이어지기 쉽다. 또 API를 만드는데 있어 내가 처리하기 보다 내가 만든 API를 사용하는 다른 개발자에게 원하는 처리를 하도록 기회를 줄 수 있다.

		    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/22926983-ae49-4054-8d55-5933d35117dd/throws.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/22926983-ae49-4054-8d55-5933d35117dd/throws.png)

		- 내가 method를 만들었는데 이게 NullpointerException이 발생할 수 있다는 것을 인지했다면 나중을 대비해야 한다.
		- try-catch 문을 사용하여 원하는대로 처리할 수 있지만 내가 만든 코드를 사용하는 다른팀원들이 해당 예외가 발생했을때의 처리를 각각 원하는대로 구현하도록 기회를 줌과 동시에 메서드 선언부를 통해 NullPointerException가 발생할 수 있다는 것을 알려주는 것입니다.
		- 팀의 정책이나 api 설계 규칙, 플랫폼 환경에 따라(웹 서버 환경이라든지) throws를 사용하는 이유는 많다. 가장 중요한 점은 단순히 예외 처리하기 귀찮아서 사용하는 것은 *절대금지*

		---

		### 1-2-3 throw

		- s 차이 하나지만 쓰임새는 매우 다르다.
		- 개발자가 직접 사용자정의 예외를 발생시키고싶을 때.
		- 사용자가 직접 예외를 발생하고 싶은 곳에 사용

		```java
		public static void throwExample() throws Exception {
				throw new Exception();
			}
			public static void main(String[] args) {
				try {
					throwExample();
				} catch (Exception e){
					System.out.println("예외가 발생했습니다...");
				}
			}
		```

		- 이 코드에서 try-catch문을 빼고 throwExample() 메소드를 호출하면 에러가 발생
		- 그렇기 때문에 이런식으로 사용자가 직접 예외를 발생시켜주고싶은 부분에 throw new Excepiton();을 통하여 예외를 발생시켜주고 throws를 통하여 예외처리를 던져준다. 그러면 main에서 throwExample 메소드를 호출할때 예외처리를 해주어야한다.
		- throw 예약어 뒤에는 java.lang.Throwable 클래스를 상속받은 자식 클래스의 객체를 지정해야 한다.
		- throw는 메소드내에서 상위블럭으로 예외를 던지는 것
		- throws는 현재 메소드에서 상위 메소드로 예외를 던진다.
		- throw는 강제로 에러 발생도 가능하지만 에러 처리 후 상위 메소드에 정보를 줌으로써 상위 메소드에서도 에러가 발생한 것을 감지할 수 있다.

		> 참고, 출처: [https://dololak.tistory.com/87](https://dololak.tistory.com/87) [코끼리를 냉장고에 넣는 방법]
		[https://sundrystore.tistory.com/14](https://sundrystore.tistory.com/14) [잡다창고]
		[https://vitalholic.tistory.com/246](https://vitalholic.tistory.com/246)[개발자의 하루]

		---

		## 1-3 사용자 정의 예외처리

		- 사용자 정의 예외처리 하려면 exception 클래스 상속
		- exception 클래스는 throwable 클래스를 상속받아 구현
		- throwable 은 error, exception 두 가지 추상화
		- exception이 최상위 클래스

		---

		### 1-3-1 방법

		- Exception을 상속받는 예외 객체를 직접 만들고 특정 상황에서 예외를 강제로 발생시키게 만든다. 조건문으로 예외를 처리할 수 있지만 명시적인 예외 객체를 만듬으로써 코드의 가시성을 높인다.

		```java
		class UserException extends Exception { 
		   public UserException(String mesg) { 
		       super(mesg); 
		  } 
		} 

		public class Ex09_8 { 
		  public static void check(int num) throws UserException { 
		    if (num < 100) { 
		        throw new UserException("num 값이 100보다 작다"); 
		     } 
		} 

		public static void main(String[] args) { 
		   System.out.println("프로그램 시작"); 
		      try {
		         check(70); 
		     } catch (UserException e) { 
		          System.out.println("예외발생: " + e.getMessage()); 
		     } System.out.println("프로그램 정상 종료"); 
		} }
		-------------------------------
		프로그램 시작
		예외발생: num 값이 100보다 작다
		프로그램 정상 종료

		출처: https://xianeml.tistory.com/36 [미현 개발 TIL]
		```

		- 예외는 throw new로 생성하여 던지고 최근 메소드를 실행한 곳으로 던져진다.
		- 메인에서 try-catch로 받아 예외처리 가능
		- exception을 상속받았으므로 컴파일시 try-catch작성을 강제화

		---

		## 1-4 multi-catch (JDK 1.7 부터)

		- 하나의 try 블록에서 여러 개의 예외가 발생하면 많은 catch가 발생(중복 코드)
		- 예) e.printStackTrace()

		e.printStackTrace() : 예외 클래스명, 예외 발생 위치, 예외 메세지 등을 stack 호출의 역순으로
		빨간색 글씨를 이용하여 로그 형태로 출력 기능

		- 동일한 레벨의 다른 타입의 예외를 하나의 catch 블럭으로 다룰 수 있다

		```java
		catch(PriceNegativeException | MoneyNegativeException e) {
					e.getMessage()로 발생한 예외 클래스의 정보를 알 수 있다. 
					System.out.println(e.getClass() + " 발생!");
					 e.getMessage()로 예외 발생 시 전달한 메세지를 문자열로 반환받을 수 있다. 
					System.out.println(e.getMessage());
		```

		- Multi Catch문에 사용된 예외들의 공통된 조상의 멤버만 사용할 수 있다.
		하나의 참조변수로 예외를 처리한다는 사실, 이 경우 예외 발생시 e라는 참조변수가 가리키는 객체의 어느 예외 클래스의 인스턴스인지 알 수 없다.
		- 그래서 조상의 멤버만 사용 가능하고 형변환 후 사용해야 한다.
		- e.getMessage() 로 예외 발생 시 전달한 메세지를 문자열로 반환 받을 수 있다

		---

		## 1-5 try-with-resource

		- JDK 1.7에서 추가된 문법
		- close 해야 하는 인스턴스의 경우 try 옆에 괄호 안에서 인스턴스를 생성하게 되면 해당 try-catch블럭이 완료될 때 자동으로 close 처리 해준다.

		```java
		try(BufferedReader in = new BufferedReader(new FileReader("test.dat"));)
		```

		- AutoCloseable을 구현한 객체만 close()가 호출
		- AutoCloseable은 인터페이스
		- try-with-resource 하려면 AutoCloseable을 implements 해야함

		---

		## 1-6 io 패키지에서 예외처리 많이 사용

		- NullPointerException이 발생
		- 파일을 찾지 못해 객체를 생성하지 못하고 레퍼런스 변수는 null값을 가진 상태이기 때문에 null을 참조하는 상태에서 참조연산자를 사용하면 발생하는 예외이다.
		- NullPointerException은 unchecked Exception으로 try-catch로 처리하기 보다는 보통 if-else구문으로 해결 가능하다

		if(in != null)

		- 입출력에서 사용한 스트림을 닫아주는 메소드이다.
		- IOException을 위임한 메소드 이기 때문에 finally 블럭 안이라도 예외처리를 중첩으로 해주어야 한다.
		- try 블럭과 finally 블럭은 별개이다.

		---

		## 1-7 오버라이딩

		- 예외를 던지는 구문 없이 오버라이딩 할 수 있다.

		```java
		@Override
		public void method() {}
		```

		- 같은 예외를 던져주는 구문으로는 오버라이딩 할 수 있다.

		```java
		@Override
		public void method() throws IOException {}
		```

		- 부모의 예외처리 클래스보다 상위 타입으로는 예외를 던질 수 없다.

		```java
		@Override
		public void method() throws Exception {}
		```

		- 부모의 예외처리 클래스보다 하위 타입으로는 예외를 던질 수 있다.

		```java
		@Override
		public void method() throws FileNotFoundException {}
		```

		1. 상위클래스의 메서드에서 throws를 선언했더라도 하위클래스는 throws 처리를 하지 않을 수 있다.
		2. 하위클래스는 상위클래스의 메서드에서 throws 하는 예외와 같은 예외를 throws 할 수 있다.
		3. 하위클래스는 상위클래스의 메서드에서 throws 하는 예외의 하위 예외만 throws 할 수 있다.
		4. 하위클래스는 Runtime 예외(Unchecked) 예외를 상위클래스의 메서드와 관계없이 throws 할 수 있다.

		```java
		class Parent {
		    public void methodA() throws IOException, SQLException {
		    }
		}
		```

		- Parent 클래스가 있다. methodA()는 IOException, SQLException 두 가지의 예외를 throws한다.
		- 1번 규칙에 의하면 Parent 클래스의 methodA()를 오버라이딩 하는 Child의 methodA()는 throws를 선언하지 않아도 된다. 상위 클래스나 인터페이스는 그것을 구현하는 하위 클래스에 대해 제약을 거는것이기에 상위 클래스에서 선언한 예외의 범위를 넘어서지만 않으면 되기 때문

		```java
		class Child extends Parent {
		    public void methodA() {
		    }
		}
		```

		- 또는 아래와 같이 IOException은 throws하고 SQLException은 선택적으로 선언하지 않을 수 있다.

		```java
		class Child extends Parent {
		    public void methodA() throws IOException {
		    }
		}
		```

		- 2번 규칙에 의하면 Parent에서 throws한 IOException, SQLException를 똑같이 Child에서도 throws 할 수 있다.

		```java
		class Child extends Parent {
		    public void methodA() throws IOException, SQLException { 
		    }
		}
		```

		- 단! 1번과 2번규칙을 종합했을때 하위 클래스에서는 상위 클래스보다 상위 예외를 throws할 수 없다. 다음 코드를 보면 Child에서 Parent의 methodA()의 IOException보다 상위 예외인 Exception을 throws 했는데, 이런 처리는 불가능

		```java
		class Child extends Parent {
		    public void methodA() throws Exception { 
		//IOException, SQLException 보다 상위예외이므로 X 
		    }
		}
		```

		- 3번 규칙에 의해서 Child의 methodA()에서는 IOException, SQLException의 하위 예외들을 throws 할 수 있다. ZipException과 XmlStreamReaderException 이 두개의 예외는 IOException를 상속받은 하위 예외이므로 선언이 가능하고 SQLException은 Parent에서 선언되어 있기때문에 마찬가지로 Child에서도 선언할 수 있다.

		```java
		class Child extends Parent {
		    public void methodA() throws ZipException, XmlStreamReaderException, SQLException {
		    }
		}
		```

		- 마지막으로 4번 규칙에 따라 RuntimeException과 그 하위 예외들은 상위 클래스와 관계 없이 하위 클래스에서 throws 할 수 있다. 이 부분이 *특이*, 아마도 RuntimeException은 메서드를 사용하는 쪽에서 예외 핸들링이 필수가 아니므로(Unchecked Exception) 제약을 걸어두지 않은것으로 예상

		```java
		class Child extends Parent {
		    public void methodA() throws RuntimeException {
		    }
		}
		```

		- 특히나 최신의 프레임워크나 라이브러리들은 API에 RuntimeException을 사용하는 추세이기에 throws로 예외를 떠넘길 필요가 없다. 그래도 이러한 예외 처리 개념들이 Java에 있다 라는 정도는 알아두는게 좋지 않을까

		> 출처: [https://dololak.tistory.com/609](https://dololak.tistory.com/609) [코끼리를 냉장고에 넣는 방법] */
		}

	}
