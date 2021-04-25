# An overview of design pattern - SOLID, GRASP

먼저 디자인 패턴을 공부하기 전에 Design Principle인 SOLID와 GRASP에 대해서 알아보자


# Design Smells
design smell이란 나쁜 디자인을 나타내는 증상같은 것이다.

아래 4가지 종류가 있다.
1. Rigidity(경직성)  
    시스템이 변경하기 어렵다. 하나의 변경을 위해서 다른 것들을 변경 해야할 때 경직성이 높다.
    경직성이 높다면 non-critical한 문제가 발생했을 때 관리자는 개발자에게 수정을 요청하기가 두려워진다. 

2. Fragility(취약성)  
    취약성이 높다면 시스템은 어떤 부분을 수정하였는데 관련이 없는 다른 부분에 영향을 준다. 수정사항이 관련되지 않은 부분에도 영향을 끼치기 떄문에 관리하는 비용이 커지며 시스템의 credibility 또한 잃는다.

3. Immobility(부동성)  
    부동성이 높다면 재사용하기 위해서 시스템을 분리해서 컴포넌트를 만드는 것이 어렵다. 주로 개발자가 이전에 구현되었던 모듈과 비슷한 기능을 하는 모듈을 만들려고 할 때 문제점을 발견한다.

4. Viscosity(점착성)  
    점착성은 디자인 점착성과 환경 점착성으로 나눌 수 있다.

    시스템에 코드를 추가하는 것보다 핵을 추가하는 것이 더 쉽다면 디자인 점착성이 높다고 할 수 있다. 예를 들어 수정이 필요할 때 다양한 방법으로 수정할 수 있을 것이다. 어떤 것은 디자인을 유지하는 것이고 어떤 것은 그렇지 못할 것이다(핵을 추가).

    환경 점착성은 개발환경이 느리고 효율적이지 못할 때 나타난다. 예를들면 컴파일 시간이 매우 길다면 큰 규모의 수정이 필요하더라도 개발자는 recompile 시간이 길기 때문에 작은 규모의 수정으로 문제를 해결할려고 할 것이다.

위의 design smell은 곧 나쁜 디자인을 의미한다.(스파게티 코드)

# Robert C. Martin's Software design principles(SOLID)
Robejt C. Martin은 5가지 Software design principles을 정의하였고 앞글자를 따서 SOLID라고 부른다.

## Single Responsibility Principle(SRP)
A class should have one, and only one, reason to change  

클래스는 오직 하나의 이유로 수정이 되어야 한다는 것을 의미한다.

### Example

SRP를 위반하는 예제로 아래 클래스 다이어그램을 보자

