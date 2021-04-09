
# 데이터 타입

자바스크립트의 데이터 타입은 크게 Primitive type, Structural Type, Structural Root Primitive 로 나눌 수 있다.

- Primitive type
    - undefined : typeof instance === 'undefined'
    - Boolean : typeof instance === 'boolean'
    - Number : typeof instance === 'number'
    - String : typeof instance === 'string'
    - BitInt : typeof instance === 'bigint'
    - Symbol : typeof instance === 'symbol'
- Structural Types
    - Object : typeof instance === 'object'
    - Fuction : typeof instance === 'fuction'
- Structural Root Primitive
    - null : typeof instance === 'obejct'

기본적인 것은 설명하지 않으며, 놓칠 수 있는 부분만 설명하겠다.

### Number Type

ECMAScript Specification을 참조하면 number type은 double-precision 64-bit binary 형식을 따른다. 

아래 예제를 보자

```jsx
console.log(1 === 1.0); // true
```

즉 number type은 모두 실수로 처리된다.

### BigInt Type

BigInt type은 number type의 범위를 넘어가는 숫자를 안전하게 저장하고 실행할 수 있게 해준다. BitInt는 n을 붙여 할당할 수 있다.

```jsx
const x = 2n ** 53n;
9007199254740992n
```

### Symbol Type

Symbol Type은 **unique**하고 **immutable** 하다. 이렇나 특성 때문에 주로 이름이 충돌할 위험이 없는 obejct의 유일한 property key를 만들기 위해서 사용된다.

```jsx
var key = Symbol('key');

var obj = {};

obj[key] = 'test';
```

## 데이터 타입의 필요성

```jsx
var score = 100;
```

위 코드가 실행되면 자바스크립트 엔진은 아래와 같이 동작한다.

1. score는 특정 주소 addr1를 가르키며 그 값은 undefined 이다.
2. 자바스크립트 엔진은 100이 number type 인 것을 해석하여 addr1와는 다른 주소 addr2에 8바이트의 메모리 공간을 확보하고 값 100을 저장하며 score는 addr2를 가르킨다. (할당)

만약 값을 참조할려고 할 떄에도 한 번에 읽어야 할 메모리 공간의 크기(바이트 수)를 알아야 한다. 자바스크립트 엔진은 number type의 값이 할당 되어있는 것을 알기 때무네 8바이트 만큼 읽게 된다.

정리하면 데이터 타입이 필요한 이유는 다음과 같다.

- 값을 저장할 때 확보해야 하는 메모리 공간의 크기를 결정하기 위해
- 값을 참조할 때 한 번에 읽어 들여야 할 메모리 공간의 크기를 결정하기 위해
- 메모리에서 읽어 들인 2진수를 어떻게 해석할지 결정하기 위해