# [React] Fragment

<br>

```
JSX 파일 규칙상 return 시 하나의 태그로 묶어야한다.
이런 상황에 Fragment를 사용하면 쉽게 그룹화가 가능하다.
```

<br>

아래와 같이 Table 컴포넌트에서 Columns를 불렀다고 가정해보자

```JSX
import { Component } from 'React'
import Columns from '../Components'

class Table extends Component {
  render() {
    return (
      <table>
        <tr>
          <Columns />
        </tr>
      </table>
    );
  }
}
```

<br>

Columns 컴포넌트에서는 `<td> ~~ </td>`와 같은 element를 반환해야 유효한 테이블 생성이 가능할 것이다.

```jsx
import { Component } from 'React'

class Columns extends Component {
  render() {
    return (
      <div>
        <td>Hello</td>
        <td>World</td>
      </div>
    );
  }
}
```

여러 td 태그를 작성하기 위해 div 태그로 묶었다. (JSX 파일 규칙상 return 시 하나의 태그로 묶어야한다.)

이제 Table 컴포넌트에서 DOM 트리를 그렸을 때 어떻게 결과가 나오는지 확인해보자

<br>

```html
<table>
  <tr>
    <div>
      <td>Hello</td>
      <td>World</td>
    </div>
  </tr>
</table>
```

Columns 컴포넌트에서 div 태그로 묶어서 Table 컴포넌트로 보냈기 때문에 문제가 발생한다. 따라서 JSX파일의 return문을 무조건 div 태그로 묶는 것이 바람직하지 않을 수 있다.

이때 사용할 수 있는 문법이 바로 `Fragment`다.

```jsx
import { Component } from 'React'

class Columns extends Component {
  render() {
    return (
      <Fragment>
        <td>Hello</td>
        <td>World</td>
      </Fragment>
    );
  }
}
```

div 태그 대신에 Fragment로 감싸주면 문제가 해결된다. Fragment는 DOM트리에 추가되지 않기 때문에 정상적으로 Table을 생성할 수 있다.

<br>

Frament로 명시하지 않고, 빈 태그로도 가능하다.

```JSX
import { Component } from 'React'

class Columns extends Component {
  render() {
    return (
      <>
        <td>Hello</td>
        <td>World</td>
      </>
    );
  }
}
```

<br>

이 밖에도 부모, 자식과의 관계에서 flex, grid로 연결된 element가 있는 경우에는 div로 연결 시 레이아웃을 유지하는데 어려움을 겪을 수도 있다.

따라서 위와 같은 개발이 필요할 때는 Fragment를 적절한 상황에 사용하면 된다.

<br>

<br>

#### [참고 사항]

- [링크](https://velog.io/@dolarge/React-Fragment%EB%9E%80)