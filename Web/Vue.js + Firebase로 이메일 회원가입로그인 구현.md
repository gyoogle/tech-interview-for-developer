## Vue.js + Firebase로 이메일 회원가입/로그인 구현

***2019.07.08 (김규석)***

<br>

Vue.js와 Firebase를 통한 이메일 로그인을 구현해보자~

<br>

우선 설치해야할 것

```
$ npm -i -g @vue/cli
$ npm -i -g @vue/cli-init
```

> @vue/cli-init은 2.0버전을 사용하기 위한 설치!

<br>

vue-cli는 템플릿 기반 프로젝트 초기 구성을 간편하게 할 수 있도록 도와준다!

<br>

### 프로젝트 생성

```
$ vue init webpack "프로젝트 이름"
```

이름과 같은 환경설정을 해주면 vue 프로젝트가 생성된다.

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/vue%20init.JPG?raw=true">

<br>

이제 해당 경로로 들어가서 npm 설치를 진행한다.

```
$ cd "프로젝트 이름"
$ npm install
```

> 만약 npm install 후에 `vulnerabilities` 알림이 뜨면, npm audit fix를 통해 충돌나는 부분에 대한 문제를 해결하자

<br>

이제 npm 설치가 끝났으니 프로젝트를 실행해보자

```
$ npm run dev
```

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/run%20%ED%99%94%EB%A9%B4.JPG?raw=true">

<br>

화면이 잘 나온다! 순조롭게 잘 실행했다는 뜻~

<br>

현재 만들어진 기본적인 Vue.js 파일 구조를 이해하지 못한 사람은 먼저 구조를 이해하고 다음 과정을 진행합시다.

<br>

<br>

### vue-router 활용하기

회원가입과 로그인 과정을 진행하기 위해, 3개의 view에 해당하는 컴포넌트를 src/components 폴더 아래에 만들고 vue-router를 통해 이동해볼 것이다.

- Login 컴포넌트 : 로그인 하는 곳
- Signup 컴포넌트 : 회원가입 하는 곳
- Show 컴포넌트 : 로그인해야 볼 수 있는 곳 (기존의 HelloWorld.vue)

<br>

<br>









#### 로그인 구현

---

src/components에 Login.vue를 만들자

```vue
<template>
  <div class="login">
    <h3>Login</h3>
    <input type="text" placeholder="email"><br>
    <input type="password" placeholder="password"><br>
    <button>로그인</button>
    <p>만약 계정이 없다면, 회원가입을 먼저 진행해주세요!</p>
  </div>
</template>

<script>
  export default {
    name: 'login',
    data() {
      return {
      }
    },
    methods: {}
  }
</script>

<style scoped>
  .login {
    margin-top: 40px;
  }
  input {
    margin: 10px 0;
    width: 20%;
    padding: 15px;
  }
  button {
    margin-top: 20px;
    width: 10%;
    cursor: pointer;
  }
  p {
    margin-top: 40px;
    font-size: 15px;
  }
  p a {
    text-decoration: underline;
    cursor: pointer;
  }
</style>
```

<br>

이제 로그인을 router/index.js에 라우터를 추가해주자.

```javascript
import Vue from 'vue'
import Router from 'vue-router'

import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
```



> url 중간에 "#"을 지우기 위해서는 라우터에서 mode: 'history'를 위와 같이 추가해주면 된다.

<br>

이제 <http://localhost:8080/login>로 접속하면 아래와 같은 로그인 화면이 나온다.

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/login.JPG?raw=true">

style을 적용시켜서 이쁘게 화면을 구현시킬 수 있다ㅎㅎ

<br>

#### 회원가입 구현

---

로그인처럼 같은 방식으로 회원가입에 해당하는 컴포넌트와 라우터 연결을 진행해보자

##### src/components/SignUp.vue

```vue
<template>
  <div class="sign-up">
    <p>회원가입</p>
    <input type="text" placeholder="email"><br>
    <input type="password" placeholder="password"><br>
    <button>가입하기</button>
    <span>또는 로그인으로 돌아가기</span>
  </div>
</template>

<script>
  export default {
    name: 'signUp',
    data() {
      return {
      }
    },
    methods: {}
  }
</script>

<style scoped>
  .signUp {
    margin-top: 40px;
  }
  input {
    margin: 10px 0;
    width: 20%;
    padding: 15px;
  }
  button {
    margin-top: 20px;
    width: 10%;
    cursor: pointer;
  }
  p {
    margin-top: 40px;
    font-size: 20px;
  }
  span {
    display: block;
    margin-top: 20px;
    font-size: 15px;
  }
</style>
```

<br>

##### router/index.js

```javascript
import Vue from 'vue'
import Router from 'vue-router'

import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import SignUp from '@/components/SignUp'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/signup',
      name: 'SignUp',
      component: SignUp
    }
  ]
})
```

<br>

이제 <http://localhost:8080/signup> 경로로 들어가면 아래와 같이 회원가입 창이 잘 나오는 것을 확인할 수 있다.

<br>

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/signup.JPG?raw=true">

<br>

<br>

