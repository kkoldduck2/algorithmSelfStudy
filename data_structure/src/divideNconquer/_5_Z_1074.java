package divideNconquer;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1074
/* 2���� �迭�� ũ�Ⱑ 2^N * 2^N,
 * N�� �־����� ��, (r, c)�� �� ��°�� �湮�ϴ��� ���
 * */
public class _5_Z_1074 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		int ans = solve(r,c,n,0);
		System.out.println(ans);
	}
	
	// ���� �Ѻ��� ���� 2^n
	static int solve(int r, int c, int n, int defaultVal) {
		// i) ���̻� �������� ���� ��� (base case)
		if(n==1) {
			if(r%2==0 && c%2==0) {  // 1��и�
				return defaultVal;
			}
			else if(r%2==0 && c%2==1) { // 2��и�: 0,1
				return defaultVal+1;
			}else if(r%2==1 && c%2==0) {// 3��и�: 1,0
				return defaultVal+2;
			} else {		// 4��и�
				return defaultVal+3;
			}
		}else {
			// ii) ���� ���� 4���� ������.
			int N = (int)Math.pow(2, n-1);		// ���� ���� �Ѻ��� ���� or �߰� ��
			int newDefault = (int)Math.pow(N, 2);		// ���� ���� 1��и��� ���� ������ �Ʒ� ��+1 (��и鸶�� �������� Ƚ�� �ٸ�)
			
			if(r<N && c<N) {		// 1��и�
				return solve(r,c,n-1,defaultVal);
			}
			else if(r<N && c>=N) {	// 2��и�
				return solve(r,c-=N,n-1,defaultVal+newDefault);
			}else if(r>=N && c<N) {	// 3��и�
				return solve(r-=N,c,n-1,defaultVal+newDefault*2);
			}else {						// 4��и�
				return solve(r-=N,c-=N,n-1,defaultVal+newDefault*3);
			}
		}
	}
}
