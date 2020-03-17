# [Javascript] ES2015+ 요약 정리

---

<br>



### ES2015+의 등장

기존의 자바스크립트 문법에 다른 언어의 장점들을 더한 편리한 기능들이 많이 추가되었다. 이 중에  활용도가 높은 부분에 대해서 알아보자.



### 1. const, let

---

자바스크립트에서 변수를 선언할 때 var를 이용해왔다. 하지만 이제 var는 `const`와 `let`으로 대체할 것이다.

const와 let은 함수 스코프를 가지는 var와는 달리 **블록 스코프**를 갖는다.

블록 스코프는 `if, while, for, function` 등에서 사용하는 중괄호에 속하는 범위를 뜻한다. 따라서 const와 let을 이 중괄호 안에서 사용하게 된다면, 그 스코프 범위 안에서만 접근이 가능하다. 이를 통해 호이스팅에 관련된 문제는 자연스럽게 해결할 수 있다.



#### *그렇다면 const와 let은 무슨 차이일까?*

간단히 말해서 let은 대입한 값을 계속 수정할 수 있지만, const는 한번 대입하면 다른 값 대입을 할 수 없고 초기화 시 값이 필요다.


```javascript
const a = 0;
a = 1; // error


let b = 0;
b = 1; // 1

const c; // error 
```





### 2. 템플릿 문자열

---