### 컴포넌트간 이동하기

---

컴포넌트와 컴포넌트간 이동을 하기 위해서는 `router-link`를 사용한다.



로그인과 회원가입 vue 폴더에서 서로 이동하도록 link를 사용해보자

##### Login.vue

```vue
<template>
  <div class="login">
    <h3>Login</h3>
    <input type="text" placeholder="email"><br>
    <input type="password" placeholder="password"><br>
    <button>로그인</button>
    <p>만약 계정이 없다면, <router-link to="/signup">회원가입</router-link>을 먼저 진행해주세요!</p>
  </div>
</template>
```

##### SignUp.vue

```vue
<template>
  <div class="sign-up">
    <p>회원가입</p>
    <input type="text" placeholder="email"><br>
    <input type="password" placeholder="password"><br>
    <button>가입하기</button>
    <span>또는 <router-link to="/login">로그인</router-link>으로 돌아가기</span>
  </div>
</template>
```

이처럼 link 태그에 to="/경로"를 통해 컴포넌트 이동이 가능하다.

다시 화면으로 돌아가면, a태그와 같이 링크가 걸려있고 클릭 시 컴포넌트가 잘 이동되는 것을 확인할 수 있을 것이다.

<br>

<br>



현재는 인증 단계가 진행되지 않은 상태이므로, 로그인이 완료되었을 때 helloWorld.vue 화면으로 이동이 되도록만 replace 메소드를 적용시켜보자

##### Login.vue

```vue
<template>
  <div class="login">
    <h3>Login</h3>
    <input type="email" placeholder="email"><br>
    <input type="password" placeholder="password"><br>
    <button v-on:click="login">로그인</button>
    <p>만약 계정이 없다면, <router-link to="/signup">회원가입</router-link>을 먼저 진행해주세요!</p>
  </div>
</template>

<script>
  export default {
    name: 'login',
    data() {
      return {
      }
    },
    methods: {
      login() {
        this.$router.replace('hello')
      }
    }
  }
</script>

<style scoped>
 ...
</style>
```

로그인 button에 `v-on:click`을 통해 버튼을 눌렀을 때 login() 메소드가 실행되도록 해둔 상태다. methods에서 구현한 login 메소드가 실행되며, hello라는 경로를 가진 페이지로 이동하는 메소드다.



현재 hello라는 경로가 없기 때문에, 기존의 root 경로를 hello로 변경해주자

```javascript
import Vue from 'vue'
import Router from 'vue-router'

import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import SignUp from '@/components/SignUp'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/signup',
      name: 'SignUp',
      component: SignUp
    }
  ]
})
```

root 경로의 path를 `/`에서 `/hello`로 변경했다.

이제 로그인 창에서 이메일과 패스워드를 입력 후 로그인을 누르면 HelloWorld.vue로 이동하는 것을 확인할 수 있을 것이다.

<br>

<br>









### 파이어베이스 연동

---

프론트 구현은 끝났다. 이제 가장 중요한 파이어베이스 연동이다.



파이어베이스를 사용하기 위해, 파이어베이스 콘솔에서 새로운 프로젝트를 생성하자

