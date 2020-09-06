package sort;

// pivot : 기준점 (배열에서 물리적으로 중간에 있는거 )
// s : 기준점의 smaller part의 가장 첫번째 인덱스에서 출발
// e : 기준점의 bigger part의 가장 마지막 인덱스에서 출발
// s와 pivot을 비교 : s>pivot 이면 멈춤
// e와 pivot을 비교 : e<pivot 이면 멈춤
// 둘다 멈췄을때 s와 e의 값을 swap
// 반복한다
// e와s가 각 영역을 벗어났을때 반복 끝남
// 이때, s는 두번째 배열방(bigger part)의 첫번째 인덱스가 됨 
// -> 이 방번호를 함수의 결과로 반환한다. 
// 각 배열방에서 새로운 pivot 정함  -> 재귀 -> partition 방이 한개가 될때까지

public class QuickSort {
	
	// 정렬할 배열을 매개변수 로 하는 quickSort 함수
	private static void quickSort(int[] arr) {
		// 재귀함수 -> 본격적으로 시작
		quickSort(arr, 0, arr.length-1);
	}
	
	// 배열의 pointer와 start와 end 파티션을 나눌 range를 인자로 받는다
	private static void quickSort(int[] arr,  int start, int end) {
		// arr의 start와 end 파티션을 나눌 range를 인자로 받는다
		// 나눈 파티션의 오른쪽 방 첫번째 값을 가져온다.
		int part2 = partition(arr, start, end);
		
		// 아래 상황일 경우에만 재귀적으로 quickSort를 호출한다. (나눴는데 한쪽 배열방이 한칸만 있을 경우 정렬할 필요x)
		if(start < part2 -1) {
			quickSort(arr, start, part2-1);
		}
		if(part2 < end) {
			quickSort(arr, part2, end);
		}
		
	}
	
	private static int partition(int[] arr, int start, int end){
		int pivot = arr[(start+end)/2];
		while(start<=end) {
			while(arr[start] <pivot) start++;
			while(arr[end] >pivot) end--;
			// 위 while 반복문 조건을 만족 안함 -> 정지하고 swap
			if(start <=end) {
				swap(arr, start, end);
				start++;
				end--;
				
			}
		}
		return start;
	}
	
	private static void swap(int[] arr,  int start, int end) {
		int temp = arr[start];
		arr[start]= arr[end];
		arr[end] = temp;
	}
	
	// 확인 차 print 해줄 함수 설정
	public static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data+", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		
		printArray(arr);
		quickSort(arr);
		printArray(arr);
	}
}
