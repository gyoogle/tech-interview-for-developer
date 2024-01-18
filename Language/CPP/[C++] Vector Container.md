# [C++] Vector Container

<br>

```cpp
#include <vector>
```

자동으로 메모리를 할당해주는 Cpp 라이브러리

데이터 타입을 정할 수 있으며, push pop은 스택과 유사한 방식이다.

<br>

## 생성

- `vector<"Type"> v;`
- `vector<"Type"> v2(v); ` : v2에 v 복사

### Function

- `v.assign(5, 2);` : 2 값으로 5개 원소 할당
- `v.at(index);` : index번째 원소 참조 (범위 점검 o)
- `v[index];` : index번째 원소 참조 (범위 점검 x)
- `v.front(); v.back();` : 첫번째와 마지막 원소 참조
- `v.clear();` : 모든 원소 제거 (메모리는 유지)
- `v.push_back(data); v.pop_back(data);` : 마지막 원소 뒤에 data 삽입, 마지막 원소 제거
- `v.begin(); v.end();` : 첫번째 원소, 마지막의 다음을 가리킴 (iterator 필요)
- `v.resize(n);` : n으로 크기 변경
- `v.size();` : vector 원소 개수 리턴
- `v.capacity();` : 할당된 공간 크기 리턴
- `v.empty();` : 비어있는 지 여부 확인 (true, false)

```
capacity : 할당된 메모리 크기
size : 할당된 메모리 원소 개수
```

<br>

```cpp
#include<iostream>
#include<vector>
#include<string>
using namespace std;

int main(void) {
    vector<int> v;
    
    v.push_back(1);
    v.push_back(2);
    v.push_back(3);
    
    vector<int>::iterator iter;
    for(iter = v.begin(); iter != v.end(); iter++) {
        cout << *iter << endl;
    }
}
```

<br>

<br>

#### [참고 자료]

- [링크](https://blockdmask.tistory.com/70)