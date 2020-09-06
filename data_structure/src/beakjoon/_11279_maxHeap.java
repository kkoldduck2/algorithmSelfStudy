package beakjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11279

class MaxHeap{
	
	int[] mh= new int[] {};
	
	// Max heapify
	void max_heapify(int i) {
		
	}
	
	// root�� ����ϴ� �޼��� 
	int returnMax() {
		int result = mh[0];		// return�� �ִ밪 (root)
		mh[0]=mh[mh.length-1]; 	// ���� �������� �ִ� ���� root ��ġ�� �ű��.
		int heap_size = mh.length-1;	// heap size �ϳ� ���δ�.
		// heapify
		return result;
	}
	
	// �迭�� �Է��� �켱���� ��� �����ϴ� �޼��� 
	void max_heap_insert(int key) {
		// heap size �÷��ֱ�
		int heap_size = mh.length+1;
		mh = new int[heap_size];
		// �迭�� key �߰�
		mh[heap_size]=key;
		int i = heap_size;  // ���⼭ ���� heapify ������ ����
		// heapify - �θ� ���� �ڽ� ��庸�� ũ��. -> ��Ʈ ��� ���� �ݺ�
		while(i >1 && mh[i/2] < mh[i]) {
			// exchange mh[i/2] (�θ�)�� mh[i]�� ��ġ�� �ٲ۴�.
			int temp = mh[i];
			mh[i] = mh[i/2];
			mh[i/2]= temp;
			
			i = mh[i/2]; // ��ȯ �� �θ����� �θ���� �� -> �� Ÿ�� �ö󰣴�.
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
