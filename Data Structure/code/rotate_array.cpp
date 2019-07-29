#include  
using namespace std; 

//왼쪽으로 한번 회전
void leftRotatebyOne(int arr[], int n){
    int temp = arr[0], i;
    for(i = 0; i < n-1; i++){
        arr[i] = arr[i+1];
    }
    arr[i] = temp;
}

// d만큼 회전
void leftRotate(int arr[], int d, int n){
    for(int i = 0; i < d; i++)
        leftRotatebyOne(arr, n);
}

void printArray(int arr[], int n){
    for(int i = 0; i < n; i++)
        cout << arr[i] << " ";
}


int main(){
    int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
    int n = sizeof(arr) / sizeof(arr[0]);
    
    leftRotate(arr, 2, n);
    printArray(arr, n);
    
    return 0;
}
