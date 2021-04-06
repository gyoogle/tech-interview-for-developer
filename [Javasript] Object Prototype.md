# Object Prototype
Prototype은 JavaScript object가 다른 object에서 상속하는 매커니즘이다. 

## A prototype-based language?
JavaScript는 종종 prototype-based language로 설명된다. prototype-based language는 상속을 지원하고 object는 prototype object를 갖는다. prototyp object는 method와 property를 상속하는 template object 같은 것이다.

object의 prototype object 또한 prototype object를 가지고 있으며 이것을 **prototype chain** 이라고 부른다.

JavaScript에서 연결은 object instance와 prototype(\__proto__ 속성 또는 constructor의 prototype 속성) 사이에 만들어진다

## Understanding prototype objects
아래 예제를 보자.
```js
function Person(first, last, age, gender, interests) {

  // property and method definitions
  this.name = {
    'first': first,
    'last' : last
  };
  this.age = age;
  this.gender = gender;
  //...see link in summary above for full definition
}
```
우리는 object instace를 아래와 같이 만들 수 있다.
```js
let person1 = new Person('Bob', 'Smith', 32, 'male', ['music', 'skiing']);
```

person1에 있는 method를 부른다면 어떤일이 발생할 것인가?
```js
person1.valueOf()
```
valueOf()를 호출하면
- 브라우저는 person1 object가 valueOf() method를 가졌는지 확인한다. 즉, 생성자인 Person()에 정의되어 있는지 확인한다.
- 그렇지 않다면 person1의 prototype object를 확인한다. prototype object에 method가 없다면 prototype object의 prototype object를 확인하며 prototype object가 null이 될 때까지 탐색한다.