package sort;

// pivot : ������ (�迭���� ���������� �߰��� �ִ°� )
// s : �������� smaller part�� ���� ù��° �ε������� ���
// e : �������� bigger part�� ���� ������ �ε������� ���
// s�� pivot�� �� : s>pivot �̸� ����
// e�� pivot�� �� : e<pivot �̸� ����
// �Ѵ� �������� s�� e�� ���� swap
// �ݺ��Ѵ�
// e��s�� �� ������ ������� �ݺ� ����
// �̶�, s�� �ι�° �迭��(bigger part)�� ù��° �ε����� �� 
// -> �� ���ȣ�� �Լ��� ����� ��ȯ�Ѵ�. 
// �� �迭�濡�� ���ο� pivot ����  -> ��� -> partition ���� �Ѱ��� �ɶ�����

public class QuickSort {
	
	// ������ �迭�� �Ű����� �� �ϴ� quickSort �Լ�
	private static void quickSort(int[] arr) {
		// ����Լ� -> ���������� ����
		quickSort(arr, 0, arr.length-1);
	}
	
	// �迭�� pointer�� start�� end ��Ƽ���� ���� range�� ���ڷ� �޴´�
	private static void quickSort(int[] arr,  int start, int end) {
		// arr�� start�� end ��Ƽ���� ���� range�� ���ڷ� �޴´�
		// ���� ��Ƽ���� ������ �� ù��° ���� �����´�.
		int part2 = partition(arr, start, end);
		
		// �Ʒ� ��Ȳ�� ��쿡�� ��������� quickSort�� ȣ���Ѵ�. (�����µ� ���� �迭���� ��ĭ�� ���� ��� ������ �ʿ�x)
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
			// �� while �ݺ��� ������ ���� ���� -> �����ϰ� swap
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
	
	// Ȯ�� �� print ���� �Լ� ����
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