[파이어베이스 콘솔 링크](<https://console.firebase.google.com/>)



#### 프로젝트 추가

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/%ED%8C%8C%EC%9D%B4%EC%96%B4%EB%B2%A0%EC%9D%B4%EC%8A%A4%20%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EC%B6%94%EA%B0%80.JPG?raw=true">

프로젝트 추가버튼 클릭

<br>

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/%ED%8C%8C%EC%9D%B4%EC%96%B4%EB%B2%A0%EC%9D%B4%EC%8A%A4%20%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EC%B6%94%EA%B0%802.JPG?raw=true">

<br>

이제 파이어베이스 프로젝트 생성이 완료되었다.

해당 프로젝트에 들어가면 코드 스니펫 모양이 있는데, 웹 앱을 추가하는 곳이다. 클릭해서 웹 앱에 파이어베이스를 추가하자

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/%EC%9B%B9%EC%95%B1%20%EC%B6%94%EA%B0%80.JPG?raw=true">

앱 닉네임을 정하고, 등록을 누르면 스크립트가 나올 것이다.

이 스크립트에 있는 config를 우리 vue 프로젝트에 적용시킬 것이다.

<br>

```javascript
var firebaseConfig = {
    apiKey: "개인 API KEY",
    authDomain: "개인 프로젝트 ID.firebaseapp.com",
    databaseURL: "https://vue-firebase-tutorial-da26f.firebaseio.com",
    projectId: "vue-firebase-tutorial-da26f",
    storageBucket: "",
    messagingSenderId: "173286603007",
    appId: "1:173286603007:web:2258c081f9102650"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
```

코드 중에서 이 부분만 가져와서 활용할 것이다.

<br>

적용시키기 전에 터미널에서 firebase를 설치하자

```
$ npm install --save firebase
```

설치가 끝나면, main.js 파일에다 Firebase를 아래와 같이 적용시키자

<br>

```javascript
import Vue from 'vue'
import App from './App'
import router from './router'
import firebase from 'firebase'

Vue.config.productionTip = false

var firebaseConfig = {
    apiKey: "개인 API KEY",
    authDomain: "개인 프로젝트 ID.firebaseapp.com",
    databaseURL: "https://vue-firebase-tutorial-da26f.firebaseio.com",
    projectId: "vue-firebase-tutorial-da26f",
    storageBucket: "",
    messagingSenderId: "173286603007",
    appId: "1:173286603007:web:2258c081f9102650"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
```

<br>

<br>

#### 회원가입 컴포넌트에서 파이어베이스 사용자 생성하기

---

이제 회원가입을 통해 가입한 사용자 데이터를 파이어베이스에게 전송해줘야 한다.

회원가입 시 필요한 email과 password를 받아서 전송해야 하는데, **양방향 데이터 바인딩을 지원하는 v-model을 활용**하자

```vue
<input type="text" v-model="email" placeholder="email"><br>
<input type="password" v-model="password" placeholder="password"><br>
<button v-on:click="signUp">가입하기</button>
```

> 이처럼 회원가입의 template에서 v-model과 메소드를 실행할 v-on을 추가한다.

<br>

##### signUp() 메소드 구현

```vue
<script>
  import firebase from 'firebase'

  export default {
    name: 'signUp',
    data() {
      return {
        email: '',
        password: ''
      }
    },
    methods: {
      signUp() {
        firebase.auth().createUserWithEmailAndPassword(this.email, this.password).then(
          function(user) {
            alert('회원가입 완료!')
          },
          function(err) {
            alert('에러 : ' + err.message)
          }
        );
      }
    }
  }
</script>
```

createUserWithEmailAndPassword 메소드는 onResolve, onReject 콜백과 파이어베이스의 프로미스를 반환해준다.

<br>

<br>

#### 파이어베이스 로그인 공급자 활성화시키기

---

다시 파이어베이스 콘솔로 돌아가자

왼쪽 사이드바를 열고, DEVELOP의 Authentication으로 들어간다.

<br>

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/authentication.JPG?raw=true">

로그인 방법으로 들어가서 `이메일/비밀번호`를 활성화 시킨다.

<br>

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/%ED%99%9C%EC%84%B1%ED%99%94.JPG?raw=true">

사용 설정됨으로 표시되면, 이제 사용자 가입 시 파이어베이스에 저장이 가능하다!

<br>

회원가입 view로 가서 이메일과 비밀번호를 입력하고 가입해보자

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%EC%84%B1%EA%B3%B5.JPG?raw=true">



회원가입이 정상적으로 완료되었다는 alert가 뜬다. 진짜 파이어베이스에 내 정보가 저장되어있나 확인하러 가보자

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/%EC%82%AC%EC%9A%A9%EC%9E%90%ED%99%95%EC%9D%B8.JPG?raw=true">

오오..사용자 목록을 눌러보면, 내가 가입한 이메일이 나오는 것을 확인할 수 있다.

이제 다음 진행은 당연히 뭘까? 내가 로그인할 때 **파이어베이스에 등록된 이메일과 일치하는 비밀번호로만 진행**되야 된다.

<br>

<br>

#### 사용자 로그인

회원가입 시 진행했던 것처럼 v-model 설정과 로그인 버튼 클릭 시 진행되는 메소드를 파이어베이스의 signInWithEmailAndPassword로 수정하자

```vue
<template>
  <div class="login">
    <h3>Login</h3>
    <input type="text" v-model="email" placeholder="email"><br>
    <input type="password" v-model="password" placeholder="password"><br>
    <button v-on:click="login">로그인</button>
    <p>만약 계정이 없다면, <router-link to="/signup">회원가입</router-link>을 먼저 진행해주세요!</p>
  </div>
</template>

<script>
  import firebase from 'firebase'

  export default {
    name: 'login',
    data() {
      return {
        email: '',
        password: ''
      }
    },
    methods: {
      login() {
        firebase.auth().signInWithEmailAndPassword(this.email, this.password).then(
          function(user) {
            alert('로그인 완료!')
          },
          function(err) {
            alert('에러 : ' + err.message)
          }
        );
      }
    }
  }
</script>
```

이제 다 끝났다.

로그인을 진행해보자! 우선 비밀번호를 제대로 입력하지 않고 로그인해본다

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8%20%EB%B6%88%EC%9D%BC%EC%B9%98%EC%8B%9C.JPG?raw=true">

에러가 나오면서 로그인이 되지 않는다!

<br>

다시 제대로 비밀번호를 치면?!

<img src="https://github.com/kim6394/Dev_BasicKnowledge/blob/master/screenshot/%EB%A1%9C%EA%B7%B8%EC%9D%B8%20%EC%84%B1%EA%B3%B5.JPG?raw=true">

제대로 로그인이 되는 것을 확인할 수 있다.

<br>

이제 로그인이 되었을 때 보여줘야 하는 화면으로 이동을 하거나 로그인한 사람이 관리자면 따로 페이지를 구성하거나를 구현하고 싶은 계획에 따라 만들어가면 된다. 끝~~