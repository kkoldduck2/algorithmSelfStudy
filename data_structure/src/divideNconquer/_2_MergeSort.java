package divideNconquer;

import java.util.Arrays;

// devide and conquer의 대표적 문제 2
// 마찬가지로 나누어지는 것들 간에 겹치는 거 없다 (다이나믹과 다른점)
public class _2_MergeSort {
	static int[] arr  = {5,3,7,6,9,11,10};
	static void sort(int start, int end) {
		if(start == end) {
			return; 		// 크기 1  -> 재귀함수 호출 종료            크기가 1인 배열은 이미 정렬된 상태라고 생각한다. 
		}
		
		int mid = (start+end)/2;
		sort(start,mid);		// 둘로 나눴을때 왼쪽 정렬
		sort(mid+1, end);		// 오른쪽 정렬
		merge(start, end);		// 합
	}
	
	// 2,3,5,9   		1,4,7
	// 1) 2와 1비교  : 1이 더 작으므로 1이 들어간다.
	// 2) 2와 4비교 : 2가 더 작
	// 3) 4와 3비교 : 3이 더 작 
	static void merge(int start, int end) {
		 int mid = (start+end)/2;
		 int i=start; 		// 절반으로 나눴을때 왼쪽 배열의 첫번째 인덱스	
		 int j = mid+1;		// 절반으로 나눴을때 오른쪽 배열의 첫번째 인덱스
		 int k =0; 	// 두배열이 합쳐질 임시 배열의 인덱스
		 int[] b = new int[end-start+1];	// 두 배열이 합쳐질 임시배열
		 
		 
		 while(i<=mid && j<=end) {		// 둘중 하나라도 만족하지 않으면 while문 빠져나감
			 if(arr[i]<=arr[j]) {
				 b[k++] = arr[i++];			// 후치증가 알지?
			 }else {
				 b[k++] = arr[j++];
			 }
		 }
		 
		 // 만약 한쪽이 더 짧을 경우, 남아있는거 처리
		 while(i<=mid) {
			 b[k++] = arr[i++];
		 }
		 while(j<=end) {
			 b[k++] = arr[j++];
		 }
		 
		 for(int l=start; l<=end; l++) {
			arr[l] = b[l-start];		// arr배열은 start부터 end 인덱스까지 옮기지만  임시배열 b는 0번쨰 인덱스부터 옮겨야한다.
		 }
	}
	
	public static void main(String[] args) {
		sort(0,arr.length-1
				);
		
		System.out.println(Arrays.toString(arr));
	}
}	