백틱(`)을 이용해 새로운 문자열을 만들 수 있다.

> 백틱은 키보드에서 `tab키` 위에 있다



백틱을 활용해서 문자열 안에 변수도 넣을 수 있게 되었다. 기존에는 변수가 등장할 때마다 따옴표를 닫고 +를 통해 연결했는데 이제 백틱을 활용하면 변수가 포함된 문자열을 한번에 모두 작성이 가능해졌다.



```javascript
var string = num1 + ' + ' + num2 + ' = ' + result;

const string = ${num1} + ${num2} = ${result};
```



아래가 훨씬 가독성이 좋아졌다. 또한, 백틱 안에 따옴표를 함께 작성하는 것도 가능하다.





### 3. 객체 리터럴

---

다음 코드는 oldObject 객체에 동적으로 속성을 추가하는 상황이다.

- #### 기존 코드

```javascript
var sayNode = function() {
    console.log('Node');
};
 
var es = 'ES';
var oldObject = {
    sayJS: function(){
        console.log('JS');
    },
    sayNode: sayNode,
};
 
oldObject[es + 6] = 'Fantastic';
 
oldObject.sayNode();
oldObject.sayJS();
console.log(oldObject.ES6);
```



이제 위와 같은 코드를 아래처럼 수정할 수 있다.

```javascript
var sayNode = function() {
    console.log('Node');
};
 
var es = 'ES';
 
const newObject = {
    sayJS() {
        console.log('JS');
    },
    sayNode,
    [es+6]: 'Fantastic',
};
 
newObject.sayNode();
newObject.sayJS();
console.log(newObject.ES6);
```



oldObject와 newObject를 비교해보자.

객체의 메서드에 함수를 연결할 때 이제 `:`와 같은 콜론과 function을 붙이지 않아도 가능해졌다.

또한 `sayNode : sayNode`와 같이 중복되는 이름의 변수는 그냥 간단히 sayNode 하나만 작성하면 된다.

또한 객체의 속성명을 동적으로 생성이 가능하다. 이전에는 객체 리터럴 바깥에서 [es+6]으로 만들었지만, 이제 객체 리터럴 안에서 만들 수 있는 모습을 확인할 수 있다.

> 코드의 양을 줄이고, 편리하니 익숙해지면 좋다.





### 4. 화살표 함수

---

기존의 `function {}`도 이전처럼 사용이 가능하지만, ES2015 이후로 화살표 함수가 생기면서 많이 사용되고 있다.

```javascript
function add1(x, y) {
	return x+y;
}

const add2 = (x, y) => x + y;
```



두 가지 모두 똑같은 기능을 하는 함수다. 하지만 화살표 함수에서는 function 대신 `=>` 기호로 선언한다. 이는 **return문을 줄일 수 있는 장점**이 있다. 또한 화살표 함수는 **function과 this 바인드 방식에서 차이점**이 존재한다.



- #### 기존 코드

```javascript
var relationship1 = {
    name: 'kim',
    friends: ['a', 'b', 'c'],
    logFriends: function() {
        var that = this; // relationship1을 가리키는 this를 that에 저장
 
        this.friends.forEach(function(friend){
            console.log(that.name, friend);
        });
    },
};
relationship1.logFriends();
```



`relationship1.logFriends()`에서 forEach문 안에 function 선언문을 사용했다. 

이로써 각자 다른 함수 스코프 this를 가지게 되므로 friends 값을 가져오기 위해서 `that`이라는 변수를 만들어 이에 this 값을 미리 저장해놓는 모습이다.



```javascript
const relationship2 = {
    name: 'kim',
    friends: ['a', 'b', 'c'],
    logFriends() {
        this.friends.forEach(friend => {
            console.log(this.name, friend);
        });
    },
};
relationship2.logFriends();
```



이번에는 forEach문에서 function을 선언하지 않고 화살표 함수를 사용했다. 

따라서 바로 바깥 스코프인 `logFriends()`의 **this를 그대로 사용이 가능한 상황**입니다. 이런 상황에서는 function 대신 화살표 함수를 사용하면서 따로 바깥 스코프의 this를 저장해놓고 불러오지 않아도 되서 편리하다.





### 5. 비구조화 할당

---

객체나 배열에서 속성 혹은 요소를 꺼내올때 사용한다.



- #### 기존 코드

```javascript
var candyMachine = {
    status: {
        name: 'node',
        count: 5,
    },
    getCandy: function(){
        this.status.count--;
        return this.status.count;
    }
};
 
var getCandy = candyMachine.getCandy;
var count = candyMachine.status.count;
```

기존에는 객체에서 속성을 가져올 때 이처럼 작성했다.



```javascript
const candyMachine1 = {
    status: {
        name: 'node',
        count1: 5,
    },
    getCandy1() {
        this.status.count--;
        return this.status.count;
    }
};
 
const { getCandy1, status: { count1 } } = candyMachine1;
```

하지만 이처럼 간단하게 한 줄로 나타내는 것이 가능해졌다. 여러 단계 안의 속성도 count1을 가져오는 것처럼 작성이 가능하다.



이 뿐만 아니라, 배열에서도 마찬가지로 적용이 가능하다.

```javascript
var array = ['nodejs', {}, 10, true];
var node = array[0];
var obj = array[1];
var bool = array[array.length - 1];
```



array라는 배열 안에 4가지 요소를 넣고 가져오는 모습을 확인할 수 있다.



```javascript
const array1 = ['nodejs', {}, 10, true];
const [node, obj, , bool] = array1;
```



bool은 true를 가져오기 위해 배열의 마지막 부분에 작성한 걸 볼 수 있다. 이처럼 작성하면 맨 끝이라고 자동으로 인식해주니 상당히 편한 장점이 있다.



이처럼 **비구조화 할당**을 이용하면, 배열이 위치마다 변수를 넣어 똑같은 역할을 하도록 만들 수 있다. 코드 줄도 상당히 줄일 수 있고, 특히 `Node.js`에서는 모듈을 사용하기 때문에 이런 방식이 많이 사용된다고 한다.





### 6. 프로미스(promise)

---

자바스크립트와 Node는 **비동기 프로그래밍으로 이벤트 주도 방식을 활용**하면서 콜백 함수를 많이 사용하게 된다. 콜백 함수 자체가 복잡한 것도 있고, 이해하기 어려운 자바스크립트 내용 중 하나이기도 하다.



이에 ES2015부터는 콜백 대신 API들이 프로미스 기반으로 재구성되고 있다. 따라서 프로미스에 대해 잘 이해하고 사용하게 된다면, 복잡한 콜백 함수의 지옥에서 벗어날 수 있으니 확실히 알고 있어야 한다.



promise 객체 구조는 아래와 같다.

```javascript
const condition = true;
 
const promise = new Promise((resolve, reject) => {
    if (condition){
        resolve('성공');
    } else {
        reject('실패');
    }
});
 
promise
    .then((message) => {
        console.log(message);
    })
    .catch((error) => {
        console.log(error);
    });
```



`new Promise`로 프로미스를 생성할 수 있다. 그리고 안에 `resolve와 reject`를 매개변수로 갖는 콜백 함수를 넣는 방식이다.

이제 선언한 promise 변수에 `then과 catch` 메서드를 붙이는 것이 가능하다. 

```
resolve가 호출되면 then이 실행되고, reject가 호출되면 catch가 실행된다.
```

이제 resolve와 reject에 넣어준 인자는 각각 then과 catch의 매개변수에서 받을 수 있게 되었다. 

즉, condition이 true가 되면 resolve('성공')이 호출되어 message에 '성공'이 들어가 log로 출력된다. 반대로 false면 reject('실패')가 호출되어 catch문이 실행되고 error에 '실패'가 되어 출력될 것이다.



이제 이러한 방식을 활용해 콜백을 프로미스로 바꿔보자.

```javascript
function findAndSaveUser(Users) {
    Users.findOne({}, (err, user) => { // 첫번째 콜백
        if(err) {
            return console.error(err);
        }
        user.name = 'kim';
        user.save((err) => { // 두번째 콜백
            if(err) {
                return console.error(err);
            }
            Users.findOne({gender: 'm'}, (err, user) => { // 세번째 콜백
                // 생략
            });
        });
    });
}
```



보통 콜백 함수를 사용하는 패턴은 이와 같이 작성할 것이다. **현재 콜백 함수가 세 번 중첩**된 모습을 볼 수 있다.

즉, 콜백 함수가 나올때 마다 코드가 깊어지고 각 콜백 함수마다 에러도 따로 처리해주고 있다.



프로미스를 활용하면 아래와 같이 작성이 가능하다.

```javascript
function findAndSaveUser1(Users) {
    Users.findOne({})
        .then((user) => {
            user.name = 'kim';
            return user.save();
        })
        .then((user) => {
            return Users.findOne({gender: 'm'});
        })
        .then((user) => {
            // 생략
        })
        .catch(err => {
            console.error(err);
        });
}
```



`then`을 활용해 코드가 깊어지지 않도록 만들었다. 이때, then 메서드들은 순차적으로 실행된다. 

에러는 마지막 catch를 통해 한번에 처리가 가능하다. 하지만 모든 콜백 함수를 이처럼 고칠 수 있는 건 아니고, `find와 save` 메서드가 프로미스 방식을 지원하기 때문에 가능한 상황이다.

> 지원하지 않는 콜백 함수는 `util.promisify`를 통해 가능하다.



프로미스 여러개를 한꺼번에 실행할 수 있는 방법은 `Promise.all`을 활용하면 된다.

```javascript
const promise1 = Promise.resolve('성공1');
const promise2 = Promise.resolve('성공2');
 
Promise.all([promise1, promise2])
    .then((result) => {
        console.log(result);
    })
    .catch((error) => {
        console.error(err);
    });
```



`promise.all`에 해당하는 모든 프로미스가 resolve 상태여야 then으로 넘어간다. 만약 하나라도 reject가 있다면, catch문으로 넘어간다.

기존의 콜백을 활용했다면, 여러번 중첩해서 구현했어야하지만 프로미스를 사용하면 이처럼 깔끔하게 만들 수 있다.





### 7. async/await

---

ES2017에 추가된 최신 기능이며, Node에서는 7,6버전부터 지원하는 기능이다. Node처럼 **비동기 프로그래밍을 할 때 유용하게 사용**되고, 콜백의 복잡성을 해결하기 위한 **프로미스를 조금 더 깔끔하게 만들어주는 도움**을 준다.



이전에 학습한 프로미스 코드를 가져와보자.

```javascript
function findAndSaveUser1(Users) {
    Users.findOne({})
        .then((user) => {
            user.name = 'kim';
            return user.save();
        })
        .then((user) => {
            return Users.findOne({gender: 'm'});
        })
        .then((user) => {
            // 생략
        })
        .catch(err => {
            console.error(err);
        });
}
```



콜백의 깊이 문제를 해결하기는 했지만, 여전히 코드가 길긴 하다. 여기에 `async/await` 문법을 사용하면 아래와 같이 바꿀 수 있다.



```javascript
async function findAndSaveUser(Users) {
    try{
        let user = await Users.findOne({});
        user.name = 'kim';
        user = await user.save();
        user = await Users.findOne({gender: 'm'});
        // 생략
 
    } catch(err) {
        console.error(err);
    } 
}
```



상당히 짧아진 모습을 볼 수 있다.

function 앞에 `async`을 붙여주고, 프로미스 앞에 `await`을 붙여주면 된다. await을 붙인 프로미스가 resolve될 때까지 기다린 후 다음 로직으로 넘어가는 방식이다.



앞에서 배운 화살표 함수로 나타냈을 때 `async/await`을 사용하면 아래와 같다.

```javascript
const findAndSaveUser = async (Users) => {
    try{
        let user = await Users.findOne({});
        user.name = 'kim';
        user = await user.save();
        user = await user.findOne({gender: 'm'});
    } catch(err){
        console.error(err);
    }
}
```



화살표 함수를 사용하면서도 `async/await`으로 비교적 간단히 코드를 작성할 수 있다. 

예전에는 중첩된 콜백함수를 활용한 구현이 당연시 되었지만, 이제 그런 상황에 `async/await`을 적극 활용해 작성하는 연습을 해보면 좋을 것이다.



<br>

<br>

#### [참고 자료]

- [링크 - Node.js 도서](http://www.yes24.com/Product/Goods/62597864)