## [C++] 입출력 실행속도 줄이는 법

<br>

C++로 알고리즘 문제를 풀 때, `cin, cout`은 실행속도가 느리다. 하지만 최적화 방법을 이용하면 실행속도 단축에 효율적이다.

만약 `cin, cout`을 문제풀이에 사용하고 싶다면, 시간을 단축하고 싶다면 사용하자

```
최적화 시 거의 절반의 시간이 단축된다.
```

<br>

```c++
int main(void)
{
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}
```

`ios_base`는 c++에서 사용하는 iostream의 cin, cout 등을 함축한다.

`sync_with_stdio(false)`는 c언어의 stdio.h와 동기화하지만, 그 안에서 활용하는 printf, scanf, getchar, fgets, puts, putchar 등은 false로 동기화하지 않음을 뜻한다.

<br>

***주의***

```
따라서, cin/scanf와 cout/printf를 같이 쓰면 문제가 발생하므로 조심하자
```

또한, 이는 싱글 스레드 환경에서만 효율적일뿐(즉, 알고리즘 문제 풀이할 때) 실무에선 사용하지 말자

그리고 크게 차이 안나므로 그냥 `printf/scanf` 써도 된다!