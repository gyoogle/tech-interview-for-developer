## 함수형 프로그래밍

> 순수 함수를 조합하고 공유 상태, 변경 가능한 데이터 및 부작용을 **피해** 소프트웨어를 만드는 프로세스

<br>

<img src="https://user-images.githubusercontent.com/6733004/46247710-5ce5fb00-c44a-11e8-9400-16dd44626820.png">

<br>

'선언형' 프로그래밍으로, 애플리케이션의 상태는 순수 함수를 통해 전달된다.

애플리케이션의 상태가 일반적으로 공유되고 객체의 메서드와 함께 배치되는 OOP와는 대조되는 프로그래밍 방식

<br>

- ##### 명령형 프로그래밍(절차지향, 객체지향)

  > 상태와 상태를 변경시키는 관점에서 연산을 설명하는 방식 
  >
  > 알고리즘을 명시하고, 목표는 명시하지 않음

- ##### 선언형 프로그래밍

  > How보다는 What을 설명하는 방식 (어떻게보단 무엇을)
  >
  > 알고리즘을 명시하지 않고 목표만 명시함

<br>

```
명령형 프로그래밍은 어떻게 할지 표현하고, 선언형 프로그래밍은 무엇을 할 건지 표현한다.
```

<br>

함수형 코드는 명령형 프로그래밍이나 OOP 코드보다 더 간결하고 예측가능하여 테스트하는 것이 쉽다.

(하지만 익숙치 않으면 더 복잡해보이고 이해하기 어려움)

<br>

함수형 프로그래밍은 프로그래밍 언어나 방식을 배우는 것이 아닌, 함수로 프로그래밍하는 사고를 배우는 것이다.

`기존의 사고방식을 전환하여 프로그래밍을 더 유연하게 문제해결 하도록 접근하는 것`

<br>

#### 함수형 프로그래밍의 의미를 파악하기 전 꼭 알아야 할 것들

- 순수 함수 (Pure functions)

  > 입출력이 순수해야함 : 반드시 하나 이상의 인자를 받고, 받은 인자를 처리해 반드시 결과물을 돌려줘야 함. 인자 외 다른 변수 사용 금지

- 합성 함수 (Function composition)

- 공유상태 피하기 (Avoid shared state)

- 상태변화 피하기 (Avoid mutating state)

- 부작용 피하기 (Avoid side effects)

  > 프로그래머가 바꾸고자 하는 변수 외에는 변경되면 안됨. 원본 데이터는 절대 불변!

<br>

대표적인 자바스크립트 함수형 프로그래밍 함수 : map, filter, reduce

<br>

##### 함수형 프로그래밍 예시

```javascript
var arr = [1, 2, 3, 4, 5];
var map = arr.map(function(x) {
  return x * 2;
}); // [2, 4, 6, 8, 10]
```

arr을 넣어서 map을 얻었음. arr을 사용했지만 값은 변하지 않았고 map이라는 결과를 내고 어떠한 부작용도 낳지 않음

이런 것이 바로 함수형 프로그래밍의 순수함수라고 말한다.

<br>

```javascript
var arr = [1, 2, 3, 4, 5];
var condition = function(x) { return x % 2 === 0; }
var ex = function(array) {
  return array.filter(condition);
};
ex(arr); // [2, 4]
```

이는 순수함수가 아니다. 이유는 ex 메소드에서 인자가 아닌 condition을 사용했기 때문.

순수함수로 고치면 아래와 같다.

```javascript
var ex = function(array, cond) {
  return array.filter(cond);
};
ex(arr, condition);
```

순수함수로 만들면, 에러를 추적하는 것이 쉬워진다. 인자에 문제가 있거나 함수 내부에 문제가 있거나 둘 중 하나일 수 밖에 없기 때문이다.

<br>

<br>

### Java에서의 함수형 프로그래밍

---

Java 8이 릴리즈되면서, Java에서도 함수형 프로그래밍이 가능해졌다.

```
함수형 프로그래밍 : 부수효과를 없애고 순수 함수를 만들어 모듈화 수준을 높이는 프로그래밍 패러다임
```

부수효과 : 주어진 값 이외의 외부 변수 및 프로그래밍 실행에 영향을 끼치지 않아야 된다는 의미

최대한 순수함수를 지향하고, 숨겨진 입출력을 최대한 제거하여 코드를 순수한 입출력 관계로 사용하는 것이 함수형 프로그래밍의 목적이다.



Java의 객체 지향은 명령형 프로그래밍이고, 함수형은 선언형 프로그래밍이다.

둘의 차이는 `문제해결의 관점`

여태까지 우리는 Java에서 객체지향 프로그래밍을 할 때 '데이터를 어떻게 처리할 지에 대해 명령을 통해 해결'했다.

함수형 프로그래밍은 선언적 함수를 통해 '무엇을 풀어나가야할지 결정'하는 것이다.



##### Java에서 활용할 수 있는 함수형 프로그래밍

- 람다식
- stream api
- 함수형 인터페이스



Java 8에는 Stream API가 추가되었다.

```java
import java.util.Arrays;
import java.util.List;

public class stream {

	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a", "b", "c", "d", "e");
 
        // 기존방식
        for(int i=0; i<myList.size(); i++){
            String s = myList.get(i);
            if(s.startsWith("c")){
                System.out.println(s.toUpperCase());
            }
        }
 
        // stream API를 이용한 방식
        myList.stream()
              .filter(s -> s.startsWith("c"))
              .map(String::toUpperCase)
              .forEach(System.out::println);
 
	}

}
```

뭐가 다른건지 크게 와닿지 않을 수 있지만, 중요한건 프로그래밍의 패러다임 변화라는 것이다.

단순히 함수를 선언해서 데이터를 내가 원하는 방향으로 처리해나가는 함수형 프로그래밍 방식을 볼 수 있다. **한눈에 보더라도 함수형 프로그래밍은 내가 무엇을 구현했는지 명확히 알 수 있다**. (무슨 함수인지 사전학습이 필요한 점이 있음)





