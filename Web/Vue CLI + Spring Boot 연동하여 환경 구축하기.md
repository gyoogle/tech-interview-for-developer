## Vue CLI + Spring Boot 연동하여 환경 구축하기



<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fb2Pobh%2Fbtqwtl6pmaF%2F0fITFNedrPMn9uaEj8RrJK%2Fimg.png">

<br>

프론트엔드는 Vue.js로, 백엔드는 Spring Boot를 이용해서 프로젝트를 진행하려고 한다.

스프링에서 Jsp를 통해 view를 구축해봤지만, 이번엔 Vue.js를 활용해서 View를 모두 넘겨주려고 한다.

<br>

스프링에서 컨트롤러를 통해 DB 관리나 데이터에 관한 비즈니스 로직을 잘 처리하고, 이에 대한 값을 활용해 Vue에서 화면으로 뿌려줄 탬플릿을 만들어나가는 진행 방식이 되지 않을까 생각된다.

<br>

개발 툴은 VS Code로 진행한다.

[VS Code 다운로드](https://code.visualstudio.com/download)

<br>

Java와 Node.js도 기본적으로 깔린 상태여야 한다.

[Node.js 다운로드](https://nodejs.org/ko/download/)

<br>

<br>

VS Code를 열고, 자신이 프로젝트를 생성할 폴더로 들어가자 (File → Open Folder)

<br>

시작하기에 앞서, VS Code에서 필요한 플러그인을 설치한다.

왼쪽 메뉴탭에서 Extensions(단축키 : Ctrl + Shift + X)를 누르고, 검색창에서 아래 3가지를 입력 후 install 한다.

```
1. Vetur
2. Java IDE Pack
3. Lombok
```

<br>

<br>

#### VS Code 한글 인코딩

현재 상태로는 VS Code에서 한글을 인식해주지 않는다. 인코딩을 따로 해줘야한다.

<br>

File → Preferences → Settings로 들어간다.

위의 검색창에 'settings.json'을 검색하면 아래와 같이 Edit할 수 있는 링크가 뜬다.

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FWSVv1%2Fbtqwr5pWRwm%2Fyx95AKviDEKtXNruHkwowK%2Fimg.png">

<br>

json 파일이 나오게 되는데, 이곳에서 'java.jdt.ls.vmargs'를 찾는다.

<br>

이곳에 value 값으로 '-Dfile.encoding=utf-8'를 추가해줘야한다.

추가 후에 java.jdt.ls.vmargs는 아래와 같이 될 것이다.

<br>

```
"java.jdt.ls.vmargs": "-Dfile.encoding=utf-8 -noverify -Xmx1G -XX:+UseG1GC -XX:+UseStringDeduplication -javaagent:\"lombok 경로~~"
```

<br>

<br>

### 프로젝트 구성하기

이제 프로젝트를 구성해보자!

<br>

#### 1.Spring Boot Project

<br>

먼저, 스프링 부트 프로젝트를 만든다. (우리는 스프링 부트 프로젝트 안에 Vue 프로젝트를 넣을 것이다)

프로젝트는 [Spring Initializr](https://start.spring.io/)을 이용할 것이다. 스프링 부트 프로젝트를 매우 쉽고 간편하게 만들어주는 곳이다.

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FTLnMo%2FbtqwrAw7TqQ%2FjBy8g9AOdUTh7cEVOhK4W0%2Fimg.png">

<br>

자신이 만들 프로젝트 목적에 맞게 설정해주면 된다.

Dependencies도 미리 추가해놓을 수 있다. (Web, JDBC, Lombok, MySQL 등)

나중에 따로 추가할 수 있으니 기억나는 것들만 지정해도 무방하다.

<br>

프로젝트 Metadata 부분은 생성할 프로젝트 패키지나 이름 등 옵션을 지정해줄 수 있다. 처음에는 demo로 되어있는데 자신이 만들고 싶은대로 수정할 수 있다.

<br>

마지막으로 'Generate the project' 버튼을 클릭하면, zip 파일로 프로젝트가 다운로드 된다. 해당 파일을 압축 해제하고 현재 VS Code에서 접속 중인 폴더에 복사하면 된다.

<br>

<br>

<br>

#### 2.Vue.js Project

<br>

이제 스프링 부트에서 Vue.js 프로젝트를 만들어보자. 프로젝트 생성은 Vue CLI를 이용할 것이다.

<br>

Vue CLI는 Vue.js 개발을 위한 시스템으로, Vue.js Core에서 공식적으로 제공하는 CLI다. 개발에 집중할 수 있도록 프로젝트 구성을 빠르고 쉽게 도와주는 역할을 하고 있다.

(따라서 반드시 이용해야 한다는 건 아니다. 다만 쉽게 구축할 수 있도록 만들어준거니 이용하면 편하다)

<br>

현재는 Vue CLI 버전 3가 나온 상태다. 2보다 더욱 편하고 많은 기능들을 제공한다고 하지만, 많은 정보가 없어서 일단 2로 진행하고자 한다.

<br>

Node.js를 설치한 상태기 때문에, npm을 통해 터미널에서 Vue CLI 설치가 가능하다.

<br>

VS Code에서 터미널을 열고, 아래와 같이 설치를 진행하자

```
$ npm i -g @vue/cli
$ npm i -g @vue/cli-init
```

@vue/cli-init은 2버전 템플릿을 가져오기 위한 vue init을 제공해준다.

이제 필요한 설치는 끝났다! Vue 프로젝트를 만들어보자. 이름은 그냥 frontend로 생성했다.

<br>

(현재 프로젝트 생성은, 스프링 부트 루트 폴더 위치에서 진행하는 것이다.)

```
$ vue init webpack frontend
```

<br>

몇가지 설정하는 부분이 나온다.

<br>

> Project name
>
> Project description
>
> Author

<br>

이 3가지는 자신의 프로젝트에 맞게 작성해주면 된다.

> Vue build는 standalone
>
> vue-router는 설치(Yes)
>
> Use ESLint to lint your code도 Yes
>
> ESLint preset은 Standard

<br>

그 이후 test부분은 진행할 사람들은 Yes, 안할사람은 No로 넘어가면 된다.

터미널 창에서 열심히 파일들이 다운로드되는 모습을 볼 수 있다. (시간 조금 걸림)

<br>

끝나면 스프링부트 루트 폴더에 'frontend'라는 Vue 프로젝트 폴더가 생성된 모습을 확인할 수 있다.

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2F0543k%2Fbtqwq5xDdXA%2F9jkKem7iR2QXlo9C3SYbk0%2Fimg.png">

<br>

<br>

#### Webpack 번들링 output 설정

<br>

Vue에서 작성한 코드들을 번들링하고, 이 결과를 어느 위치에서 뽑아낼 지 정해야 한다.

<br>

Spring Boot에서는 자동설정으로 src/main/resources에 번들링한 결과들을 저장하도록 되어있다.

(이곳에 index.html과 정적 파일(css, img, javascript)들이 인식됨)

<br>

이 구역에 잘 번들링 될 수 있도록, Vue 프로젝트에서 경로 지정을 해주자.

config/index.js을 열어 build 부분에 정의한 곳을 수정해야 한다.

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FypIZ4%2FbtqwrRyGxV2%2F6kBWA8wH0C3CKECs9ITy40%2Fimg.png">

<br>

해당 위치에 절대 경로로 위와 같이 수정해준다.

<br>

이제 터미널에서 'npm run build' 커맨드를 입력하여 빌드를 실행한다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FbdPbwS%2FbtqwrBbLXZE%2FSK29p5xKxGDkZ3cNZ5al6K%2Fimg.png">

이제 Spring Boot의 src/main/resources/static 경로에 들어가보면, 번들링 된 정적 파일들이 생성된 모습을 확인할 수 있다.

<br>

이제 스프링 부트 애플리케이션을 실행해보자

.vscode 폴더의 launch.json에 들어가서 F5키를 누르면 스프링 부트 서버가 실행된다.

<br>

???

에러가 뜰 것이다.

```

***************************
APPLICATION FAILED TO START
*************************** 
Description: 
Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured. 

Reason: Failed to determine a suitable driver class

```

datasource 내용이 없어서 뜬 에러다.

<br>

스프링부트에서 프로젝트를 생성할 때, application.properties 파일이 자동생성되나 확인해보면 빈 파일일 것이다.

사용자가 원하는 데이터베이스를 선택하고, 그에 맞는 드라이버 라이브러리 설치와 jdbc 설정을 직접 해야한다.

<br>

이 공간이 비어있기 때문에 서버가 실행을 하고 있지 못하는 것이다. 현재는 어떤 데이터베이스를 지정할 지 결정이 되있는 상태가 아니기 때문에 스프링 부트의 메인 클래스에서 어노테이션을 추가해주자

<br>


 ```

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

 ```

이를 추가한 메인 클래스는 아래와 같이 된다.

<br>

```java
package com.example.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

}
```

<br>

이제 다시 스프링 부트 메인 애플리케이션을 실행하면, 디버깅 창에서 에러가 없어진 걸 확인할 수 있다.

<br>

이제 localhost:8080/으로 접속하면, Vue에서 만든 화면이 잘 나오는 것을 확인할 수 있다.

<br>

 <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FHGlD8%2Fbtqwr6biQpm%2FXeCKMJsUr0HbcXiWa3S98K%2Fimg.png">

<br>

Vue.js에서 View에 필요한 템플릿을 구성하고, 스프링 부트에 번들링하는 과정을 통해 연동하는 과정을 완료했다!

<br>

<br>

