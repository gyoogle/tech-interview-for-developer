# [Travis CI] 프로젝트 연동하기

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbMIduW%2FbtrfWMtiPEC%2FENLpZFdHhIVcpV31IWNBcK%2Fimg.jpg">

<br>

```
자동으로 테스트 및 빌드가 될 수 있는 환경을 만들어 개발에만 집중할 수 있도록 하자
```

<br>

#### CI(Continuous Integration)

코드 버전 관리를 하는 Git과 같은 시스템에 PUSH가 되면 자동으로 빌드 및 테스트가 수행되어 안정적인 배포 파일을 만드는 과정을 말한다.

<br>

#### CD(Continuous Deployment)

빌드한 결과를 자동으로 운영 서버에 무중단 배포하는 과정을 말한다.

<br>

### Travis CI 웹 서비스 설정하기

[Travis 사이트](https://www.travis-ci.com/)로 접속하여 깃허브 계정으로 로그인 후, `Settings`로 들어간다.

Repository 활성화를 통해 CI 연결을 할 프로젝트로 이동한다.

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcpCgp3%2Fbtrf1hF3DBd%2F6y2x40HdH0Ko8ZUB4kHV90%2Fimg.jpg">

<br>

<br>

### 프로젝트 설정하기

세부설정을 하려면 `yml`파일로 진행해야 한다. 프로젝트에서 `build.gradle`이 위치한 경로에 `.travis.yml`을 새로 생성하자

```yml
language: java
jdk:
  - openjdk11

branches:
  only:
    - main

# Travis CI 서버의 Home
cache:
  directories:
    - '$HOME/.m2/repository'
    - '$HOME/.gradle'

script: "./gradlew clean build"

# CI 실행 완료시 메일로 알람
notifications:
  email:
    recipients:
      - gyuseok6394@gmail.com
```

- `branches` : 어떤 브랜치가 push할 때 수행할지 지정
- `cache` : 캐시를 통해 같은 의존성은 다음 배포하지 않도록 설정
- `script` : 설정한 브랜치에 push되었을 때 수행하는 명령어
- `notifications` : 실행 완료 시 자동 알람 전송 설정

<br>

생성 후, 해당 프로젝트에서 `Github`에 push를 진행하면 Travis CI 사이트의 해당 레포지토리 정보에서 빌드가 성공한 것을 확인할 수 있다.

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbwMGb1%2FbtrfXzHcn2G%2FFjODgalLKrzYNvsx5COlxK%2Fimg.jpg">

<br>

<br>

#### *만약 Travis CI에서 push 후에도 아무런 반응이 없다면?*

현재 진행 중인 프로젝트의 GitHub Repository가 바로 루트 경로에 있지 않은 확률이 높다.

즉, 해당 레포지토리에서 추가로 폴더를 생성하여 프로젝트가 생성된 경우를 말한다.

이럴 때는 `.travis.yml`을  `build.gradle`이 위치한 경로에 만드는 것이 아니라, 레포지토리 루트 경로에 생성해야 한다.

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FzdMai%2Fbtrf1iEWSaG%2Fq2FZkc3HXXo0Nnes2MYegk%2Fimg.jpg">

<br>

그 이후 다음과 같이 코드를 추가해주자 (현재 위치로 부터 프로젝트 빌드를 진행할 곳으로 이동이 필요하기 때문)

```yml
language: java
jdk:
  - openjdk11

branches:
  only:
    - main

# ------------추가 부분----------------

before_script:
  - cd {프로젝트명}/
  
# ------------------------------------

# Travis CI 서버의 Home
cache:
  directories:
    - '$HOME/.m2/repository'
    - '$HOME/.gradle'

script: "./gradlew clean build"

# CI 실행 완료시 메일로 알람
notifications:
  email:
    recipients:
      - gyuseok6394@gmail.com
```

<br>

<br>

#### [참고 자료]

- [링크](https://github.com/jojoldu/freelec-springboot2-webservice)

<br>