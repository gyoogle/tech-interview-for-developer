#include <iostream>
using namespace std;

int fix(int A[], int len){
    
    for(int i = 0; i < len; i++) {
        
        
        if (A[i] != -1 && A[i] != i){ // A[i]가 -1이 아니고, i도 아닐 때
            
            int x = A[i]; // 해당 값을 x에 저장
            
            while(A[x] != -1 && A[x] != x){ // A[x]가 -1이 아니고, x도 아닐 때
                
                int y = A[x]; // 해당 값을 y에 저장
                A[x] = x; 
                
                x = y;
            }
            
            A[x] = x;
            
            if (A[i] != i){
                A[i] = -1;
            }
        }
    }
    
}

void printArray(int A[], int len){
    for(int i = 0; i < len; i++){
        cout << A[i] << " ";
    }
}

int main() {
    
    int A[] = { -1, -1, 6, 1, 9, 
                3, 2, -1, 4, -1 };
                
    int len = sizeof(A) / sizeof(A[0]);
    fix(A, len);
    printArray(A, len);
    
    return 0;
}