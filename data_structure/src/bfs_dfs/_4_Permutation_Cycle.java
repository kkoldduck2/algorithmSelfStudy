package bfs_dfs;

import java.util.Scanner;

// ���� ����Ŭ
// https://www.acmicpc.net/problem/10451
/*	i    1	2	3	4	5	6	7	8
 * p[i]	 3	2	7	8	1	4	5	6
 * i --> p[i] �����ϴ� ������ �����
 * �̶� ���� ����Ŭ ���� ã�� ��!   (�������� ���� ã�� ������ �����ϴ�)
 * dfs�� ����
 * 
 * */


public class _4_Permutation_Cycle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();	
		
		while(testcase>0) {
			testcase--;
			int n = sc.nextInt();
			int[] perm = new int[n+1];			// ������ ��� �迭 
			boolean[] check = new boolean[n+1];	// �ش� ��� �湮 ����
			
			for(int i=1; i<=n ;i++) {
				perm[i] = sc.nextInt();
				check[i]=false;
			}
			
			
			int ans = 0;
			// ��� ��� Ž��
			for(int i=1; i<=n; i++) {
				// �ش� ��带 ���� �湮 ���ߴٸ�
				if(check[i]==false) {
					dfs(perm,check, i);
					ans++;
				}
			}
			System.out.println(ans);
			
		}
	}
	
	// ���� �켱 Ž��
	static void dfs(int[] a, boolean[] check, int i) {
		// i��° ���� ����� ��� ã�� 
		// a[i] =  i -> ?      
		if(check[i]==true) return;
		check[i] = true;
		dfs(a,check, a[i]);
		
	}
	
}
