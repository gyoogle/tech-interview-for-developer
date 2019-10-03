## 스트레티지 패턴(Strategy Pattern)

> 어떤 동작을 하는 로직을 정의하고, 이것들을 하나로 묶어(캡슐화) 관리하는 패턴

새로운 로직을 추가하거나 변경할 때, 한번에 효율적으로 변경이 가능하다.

<br>

```
[ 슈팅 게임을 설계하시오 ]
유닛 종류 : 전투기, 헬리콥터
유닛들은 미사일을 발사할 수 있다.
전투기는 직선 미사일을, 헬리콥터는 유도 미사일을 발사한다.
필살기로는 폭탄이 있는데, 전투기에는 있고 헬리콥터에는 없다.
```

<br>

Strategy pattern을 적용한 설계는 아래와 같다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile9.uf.tistory.com%2Fimage%2F255CF641559E74AC09EFBB">

> 상속은 무분별한 소스 중복이 일어날 수 있으므로, 컴포지션을 활용한다. (인터페이스와 로직의 클래스와의 관계를 컴포지션하고, 유닛에서 상황에 맞는 로직을 쓰게끔 유도하는 것)

<br>

- ##### 미사일을 쏘는 것과 폭탄을 사용하는 것을 캡슐화하자

  ShootAction과 BombAction으로 인터페이스를 선언하고, 각자 필요한 로직을 클래스로 만들어 implement한다.

- ##### 전투기와 헬리콥터를 묶을 Unit 추상 클래스를 만들자

  Unit에는 공통적으로 사용되는 메서드들이 들어있고, 미사일과 폭탄을 선언하기 위해 variable로 인터페이스들을 선언한다.

<br>

전투기와 헬리콥터는 Unit 클래스를 상속받고, 생성자에 맞는 로직을 정의해주면 끝난다.

##### 전투기 예시

```java
class Fighter extends Unit {
    private ShootAction shootAction;
    private BombAction bombAction;
    
    public Fighter() {
        shootAction = new OneWayMissle();
        bombAction = new SpreadBomb();
    }
}
```

`Fighter.doAttack()`을 호출하면, OneWayMissle의 attack()이 호출될 것이다.

<br>

#### 정리

이처럼 Strategy Pattern을 활용하면 로직을 독립적으로 관리하는 것이 편해진다. 로직에 들어가는 '행동'을 클래스로 선언하고, 인터페이스와 연결하는 방식으로 구성하는 것!

<br>

<br>

##### [참고]

[링크](<https://flowarc.tistory.com/entry/1-Strategy-Pattern?category=562154>)

