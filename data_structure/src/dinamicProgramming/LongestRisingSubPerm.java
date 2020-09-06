package dinamicProgramming;
// https://www.acmicpc.net/problem/11053

/* ���� A�� �־����� ��, ���� �� �����ϴ� �κ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ���, ���� A = {10, 20, 10, 30, 20, 50} �� ��쿡 
���� �� �����ϴ� �κ� ������ A = {10, 20, 10, 30, 20, 50} �̰�, ���̴� 4�̴�.
 * 
 * */ 

// D[i] : A[i] �� �������� �ϴ� ���� �� �����ϴ� �κ� ������ ���� 
// D[i] = max(D[j]) +1   ( j= 1~ i-1)
// �̶�, j<i  && A[j] <A[i] ������ �����ϴ� j�� ã�ƾ� �Ѵ�. 

public class LongestRisingSubPerm {
	public static void main(String[] args) {
		int n = 6;
		int[] A = new int [] {10, 20, 10, 30, 20, 50};
		
		int[] D = new int[n+1];
		for(int i=1; i<n+1; i++) {
			D[i] = 1; // �⺻������ ��� ������ ���̴� 1�̴�. 
			for(int j=1; j<i; j++) {  // j<i
				if(A[j-1]<A[i-1] && D[i] < D[j]+1) {
					D[i]=D[j]+1;
				}
			}
		}
		
		System.out.println(D[n]);
		
	}
}
