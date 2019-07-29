#include <iostream>
using namespace std;

// swap을 활용한 reverse 구현
void reverseArr(int arr[], int start, int end){
    
    while (start < end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        
        start++;
        end--;
    }
}


// d로 나눠서 역전 알고리즘 수행
void rotateLeft(int arr[], int d, int n){
    reverseArr(arr, 0, d-1);
    reverseArr(arr, d, n-1);
    reverseArr(arr, 0, n-1);
}

void printArray(int arr[], int n){
    for(int i = 0; i < n; i++){
        cout << arr[i] << " ";
    }
}


int main(void){
    
    int arr[10] = {1,2,3,4,5,6,7,8,9,10};
    int n = sizeof(arr) / sizeof(arr[0]);
    int d = 3;
    
    rotateLeft(arr, d, n);
    printArray(arr, n);
    
    return 0;
}
