package divideNconquer;

import java.util.Arrays;

// devide and conquer�� ��ǥ�� ���� 2
// ���������� ���������� �͵� ���� ��ġ�� �� ���� (���̳��Ͱ� �ٸ���)
public class _2_MergeSort {
	static int[] arr  = {5,3,7,6,9,11,10};
	static void sort(int start, int end) {
		if(start == end) {
			return; 		// ũ�� 1  -> ����Լ� ȣ�� ����            ũ�Ⱑ 1�� �迭�� �̹� ���ĵ� ���¶�� �����Ѵ�. 
		}
		
		int mid = (start+end)/2;
		sort(start,mid);		// �ѷ� �������� ���� ����
		sort(mid+1, end);		// ������ ����
		merge(start, end);		// ��
	}
	
	// 2,3,5,9   		1,4,7
	// 1) 2�� 1��  : 1�� �� �����Ƿ� 1�� ����.
	// 2) 2�� 4�� : 2�� �� ��
	// 3) 4�� 3�� : 3�� �� �� 
	static void merge(int start, int end) {
		 int mid = (start+end)/2;
		 int i=start; 		// �������� �������� ���� �迭�� ù��° �ε���	
		 int j = mid+1;		// �������� �������� ������ �迭�� ù��° �ε���
		 int k =0; 	// �ι迭�� ������ �ӽ� �迭�� �ε���
		 int[] b = new int[end-start+1];	// �� �迭�� ������ �ӽù迭
		 
		 
		 while(i<=mid && j<=end) {		// ���� �ϳ��� �������� ������ while�� ��������
			 if(arr[i]<=arr[j]) {
				 b[k++] = arr[i++];			// ��ġ���� ����?
			 }else {
				 b[k++] = arr[j++];
			 }
		 }
		 
		 // ���� ������ �� ª�� ���, �����ִ°� ó��
		 while(i<=mid) {
			 b[k++] = arr[i++];
		 }
		 while(j<=end) {
			 b[k++] = arr[j++];
		 }
		 
		 for(int l=start; l<=end; l++) {
			arr[l] = b[l-start];		// arr�迭�� start���� end �ε������� �ű�����  �ӽù迭 b�� 0���� �ε������� �Űܾ��Ѵ�.
		 }
	}
	
	public static void main(String[] args) {
		sort(0,arr.length-1
				);
		
		System.out.println(Arrays.toString(arr));
	}
}	
