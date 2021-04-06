# [Javascript] Closure

closure는 주변 state(lexical environment를 의미)에 대한 참조와 함께 묶인 함수의 조합이다. 다시말해서, closure는 inner function이 outer function의 scope를 접근할 수 있게 해준다. JavaScript에서 closure는 함수 생성 시간에 함수가 생성될 때마다 만들어진다.

## Lexical scoping
아래 예제를 보자
```js
function init() {
  var name = 'Mozilla'; // name is a local variable created by init
  function displayName() { // displayName() is the inner function, a closure
    alert(name); // use variable declared in the parent function
  }
  displayName();
}
init();
```
closure는 inner function이 outer function의 scope에 접근할 수 있기 때문에 위의 예제에서 inner function인 displayName()이 outer function인 init()의 local 변수 name을 참조하고 있다.

lexical scoping은 nested 함수에서 변수 이름이 확인되는 방식을 정의한다. inner function은 parent function이 return 되었더라고 parent function의 scope를 가지고 있다. 아래 예제를 보자
```js
/* lexical scope (also called static scope)*/
function func() {
    var x = 5;
    function func2() {
        console.log(x);
    }
}

func() // print 5
```
```js
/* dynamic scope */
function func() {
    console.log(x)
}

function dummy1() {
    x = 5;
    func();
}

function dummy2() {
    x = 10;
    func();
}

dummy1() // print 5
dummy2() // print 10
```
첫 번째 예제는 compile-time에 추론할 수 있기 때문에 static이며 두 번째 예제는 outer scope가 dynamic 하고 function의 chain call에 의존하기 때문에 dynamic이라고 불린다.

## Closure
```js
function makeFunc() {
  var name = 'Mozilla';
  function displayName() {
    alert(name);
  }
  return displayName;
}

var myFunc = makeFunc();
myFunc();
```
위의 예제는 처음의 init() 함수와 같은 효과를 가진다. 차이점은 inner function인 displayName()이 outer function이 실행되기 이전에 return 되었다는 것이다.

다른 programming language에서는 함수의 local variable은 함수가 실행되는 동안에서만 존재한다. makeFunc()가 호출되고 끝난다음에 더 이상 name 변수에 접근하지 못해야 할 것 같지만 JavaScript에서는 그렇지 않다.

그 이유는 JavaScript의 함수가 closure를 형성하기 때문이다. closure란 함수와 lexical environment의 조합이다. 이 environment는 closure가 생설 될 때 scope 내에 있던 모든 local 변수로 구성된다. 위의 경우에, myFunc는 makeFunc가 실행될 때 만들어진 displayName의 instance를 참조한다. displayName의 instance는 name 변수를 가진 lexical environment를 참조하는 것을 유지한다. 이러현 이유로 myFunc가 실행 될 때, name 변수는 사용가능한 상태로 남아있다.

closure는 매우 유용하다. 왜냐하면 data와 함수를 연결 시켜주기 때문이다. 이것은 data와 하나 또는 여러개의 method와 연결 되어있는 OOP(object-oriented programming)과 똑같다.

결국 closure를 이용하여 OOP의 object로 이용할 수 있다.

## Emulating private methods with closures
Java와 다르게 JavaScript은 private를 구현하기 위한 native 방법을 제공하지 않는다. 그러나 closure를 통해서 private를 구현할 수 있다.

