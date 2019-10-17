### Linked List

---

![img](https://www.geeksforgeeks.org/wp-content/uploads/gq/2013/03/Linkedlist.png)

연속적인 메모리 위치에 저장되지 않는 선형 데이터 구조

(포인터를 사용해서 연결된다)

각 노드는 **데이터 필드**와 **다음 노드에 대한 참조**를 포함하는 노드로 구성

<br/>

**왜 Linked List를 사용하나?**

> 배열은 비슷한 유형의 선형 데이터를 저장하는데 사용할 수 있지만 제한 사항이 있음
>
> 1) 배열의 크기가 고정되어 있어 미리 요소의 수에 대해 할당을 받아야 함
>
> 2) 새로운 요소를 삽입하는 것은 비용이 많이 듬 (공간을 만들고, 기존 요소 전부 이동)

**장점**

> 1) 동적 크기
>
> 2) 삽입/삭제 용이

**단점**

> 1) 임의로 액세스를 허용할 수 없음. 즉, 첫 번째 노드부터 순차적으로 요소에 액세스 해야함 (이진 검색 수행 불가능)
>
> 2) 포인터의 여분의 메모리 공간이 목록의 각 요소에 필요



노드 구현은 아래와 같이 데이터와 다음 노드에 대한 참조로 나타낼 수 있다

```
// A linked list node 
struct Node 
{ 
  int data; 
  struct Node *next; 
}; 
```



**Single Linked List**

노드 3개를 잇는 코드를 만들어보자

```
      head         second         third 
        |             |             | 
        |             |             | 
    +---+---+     +---+---+     +----+----+ 
    | 1  | o----->| 2 | o-----> |  3 |  # | 
    +---+---+     +---+---+     +----+----+
```

[소스 코드]()



<br/>

<br/>

**노드 추가**

- 앞쪽에 노드 추가

```
void push(struct Node** head_ref, int new_data){
    struct Node* new_node = (struct Node*) malloc(sizeof(struct Node));

    new_node->data = new_data;

    new_node->next = (*head_ref);

    (*head_ref) = new_node;
}
```

</br>

- 특정 노드 다음에 추가

```
void insertAfter(struct Node* prev_node, int new_data){
    if (prev_node == NULL){
        printf("이전 노드가 NULL이 아니어야 합니다.");
        return;
    }

    struct Node* new_node = (struct Node*) malloc(sizeof(struct Node));

    new_node->data = new_data;
    new_node->next = prev_node->next;

    prev_node->next = new_node;
    
}
```

</br>

- 끝쪽에 노드 추가

```
void append(struct Node** head_ref, int new_data){
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));

    struct Node *last = *head_ref;

    new_node->data = new_data;

    new_node->next = NULL;

    if (*head_ref == NULL){
        *head_ref = new_node;
        return;
    }

    while(last->next != NULL){
        last = last->next;
    }

    last->next = new_node;
    return;

}
```

