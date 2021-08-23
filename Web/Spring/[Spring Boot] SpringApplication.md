## [Spring Boot] SpringApplication

<br>

스프링 부트로 프로젝트를 실행할 때 Application 클래스를 만든다.

클래스명은 개발자가 프로젝트에 맞게 설정할 수 있지만, 큰 틀은 아래와 같다.

```java
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
```

<br>

`@SpringBootApplication` 어노테이션을 통해 스프링 Bean을 읽어와 자동으로 생성해준다.

이 어노테이션이 있는 파일 위치부터 설정들을 읽어가므로, 반드시 프로젝트의 최상단에 만들어야 한다.

`SpringApplication.run()`으로 해당 클래스를 run하면, 내장 WAS를 실행한다. 내장 WAS의 장점으로는 개발자가 따로 톰캣과 같은 외부 WAS를 설치 후 설정해두지 않아도 애플리케이션을 실행할 수 있다.

또한, 외장 WAS를 사용할 시 이 프로젝트를 실행시키기 위한 서버에서 모두 외장 WAS의 종류와 버전, 설정을 일치시켜야만 한다. 따라서 내장 WAS를 사용하면 이런 신경은 쓰지 않아도 되기 때문에 매우 편리하다.

> 실제로 많은 회사들이 이런 장점을 살려 내장 WAS를 사용하고 있고, 전환하고 있다.