아래 예제는 [Module Design Pattern](https://www.google.com/search?q=javascript+module+pattern)을 따른다.
```js
var counter = (function() {
  var privateCounter = 0;

  function changeBy(val) {
    privateCounter += val;
  }

  return {
    increment: function() {
      changeBy(1);
    },

    decrement: function() {
      changeBy(-1);
    },

    value: function() {
      return privateCounter;
    }
  };
})();

console.log(counter.value());  // 0.

counter.increment();
counter.increment();
console.log(counter.value());  // 2.

counter.decrement();
console.log(counter.value());  // 1.
```
위의 예제에서 counter.increment 와 counter.decrement, counter.value는 같은 lexical environment를 공유하고 있다. 

공유된 lexical environment는 선언가 동시에 실행되는 anonymous function([IIFE](https://developer.mozilla.org/en-US/docs/Glossary/IIFE))의 body에 생성되어 있다. lexical environment는 private 변수와 함수를 가지고 있어 anonymous function의 외부에서 접근할 수 없다.

아래는 anonymous function이 아닌 function을 사용한 예제이다
```js
var makeCounter = function() {
  var privateCounter = 0;
  function changeBy(val) {
    privateCounter += val;
  }
  return {
    increment: function() {
      changeBy(1);
    },

    decrement: function() {
      changeBy(-1);
    },

    value: function() {
      return privateCounter;
    }
  }
};

var counter1 = makeCounter();
var counter2 = makeCounter();

alert(counter1.value());  // 0.

counter1.increment();
counter1.increment();
alert(counter1.value()); // 2.

counter1.decrement();
alert(counter1.value()); // 1.
alert(counter2.value()); // 0.
```
위의 예제는 closure 보다는 object를 사용하는 것을 추천한다. 위에서 makeCounter() 가 호출될 때마다 increment, decrement, value 함수들이 새로 assign되어 오버헤드가 발생한다. 즉, object의 prototype에 함수들을 선언하고 object를 운용하는 것이 더 효율적이다.

```js
function makeCounter() {
    this.publicCounter = 0;
}

makeCounter.prototype = {
    changeBy : function(val) {
        this.publicCounter += val;
    },
    increment : function() {
        this.changeBy(1);
    },
    decrement : function() {
        this.changeBy(-1);
    },
    value : function() {
        return this.publicCounter;
    }
}
var counter1 = new makeCounter();
var counter2 = new makeCounter();

alert(counter1.value());  // 0.

counter1.increment();
counter1.increment();
alert(counter1.value()); // 2.

counter1.decrement();
alert(counter1.value()); // 1.
alert(counter2.value()); // 0.
```

## Closure Scope Chain
모든 closure는 3가지 scope를 가지고 있다.
- Local Scope(Own scope)
- Outer Functions Scope
- Global Scope

```js
// global scope
var e = 10;
function sum(a){
  return function(b){
    return function(c){
      // outer functions scope
      return function(d){
        // local scope
        return a + b + c + d + e;
      }
    }
  }
}

console.log(sum(1)(2)(3)(4)); // log 20

// You can also write without anonymous functions:

// global scope
var e = 10;
function sum(a){
  return function sum2(b){
    return function sum3(c){
      // outer functions scope
      return function sum4(d){
        // local scope
        return a + b + c + d + e;
      }
    }
  }
}

var s = sum(1);
var s1 = s(2);
var s2 = s1(3);
var s3 = s2(4);
console.log(s3) //log 20
```
위의 예제를 통해서 closure는 모든 outer function scope를 가진다는 것을 알 수 있다.

## Creating closures in loops: A common mistake
아래 예제를 보자
```html
<p id="help">Helpful notes will appear here</p>
<p>E-mail: <input type="text" id="email" name="email"></p>
<p>Name: <input type="text" id="name" name="name"></p>
<p>Age: <input type="text" id="age" name="age"></p>
```

```js
function showHelp(help) {
  document.getElementById('help').textContent = help;
}

function setupHelp() {
  var helpText = [
      {'id': 'email', 'help': 'Your e-mail address'},
      {'id': 'name', 'help': 'Your full name'},
      {'id': 'age', 'help': 'Your age (you must be over 16)'}
    ];

  for (var i = 0; i < helpText.length; i++) {
    var item = helpText[i];
    document.getElementById(item.id).onfocus = function() {
      showHelp(item.help);
    }
  }
}

setupHelp();
```
위의 코드는 정상적으로 동작하지 않는다. 모든 element에서 age의 help text가 보일 것이다. 그 이유는 onfocus가 closure이기 때문이다. closure는 function 선언과 setupHelp의 fucntion scope를 가지고 있다. 3개의 closure를 loop에 의해서 만들어지며 같은 lexical environment를 공유하고 있다. 하지만 item은 var로 선언이 되어있어 hoisting이 일어난다. item.help는 onfocus 함수가 실행될 때 결정되므로 항상 age의 help text가 전달이 된다.
아래는 해결방법이다.

```js
function showHelp(help) {
  document.getElementById('help').textContent = help;
}

function makeHelpCallback(help) {
  return function() {
    showHelp(help);
  };
}

function setupHelp() {
  var helpText = [
      {'id': 'email', 'help': 'Your e-mail address'},
      {'id': 'name', 'help': 'Your full name'},
      {'id': 'age', 'help': 'Your age (you must be over 16)'}
    ];

  for (var i = 0; i < helpText.length; i++) {
    var item = helpText[i];
    document.getElementById(item.id).onfocus = makeHelpCallback(item.help);
  }
}

setupHelp();
```
하나의 lexical environment를 공유하는 대신 makeHekpCallback 함수가 새로운 lexical environment를 만들었다.

다른 방법으로는 anonymous closure(IIFE)를 이용한다.

```js
function showHelp(help) {
  document.getElementById('help').textContent = help;
}

function setupHelp() {
  var helpText = [
      {'id': 'email', 'help': 'Your e-mail address'},
      {'id': 'name', 'help': 'Your full name'},
      {'id': 'age', 'help': 'Your age (you must be over 16)'}
    ];

  for (var i = 0; i < helpText.length; i++) {
    (function() {
       var item = helpText[i];
       document.getElementById(item.id).onfocus = function() {
         showHelp(item.help);
       }
    })(); // Immediate event listener attachment with the current value of item (preserved until iteration).
  }
}

setupHelp();
```

let keyword를 사용해서 해결할 수 있다.
```js
function showHelp(help) {
  document.getElementById('help').textContent = help;
}

function setupHelp() {
  var helpText = [
      {'id': 'email', 'help': 'Your e-mail address'},
      {'id': 'name', 'help': 'Your full name'},
      {'id': 'age', 'help': 'Your age (you must be over 16)'}
    ];

  for (let i = 0; i < helpText.length; i++) {
    let item = helpText[i];
    document.getElementById(item.id).onfocus = function() {
      showHelp(item.help);
    }
  }
}

setupHelp();
```

## Performane consideration
closure가 필요하지 않을 때 closure를 만드는 것은 메모리와 속도에 악영향을 끼치낟.

예를들어, 새로운 object/class를 만들 때, method는 object의 생성자 대신에 object의 prototype에 있는 것이 좋다. 왜냐하면 생성자가 호출될 때마다, method는 reassign 되기 때문이다.
```js
function MyObject(name, message) {
  this.name = name.toString();
  this.message = message.toString();
  this.getName = function() {
    return this.name;
  };

  this.getMessage = function() {
    return this.message;
  };
}
```
위의 예제에서 getName과 getMessage는 생성자가 호출될 때마다 reaasign된다.
```js
function MyObject(name, message) {
  this.name = name.toString();
  this.message = message.toString();
}
MyObject.prototype = {
  getName: function() {
    return this.name;
  },
  getMessage: function() {
    return this.message;
  }
};
```
prototype 전부를 다시 재선언하는 것은 추천하지 않는다.
```js
function MyObject(name, message) {
  this.name = name.toString();
  this.message = message.toString();
}
MyObject.prototype.getName = function() {
  return this.name;
};
MyObject.prototype.getMessage = function() {
  return this.message;
};
```