#### 디자인 패턴 _ Template Method Pattern

---

[디자인 패턴 예]

1. 템플릿 메서드 패턴

   특정 환경 or 상황에 맞게 확장, 변경할 때 유용한 패턴

   **<u>추상 클래스, 구현 클래스</u>** 둘로 구분. 

   추상클래스 (Abstract Class) : 메인이 되는 로직 부분은 일반 메소드로 선언해 둠.

   구현클래스 (Concrete Class) : 메소드를 선언 후 호출하는 방식.

   - 장점
     - 구현 클래스에서는 추상 클래스에 선언된 메소드만 사용하므로, **<u>핵심 로직 관리가 용이</u>**
     - 객체 추가 및 확장 가능
   - 단점
     - 추상 메소드가 많아지면, 클래스 관리가 복잡함.

   * 설명

     1) HouseTemplate.java

     > Template 추상 클래스를 하나 생성. (예, HouseTemplate)
     >
     > 이 HouseTemplate을 사용할 때는,
     >
     > "HouseTemplate houseType = new WoodenHouse()" 이런 식으로 넣음.
     >
     > HouseTemplate 내부에 **<u>buildHouse</u>**라는 변해서는 안되는 핵심 로직을 만들어 놓음. (장점 1)
     >
     > Template 클래스 내부의 **<u>핵심 로직 내부의 함수</u>**를 상속하는 클래스가 직접 구현하도록, abstract를 지정해 둠.

     ```java
     public abstract class HouseTemplate {
         
         // 이런 식으로 buildHouse라는 함수 (핵심 로직)을 선언해 둠.
         public final void buildHouse() {
             buildFoundation();	// (1)
             buildPillars();		// (2)
             buildWalls();		// (3)
             buildWindows();		// (4)
             System.out.println("House is built.");
         }
         
         // buildFoundation(); 정의 부분 (1)
         // buildWalls(); 정의 부분		(2)
         
         // 위의 두 함수와는 다르게 이 클래스를 상속받는 클래스가 별도로 구현했으면 하는 메소드들은 abstract로 선언하여, 정의하도록 함
         public abstract void buildWalls();	// (3)
         public abstract void buildPillars();// (4)
         
     }
     
     ```

     

     2) WoodenHouse.java (GlassHouse.java도 가능)

     > HouseTemplate을 상속받는 클래스.
     >
     > Wooden이나, Glass에 따라서 buildHouse 내부의 핵심 로직이 바뀔 수 있으므로,
     >
     > 이 부분을 반드시 선언하도록 지정해둠.

     ```java
     public class WoodenHouse extends HouseTemplate {
         @Override
         public void buildWalls() {
             System.out.println("Building Wooden Walls");
         }
         @Override
         public void buildPillars() {
             System.out.println("Building Pillars with Wood coating");
         }
     }
     ```

     