package dinamicProgramming;

import java.util.Scanner;

// �ǿ��� ���� 
/* ���� ����� ���Ҷ� ��� ���� ��Ģ�� �����ؼ� ������ ������ ���� ���ΰ�?
 * �ּ� ���� Ƚ���� ���ϼ��� 
 * ���� ��ȹ�� 
 * 1) ��ȯ�� ���ϱ� (Optimal Stucture : ������ ���� �����ظ� �����ϰ�, �װ��� �Ϻκ��� �� �κ��ؿ� ���� ���������� Ȯ���Ѵ�.)
 * 		m[i,j] : Ai, Ai+1, Ai+2, ..., Aj�� ���ϴ� �ּ� ���� Ƚ��
 * 		m[i,j] = 0 (i=j)
 * 			   = min (m[i,k] + m[k+1,j] + Pi-1 * Pk * Pj)  (i<j)		--> �ᱹ base case�� �����ؾ� �Ѵ�. 
 * 
 * 2) ��ȯ����  memoization �̳� bottom up ������� ��� Ǯ ���ΰ�? 
 * 		bottom up : ��ȯ�� ������ ���ڰ� ���� ���ں��� ���� ���ǵ��� ���α׷��� �����Ѵ�. 
 * 		-> m[i,j]�� ������ 2���� �迭�� �׷�����
 * 		-> �츮�� ���������� ���ϰ� ���� �� m[1,n]�� ���Ͻ�Ų��. 
 * */
public class _DP1_Matrix_chain_Multiplecation {
	static int[][] m;
	static int[] p;
	
	static int matrixChain(int n) {
		for(int i=1; i<=n; i++) {	
			m[i][i] = 0; 		// �밢�� (i, i)�� �̸� 0���� ä��� 
			p[i]=i+1;		// �� �ƹ����̳� ������ �� �ǹ� x (Ai ��� = pi-1 x pi)
		}
		
		// r��° �밢���� ���ؼ�  (�밢���� ������ �� n-1��)
		for(int r=1; r<=n-1; r++) {
			// r��° �밢���� i��° ���� �� (�ε��� j) (r��° �밢���� �����ϴ� ������ ������ �� n-r�� )
			for(int i=1; i<=n-r; i++) {
				int j= i+r; // r��° �밢�� + i��° �� = j�� (������ �迭 �׸� ���� ���ذ� �� ��)
				m[i][j] = m[i+1][j] + p[i-1]*p[i]*p[j];		// k=i�� �� (m[i,i]�� ������) -> default
				
				for(int k=i+1; k<=j-1; k++) {	// �ּڰ� ���ϴ� ����
					if(m[i][j] > m[i][k] + m[k+1][j] + p[i-1]*p[i]*p[j]) {
						m[i][j] = m[i][k] + m[k+1][j] + p[i-1]*p[i]*p[j];
					}
				}
			}
		}
		return m[1][n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		m = new int[n+1][n+1];
		matrixChain(n);
	}
}
