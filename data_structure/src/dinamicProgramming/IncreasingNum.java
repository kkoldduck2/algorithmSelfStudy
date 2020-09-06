package dinamicProgramming;

import java.util.Scanner;

/* ������ ���� ���� �ڸ��� ���������� �̷�� ���� ���Ѵ�. �̶�, ������ ���� ���Ƶ� ������������ ģ��.
���� ���, 2234�� 3678, 11119�� ������ ��������, 2232, 3676, 91111�� ������ ���� �ƴϴ�.
���� ���� N�� �־����� ��, ������ ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� 0���� ������ �� �ִ�.
 * 
 * 
 * d[n][l] = ���� N�� �־����� ��, ������ ���� ����, ������ ���� : l
 * d
 * */
public class IncreasingNum {
	
	public static long recurSol(long[][] d, int n, int l) {
		
		if(n==1) {
			d[n][l] =1;
			return 1;
		} 
		//if(l==0) return 1;   -> ���� �����൵ �� l==0 �̸� for���� �ѹ� �ۿ� �ȵ���
		if(d[n][l]>0) return d[n][l];	// memorization (�̹� ���� ���� ���� ��� ����� ���� ��ȯ)
		
		
		for(int i=0; i<=l; i++) {
			d[n][l] += recurSol(d,n-1,i);
		} 
		// System.out.println(n+" , "+l+" , "+d[n][l]);   -> ���� ������ �� �� �ִ� 
		d[n][l] %= 10007;
		
		return d[n][l];
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		long[][] d = new long[n+1][11];
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<=9; j++) {
				d[i][j]= 0;
			}
		}
		
		long ans =0; 
		for(int i=0; i<=9; i++) {
			long temp = recurSol(d, n, i);
			ans +=temp;
			ans %= 10007;
		}
		ans %=  10007;
		System.out.println(ans);
	}
}
