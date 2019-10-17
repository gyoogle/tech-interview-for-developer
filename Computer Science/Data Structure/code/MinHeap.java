package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinHeap {
	
	public static class minHeap {
		
		private ArrayList<Integer> heap;
		
		// 힙 생성자
		public minHeap() {
			heap = new ArrayList<>();
			heap.add(0); // 인덱스 0 채우기 (1부터 시작하기 위함)
		}
		
		// 삽입
		public void insert(int val) {
			heap.add(val);
			int p = heap.size() - 1;
			
			// 힙 사이즈 - 1이 1보다 작아질 때까지 진행 -> root로 이동
			while(p > 1 && heap.get(p / 2) > heap.get(p)) {
				System.out.println("swap");
				// 부모보다 자식 노드가 더 작으면 바꿔야 함 (최소힙)
				int tmp = heap.get(p/2);
				heap.set(p/2, heap.get(p));
				heap.set(p, tmp);
				
				p = p / 2; // p는 부모 값으로 변경 (부모 노드 인덱스로 이동)
			}
		}
		
		// 삭제
		public int delete() {
			
			// 힙 사이즈 - 1이 1보다 작으면 0 리턴
			if(heap.size()-1 < 1) {
				return 0;
			}
			
			// 삭제할 노드는 루트 노드임
			int deleteItem = heap.get(1);
			
			// root에 가장 마지막 값 넣고 마지막 값 삭제
			heap.set(1, heap.get(heap.size() - 1));
			heap.remove(heap.size()-1);
			
			int pos = 1;
			while((pos * 2) < heap.size()) {
				
				int min = heap.get(pos * 2);
				int minPos = pos * 2;
				
				if (((pos*2 + 1) < heap.size()) && min > heap.get(pos*2 + 1)) {
					min = heap.get(pos*2 + 1);
					minPos = pos * 2 + 1;
				}
				
				if(heap.get(pos) < min)
					break;
				
				// 부모 자식 노드 교환
				int tmp = heap.get(pos);
				heap.set(pos, heap.get(minPos));
				heap.set(minPos, tmp);
				pos = minPos;
			}
			
			return deleteItem;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		minHeap heap = new minHeap();
		
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			
			if(val == 0) {
				System.out.println(heap.delete());
			} else {
				heap.insert(val);
			}
		}
		
	}

}
