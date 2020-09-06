package sort;

import java.util.Arrays;

// k=5 --> 배열의 모든 수는 5이하 이다. 이때 배열 A의 데이터를 정렬하시오 
public class CountingSort {
	
	
	public static void main(String[] args) {
		int[] A = new int[] {2,5,3,0,2,3,0,3};	// 정렬 전 배열
		int[] B = new int[8];	// 정렬 후 배열
		int k =5;
		
		int[] C = new int[k+1]; // 5번째 인덱스가 있어야하니까 배열크기는 6이어야한다.
		for(int i=0; i<C.length; i++) {
			C[i] = 0;	// 배열 C 초기화
		}
		
		for(int i=0; i<A.length; i++) {
			C[A[i]]++;	// A[i]의 값 = C의 인덱스 값, 즉 C[A[i]] 값을 하나 증가 시킨다.
		}
		
		// 배열 C를 누적 배열로 전환
		for(int i=1; i<C.length; i++) {
			C[i]= C[i]+C[i-1];
		}
		
		
		for(int i=A.length-1; i>=0; i--){
			B[C[A[i]]-1]=A[i];
			C[A[i]]--;
		}		
		
		System.out.println(Arrays.toString(B));
		
	}
}
