## Logging Level

<br>

로그 레벨은 애플리케이션에서의 이벤트에 대한 로그 메시지의 심각성의 수준을 나타내는 기준이다. 주요 목적은 단순히 정보제공 메시지와 오류 감지 메시지를 구분하는 것이다.

보통 log4j 라이브러리를 활용한다. (일부 버전에서 취약점이 있으므로 사용에 주의해야 한다.)

대부분의 로깅 라이브러리에서 FATAL, ERROR, WARN, INFO, DEBUG, TRACE 로그 레벨을 제공하며, 주로 사용하는 로그 레벨은 ERROR, WARN, INFO, DEBUG이다.
<br>

- #### ERROR

  에러 로그는, 프로그램 동작에 큰 문제가 발생했다는 것으로 즉시 문제를 조사해야 하는 것

  `DB를 사용할 수 없는 상태, 중요 에러가 나오는 상황`

  <br>

- #### WARN

  주의해야 하지만, 프로세스는 계속 진행되는 상태. 하지만 WARN에서도 2가지의 부분에선 종료가 일어남

  - 명확한 문제 : 현재 데이터를 사용 불가, 캐시값 사용 등
  - 잠재적 문제 : 개발 모드로 프로그램 시작, 관리자 콘솔 비밀번호가 보호되지 않고 접속 등

  <br>

- #### INFO

  애플리케이션의 주요 이벤트나 실행 상태에 대한 정보를 전달한다. 주로 비즈니스 목적에 중요한 시스템 이벤트를 기록한다.

  `~가 ~를 실행했음`

  <br>

- #### DEBUG

  디버깅의 목적으로 개발 단계에서 상세한 정보를 기록한다. 애플리케이션 내부 동작을 이해하고 트러블슈팅하는데 도움을 준다.

<br>

<br>

##### [참고사항]

- [링크](https://jangiloh.tistory.com/18)
- [log4j architecture](https://logging.apache.org/log4j/2.x/manual/architecture.html)
- [log4j vs logback vs log4j2](https://stackify.com/compare-java-logging-frameworks/)