![](https://images.velog.io/images/whow1101/post/57693bec-b90d-47aa-a2dc-a4916b663234/overview_pattern_1.PNG)

Register 클래스가 Student 클래스에 dependency를 가지고 있는 모습이다.
만약 여기서 어떤 클래스가 Student를 다양한 방법으로 정렬을 하고 싶다면 아래와 같이 구현 할 수 있다.

![](https://images.velog.io/images/whow1101/post/c7db57cb-5579-45eb-b999-ffc2f57b2061/overview_pattern_2.PNG)

하지만 Register 클래스는 어떠한 변경도 일어나야하지 않지만 Student 클래스가 바뀌어서 Register 클래스가 영향을 받는다. 정렬을 위한 변경이 관련없는 Reigster 클래스에 영향을 끼쳤기 때문에 SRP를 위반한다.

![](https://images.velog.io/images/whow1101/post/ddd405f3-ad24-40ac-bf58-b7d9629006f8/overview_pattern_3.PNG)

위의 그림은 SRP 위반을 해결하기 위한 클래스 다이어그램이다. 각각의 정렬 방식을 가진 클래스를 새로 생성하고 Client는 새로 생긴 클래스를 호출한다.

### 관련 측정 항목
SRP는 같은 목적으로 responsibility를 가지는 cohesion과 관련이 깊다. 

## Open Closed Principle(OCP)
Software entities (classes, modules, functions, etc) should be open for extension but closed for modification

자신의 확장에는 열려있고 주변의 변화에는 닫혀 있어야 하는 것을 의미한다.

### Example

![](https://images.velog.io/images/whow1101/post/567b0348-8bad-40a4-baf7-065baf6330a7/overview_pattern_4.PNG)
```java
void incAll(Employee[] emps) {
    for (int i=0; i<emps.size(); i++) {
        if(emps[i].empType == FACULTY)
            incFacultySalary((FACULTY)emps[i])
        else if(emps[i].empType == STAFF)
            incStaffSalary((STAFF)emps[i])
        else if(emps[i].empType == SECRETARY)
            incSecretarySalary((SECRETARY)emps[i])
    }
}
```
위의 예제는 아래 문제점을 가지고 있다.

Rigid - 새로운 employee type이 계속 요구된다.

Fragile - 많은 if/lese 구문과 코드를 찾기 어렵다

![](https://images.velog.io/images/whow1101/post/ed143d4d-c85b-4c7a-82c9-ddd3cb0974cc/overview_pattern_5.PNG)

이전에 설명한 문제점을 해결한 클래스 다이어그램이다.

incAll() 함수를 통해서 문제를 해결한 것을 볼 수 있다.

## Liskov Substitution Principle(LSP)
subtypes must be substitutable for their base types

base 클래스에서 파생된 클래스는 base 클래스를 대체해서 사용할 수 있어야한다.

### Example
아래는 Java 라이브러리의 Date 클래스이다.

![](https://images.velog.io/images/whow1101/post/c85dc1d3-c49f-4882-8b34-d11737e0b4c1/overview_pattern_6.PNG)
```java
java.util.Date date = new java.util.Date();
int dateValue = date.getDate(); // Okay

date = new java.sql.Time(10,10,10);
dataValue = date.getDate(); // throws IllegalArgumentException
```

### Inheritance Vs. Composition

![](https://images.velog.io/images/whow1101/post/e3fcc38c-4cd1-4bcf-b0f9-108787d30a1b/overview_pattern_7.PNG)

위의 예제엇 만약 List의 Implemenation을 재사용하게 된다면 inheritance보다 object composition을 사용하는 것을 추천한다.

위에서 Queue 클래스가 List 클래스를 inheritance 한다면 LSP를 위반하게 된다.

## Interface Segregation Principle(ISP)
Clients should not be forced to depend on methods they do not use

사용하지 않는 메소드에 의존하면 안된다.

![](https://images.velog.io/images/whow1101/post/78f2622b-b05b-4e3f-a810-f7519b97371d/overview_pattern_8.PNG)

Roast Application은 getName(), getSSN() 메소드만을 사용하고 Account Application은 getInvoice(), postPayment() 메소드만을 사용한다.

![](https://images.velog.io/images/whow1101/post/a1411b66-caed-4190-8e54-474d7155fd51/overview_pattern_9.PNG)
위 클래스 다이어그램 처럼 클래스에 맞는 interface를 만들어서 제공하면 ISP 문제를 해결할 수 있다.

## Dependency Inversion Principle(DIP)
high-level modules should not depend on low-level modules. Both should depend on abstractions

자신(high level module)보다 변하기 쉬운 모듈(low level modeul)에 의존해서는 안된다.

### Inversion?

![](https://images.velog.io/images/whow1101/post/eb1bd2bf-b8ad-4309-9d3c-746eceb28034/overview_pattern_10.PNG)

Program 클래스는 Module 클래스에 dependency를 가지고 있으며 Module 클래스는 Function 클래스에 의존하고 있다.

![](https://images.velog.io/images/whow1101/post/828c9238-78a2-4b1d-aefc-5d4e604af345/overview_pattern_11.PNG)

Module 클래스를 인터페이스 클래스로 변경을 한 클래스 다이어그램이다.
이전 그림과 다르게 depenedency가 inversion 된 모습을 볼 수 있다.


DIP는 dependency를 inversion 하는 것 뿐 아니라 ownership 또한 inversion 한다.
