# [Cpp] 얕은 복사 vs 깊은 복사

<br>

> shallow copy와 deep copy가 어떻게 다른지 알아보자

<br>

### 얕은 복사(shallow copy)

한 객체의 모든 멤버 변수의 값을 다른 객체로 복사

<br>

### 깊은 복사(deep copy)

모든 멤버 변수의 값뿐만 아니라, 포인터 변수가 가리키는 모든 객체에 대해서도 복사

<br>

<br>

```cpp
struct Test {
    char *ptr;
};

void shallow_copy(Test &src, Test &dest) {
    dest.ptr = src.ptr;
}

void deep_copy(Test &src, Test &dest) {
    dest.ptr = (char*)malloc(strlen(src.ptr) + 1);
    strcpy(dest.ptr, src.ptr);
}
```

<br>

`shallow_copy`를 사용하면, 객체 생성과 삭제에 관련된 많은 프로그래밍 오류가 프로그램 실행 시간에 발생할 수 있다.

```
즉, 얕은 복사는 프로그래머가 스스로 무엇을 하는 지
잘 이해하고 있는 상황에서 주의하여 사용해야 한다
```

대부분, 얕은 복사는 실제 데이터를 복제하지 않고서, 복잡한 자료구조에 관한 정보를 전달할 때 사용한다. 얕은 복사로 만들어진 객체를 삭제할 때는 조심해야 한다.

<br>

실제로 얕은 복사는 실무에서 거의 사용되지 않는다. 대부분 깊은 복사를 사용해야 하는데, 복사되는 자료구조의 크기가 작으면 더욱 깊은 복사가 필요하다.

<br>

<br>

#### [참고 자료]

- 코딩 인터뷰 완전분석