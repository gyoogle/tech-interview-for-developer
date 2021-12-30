# [Java ]Interview List

> - 간단히 개념들을 정리해보며 머리 속에 넣자~
> - 질문 자체에 없는 질문 의도가 있는 경우 추가 했습니다.
> - 완전한 설명보다는 면접 답변에 초점을 두며, 추가로 답변하면 좋은 키워드를 기록했습니다.

- [언어(Java, C++ ... )](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Interview/README.md#언어)
- [운영체제](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Interview/README.md#운영체제)
- [데이터베이스](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Interview/README.md#데이터베이스)
- [네트워크](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Interview/README.md#네트워크)
- [스프링](https://github.com/kim6394/Dev_BasicKnowledge/blob/master/Interview/README.md#스프링)

### 가비지 컬렉션이란?

> 배경 & 질문 의도

- JVM 의 구조, 특히 Heap Area 에 대한 이해

> 답변

- 자바가 실행되는 JVM 에서 사용되는 객체, 즉 Heap 영역의 객체를 관리해 주는 기능을 말합니다.
- 이 과정에서 stop the world 가 일어나게 되며, 이 일련 과정을 효율적으로 하기 위해서는 가비지 컬렉터 변경 또는 세부 값 조정이 필요합니다.

> 키워드 & 꼬리 질문

- 가비지 컬렉션 과정, 가비지 컬렉터 종류에 대한 이해

### StringBuilder와 StringBuffer의 차이는?

> 배경 & 질문 의도

- mutation(가변), immutation(불변) 이해
- 불변 객체인 String 의 연산에서 오는 퍼포먼스 이슈 이해
- String
    - immutation
    - String 문자열을 연산하는 과정에서 불변 객체의 반복 생성으로 퍼포먼스가 낮아짐.

> 답변

- 같은점
    - mutation
    - append() 등의 api 지원
- 차이점
    - StringBuilder 는 동기화를 지원하지 않아 싱글 스레드에서 속도가 빠릅니다.
    - StringBuffer 는 멀티 스레드 환경에서의 동기화를 지원하지만 이런 구현은 로직을 의심해야 합니다.

> 키워드 & 꼬리 질문

- [실무에서의 String 연산](https://hyune-c.tistory.com/entry/String-%EC%9D%84-%EC%9E%98-%EC%8D%A8%EB%B3%B4%EC%9E%90)

### Java의 메모리 영역은?

> 배경 & 질문 의도

- JVM 구조의 이해

> 답변

- 메소드, 힙, 스택, pc 레지스터, 네이티브 영역으로 구분됩니다.
    - 메소드 영역은 클래스가 로딩될 때 생성되며 주로 static 변수가 저장됩니다.
    - 힙 영역은 런타임시 할당되며 주로 객체가 저장됩니다.
    - 스택 영역은 컴파일시 할당되며 메소드 호출시 지역변수가 저장됩니다.
    - pc 레지스터는 스레드가 생성될 때마다 생성되는 영역으로 다음 명령어의 주소를 알고 있습니다.
    - 네이티브 영역은 자바 외 언어로 작성된 코드를 위한 영역입니다.
- 힙과 스택은 같은 메모리 공간을 동적으로 공유하며, 과도하게 사용하는 경우 OOM 이 발생할 수 있습니다.
- 힙 영역은 GC 를 통해 정리됩니다.

> 키워드 & 꼬리 질문

- Method Area (Class Area)
    - 클래스가 로딩될 때 생성됩니다.
    - 클래스, 변수, 메소드 정보
    - static 변수
    - Constant pool - 문자 상수, 타입, 필드, 객체참조가 저장됨
- Stack Area
    - 컴파일 타임시 할당됩니다.
    - 메소드를 호출할 때 개별적으로 스택이 생성되며 종료시 해제 됩니다.
    - 지역 변수 등 임시 값이 생성되는 영역
    - Heap 영역에 생성되는 객체의 주소 값을 가지고 있습니다.
- Heap Area
    - 런타임시 할당 됩니다.
    - new 키워드로 생성되는 객체와 배열이 저장되는 영역
    - 참조하는 변수가 없어도 바로 지워지지 않습니다. -> GC 를 통해 제거됨.
- Java : GC, 컴파일/런타임 차이
- CS : 프로세스/단일 스레드/멀티 스레드 차이

### 오버로딩과 오버라이딩 차이는?

> 배경 & 질문 의도

> 답변

- 오버로딩
    - 반환타입 관계 없음, 메소드명 같음, 매개변수 다름 (자료형 또는 순서)
- 오버라이딩
    - 반환타입, 메소드명, 매개변수 모두 같음
    - 부모 클래스로부터 상속받은 메소드를 재정의하는 것.

> 키워드 & 꼬리 질문

- 오버로딩은 생성자가 여러개 필요한 경우 유용합니다.
- 결합도를 낮추기 위한 방법 중 하나로 interface 사용이 있으며, 이 과정에서 오버라이딩이 적극 사용됩니다.

### 추상 클래스와 인터페이스 차이는?

> 배경 & 질문 의도

> 답변

- abstract class 추상 클래스
    - 단일 상속을 지원합니다.
    - 변수를 가질 수 있습니다.
    - 하나 이상의 abstract 메소드가 존재해야 합니다.
    - 자식 클래스에서 상속을 통해 abstract 메소드를 구현합니다. (extends)
        - abstract 메소드가 아닌 구현된 메소드를 상속 받을 수 있습니다.
- interface 인터페이스
    - 다중 상속을 지원합니다.
    - 변수를 가질 수 없습니다. 상수는 가능합니다.
    - 모든 메소드는 선언부만 존재합니다.
    - 구현 클래스는 선언된 모든 메소드를 overriding 합니다.

> 키워드 & 꼬리 질문

- java 버전이 올라갈수록 abstract 의 기능을 interface 가 흡수하고 있습니다.
    - java 8: interface 에서 default method 사용 가능
    - java 9: interface 에서 private method 사용 가능

### 제네릭이란?

- 클래스에서 사용할 타입을 클래스 외부에서 설정하도록 만드는 것
- 제네릭으로 선언한 클래스는, 내가 원하는 타입으로 만들어 사용이 가능함
- <안에는 참조자료형(클래스, 인터페이스, 배열)만 가능함 (기본자료형을 이용하기 위해선 wrapper 클래스를 활용해야 함)
- 참고
    - Autoboxing, Unboxing

### 접근 제어자란? (Access Modifier)

> 배경 & 질문 의도

> 답변

- public: 모든 접근 허용
- protected: 상속받은 클래스 or 같은 패키지만 접근 허용
- default: 기본 제한자. 자신 클래스 내부 or 같은 패키지만 접근 허용
- private: 외부 접근 불가능. 같은 클래스 내에서만 가능

> 키워드 & 꼬리 질문

- 참고
    - 보통 명시적인 표현을 선호하여 default 는 잘 쓰이지 않습니다.

### Java 컴파일 과정

> 배경 & 질문 의도

- CS 에 가까운 질문

> 답변

1. 컴파일러가 변환: 소스코드 -> 자바 바이트 코드(.class)
2. JVM이 변환: 바이트코드 -> 기계어
3. 인터프리터 방식으로 애플리케이션 실행

> 키워드 & 꼬리 질문

- JIT 컴파일러
