# [Java] Record

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdgOUBE%2FbtqD9u258Y0%2FV8ICQnAgbwpSJnXL6qkfd1%2Fimg.jpg" width="400">

<br>

```
Java 14에서 프리뷰로 도입된 클래스 타입
순수히 데이터를 보유하기 위한 클래스
```

<br>

Java 14버전부터 도입되고 16부터 정식 스펙에 포함된 Record는 class처럼 타입으로 사용이 가능하다.

객체를 생성할 때 보통 아래와 같이 개발자가 만들어야한다.

<br>

```java
public class Person {
   private final String name;
   private final int age;
 
   public Person(String name, int age) {
      this.name = name;
      this.age = age;
   }
 
   public String getName() {
      return name;
   }
 
   public int getAge() {
      return age;
   }
}
```

- 클래스 `Person` 을 만든다. 
- 필드 `name`, `age`를 생성한다.
- 생성자를 만든다.
- getter를 구현한다.

<br>

보통 `Entity`나 `DTO` 구현에 있어서 많이 사용하는 형식이다.

이를 Record 타입의 클래스로 만들면 상당히 단순해진다.

<br>

```java
public record Person(
	String name,
    int age
) {}
```

<br>

자동으로 필드를 `private final` 로 선언하여 만들어주고, `생성자`와 `getter`까지 암묵적으로 생성된다. 또한 `equals`, `hashCode`, `toString` 도 자동으로 생성된다고 하니 매우 편리하다.

대신 `getter` 메소드의 경우 구현시 `getXXX()`로 명칭을 짓지만, 자동으로 만들어주는 메소드는 `name()`, `age()`와 같이 필드명으로 생성된다.

<br>

<br>

#### [참고 자료]

- [링크](https://coding-start.tistory.com/355)