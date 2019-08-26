## [디자인 패턴] Template Method Pattern

> 로직을 단계 별로 나눠야 하는 상황에서 적용한다.
>
> 단계별로 나눈 로직들이 앞으로 수정될 가능성이 있을 경우 더 효율적이다.

<br>

#### 조건

- 클래스는 추상(abstract)로 만든다.
- 단계를 진행하는 메소드는 수정이 불가능하도록 final 키워드를 추가한다.
- 각 단계들은 외부는 막고, 자식들만 활용할 수 있도록 protected로 선언한다.

<br>

예를 들어보자. 피자를 만들 때는 크게 `반죽 → 토핑 → 굽기` 로 3단계로 이루어져있다.

이 단계는 항상 유지되며, 순서가 바뀔 일은 없다. 물론 실제로는 도우에 따라 반죽이 달라질 수 있겠지만, 일단 모든 피자의 반죽과 굽기는 동일하다고 가정하자. 그러면 피자 종류에 따라 토핑만 바꾸면 된다.

```java
abstract class Pizza {
    
    protected void 반죽() { System.out.println("반죽!"); }
    abstract void 토핑() {}
    protected void 굽기() { System.out.println("굽기!"); }
    
    final void makePizza() { // 상속 받은 클래스에서 수정 불가
        this.반죽();
        this.토핑();
        this.굽기();
    }
    
}
```

```java
class PotatoPizza extends Pizza {
    
    @Override
    void 토핑() {
        System.out.println("고구마 넣기!");
    }
    
}

class TomatoPizza extends Pizza {
    
    @Override
    void 토핑() {
        System.out.println("토마토 넣기!");
    }
    
}
```

abstract 키워드를 통해 자식 클래스에서는 선택적으로 메소드를 오버라이드 할 수 있게 된다.

<br>

<br>

#### abstract와 Interface의 차이는?

- abstract : 부모의 기능을 자식에서 확장시켜나가고 싶을 때
- interface : 해당 클래스가 가진 함수의 기능을 활용하고 싶을 때

> abstract는 다중 상속이 안된다. 상황에 맞게 활용하자!



