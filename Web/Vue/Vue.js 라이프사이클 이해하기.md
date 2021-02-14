## Vue.js 라이프사이클 이해하기

<br>

무작정 프로젝트를 진행하면서 적용하다보니, 라이프사이클을 제대로 몰라서 애를 먹고있다. Vue가 가지는 라이프사이클을 제대로 이해하고 넘어가보자.

<br>

Vue.js의 라이프사이클은 크게 4가지로 나누어진다.

> Creation, Mounting, Updating, Destruction

<br>

<img src="https://miro.medium.com/max/700/1*tnSXRrpLBYmfHnIagITlcg.png">

<br>

### Creation

> 컴포넌트 초기화 단계

Creation 단계에서 실행되는 훅(hook)들이 라이프사이클 중 가장 먼저 실행됨

아직 컴포넌트가 DOM에 추가되기 전이며 서버 렌더링에서도 지원되는 훅임

<br>

클라이언트와 서버 렌더링 모두에서 처리해야 할 일이 있으면, 이 단계에 적용하자

<br>

- beforeCreate

  > 가장 먼저 실행되는 훅
  >
  > 아직 데이터나 이벤트가 세팅되지 않은 시점이므로 접근 불가능

- created

  > 데이터, 이벤트가 활성화되어 접근이 가능함
  >
  > 하지만 아직 템플릿과 virtual DOM은 마운트 및 렌더링 되지 않은 상태임

<br>

<br>

### Mounting

> DOM 삽입 단계

초기 렌더링 직전 컴포넌트에 직접 접근이 가능하다.

컴포넌트 초기에 세팅되어야할 데이터들은 created에서 사용하는 것이 나음

<br>

- beforeMount

  > 템플릿이나 렌더 함수들이 컴파일된 후에 첫 렌더링이 일어나기 직전에 실행됨
  >
  > 많이 사용하지 않음

- mounted

  > 컴포넌트, 템플릿, 렌더링된 DOM에 접근이 가능함
  >
  > 모든 화면이 렌더링 된 후에 실행

<br>

##### 주의할 점

부모와 자식 관계의 컴포넌트에서 생각한 순서대로 mounted가 발생하지 않는다. 즉, 부모의 mounted가 자식의 mounted보다 먼저 실행되지 않음

> 부모는 자식의 mounted 훅이 끝날 때까지 기다림

<br>

### Updating

> 렌더링 단계

컴포넌트에서 사용되는 반응형 속성들이 변경되거나 다시 렌더링되면 실행됨

디버깅을 위해 컴포넌트가 다시 렌더링되는 시점을 알고 싶을때 사용 가능

<br>

- beforeUpdate

  > 컴포넌트의 데이터가 변하여 업데이트 사이클이 시작될 때 실행됨
  >
  > (돔이 재 렌더링되고 패치되기 직전 상태)

- updated

  > 컴포넌트의 데이터가 변하여 다시 렌더링된 이후에 실행됨
  >
  > 업데이트가 완료된 상태이므로, DOM 종속적인 연산이 가능

<br>

### Destruction

> 해체 단계

<br>

- beforeDestory

  > 해체되기 직전에 호출됨
  >
  > 이벤트 리스너를 제거하거나 reactive subscription을 제거하고자 할 때 유용함

- destroyed

  > 해체된 이후에 호출됨
  >
  > Vue 인스턴스의 모든 디렉티브가 바인딩 해제되고 모든 이벤트 리스너가 제거됨

<br>

<br>



#### 추가로 사용하는 속성들

---



- computed

  > 템플릿에 데이터 바인딩할 수 있음
  >
  > ```vue
  > <div id="example">
  >   <p>원본 메시지: "{{ message }}"</p>
  >   <p>역순으로 표시한 메시지: "{{ reversedMessage }}"</p>
  > </div>
  > 
  > <script>
  >     new Vue({
  >       el: '#example',
  >       data: {
  >         message: '안녕하세요'
  >       },
  >       computed: {
  >         // 계산된 getter
  >         reversedMessage: function () {
  >           // `this` 는 vm 인스턴스를 가리킵니다.
  >           return this.message.split('').reverse().join('')
  >         }
  >       }
  >     })
  > </script>
  > ```
  >
  > message의 값이 바뀌면, reversedMessage의 값도 따라 바뀜

  <br>

  `Date.now()`와 같이 의존할 곳이 없는 computed 속성은 업데이트 안됨

  ```
  computed: {
    now: function () {
      return Date.now() //업데이트 불가능
    }
  }
  ```

  호출할 때마다 변경된 시간을 이용하고 싶으면 methods 이용

  <br>

- watch

  > 데이터가 변경되었을 때 호출되는 콜백함수를 정의
  >
  > watch는 감시할 데이터를 지정하고, 그 데이터가 바뀌면 어떠한 함수를 실행하라는 방식으로 진행



##### computed와 watch로 진행한 코드

```vue
//computed
<script>
    new Vue({
      el: '#demo',
      data: {
        firstName: 'Foo',
        lastName: 'Bar'
      },
      computed: {
        fullName: function () {
          return this.firstName + ' ' + this.lastName
        }
      }
    })
</script>
```

<br>

```vue
//watch
<script>
    new Vue({
      el: '#demo',
      data: {
        firstName: 'Foo',
        lastName: 'Bar',
        fullName: 'Foo Bar'
      },
      watch: {
        firstName: function (val) {
          this.fullName = val + ' ' + this.lastName
        },
        lastName: function (val) {
          this.fullName = this.firstName + ' ' + val
        }
      }
    })
</script>
```

<br>

computed는 선언형, watch는 명령형 프로그래밍 방식

watch를 사용하면 API를 호출하고, 그 결과에 대한 응답을 받기 전 중간 상태를 설정할 수 있으나 computed는 불가능

<br>

대부분의 경우 선언형 방식인 computed 사용이 더 좋으나, 데이터 변경의 응답으로 비동기식 계산이 필요한 경우나 시간이 많이 소요되는 계산을 할 때는 watch를 사용하는 것이 좋다.