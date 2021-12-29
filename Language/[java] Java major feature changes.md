> Java 버전별 변화 중 중요한 부분만 기록했습니다. 더 자세한건 참고의 링크를 봐주세요.

## Java 8

1. 함수형 프로그래밍 패러다임 적용
    1. Lambda expression
    2. Stream
    3. Functional interface
    4. Optional
2. interface 에서 default method 사용 가능
3. 새로운 Date and Time API
4. JVM 개선
    1. JVM 에 의해 크기가 결정되던 Permanent Heap 삭제
    2. OS 가 자동 조정하는 Native 메모리 영역인 Metaspace 추가
    3. `Default GC` Serial GC -> Parallel GC (멀티 스레드 방식)

## Java 9

1. module
2. interface 에서 private method 사용 가능
3. Collection, Stream, Optional API 사용법 개선
    1. ex) Immutable collection, Stream.ofNullable(), Optional.orElseGet()
4. `Default GC` Parallel GC -> G1GC (멀티 프로세서 환경에 적합)

## Java 10

1. var (지역 변수 타입 추론)

## Java 11

1. HTTP Client API
    1. HTTP/2 지원
    2. RestTemplate 의 상위 호환
2. String API 사용법 개선
3. OracleJDK 독점 기능이 OpenJDK 에 포함

## 참고

- [Java Latest Versions and Features](https://howtodoinjava.com/java-version-wise-features-history/)
- [JDK 8에서 Perm 영역은 왜 삭제됐을까](https://johngrib.github.io/wiki/java8-why-permgen-removed/)
- [Java 11 String API Additions](https://www.baeldung.com/java-11-string-api)
