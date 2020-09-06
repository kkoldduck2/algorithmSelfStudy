package beakjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11279

class MaxHeap{
	
	int[] mh= new int[] {};
	
	// Max heapify
	void max_heapify(int i) {
		
	}
	
	// root를 출력하는 메서드 
	int returnMax() {
		int result = mh[0];		// return할 최대값 (root)
		mh[0]=mh[mh.length-1]; 	// 가장 마지막에 있는 값을 root 위치로 옮긴다.
		int heap_size = mh.length-1;	// heap size 하나 줄인다.
		// heapify
		return result;
	}
	
	// 배열에 입력후 우선순위 대로 정렬하는 메서드 
	void max_heap_insert(int key) {
		// heap size 늘려주기
		int heap_size = mh.length+1;
		mh = new int[heap_size];
		// 배열에 key 추가
		mh[heap_size]=key;
		int i = heap_size;  // 여기서 부터 heapify 시작할 예정
		// heapify - 부모 노드는 자식 노드보다 크다. -> 루트 노드 까지 반복
		while(i >1 && mh[i/2] < mh[i]) {
			// exchange mh[i/2] (부모)와 mh[i]의 위치를 바꾼다.
			int temp = mh[i];
			mh[i] = mh[i/2];
			mh[i/2]= temp;
			
			i = mh[i/2]; // 교환 후 부모노드의 부모노드와 비교 -> 쭉 타고 올라간다.
		}
		
	}
	
}

public class _11279_maxHeap {
	
	public static void main(String[] args) {
		MaxHeap MH = new MaxHeap();
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		
		for(int i=0; i<repeat; i++) {
			
		}
	}
}
