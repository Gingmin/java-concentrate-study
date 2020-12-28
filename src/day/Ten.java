package day;

public class Ten {

	public static void main(String[] args) {

		/*

		# 1. File

		- JDK 1.0부터 지원하는 API
		- 대상 파일에 대한 정보로 인스턴스를 생성하고 파일의 생성, 삭제 등의 처리를 수행하는 기능을 제공
		- 대상 파일이 존재하지 않아도 인스턴스를 생성할 수 있다

		File file = new File("경로");

		## 1-1 createNewFile();

		- 빈 파일을 만들어 낼 때 사용
		- boolean값을 반환한다. 같은 이름을 가진 파일이 없으면 파일 생성후 true
		이미 같은 파일이 존재하면 false 반환

		> 이유는 실수로 기존 파일을 지워버리는 일을 막기 위해서

		- *파일을 새로 생성하는데 파일이름을 체크하지 않으면 중요한 데이터를 덮어버릴 수 있다!*
		- try-catch 사용해야 함

		```java
		File file = new File("src/com/greedy/section01/file/test.txt");

				try {
					boolean createSuccess = file.createNewFile();
					
					System.out.println("createSuccess : " + createSuccess);
				} catch (IOException e) {
					e.printStackTrace();
				}
		```

		---

		## 1-2 메소드

		- length() - 파일 크기 반환
		- getPath() - 파일의 경로
		- getParent - 파일의 상위 경로
		- getAbsolutePath() - 파일의 절대 경로
		- delete() - 파일 삭제 (boolean 반환)

		> [https://blog.naver.com/jjekjjek7/222032563526](https://blog.naver.com/jjekjjek7/222032563526) 더 많은 메소드 참고

		---

		# 2. stream

		우리는 프로그래밍을 할 때 많은 종류의 데이터를 다루어야 한다. 하지만 데이터는 프로그램 내부에 있을 수도 있지만, 프로그램 외부의 데이터를 가져와서 사용해야 할 수도 있다. 하지만 데이터는 프로그램 내부에 있을 수 도 있지만, 프로그램 외부의 데이터를 가져와서 사용해야 할 수도 있다.

		- 외부 데이터란 프로그램 외부에 존재하는 모든 데이터를 의미
		- 외부 데이터는 하드디스크상의 파일이 될 수도 있고, 네트워크 상에 존재하는 자원이 될 수 도 있다.
		- 외부 데이터를 대상으로 작업할 때 가장 먼저 해야 할 일은 자바 프로그램과 외부 데이터를 연결하는 것

		> 프로그램과 외부 데이터가 연결된 길을 스트림(stream)이라고 한다.

		- 입력 스트림 : 데이터를 읽어오기 위한 길
		- 출력 스트림 : 데이터를 출력하기 위한 길
		- 스트림은 단방향
		- [java.io](http://java.io/) 패키지에서 제공
		- 입력스트림 : InputStream, Reader
		- 출력스트림 : OutputStream, Writer
		- InputStream과 OutputStream는 데이터를 1바이트 단위로 입/출력
		- Reader와 Writer 계열은 글자(2바이트 혹은 3바이트) 단위
		- 자바 프로그램과 연결되는 외부 데이터의 타입이 무엇인지는 클래스의 이름을 보고 유추가 가능
		- InputStream/OutputStream/Reader/Writer를 빼고 남은 단어가 바로 외부 데이터 타입

		예) FileInputStream은 InputStream을 제거하고 남은 단어가 File이므로 외부 데이터가 File임을 알 수 있다

		- read() : 파일에 기록된 다음 바이트를 순차적으로 읽어온다. 더이상 읽을 데이터가 없는 경우 -1을 반환

		```java
		int fileSize = (int) new File("src/com/greedy/section02/stream/testInputStream.txt").length();
					byte[] bar = new byte[fileSize];
					
					fin.read(bar);
					
					for(int i = 0; i < bar.length; i++) {
						System.out.println((char) bar[i]);
					}
		```

		> 왜 read()에 배열을 집어넣었는데 인덱스가 들어있는거지?

		- InputStream 클래스 메소드들 : (System 클래스의 in 멤버필드는 대표적인 InputStream 타입)
		- int read() : 바이트 값을 읽어온다. 만약, 파일의 끝인 경우에는 -1을 리턴
		int read(byte[]) : 읽은 내용을 바이트 배열에 채우고, 읽은 바이트의 수를 리턴
		int read(byte[], int, int) : 바이트 배열에서 시작 위치와 끝 위치를 지정한 뒤에 내용을 읽어오고, 
		                                      읽은 바이트의 수를 리턴
		- read()메소드가 byte를 리턴한다면 끝을 나타내는 값을 표현할 수가 없기 때문에, byte가 아닌 int를 리턴한다.
		- 음수의 경우 맨 좌측 비트가 1이 된다. 읽어들일 것이 있다면 항상 양수를 리턴한다고볼 수 있다. 
		파일에 값이 없으면 -1을 반환해줘야 하는데, byte로는 불가

		---

		## 2-2 자원 반납을 해야 하는 이유

		- 장기간 실행중인 프로그램에서 스트림을 닫지 않는 경우 다양한 리소스에서 누수(leak)가 발생한다.

		> 누수가 뭔데?

		- 프로그램의 오류나 프로그램의 안좋은 동작방식에 의해 자원들을 할당받기만 하고 반납해주지 않는다면 다른 프로그램은 자원을 사용하지 못하게 될 것
		- 또한 점점 더 많은 자원을 요구하여 결국 모든 자원을 독점하고 사용하게 된다면 운영체제의 자원 고갈로 인해 치명적인 문제가 발생할 수 있다.
		- 이 중 가장 많은 문제가 발생하는 것이 입출력 자원이다. 프로그램은 수많은 대상과의 입출력을 수행하게 된다. 보조 기억 장치와의 입출력 네트워크상의 다른 컴퓨터와의 입출력, 서버 프로그램인 경우에는 다수의 클라이언트와의 입출력을 수행한다. 입출력을 수행하기 위해서는 스트림이라 불리우는 데이터를 주고 받는 통로를 열어주어야 하는데 이러한 통로가 입출력 자원이다. 이러한 입출력들은 자원을 많이 소모 하므로 입출력이 완료되면 꼭 해당 자원을 돌려주어야 한다.
		- 입출력 도중 예외가 발생하게 됐을 때 특별한 처리를 해주지 않는다면 입출력을 수행하던 스트림이 open 되어진 상태로 남겨지게 된다. 한 두번의 예외라면 괜찮겠지만 동시에 수많은 입출력 처리를 하는 프로그램이라면 예외가 발생할 때마다 close 되지 않은 스트림이 쌓이게 되고 언젠가는 자원부족 특히 메모리 부족으로 인해 프로그램이 멈춰버릴 것

		이렇게 메모리가 점점 고갈되는 것을 메모리가 새어 나온다 하여 메모리 누수(Memory Leak) 현상이라 한다.

		> 출처: [https://dololak.tistory.com/67](https://dololak.tistory.com/67) [코끼리를 냉장고에 넣는 방법]

		- 버퍼를 이용하는 경우 마지막에 flush()로 버퍼에 있는 데이터를 강제로 전송해야 한다.
		- 만약 잔류 데이터가 남은 상황에서 추가로 스트림을 사용한다면 데드락(deadlock)상태가 된다.
		- 판단하기 어렵고 의도하지 않는 상황에서도 이런 현상이 발생할 수 있기 때문에 마지막에는 flush()를 무조건 실행해주는 것이 좋다. close() 메소드는 자원을 반납하며 flush() 해주기 때문에 close()만 제대로 해 주더라도 이러한 현상이 발생할 가능성을 낮춰준다. 따라서 close() 메소드는 외부 자원을 사용하는 경우 마지막에 반드시 호출해주어야 한다.

		---

		## 2-3 FileReader

		- FileInputStream과 사용하는 방법이 거의 동일
		- 단, byte단위가 아닌 character 단위로 읽어들이는 부분이 차이점
		- 따라서 1바이트, 2바이트, 3바이트 여부와 상관 없이 글자 단위로 읽어들이기 때문에 한글을 정상적으로 읽을 수 있다.

		```java
		FileReader fr = null;
				
				try {
					fr = new FileReader("src/com/greedy/section02/stream/testReader.txt");
					
//					int value;
//					while((value = fr.read()) != -1) {
//						System.out.println(value);
//					}
					
					char[] carr = new char[(int) new File("src/com/greedy/section02/stream/testReader.txt").length()];
					
					fr.read(carr);
					
					for(int i = 0; i < carr.length; i++) {
						System.out.print(carr[i]);
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(fr != null) {
						try {
							fr.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
		```

		---

		## 2-4 FileOutputStream

		- 프로그램 데이터를 파일로 내보내기 위한 용도의 스트림이다.
		- 1바이트 단위로 데이터를 처리한다.

		```java
		FileOutputStream fout = null;
				
				try {
					 OutputStream의 경우 대상 파일이 존재하지 않으면 파일을 자동으로 생성해준다. 
					fout  = new FileOutputStream("src/com/greedy/section02/stream/testOutputStream.txt");
					
					fout.write(97);
					
					byte[] bar = new byte[] {98, 99, 100, 101, 102, 10};
					fout.write(bar);
					
					 1번 인덱스부터 3의 길이 만큼 파일에 내보내기 
					fout.write(bar, 1, 3);
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(fout != null) {
						try {
							fout.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
		```

		---

		## 2-5 FileWriter

		- 프로그램의 데이터를 파일로 내보내기 위한 용도의 스트림
		- 1글자 단위로 데이터를 처리한다.

		```java
		try {
					 두 번째 인자로 true를 전달하면 이어쓰기가 된다.
					 false는 이어쓰기가 아닌 덮어쓰기이며, 기본값은 false이다. 
					fw = new FileWriter("src/com/greedy/section02/stream/testWriter.txt", true);
					
					fw.write(97);
					
					 문자 기반 스트림은 char 자료형으로 내보내기도 가능하다. 
					fw.write('A');
					
					혹은 char 배열도 가능하다 
					fw.write(new char[] {'a', 'p', 'p', 'l', 'e'});
					
					 문자열도 가능하다 
					fw.write("우리나라\n 대한민국");
					
//					fw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(fw != null) {
						try {
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
		```

		transient 키워드는 해당 필드를 직렬화에서 제외시키는 키워드이다.

		```java
		private transient double point;
		```

		---

		# 3. 필터스트림(보조)

		- [java.io](http://java.io/) 패키지의 입출력 스트림 클래스들은 기본 스트림과 필터 스트림으로 분류할 수 있다.
		- 기본 스트림은 외부 데이터에 직접 연결되는 스트림이고
		- 필터스트림은 외부 데이터에 직접 연결하는 것이 아니라 기본스트림에 추가로 사용할 수 있는 스트림이다.
		- 주로 성능 향상을 목적

		> 생성자쪽에 매개변수로 다른 스트림을 이용하는 클래스는 필터스트림

		```java
		BufferedReader br = null;
				
				try {
					br = new BufferedReader(new FileReader("src/com/greedy/section03/filterstream/testBufferd.txt"));
				
					String temp;
					while((temp = br.readLine()) != null) {
						System.out.println(temp);
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(br != null) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
		```

		---

		## 3-1 형변환 보조스트림

		- 기본스트림이 byte 기반 스트림이고, 보조스트림이 char 기반 스트림인 경우 사용

		---

		## 3-1-1 표준스트림

		- 자바에서는 콘솔이나 키보드 같은 표준 입력 장치로부터 데이터를 입출력하기 위한 스트림을 표준스트림 형태로 제공하고 있다. System 클래스의 in, out, err가 대상 데이터의 스트림을 의미한다.
		- [System.in](http://system.in/) (InputStream) : 콘솔로부터 데이터를 입력받는다.
		- System.out(PrintStream) : 콘솔로 데이터를 출력한다.
		- System.err(PrintStream) : 콘솔로 데이터를 출력한다.
		- 즉 자주 사용하는 자원에 대해 미리 스트림을 생성해 두었기 때문에 개발자가 별도로 스트림을 생성하지 않아도 된다
		- 이런 표준 스트림 중 콘솔로부터 읽어오는 기반 스트림이 InputStream인데 Buffer를 이용해서 성능을 향상시키고 싶은 경우에 형변환 보조스트림을 사용할 수 있다.

		---

		## 3-2 DataOutputStream

		- 외부 데이터로부터 읽어오는 데이터를 바이트형 정수, 문자, 문자열로만 읽어오면 여러 데이터 타입을 취급하는 경우 별도로 처리를 해주어야 한다.
		- 데이터 자료형별로 처리하는 기능을 추가한 보조스트림을 제공하고 있다.

		```java
		DataOutputStream dout = null;
				
				try {
					dout = new DataOutputStream(new FileOutputStream("src/com/greedy/section03/filterstream/score.txt"));
					
					dout.writeUTF("홍길동");
					dout.writeInt(95);
					dout.writeChar('A');
					dout.writeUTF("이순신");
					dout.writeInt(87);
					dout.writeChar('B');
					dout.writeUTF("김철수");
					dout.writeInt(73);
					dout.writeChar('C');
				
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(dout != null) {
						try {
							dout.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
		```

		---

		## 3-3 ObjectInputStream/ObjectOutputStream

		- 객체 단위로 입출력

		```java
		MemberVO[] outputMembers = {
					new MemberVO("user01", "pass01", "홍길동", "hong777@greedy.com", 25, '남', 2506.5),
					new MemberVO("user02", "pass02", "유관순", "korea3131@greedy.com", 16, '여', 1221.6),
					new MemberVO("user03", "pass03", "이순신", "leesoonsin@greedy.com", 40, '남', 1234.6)
				};
				
				ObjectOutputStream objOut = null;
				
				try {
					objOut = new ObjectOutputStream(new FileOutputStream("src/com/greedy/section03/filterstream/testObjectStream.txt"));
					
					for(int i = 0; i < outputMembers.length; i++) {
						objOut.writeObject(outputMembers[i]);
					}
				
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(objOut != null) {
						try {
							objOut.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
		```

		- 직렬화란?
		- 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부에서도 사용할 수 있도록 바이트(byte) 형태로 데이터를 변환하는 기술
		- 더 많은 보조스트림

		[Java | I/O 보조 스트림](https://pathas.tistory.com/150) */
		
		
		
		
	}

}
