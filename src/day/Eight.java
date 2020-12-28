package day;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;


public class Eight {

	public static void main(String[] args) {
/*
		12.23

		<<컬렉션>>
		컬렉션 프레임워크 - 여러 개의 다양한 데이터를 쉽고 효과적으로 처리할 수 있도록 표준화된
		방법을 제공하는 클래스들의 집합(표준화된 클래스들의 집합)
		즉 데이터를 효율적으로 저장하는 자료구조와 데이터를 처리하는 알고리즘을 미리 구현해놓은 클래스

		list, set, map

		collection 인터페이스 - list, set
		collections 인터페이스 - map

		ArrayList 가장 많이 사용되는 컬렉션(JDK 1.2부터)
		배열과 다르게 크기변경, 요소 추가, 삭제, 정렬 기능 제공
		Object 하위 타입 인스턴스 모두 저장가능(오토박싱 자동 적용)
		중복 저장 가능
		속도상의 이점은x

		ArrayList는 처음 생성하면 10칸짜리 배열 생성
		ArrayList alist = new ArrayList();

		다형성 - 상위 타입으로 ArrayList 생성 가능
		list 인터페이스 하위 구현체로 타입 변경 가능
		타입을 list로 해놓는 것이 더 유연한 코드 작성 가능

		List list = new ArrayList();
		Collection clist = new ArrayList();

		size() - 요소의 개수
		get() - 가져올 때
		add() - 더하기(원하는 인덱스에도 가능)
		remove() - 삭제
		set() - 수정

		Collections - Collection에서 사용되는 기능들을 static 메소드들로 구현한 클래스
		인터페이스 뒤에 s가 붙은 클래스들은 관례상 비슷한 방식으로 작성된 클래스 의미

		Collections.sort(); - list 오름차순 정렬

		내림차순으로도 할 수 있다.
		1. LinkedList에 역순 정렬 기능이 있으므로 변경 후 사용한다.

		stringList = new LinkedList<>(stringList);

		2. Iterator 반복자 인터페이스를 활용해서 역순 정렬
		제네릭 설정하고 Linked 타입으로 형변환 후 decendingIterator() 메소드 사용하면
		내림차순으로 정렬된 Iterator 타입의 목록으로 반환

		Iterator<String> dIter = ((LinkedList<String>) stringList).descendingIterator();

		Itreator가 뭔데
		Collection 인터페이스의 iterator() 메소드를 이용해서 인스턴스를 생성할 수 있다.
		컬렉션에서 값을 읽어오는 방식을 통일된 방식으로 제공하기 위해 사용한다.
		반복자라고 불리우며, 반복문을 이용해서 목록을 하나씩 꺼내서 사용하기 위한 목적으로 사용한다.
		인덱스로 관리되는 컬렉션이 아닌 경우 반복문을 사용해서 요소에 하나씩 접근할 수 없기 때문에
		인덱스를 사용하지 않고도 반복문을 사용하기 위한 목록을 만들어주는 역할이라고 볼 수 있다.

		hasNext() : 다음 요소를 가지고 있는 경우 true, 더 이상 요소가 없는 경우 false를 반환
		next() : 다음 요소를 반환

		while(dIter.hasNext()) {
			System.out.println(dIter.next());
		}

		제네릭 타입 제한에 의해 Comparable 타입을 가지고 있는 경우에만 sort가 가능하다. 
		Collections.sort(bookList);

		가격 순 오름차순 정렬 
		bookList.sort(new AscendingPrice());

		bookList.sort(new Comparator<BookVO>() {

			@Override
			public int compare(BookVO o1, BookVO o2) {

				return o1.getPrice() > o2.getPrice()? 1: -1;
			}

		});
		
		가격 순 내림차순 정렬
		bookList.sort(new Comparator<BookVO>() {

			@Override
			public int compare(BookVO o1, BookVO o2) {
				
				return o1.getPrice() >= o2.getPrice()? -1: 1;
			}
			
		});
		
		LinkedList
		이중 연결 리스트 구현
		
		단일 연결 리스트
	    : 저장한 요소가 순서를 유지하지 않고 저장되지만 이러한 요소들 사이를 링크로 연결하여 구성하며
		     마치 연결된 리스트 형태인 것 처럼 만든 자료구조이다.
		     요소의 저장과 삭제 시 다음 요소를 가리키는 참조 링크만 변경하면 되기 때문에
		     요소의 저장과 삭제가 빈번히 일어나는 경우 ArrayList 보다 성능면에서 우수하다.
		     
		     하지만 단일 연결 리스트는 다음 요소만 링크하기 때문에 이전 요소로 접근하기 어렵다.
		     이를 보완하고자 만든 것이 이중 연결 리스트이다.
		     
		  이중 연결 리스트
		 : 단일 연결리스트는 다음 요소만 링크하는 반면 이중연결리스트는 이전 요소도 링크하여
		     이전 요소로 접근하기 쉽게 고안된 자료구조이다.
		     
		 LinkedList는 이중 연결 리스트를 구현한 것 - List인터페이스를 상속받아서
		 ArrayList와 사용하는 방법은 거의 유사
		 
		 List<String> linkedList = new LinkedList<>();
		
		메소드 size(), get(), remove(), set(), toString(), isEmpty(), clear()
		
		
		Stack
		 Stack은 리스트 계열 클래스의 Vector 클래스를 상속
		 스택 메모리 구조는 선형 메모리 공간에 데이터를 저장하며
		 후입선출(LIFO - Last Input First Out) 방식
		 
		Stack<Integer> integerStack = new Stack<>();
		
	    push() 메소드를 이용
		add()도 이용 가능하지만 Vector의 메소드이기 때문에 push()를 이용하는 것이 좋다.
		search() - 요소 찾기(가장 상단의 위치는 0이 아니고 1)
		peek() - 가장 마지막(맨 위) 요소 반환
		pop() - 가장 마지막(맨 위) 요소 반환 후 제거
		
		
		Queue
		선형 메모리 공간에 데이터를 저장하는 선입선출(FIFO - First Input First Out) 방식
		Queue 인터페이스를 상속받는 하위 인터페이스들은
		Deque, BlockingQueue, BlockingDeque, TransferQueue 등 다양하지만
		대부분 큐는 LinkedList를 이용한다.
		
		Queue 자체로는 인터페이스이기 때문에 인스턴스 생성이 불가능하다.
		LinkedList 로 인스턴스 생성
		Queue<String> que = new LinkedList<>();
			 
		offer() - 값 넣기
		peek() - 가장 앞(먼저 들어온 요소) 반환
		poll() - 가장 앞(먼저 들어온 요소) 반환 후 제거

		
		<<set>>
		Set 인터페이스를 구현한 Set 컬렉션 클래스의 특징
		 1. 요소의 저장 순서를 유지하지 않는다.
		 2. 같은 요소의 중복 저장을 허용하지 않는다. (null값도 중복하지 않게 하나의 null만 저장한다.)
		
		HashSet 클래스
		Set 컬렉션 클래스에서 가장 많이 사용되는 클래스이다.
		JDK 1.2 부터 제공되고 있으며 해시 알고리즘을 사용하여 검색 속도가 빠르다는 장점을 가진다.
		
		HashSet 인스턴스 생성
		HashSet<String> hset = new HashSet<>();
		
		Set<String> hset2 = new HashSet<>();
		
		저장된 객체를 하나씩 꺼내는 기능이 없음 
		1. toArray()로 배열로 바꾸고 for loop 사용
		Object[] arr = hset.toArray();
		for(int i = 0; i < arr.length; i++) {
			System.out.println(i + " : " + arr[i]);
		}
	
		2. iterator()로 목록 만들어 연속 처리 
		Iterator<String> iter = hset.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		지우기 - hset.clear();
		
		
		LinkedHashSet
		 HashSet이 가지고 있는 기능을 모두 가지고 있다.
		 추가적으로 저장 순서를 유지하는 특징을 가지고 있다.
		 JDK 1.4부터 제공하고 있다.
		 
		LinkedHashSet<String> lhset = new LinkedHashSet<>();
		
        Set<Integer> lotto = new LinkedHashSet<>();
		
		while(lotto.size() < 6) {
			lotto.add(new Random().nextInt(45) + 1);
		}
		
		System.out.println("lotto : " + lotto);
		
		
		TreeSet은 오름차순 기능이 기본적으로 포함되어 있다.
		lotto = new TreeSet<>(lotto);
		
		System.out.println("ascending lotto : " + lotto);
		
		TreeSet 클래스 
		TreeSet은 데이터가 정렬된 상태로 저장되는 이진 검색 트리 형태로 요소를 저장한다.
		 이진 검색 트리는 데이터를 추가하거나 제거하는 등의 기본 동작 시간이 매우 빠르다.
		JDK 1.2 부터 제공되고 있으며
		 Set 인터페이스가 가지는 특징을 그대로 가지지만 정렬된 상태를 유지한다는 것이 다른점이다.
		
		TreeSet<String> test = new TreeSet<>();
		
		<<map>>
		Map 인터페이스의 특징
		
		 Collection 인터페이스와는 다른 저장 방식을 가진다.
		 키(key)와 값(value)를 하나의 쌍으로 저장하는 방식을 사용한다.
		 
		 키(key)란?
		 값(value)를 찾기 위한 이름 역할을 하는 객체를 의미한다.
		 
		 1. 요소의 저장 순서를 유지하지 않는다.
		 2. 키는 중복을 허용하지 않지만, 키가 다르면 중복된 값을 저장하는 것은 가능하다.
		 
		 HashMap, HashTable, TreeMap 등 대표적인 클래스가 있다.
		 HashMap이 가장 많이 사용되며 HashTable은 JDK 1.0부터 제공되며
		 HashMap과 동일하게 동작한다. 
		 하위 호환을 위해 남겨놓았기 때문에 가급적이면 HashMap을 사용하는 것이 좋다.
		 
		
		HashMap은 JDK 1.2부터 제공되는 클래스로 해시 알고리즘을 사용하여 검색 속도가 빠르다.
		
		HashMap 인스턴스 생성 
		HashMap hmap = new HashMap();
		
		put()을 이용하여 키와 값을 쌍으로 저장한다. 
		hmap.put("one", new Date());
		
		키는 중복 저장되지 않는다. (set) : 중복된 키로 저장을 하면 최근 키로 값을 override(덮어씀)
		값은 중복 저장이 가능하다
		get, remove, size
		
		1. keySet()을 이용해서 키만 따로 set으로 만들고 iterator()로 키에 대한 목록 만듦 
		Set<String> keySet = hmap2.keySet();
		Iterator<String> keyIter = keySet.iterator();
		
		Iterator<String> keyIter = hmap2.keySet().iterator();
		
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			String value = hmap2.get(key);
			
			System.out.println(key + " = " + value);
		}
		
		2. 저장된 value 객체들만 values()로 Collection 으로 만듦
		Collection<String> values = hmap2.values();
		
		2-1. iterator()로 목록 만들어서 처리
		Iterator<String> valueIter = values.iterator();
		
		while(valueIter.hasNext()) {
			System.out.println(valueIter.next());
		}
		
		2-2. 배열로 만들어서 처리
		Object[] valueArr = values.toArray();
		for(int i = 0; i < valueArr.length; i++) {
			System.out.println(i + " : " + valueArr[i]);
		}
		
		3. Map의 내부 인터페이스인 EntrySet 이용 : entrySet
		entry : 키와 값을 쌍으로 묶은 것
		 
		Set<Map.Entry<String, String>> set = hmap2.entrySet();
		
		Iterator<Map.Entry<String, String>> entryIter = set.iterator();
		while(entryIter.hasNext()) {
			Map.Entry<String, String> entry = entryIter.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		
		Properties */
	}

}
