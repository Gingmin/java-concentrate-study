package day;

public class Three {

	
	/* 12.18 <<사용자 정의 타입 클래스>> */
	/* 리턴은 1개의 값만 가능하기 때문에 회원정보를 묶어서 리턴값으로 사용할 수 있다.
	 * 클래스를 이용하면 해결?
	 * 
	 * 객체를 생성하면 다른 필드의 변수에 접근 가능하다. 
	 * 
	 * 예)
	 * Member member = new Member();
	 * Member 클래스를 객체로 생성하고
	 * member.id . 참조연산자를 통해 필드에 접근 가능하다.
	 * 하지만  . 참조 연산자를 통한 직접 접근은 여러 문제를 일으킬 수 있다.
	 * 
	 * 필드 바로 접근 시 문제점
	 * 1. 필드에 올바르지 않는 값이 들어가도 통제 불가
	 * 
	 * 만약 두 개의 클래스가 있을 때 1번 클래스 필드에 int hp 라는 변수를 선언하였을 때
	 * 2번 클래스에서 1번 클래스를 객체로 만들고 . 참조 연산자를 통해 접근하여 값 대입을 할 수 있다.
	 * 그러나 hp는 0이하가 되면 안되는데 음수값을 대입하여 초기화가 가능하다.
	 * 즉, 두 개의 클래스가 결합도가 높아진다!
	 * 객체지향은 현실세계의 모습을 프로그래밍 언어에 도입한 것으로 두 클래스는 현실 세계의 각각의 주체와 같다.
	 * 현실세계에 사람1 사람2 가 있다고 가정했을 때, 두 사람은 주체성을 갖고 서로 상호작용할 수 있다. 하지만
	 * 두 사람이 합쳐지는 경우는 없다? 슬라임이 아니니까... 
	 * 객체지향의 목적은 독립성? 결합도를 낮춰야 한다. 결합도를 높이는 건 사람이 한 곳에 뭉쳐져 슬라임이 된다고 생각해버리자
	 * 
	 * 2. 필드의 이름이나 자료형을 변경할 때 사용한 쪽 모두 코드를 수정해야 하는 경우가 생긴다.
	 * 즉, 작은 변경이 사용하는 다른 여러 곳의 변경도 함께 초래
	 * 
	 * 두 개의 클래스가 있다. 
	 * 1번 클래스에 String 타입의 name 변수가 선언되어 있다.
	 * 2번 클래스에서 객체를 생성하여 . 참조연산자로 접근하여 "드라큘라"라고 초기화하였다.
	 * 그럼 name은 "드라큘라"가 되었다. 그래서 이처럼  "드라큘라"를 여기 저기 클래스 객첼를 생성하여 사용하다 보니 10개의 클래스에서 
	 * 사용하게 되었다.
	 * 그런데 말입니다. "드라큘라"를 "미이라"로 개명하고 싶다면???
	 * 그럼 사용한 10개의 클래스를 전부 뜯어고쳐야하는 상황이 발생한다.
	 * 사용한 클래스가 10개가 아니라 100개라면? 어떻게 할 텐가???????????????????
	 * 
	 * 접근 제한자
	 * 클래스 혹은 클래스 멤버에 참조연산자로 접근할 수 있는 범위를 제한하기 위한 키워드
	 * 1. public  - 모든 패키지 접근 허용
	 * 2. protected - 동일 패키지에 접근 허용, 단 상속 관계도 접근 가능
	 * 3. default - 동일 패키지 가능
	 * 4. private - 해당 클래스 내부에서만 사용
	 * 이 네 가지는 멤버에 사용가능
	 * 하지만 클래스 선언문에는 public과 default 만 가능
	 * 
	 * public class 클래스명 {} 는 가능하지만
	 * private class 클래스명 {} 은 불가
	 * 
	 * 그렇다면 위와 같은 문제를 해결하기 위해서 접근제한자를 사용하여 직접접근을 제한한다.
	 * private으로 접근을 제한하고 public 메소드를 사용하여 간접적으로 접근하도록 만드는 것을 캡슐화 라고 한다.
	 * 그 public 메소드란 setter/getter 설정자/접근자를 말한다.
	 * 캡슐화를 해줌으로써 수많은 코드를 일일이 고치지 않아도 되니 유지보수성을 증가시킬 수 있다. 즉, 객체 지향의 목적 독립성을
	 * 지키며 코딩을 할 수 있다!!
	 *  */
	
	/* <<생성자>> */
	/* 클래스명 레퍼런스 변수 = new 생성자(); 
	 * 생성자와 클래스명의 이름은 같다. 그러므로 객체를 생성한다는 것은 생성자 메소드를 사용한다고 생각하면 편하다.
	 * 기본 생성자는 컴파일러가 자동으로 추가된다. 매개변수 있는 생성자가 있으면 컴파일러는 기본 생성자를 추가해주지 않기 때문에 
	 * 기본 생성자도 작성해줘야 한다.
	 * 
	 * 사용목적
	 * 1. 생성 시점에 수행할 명령이 있을 때
	 * 2. 매개변수로 필드를 초기화하며 인스턴스를 생성하려고 
	 * 3. 초기값 전달을 강제화 한다. 
	 * 
	 * this()
	 * 동일한 클래스 내에 작성된 다른 생성자 호출
	 * 괄호 안의 타입, 개수, 수 에 맞는 생성자를 호출하고 복귀
	 * 
	 * 복사 생성자
	 * 이미 만들어진 동일한 타입의 인스턴스가 가지는 필드 값을 이용해서 새로운 인스턴스 생성 시 초기값으로 이용 가능
	 * 동일한 값을 가지지만 새롭게 할당되는 인스턴스이기 때문에 서로 다른 주소값을 가지고 있다.
	 * */
}