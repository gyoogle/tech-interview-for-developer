## [C] 구조체 메모리 크기 (Struct Memory Size)

typedef struct 선언 시, 변수 선언에 대한 메모리 공간 크기에 대해 알아보자

> 기업 필기 테스트에서 자주 나오는 유형이기도 함

<br>

- char : 1바이트
- int : 4바이트
- double : 8바이트

`sizeof` 메소드를 통해 해당 변수의 사이즈를 알 수 있음

<br>

#### 크기 계산

---

```c
typedef struct student {
    char a;
    int b;
}S;

void main() {
    printf("메모리 크기 = %d/n", sizeof(S)); // 8
}
```

char는 1바이트고, int는 4바이트라서 5바이트가 필요하다.

하지만 메모리 공간은 5가 아닌 **8이 찍힐 것이다**.

***Why?***

구조체가 메모리 공간을 잡는 원리에는 크게 두가지 규칙이 있다.

1. 각각의 멤버를 저장하기 위해서는 **기본 4바이트 단위로 구성**된다. (4의 배수 단위)
   즉, char 데이터 1개를 저장할 때 이 1개의 데이터를 읽어오기 위해서 1바이트를 읽어오는 것이 아니라 이 데이터가 포함된 '4바이트'를 읽는다.
2. 구조체 각 멤버 중에서 가장 큰 멤버의 크기에 영향을 받는다.

<br>

이 규칙이 적용된 메모리 공간은 아래와 같을 것이다.

a는 char형이지만, 기본 4바이트 단위 구성으로 인해 3바이트의 여유공간이 생긴다.

<img src="http://postfiles2.naver.net/20150930_177/sharonichoya_1443599417738eaCq5_PNG/%B1%B8%C1%B6%C3%BC%C5%A9%B1%E23.png?type=w2">

<br>

그렇다면 이와 같을 때는 어떨까?

```c
typedef struct student {
    char a;
    char b;
    int c;
}S;
```

<img src="http://postfiles15.naver.net/20150930_14/sharonichoya_1443599661246BGweK_PNG/%B1%D7%B8%B21.png?type=w2">

똑같이 8바이트가 필요하며, char형으로 선언된 a,b가 4바이트 안에 함께 들어가고 2바이트의 여유 공간이 생긴다.

<br>

이제부터 헷갈리는 경우다.

```c
typedef struct student {
    char a;
    int c;
    char b;
}S;
```

구성은 같지만, 순서가 다르다.

자료타입은 일치하지만, 선언된 순서에 따라 할당되는 메모리 공간이 아래와 같이 달라진다.

<img src="http://postfiles15.naver.net/20150930_142/sharonichoya_1443599763574jksKW_PNG/%B1%D7%B8%B22.png?type=w2">

이 경우에는 총 12바이트가 필요하게 된다.

<br>

```c
typedef struct student {
    char a;
    int c;
    double b;
}S;
```

두 규칙이 모두 적용되는 상황이다. b가 double로 8바이트이므로 기본 공간이 8바이트로 설정된다. 하지만 a와 c는 8바이트로 해결이 가능하기 때문에 16바이트로 해결이 가능하다.

<img src="http://postfiles4.naver.net/20150930_83/sharonichoya_1443600192056XIAc4_PNG/%B1%D7%B8%B24.png?type=w2">

