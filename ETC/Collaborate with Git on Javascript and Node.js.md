## Javascript와 Node.js로 Git을 통해 협업하기

<br>

협업 프로젝트를 하기 위해서는 Git을 잘 써야한다. 

하나의 프로젝트를 같이 작업하면서 자신에게 주어진 파트에 대한 영역을 pull과 push 할 때 다른 팀원과 꼬이지 않도록 branch를 나누어 pull request 하는 등등..

협업 과정을 연습해보자

<br>

<br>

### Prerequisites

| Required                                                     | Description                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [Git](https://git-scm.com/)                                  | We follow the [GitHub Flow](https://guides.github.com/introduction/flow/) |
| [Node.js](https://github.com/stunstunstun/awesome-javascript/blob/master/nodejs.org) | 10.15.0 LTS                                                  |
| [Yarn](https://yarnpkg.com/lang/en/)                         | 1.12.3 or above                                              |

<br>

#### Git과 GitHub을 활용한 협업 개발

Git : 프로젝트를 진행할 때 소스 코드의 버전 관리를 효율적으로 처리할 수 있게 설계된 도구

GitHub : Git의 원격 저장소를 생성하고 관리할 수 있는 기능 제공함. 이슈와 pull request를 중심으로 요구사항을 관리

<br>

Git 저장소 생성

```
$ mkdir awesome-javascript
$ cd awesome-javascript
$ git init
```

<br>

GitHub 계정에 같은 이름의 저장소를 생성한 후, `git remote` 명령어를 통해 원격 저장소 추가

```
$ git remote add origin 'Github 주소'
```

<br>

#### GitHub에 이슈 등록하기

------

***이슈는 왜 등록하는거죠?***

코드 작성하기에 앞서, 요구사항이나 해결할 문제를 명확하게 정의하는 것이 중요

GitHub의 이슈 관리 기능을 활용하면 협업하는 동료와 쉽게 공유가 가능함

<br>

GitHub 저장소의 `Issues 탭에서 New issue를 클릭`해서 이슈를 작성할 수 있음

<br>

이슈와 pull request 요청에 작성하는 글의 형식을 템플릿으로 관리할 수 있음

(템플릿은 마크다운 형식)

<br>

##### 숨긴 폴더인 .github 폴더에서 이슈 템플릿과 pull request 템플릿을 관리하는 방법

> devops/github-templates 브랜치에 템플릿 파일을 생성하고 github에 푸시하자

```
$ git checkout -b devops/github-templates
$ mkdir .github
$ touch .github/ISSUE_TEMPLATE.md # Create issue template
$ touch .github/PULL_REQUEST_TEMPLATE.md # Create pull request template
$ git add .
$ git commit -m ':memo: Add GitHub Templates'
$ git push -u origin devops/github-templates
```

<br>

<br>

#### Node.js와 Yarn으로 개발 환경 설정하기

------

오늘날 javascript는 애플리케이션 개발에 많이 사용되고 있다.

이때 git을 활용한 협업 환경뿐만 아니라 코드 검증, 테스트, 빌드, 배포 등의 과정에서 만나는 문제를 해결할 수 있는 개발 환경도 설정해야 한다.

> 이때 많이 사용하는 것이 Node.js와 npm, yarn

<br>

**Node.js와 npm** : JavaScript가 거대한 오픈소스 생태계를 확보하는 데 결정적인 역할을 함

<br>

**Node.js**는 Google이 V8 엔진으로 만든 Javascript 런타임 환경으로 오늘날 상당히 많이 쓰이는 중!

**npm**은 Node.js를 설치할 때 포함되는데, 패키지를 프로젝트에 추가할 수 있도록 다양한 명령을 제공하는 패키지 관리 도구라고 보면 된다.

**yarn**은 페이스북이 개발한 패키지 매니저로, 규모가 커지는 프로젝트에서 npm을 사용하다가 보안, 빌드 성능 문제를 겪는 문제를 해결하기 위해 탄생함

<br>

Node.js 설치 후, yarn을 npm 명령어를 통해 전역으로 설치하자

```
$ npm install yarn -g
```

<br>

#### 프로젝트 생성

------

`yarn init` 명령어 실행

프로젝트 기본 정보를 입력하면 새로운 프로젝트가 생성됨

<br>

pakage.json 파일이 생성된 것을 확인할 수 있다.

```json
{
  "name": "awesome-javascript",
  "version": "1.0.0",
  "main": "index.js",
  "repository": "https://github.com/kim6394/awesome-javascript.git",
  "author": "gyuseok <gyuseok6394@gmail.com>",
  "license": "MIT"
}
```

이 파일은 프로젝트의 모든 정보를 담고 있다.

이 파일에서 가장 중요한 속성은 `dependencies`로, **프로젝트와 패키지 간의 의존성을 관리하는 속성**이다.

yarn의 cli 명령어로 패키지를 설치하면 package.json 파일의 dependencies 속성이 자동으로 변경됨

node-fetch 모듈을 설치해보자

```
$ yarn add node-fetch
```

pakage.json안에 아래와 같은 내용이 추가된다.

```
"dependencies": {
    "node-fetch": "^2.6.0"
}
```

<br>

***추가로 생성된 yarn.lock 파일은 뭔가요?***

앱을 개발하는 도중 혹은 배포할 때 프로젝트에서 사용하는 패키지가 업데이트 되는 경우가 있다. 또한 협업하는 동료들마다 다른 버전의 패키지가 설치될 수도 있다.

yarn은 모든 시스템에서 패키지 버전을 일관되게 관리하기 위해 `yarn.lock` 파일을 프로젝트 최상위 폴더에 자동으로 생성함.

(사용자는 이 파일을 직접 수정하면 안됨. 오로지 cli 명령어를 사용해 관리해야한다!)

<br>

#### 프로젝트 공유

현재 프로젝트는 Git의 원격 저장소에 반영해요 협업하는 동료와 공유가 가능하다.

프로젝트에 생성된 `pakage.json`과 `yarn.lock` 파일도 원격 저장소에서 관리해야 협업하는 동료들과 애플리케이션을 안정적으로 운영하는 것이 가능해짐

<br>

원격 저장소에 공유 시, 모듈이 설치되는 `node-_modules` 폴더는 제외시켜야 한다. 폴더의 용량도 크고, 어차피 **yarn.lock 파일을 통해 동기화 되기 때문**에 따로 git 저장소에서 관리할 필요가 없음

따라서, 해당 폴더를 .gitignore 파일에 추가해 git 관리 대상에서 제외시키자

```
$ echo "node_modules/" > .gitignore
```

<br>

<br>

##### 이슈 해결 관련 브랜치 생성 & 프로젝트 push

> 이번엔 이슈 해결과 관련된 브랜치를 생성하고, 프로젝트를 github에 푸시해보자

```
$ git add .
$ git checkout -b issue/1
$ git commit -m 'Create project with Yarn'
$ git push -u origin issue/1
```

<br>

푸시가 완려되면, GitHub 저장소에 `pull request`가 생성된 것을 확인할 수 있다.

pull request는 **작성한 코드를 master 브랜치에 병합하기 위해 협업하는 동료들에게 코드 리뷰를 요청하는 작업**임

Pull requests 탭에서 New pull request 버튼을 클릭해 pull request를 생성할 수 있다

<br>

##### pull request시 주의할 점

리뷰를 하는 사람에게 충분한 정보를 제공해야 함

새로운 기능을 추가했으면, 기능을 사용하기 위한 재현 시나리오와 테스트 시나리오를 추가하는 것이 좋음.

개발 환경이 변경되었다면 변경 내역도 반드시 포함하자

<br>

#### Jest로 테스트 환경 설정

실제로 프로젝트를 진행하면, 활용되는 Javascript 구현 코드가 만들어질 것이고 이를 검증하는 테스트 환경이 필요하게 된다.

Javascript 테스트 도구로는 jest를 많이 사용한다.

<br>

GitHub의 REST API v3을 활용해 특정 GitHub 사용자 정보를 가져오는 코드를 작성해보고, 테스트 환경 설정 방법에 대해 알아보자

<br>

##### 테스트 코드 작성

구현 코드 작성 이전, 구현하려는 기능의 의도를 테스트 코드로 표현해보자

테스트 코드 저장 폴더 : `__test__`

구현 코드 저장 폴더 : `lib`

테스트 코드 : `github.test.js`

<br>

```
$ mkdir __tests__ lib
$ touch __tests__/github.test.js
```

<br>

github.test.js에 테스트 코드를 작성해보자

내 GitHub `kim6394` 계정의 사용자 정보를 가져왔는지 확인하는 코드다. 

```javascript
const GitHub = require('../lib/github')

describe('Integration with GitHub API', () => {
    let github

    beforeAll ( () => {
        github = new GitHub({
            accessToken: process.env.ACCESS_TOKEN,
            baseURL: 'https://api.github.com',
        })
    })

    test('Get a user', async () => {
        const res = await github.getUser('kim6394')
        expect(res).toEqual (
            expect.objectContaining({
                login: 'kim6394',
            })
        )
    })
})
```

<br>

##### Jest 설치

yarn에서 테스트 코드를 실행할 때는 `yarn test`

먼저 설치를 진행하자

```
$ yarn add jest --dev
```

******

***`--dev` 속성은 뭔가요?***

> 설치할 때 이처럼 작성하면, `devDependencies`  속성에 패키지를 추가시킨다. 이 옵션으로 설치된 패키지는, 앱이 실행되는 런타임 환경에는 영향을 미치지 않는다.

<br>

테스트 명령을 위한 script 속성을 pakage.json에 설정하자

```json
  "scripts": {
    "test": "jest"
  },
  "dependencies": {
    "axios": "^0.19.0",
    "node-fetch": "^2.6.0"
  },
  "devDependencies": {
    "jest": "^24.8.0"
  }
```

<br>

##### 구현 코드 작성

아직 구현 코드를 작성하지 않았기 때문에 테스트 실행이 되지 않을 것이다.

lib 폴더에 구현 코드를 작성해보자

`lib/github.js`

```javascript
const fetch = require('node-fetch')

class GitHub {
    constructor({ accessToken, baseURL }) {
        this.accessToken = accessToken
        this.baseURL = baseURL
    }

    async getUser(username) {
        if(!this.accessToken) {
            throw new Error('accessToken is required.')
        }

        return fetch(`${this.baseURL}/users/${username}`, {
            method: 'GET',
            headers: {
                Authorization: `token ${this.accessToken}`,
                'Content-Type' : 'application/json',
            },
        }).then(res => res.json())
    }
}

module.exports = GitHub
```

<br>

이제 GitHub 홈페이지에서 access token을 생성해서 테스트해보자

토큰은 사용자마다 다르므로 자신이 생성한 토큰 값으로 입력한다

```
$ ACCESS_TOKEN=29ed3249e4aebc0d5cfc39e84a2081ad6b24a57c yarn test
```

아래와 같이 테스트가 정상적으로 작동되어 출력되는 것을 확인할 수 있을 것이다!

```
yarn run v1.10.1
$ jest
 PASS  __tests__/github.test.js
  Integration with GitHub API
    √ Get a user (947ms)

Test Suites: 1 passed, 1 total
Tests:       1 passed, 1 total
Snapshots:   0 total
Time:        3.758s
Ran all test suites.
Done in 5.30s.
```

<br>

<br>

#### Travis CI를 활용한 리뷰 환경 개선

---

동료와 협업하여 애플리케이션을 개발하는 과정은, pull request를 생성하고 공유한 코드를 리뷰, 함께 개선하는 과정이라고 말할 수 있다.

지금까지 진행한 과정을 확인한 리뷰어가 다음과 같이 답을 보내왔다.

<br>

>README.md를 참고해 테스트 명령을 실행했지만 실패했습니다..

<br>

무슨 문제일까? 내 로컬 환경에서는 분명 테스트 케이스를 통해 테스트 성공을 확인할 수 있었다. 리뷰어가 보낸 문제는, 다른 환경에서 테스트 실패로 인한 문제다.

이처럼 테스트케이스에 정의된 테스트를 실행하는 일은 개발과정에서 반복되는 작업이다. 따라서 리뷰어가 테스트를 매번 실행하게 하는 건 매우 비효율적이다. 

CI 도구가 자동으로 실행하도록 프로젝트 리뷰 방법을 개선시켜보자

<br>

##### Travis CI로 테스트 자동화

저장소의 Settings 탭에서 Branches를 클릭한 후, Branch protection rules에서 CI 연동기능을 사용해보자

(CI 도구 빌드 프로세스에 정의한 작업이 성공해야만 master 브랜치에 소스코드가 병합되도록 제약 조건을 주는 것)

<br>

대표적인 CI 도구는 Jenkins이지만, CI 서버 구축 운영에 비용이 든다.

<br>

Travis CI는 아래와 같은 작업을 위임한다

- ESLint를 통한 코드 컨벤션 검증
- Jest를 통한 테스트 자동화

<br>

Travis CI의 연동과 설정이 완료되면, pull request를 요청한 소스코드가 Travis CI를 거치도록 GitHub 저장소의 Branch protection rules 항목을 설정한다.

이를 설정해두면, 작성해둔 구현 코드와 테스트 코드로 pull request를 요청했을 때 Travis CI 서버에서 자동으로 테스트를 실행할 수 있게 된다.

<br>

##### GitHub-Travis CI 연동

https://travis-ci.org/에서 GitHub Login

https://travis-ci.org/account/repositories에서 연결할 repository 허용

프로젝트에 .travis.yml 설정 파일 추가

<br>

`.travis.yml`

```yml
---
language: node_js
node_js:
  - 10.15.0
cache:
  yarn: true
  directories:
  - node_modules

env:
  global:
    - PATH=$HOME/.yarn/bin:$PATH

services:
  - mongodb

before_install:
  - curl -o- -L https://yarnpkg.com/install.sh | bash

script:
 - yarn install
 - yarn test
```

<br>


다시 돌아와서, 리뷰어가 테스트를 실패한 이유는 access token 값이 전달되지 못했기 때문이다.

환경 변수를 관리하기 위해선 Git 저장소에서 설정 정보를 관리하고, 값의 유효성을 검증하는 것이 좋다.

(보안 문제가 있을 때는 다른 방법 강구)

<br>

`dotenv과 joi 모듈`을 사용하면, .env 할 일에 원하는 값을 등록하고 유효성 검증을 할 수 있다.

프로젝트에 .env 파일을 생성하고, access token 값을 등록해두자

<br>

이제 yarn으로 두 모듈을 설치한다.

```
$ yarn add dotenv joi
$ git add .
$ git commit -m 'Integration with dotenv and joi to manage config properties'
$ git push
```

이제 Travis CI로 자동 테스트 결과를 확인할 수 있다.

<br>

<br>

#### Node.js 버전 유지시키기

---

개발자들간의 Node.js 버전이 달라서 문제가 발생할 수도 있다.

애플리케이션의 서비스를 안정적으로 관리하기 위해서는 개발자의 로컬 시스템, CI 서버, 빌드 서버의 Node.js 버전을 일관적으로 유지하는 것이 중요하다.

<br>

`package.json`에서 engines 속성, nvm을 활용해 버전을 일관되게 유지해보자

```
"engines": {
    "node": ">=10.15.3",
 },
```

<br>

.nvmrc 파일 추가 후, nvm use 명령어를 실행하면 engines 속성에 설정한 Node.js의 버전을 사용한다.

<br>

```
$ echo "10.15.3" > .nvmrc
$ git add .
$ nvm use
Found '/Users/user/github/awesome-javascript/.nvmrc' with version <10.15.3>  
Now using node v10.15.3 (npm v6.4.1)  
...
$ git commit -m 'Add .nvmrc to maintain the same Node.js LTS version'
```

<br>

<br>

<br>



지금까지 알아본 점

- Git과 GitHub을 활용해 협업 공간을 구성
- Node.js 기반 개발 환경과 테스트 환경 설정
- 개발 환경을 GitHub에 공유하고 리뷰하면서 발생 문제를 해결시켜나감

<br>

지속적인 코드 리뷰를 하기 위해 자동화를 시키자. 이에 사용하기 좋은 것들

- ESLint로 코드 컨벤션 검증
- Jest로 테스트 자동화
- Codecov로 코드 커버리지 점검
- GitHub의 webhook api로 코드 리뷰 요청

<br>

자동화를 시켜놓으면, 개발자들은 코드 의도를 알 수 있는 commit message, commit range만 신경 쓰면 된다.

<br>

협업하며 개발하는 과정에는 코드 작성 후 pull request를 생성하여 병합까지 많은 검증이 필요하다. 

테스트 코드는 이 과정에서 예상치 못한 문제가 발생할 확률을 줄여주며, 구현 코드 의도를 효과적으로 전달할 수 있다.

또한 리뷰 시, 코드 컨벤션 검증뿐만 아니라 비즈니스 로직의 발생 문제도 고민이 가능하다.

<br>

<br>

**[참고 사항]** 

- [링크](<https://d2.naver.com/helloworld/2564557>)