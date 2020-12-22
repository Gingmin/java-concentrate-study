package day;

public class six {

	public static void main(String[] args) {

		/* 12.21 
		
		<<다형성>>
		
		다형성이란 하나의 인스턴스가 여러 가지 타입을 가질 수 있다는 것
		상속 때 타입도 물려받음
		한 타입으로 여러 타입의 인스턴스 처리 가능
		하나의 메소드 호출로 객체별 다른 방법으로 동작 가능
		
		장점
		여러 타입의 객체를 하나로 관리 - 유지보수성과 생산성
		상속을 기반으로 함 - 상속관계는 동일한 메세지를 수신 가능(객체별로 메세지 처리를 다르게 할 수 있다. - 오버라이딩)
		확장성이 좋다
		결합도를 낮춰 유지보수성 증가
		
		FireCar는 FireCar이면서 Car
		RacingCar는 RacingCar이면서 Car
		
		동적바인딩
		컴파일 당시에는 해당 타입의 메소드와 연결되어 있다가
		런타임 당시 실체 객체가 가진 오버라이딩 된 메소드로 바인딩이 바뀌어 동작하는 것
		
		클래스 타입 형변환
		객체가 가진 고유 동작을 동작시키려면 형을 맞춰야(형변환)한다.
		타입이 일치하지 않을 경우 - ClassCastException 발생
		
        명시적 형변환 Animal animal1 = (Animal) new Rabbit(); 
		          Rabbit rabbit1 = (Rabbit) animal();
		묵시적 형변환 Animal animal2 = new Rabbit();
		
		레퍼런스 변수가 참조하는 실제 인스턴스가 원하는 타입과 맞는지 비교하는 연산자 instanceof
		a1 instanceof Tiger
		
		다형성 이용
		객체배열
		매개변수
		public void feed(Animal animal) {animal.eat()};
		리턴타입
		public Animal getRandomAnimal() {}
		
		<<추상클래스>>
		
		추상메소드
		메소드의 선언부만 있고 구현부는 없는 메소드(반드시 abstract 작성해야함)
		public abstract void method();
		
		추상메소드 0개 이상 포함하는 클래스
		클래스 선언부 abstract 키워드 명시
		인스턴스 생성x
		인스턴스 생성 위해서는 추상클래스 상속받은 하위 클래스를 이용하여 인스턴스 생성
		Product product = new SmartPhone();
		(추상클래스)              (Product 클래스를 상속받은 클래스)
		
		추상클래스는 상위타입으로 사용 가능(다형성)
		
		추상클래스의 추상메소드는 반드시 오버라이딩 해야함 - 동적바인딩으로 다양한 응답 가능
		후손 클래스의 공통 인터페이스 역할 수행
		
		추상클래스를 왜 쓰나?
		추상메소드의 오버라이딩을 강제화하려고
		필수 기능을 정의하여 강제성 부여 - 개발시 일관된 메소드 제공
		단일 상속만 가능해서 인터페이스를 사용
		
		추상클래스가 가질 수 있는 것
		필드, 생성자, 인스턴스생성x, 일반적 메소드, 추상메소드,
		추상메소드가 0개인 경우에는 선택적으로 클래스에 abstract 키워드 작성 가능 
		그러나 1개 이상이면 abstract 반드시 작성
		
		<<인터페이스>>
		
		인터페이스가 가질 수 있는 것
		추상메소드, 상수 필드(static, public, fianl 의 조합)
		
		인터페이스가 가질 수 없는 것
		생성자, 구현부가 있는 non-static 메소드, 
		
		사용 목적
		기능을 공통화 - 강제성 부여(표준화)
		단일 상속 단점 극복 (다중상속)
		
		* 이 인터페이스 말고 public method도 인터페이스(객체들이 상호작용 하기 위한 통로의 의미)
		
		인스턴스 생성x
		레퍼런스 타입 사용 가능
		묵시적으로 public abstract가 생략
		다른 접근 제한자 사용x - 반드시 public
		void absMethod();
		
		InterProduct interProduct = new Product();
		(인터페이스)
		
		클래스 클래스 상속 - extends 단일
		클래스 인터페이스 상속 implements 다중
		인터페이스 인터페이스 상속 extends 다중
		인터페이스가 클래스 상속x
		extends로 클래스 상속시 인터페이스도 상속 가능
		순서는 extends implements가 되어야함
		public class Product extends Object implements InterProduct
		
		JDK 1.8 추가된 기능
		static 메소드 사용 가능
		public static void staticMethod() {}
		static 메소드 오버라이딩x
		
		default 키워드 사용 시 non-static 메소드 작성 가능
		public default void defaultMethod() {}
		default 키워드는 인터페이스에서만 사용 가능
		
		<<api - object>>
		모든 클래스는 Object 클래스의 후손
		자신의 것처럼 사용, 오버라이딩 사용
		
		많이 사용하는 것 toString(), equals(), hashCode()
		
		이거 이상하게 이해가 어렵다.. 그래서 동일 객체를 비교하는 방법을 찾아헤맸다.
		동일 객체를 비교하는 방법 '==', 'equals()', 'hashCode()'
		
		1. '=='
		피연산자가 primitive type(int, double, boolean.class..) 일 때는 값이 같은지 비교하고 
		그 외 객체, reference type 일 때 가리키는 주소를 검사하게 된다.
		
		String str1 = "hello";
		String str2 = "hello";
		System.out.println(str1 == str2); //true
		String str3 = new String("hello");
		String str4 = new String("hello");
		String str5 = str4;
		System.out.println(str3 == str4); //false
		System.out.println(str4 == str5); //true
		
		str1 과 str2는 heap의 hello를 같이 가리키므로 true
		str3과 str4는 각각의 객체이므로 주소가 다르다. false
		str4와 str5는 얕은복사이므로 true
		==은 두 객체가 같은 것을 가리킬 때만 true
		
		equals()
		내용이 같은지 검사
		명확하게는 
		1번 default로 primitive type은 내용이 같은지 검사
		2번 reference type은 객체의 주소가 같은지 검사
		'=='와 차이점 : 완전히 같은 객체를 가리키지 않아도 true로 만들 수 있다.
		
		String str1 = "hello";
		String str2 = "hello";
		System.out.println(str1.equals(str2)); //true
		String str3 = new String("hello");
		String str4 = new String("hello");
		System.out.println(str3.equals(str4)); //true
		
		str1과 str2는 같은 주소, 같은 값 true
		str3과 str4는 주소는 달라도 내용이 같다. true
		하지만 String 클래스는 특별하다. 자바에서 String 클래스의 equals()를 오버라이딩 해놓았다.
		즉 String이 아닌 개발자가 만든 클래스 객체는 내용이 같은지 확인이 어렵다.
		
		다른 클래스로도 알아보자.

		public class Person {
		    private String name;
		    private int age;
		    
		    public String getName() {
		        return name;
		    }
		    public void setName(String name) {
		        this.name = name;
		    }
		    public int getAge() {
		        return age;
		    }
		    public void setAge(int age) {
		        this.age = age;
		    }
		    public Person(String name, int age) {
		        super();
		        this.name = name;
		        this.age = age;
		    }
		    @Override
		    public String toString() {
		        return "Person [name=" + name + ", age=" + age + "]";
		    }
		

		임의로 Person이라는 클래스를 만들어보았다.
		여기서는 일반적으로 사용하는 getter/setter, 생성자, toString() 메서드만 추가했다.

		Person person1 = new Person("jeong-pro", 27);
		Person person2 = new Person("jeong-pro", 27);
		System.out.println(person1 == person2);//false
		System.out.println(person1.equals(person2));//false


		결과는 둘다 false가 나온다.
		'==' 연산자를 복습해보면 당연히 두 객체가 각각 다른 주소에 생성되었기 때문에 person1과 person2는 '==' 연산에 대해 false를 리턴한다.
		그런데 내용이 같으면 true를 준다던 equals()메서드가 false를 리턴했다.
		문제는 자바에서 내용이 같은지를 모른다는 것이다.
		왜냐하면 개발자의 의도에 따라 name만 같으면 두 객체를 같게 볼 수도 있고 name, age 둘 다 같아야 같다고 볼지 모르기 때문이다.
		따라서 equals() 메서드를 오버라이드(재정의)해서 두 객체의 내용이 같은지를 정의해줘야 올바르게(의도한대로) 작동한다.
		* equals() 메서드를 재정의하지 않고 아래와 같이 쓸 수도 있다.
		
		System.out.println(person1.getName().equals(person2.getName()) 
				|| person1.getAge() == person2.getAge());
		
		어떻게 보면 위와 같은 방법이 코드를 따라갈 때에는 더 명확하게 무엇을 비교하는지 알 수 
		있어서 좋을 수도 있을 것이다. (이게 포인트가 아니므로 일단 넘어간다)
		 age와 name 모두 같아야 같은 것으로 확인하는 equals()메서드를 만들었다. (IDE가 만들어 주었다.)

		@Override
		public boolean equals(Object obj) {
		    if (this == obj)
		        return true;
		    if (obj == null)
		        return false;
		    if (getClass() != obj.getClass())
		        return false;
		    Person other = (Person) obj;
		    if (age != other.age)
		        return false;
		    if (name == null) {
		        if (other.name != null)
		            return false;
		    } else if (!name.equals(other.name))
		        return false;
		    return true;
		}
		
		equals 메서드를 오버라이드했더니 이제는 person1.equals(person2) 가 true를 리턴한다.
		* 참고로 eclipse(IDE)에서는 equals() 메서드를 generate 시켜주는 기능을 가지고 있는데 
		자연스럽게 hashCode()도 함께 generate 시켜준다. 즉, equals()와 hashCode()를 같이 재정의하게 한다는 것이다.
		hashCode()를 정리하기 전 미리 말하면,
		equals()만 재정의해서는 안되고 반드시 equals()와 hashCode()를 함께 재정의해야만 부작용이 없다.
		예를 들면 아래와 같은 부작용이 있을 수 있다.
		equals만 재정의해서 어떤 두 객체가 같다고 했는데 hash를 사용하는 Collection(HashSet, HashMap, ...)
		에 넣을 때는 같다고 생각하지 않아서 문제가 생길 수 있다. 아래에서 확인해보자.

		Set<Person> hset = new HashSet<>();
		Person person1 = new Person("jdk", 27);
		Person person2 = new Person("jdk", 27);
		System.out.println("person1 : "+person1.hashCode());//2018699554
		System.out.println("person2 : "+person2.hashCode());//1311053135
		System.out.println(person1.equals(person2));//true
		hset.add(person1);
		hset.add(person2);
		System.out.println(hset.size());//2

		person1과 person2의 해시코드가 다른 것을 위에서 확인할 수 있고 그 때문에 중복을 자동으로 없애주는 
		Set에 넣었음에도 불구하고 set의 사이즈는 2가 나와버린 것이다.
		이런 문제를 모르고 코딩하다가는 나중에 꼬여버린 탓에 곤란을 겪을 수 있다. 따라서 equals와 hashcode는 반드시 함께 재정의해야 한다.
		즉, equals로 같은 객체라면 반드시 hashCode도 같은 값이여야만 한다.
		하지만 반대로 hashCode가 같은 값이더라도 equals로 같은 객체가 아닐 수 있다는 것을 유의해야 한다.
		또한 아주 중요한 점이 같은 파라미터를 이용해야 한다는 것이다.
		(* 실제 equals의 파라미터는 반드시 Object 타입이어야 한다. 내부적으로 비교하는 파라미터를 같게 하라는 의미.
		파라미터 타입을 Object에서 다른 타입으로 바꿀 경우는 오버로딩으로 인식하여 기존의 equals 메서드가 남아있게 된다.)
		예를들어 equals를 판단하는 파라미터에는 name만 이용했는데 hashcode에서는 age를 이용한다든지 name과 
		age를 같이 사용해버린다든지 하면 부작용이 많이 일어날 수 있다.
		결론적으로 반드시 같은 파라미터를 이용하면 될 것이다.

		hashCode

		@Override
		public int hashCode() {
		    final int prime = 31;
		    int result = 1;
		    result = prime * result + age;
		    result = prime * result + ((name == null) ? 0 : name.hashCode());
		    return result;
		}

		hashCode()는 메모리에서 가진 hash주소 값을 기본적으로 반환해준다.
		기본적으로 hash는 다른 객체여도 같을 '수'가 있기 때문에 비교에 적합하지 않으나 hash함수를 쓰는
		collection같은 객체가 있으므로 함께 사용하는 것으로 이해하도록 한다.

		출처: https://jeong-pro.tistory.com/172 [기본기를 쌓는 정아마추어 코딩블로그]
			https://nesoy.github.io/articles/2018-06/Java-equals-hashcode  */
	}

}
