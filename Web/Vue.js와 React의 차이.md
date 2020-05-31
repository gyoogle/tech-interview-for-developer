## Vue.js와 React의 차이

<img src="https://miro.medium.com/max/704/1*tqpZoG9qMeVd9j7KhAnsBg.png">

<br>

##### 개발 CLI

- Vue.js : vue-cli
- React : create-react-app

##### CSS 파일 존재 유무

- Vue.js : 없음. style이 실제 컴포넌트 파일 안에서 정의됨
- React : 파일이 존재. 해당 파일을 통해 style 적용

##### 데이터 변이

- Vue.js : 반드시 데이터 객체를 생성한 이후 data를 업데이트 할 수 있음
- React : state 객체를 만들고, 업데이트에 조금 더 작업이 필요

```
name: kim 값을 lee로 바꾸려면
Vue.js : this.name = 'lee'
React : this.setState({name:'lee'})
```

Vue에서는 data를 업데이트할 때마다 setState를 알아서 결합해분다.

<br>

<br>



#### [참고 사항]

- [링크]( [https://medium.com/@erwinousy/%EB%82%9C-react%EC%99%80-vue%EC%97%90%EC%84%9C-%EC%99%84%EC%A0%84%ED%9E%88-%EA%B0%99%EC%9D%80-%EC%95%B1%EC%9D%84-%EB%A7%8C%EB%93%A4%EC%97%88%EB%8B%A4-%EC%9D%B4%EA%B2%83%EC%9D%80-%EA%B7%B8-%EC%B0%A8%EC%9D%B4%EC%A0%90%EC%9D%B4%EB%8B%A4-5cffcbfe287f](https://medium.com/@erwinousy/난-react와-vue에서-완전히-같은-앱을-만들었다-이것은-그-차이점이다-5cffcbfe287f) )
- [링크](https://kr.vuejs.org/v2/guide/comparison.html)

