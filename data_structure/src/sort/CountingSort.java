package sort;

import java.util.Arrays;

// k=5 --> �迭�� ��� ���� 5���� �̴�. �̶� �迭 A�� �����͸� �����Ͻÿ� 
public class CountingSort {
	
	
	public static void main(String[] args) {
		int[] A = new int[] {2,5,3,0,2,3,0,3};	// ���� �� �迭
		int[] B = new int[8];	// ���� �� �迭
		int k =5;
		
		int[] C = new int[k+1]; // 5��° �ε����� �־���ϴϱ� �迭ũ��� 6�̾���Ѵ�.
		for(int i=0; i<C.length; i++) {
			C[i] = 0;	// �迭 C �ʱ�ȭ
		}
		
		for(int i=0; i<A.length; i++) {
			C[A[i]]++;	// A[i]�� �� = C�� �ε��� ��, �� C[A[i]] ���� �ϳ� ���� ��Ų��.
		}
		
		// �迭 C�� ���� �迭�� ��ȯ
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
