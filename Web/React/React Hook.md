# React Hook 

> useState(), useEffect() 정의

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcbKGwj%2FbtqC5pwunG7%2FYkaJ6YKK5YSESx7Gs2x410%2Fimg.jpg">

<br>

리액트의 Component는 '클래스형'과 '함수형'으로 구성되어 있다.

기존의 클래스형 컴포넌트에서는 몇 가지 어려움이 존재한다.

1. 상태(State) 로직 재사용 어려움
2. 코드가 복잡해짐
3. 관련 없는 로직들이 함께 섞여 있어 이해가 힘듬

이와 같은 어려움을 해결하기 위해, 'Hook'이 도입되었다. (16.8 버전부터)

<br>

### Hook

- 함수형 컴포넌트에서 State와 Lifecycle 기능을 연동해주는 함수
- '클래스형'에서는 동작하지 않으며, '함수형'에서만 사용 가능

<br>

#### useState

기본적인 Hook으로 상태관리를 해야할 때 사용하면 된다.

상태를 변경할 때는, `set`으로 준 이름의 함수를 호출한다. 

```jsx
const [posts, setPosts] = useState([]); // 비구조화 할당 문법
```

`useState([]);`와 같이 `( )` 안에 초기화를 설정해줄 수 있다. 현재 예제는 빈 배열을 만들어 둔 상황인 것이다.

<br>

#### useEffect

컴포넌트가 렌더링 될 때마다 특정 작업을 수행하도록 설정할 수 있는 Hook

> '클래스' 컴포넌트의 componentDidMount()와 componentDidUpdate()의 역할을 동시에 한다고 봐도 된다.

```jsx
useEffect(() => {
    console.log("렌더링 완료");
    console.log(posts);
});
```

posts가 변경돼 리렌더링이 되면, useEffect가 실행된다.

<br>

<br>

#### [참고자료]

- [링크](https://ko.reactjs.org/docs/hooks-intro.html)
