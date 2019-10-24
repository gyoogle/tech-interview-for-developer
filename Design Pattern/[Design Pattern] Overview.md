### [Design Pattern] 개요

---

> 일종의 설계 기법이며, 설계 방법이다.



* #### 목적

  SW **<u>재사용성, 호환성, 유지 보수성</u>**을 보장.

  <br>

* #### 특징

  **<u>디자인 패턴은 아이디어</u>**임, 특정한 구현이 아님.

  프로젝트에 항상 적용해야 하는 것은 아니지만, 추후 재사용, 호환, 유지 보수시 발생하는 **<u>문제 해결을 예방하기 위해 패턴을 만들어 둔 것</u>**임.

  <br>

* #### 원칙

  SOLID (객체지향 설계 원칙)

  (간략한 설명)

  1. Single Responsibility Principle

     > 하나의 클래스는 하나의 역할만 해야 함.

  2. Open - Close Principle

     > 확장 (상속)에는 열려있고, 수정에는 닫혀 있어야 함.

  3. Liskov Substitution Principle

     > 자식이 부모의 자리에 항상 교체될 수 있어야 함.

  4. Interface Segregation Principle

     > 인터페이스가 잘 분리되어서, 클래스가 꼭 필요한 인터페이스만 구현하도록 해야함.

  5. Dependency Inversion Property

     > 상위 모듈이 하위 모듈에 의존하면 안됨.
     >
     > 둘 다 추상화에 의존하며, 추상화는 세부 사항에 의존하면 안됨.

<br>

* #### 분류 (중요)

`3가지 패턴의 목적을 이해하기!`

1. 생성 패턴 (Creational) : 객체의 **<u>생성 방식</u>** 결정

   Class-creational patterns, Object-creational patterns.

   ```text
   예) DBConnection을 관리하는 Instance를 하나만 만들 수 있도록 제한하여, 불필요한 연결을 막음.
   ```

   <br>

2. 구조 패턴 (Structural) : 객체간의 **<u>관계</u>**를 조직

   ```text
   예) 2개의 인터페이스가 서로 호환이 되지 않을 때, 둘을 연결해주기 위해서 새로운 클래스를 만들어서 연결시킬 수 있도록 함.
   ```

   <br>

3. 행위 패턴 (Behavioral): 객체의 **<u>행위</u>**를 조직, 관리, 연합

   ```text
   예) 하위 클래스에서 구현해야 하는 함수 및 알고리즘들을 미리 선언하여, 상속시 이를 필수로 구현하도록 함.
   ```

<br>

