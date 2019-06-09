## 클린코드와 리팩토링

<br>

클린코드와 리팩토링은 의미만 보면 비슷하다고 느껴진다. 어떤 차이점이 있을지 생각해보자

<br>

#### 클린코드

클린코드란, 가독성이 높은 코드를 말한다.

가독성을 높이려면 다음과 같이 구현해야 한다.

- 네이밍이 잘 되어야 함
- 오류가 없어야 함
- 중복이 없어야 함
- 의존성을 최대한 줄여야 함
- 클래스 혹은 메소드가 한가지 일만 처리해야 함

<br>

얼마나 **코드가 잘 읽히는 지, 코드가 지저분하지 않고 정리된 코드인지**를 나타내는 것이 바로 '클린 코드'

```java
public int AAA(int a, int b){
    return a+b;
}
public int BBB(int a, int b){
    return a-b;
}
```

<br>

두 가지 문제점이 있다.

<br>

```java
public int sum(int a, int b){
    return a+b;
}

public int sub(int a, int b){
    return a-b;
}
```

첫째는 **함수 네이밍**이다. 다른 사람들이 봐도 무슨 역할을 하는 함수인 지 알 수 있는 이름을 사용해야 한다.

둘째는 **함수와 함수 사이의 간격**이다. 여러 함수가 존재할 때 간격을 나누지 않으면 시작과 끝을 구분하는 것이 매우 힘들다.

<br>

<br>

#### 리팩토링

프로그램의 외부 동작은 그대로 둔 채, 내부의 코드를 정리하면서 개선하는 것을 말함

```
이미 공사가 끝난 집이지만, 더 튼튼하고 멋진 집을 만들기 위해 내부 구조를 개선하는 리모델링 작업
```

<br>

프로젝트가 끝나면, 지저분한 코드를 볼 때 가독성이 떨어지는 부분이 존재한다. 이 부분을 개선시키기 위해 필요한 것이 바로 '리팩토링 기법'

리팩토링 작업은 코드의 가독성을 높이고, 향후 이루어질 유지보수에 큰 도움이 된다.

<br>

##### 리팩토링이 필요한 코드는?

- 중복 코드
- 긴 메소드
- 거대한 클래스
- Switch 문
- 절차지향으로 구현한 코드

<br>

리팩토링의 목적은, 소프트웨어를 더 이해하기 쉽고 수정하기 쉽게 만드는 것

```
리팩토링은 성능을 최적화시키는 것이 아니다.
코드를 신속하게 개발할 수 있게 만들어주고, 코드 품질을 좋게 만들어준다.
```

이해하기 쉽고, 수정하기 쉬우면? → 개발 속도가 증가!

<br>

##### 리팩토링이 필요한 상황

>  소프트웨어에 새로운 기능을 추가해야 할 때

```
명심해야할 것은, 우선 코드가 제대로 돌아가야 한다는 것. 리팩토링은 우선적으로 해야 할 일이 아님을 명심하자
```

<br>

객체지향 특징을 살리려면, switch-case 문을 적게 사용해야 함

(switch문은 오버라이드로 다 바꿔버리자)

<br>











##### 리팩토링 예제

<br>

1번

```java
// 수정 전
public int getFoodPrice(int arg1, int arg2) {
    return arg1 * arg2;
}
```

함수명 직관적 수정, 변수명을 의미에 맞게 수정

```java
// 수정 후
public int getTotalFoodPrice(int price, int quantity) {
    return price * quantity;
}
```

<br>

2번

```java
// 수정 전
public int getTotalPrice(int price, int quantity, double discount) {
    return (int) ((price * quantity) * (price * quantity) * (discount /100));
}
```

`price * quantity`가 중복된다. 따로 변수로 추출하자

할인율을 계산하는 부분을 메소드로 따로 추출하자

할인율 함수 같은 경우는 항상 일정하므로 외부에서 건드리지 못하도록 private 선언

```java
// 수정 후
public int getTotalFoodPrice(int price, int quantity, double discount) {
	int totalPriceQuantity = price * quantity;
    return (int) (totalPriceQuantity - getDiscountPrice(discount, totalPriceQuantity))
}

private double getDiscountPrice(double discount, int totalPriceQuantity) {
    return totalPriceQuantity * (discount / 100);
}
```

<br>

이 코드를 한번 더 리팩토링 해보면?

<br>





3번

```java
// 수정 전
public int getTotalFoodPrice(int price, int quantity, double discount) {
	
    int totalPriceQuantity = price * quantity;
    return (int) (totalPriceQuantity - getDiscountPrice(discount, totalPriceQuantity))
}

private double getDiscountPrice(double discount, int totalPriceQuantity) {
    return totalPriceQuantity * (discount / 100);
}
```

<br>

totalPriceQuantity를 getter 메소드로 추출이 가능하다.

지불한다는 의미를 주기 위해 메소드 명을 수정해주자

<br>

```java
// 수정 후
public int getFoodPriceToPay(int price, int quantity, double discount) {
    
    int totalPriceQuantity = getTotalPriceQuantity(price, quantity);
    return (int) (totalPriceQuantity - getDiscountPrice(discount, totalPriceQuantity));
}

private double getDiscountPrice(double discount, int totalPriceQuantity) {
    return totalPriceQuantity * (discount / 100);
}

private int getTotalPriceQuantity(int price, int quantity) {
    return price * quantity;
}
```

<br>

<br>

##### 클린코드와 리팩토링의 차이?

리팩토링이 더 큰 의미를 가진 것 같다. 클린 코드는 단순히 가독성을 높이기 위한 작업으로 이루어져 있다면, 리팩토링은 클린 코드를 포함한 유지보수를 위한 코드 개선이 이루어진다.

클린코드와 같은 부분은 설계부터 잘 이루어져 있는 것이 중요하고, 리팩토링은 결과물이 나온 이후 수정이나 추가 작업이 진행될 때 개선해나가는 것이 올바른 방향이다.

