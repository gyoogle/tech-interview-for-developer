## [C] 동적할당

<br>

##### *동적할당이란?*

> 프로그램 실행 중에 동적으로 메모리를 할당하는 것
>
> Heap 영역에 할당한다

<br>

- `<stdlib.h>` 헤더 파일을 include 해야한다.
- 함수 형태 : `void* malloc(size_t size)`
- 메모리 할당은 size_t 크기만큼 할당해준다.

<br>

#### 중요

할당한 메모리는 반드시 해제하자 (해제안하면 메모리 릭, 누수 발생)

<br>

```c
#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int arr[4] = { 4, 3, 2, 1 };
    int* pArr;
    
    // 동적할당 : int 타입의 사이즈 * 4만큼 메모리를 할당
    pArr = (int*)malloc(sizeof(int)*4);
    
    if(pArr == NULL) { // 할당할수 없는 경우
        printf("malloc error");
        exit(1);
    }
    
    for(int i = 0; i < 4; ++i) {
        pArr[i] = arr[i];
    }
    
    for(int i = 0; i < 4; ++i) {
        printf("%d \n", pArr[i]);
    }
    
    // 할당 메모리 해제
    free(pArr);
    
    return 0;
}
```

- 동적할당 부분 : `pArr = (int*)malloc(sizeof(int)*4);`
  - `(int*)` : malloc의 반환형이 void*이므로 형변환
  - `sizeof(int)` : sizeof는 괄호 안 자료형 타입을 바이트로 연산해줌
  - `*4` : 4를 곱한 이유는, arr[4]가 가진 동일한 크기의 메모리를 할당하기 위해
  - `free[pArr]` : 다 사용하면 꼭 메모리 해제

<br>

<br>

##### [참고 자료]

- [링크](https://blockdmask.tistory.com/290)

