package bfs_dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class _3_Bipartite_Graph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// ������ ���� �Է�
		int m = sc.nextInt();	// ������ ���� �Է�
		
		ArrayList<Integer>[] a = new ArrayList[n+1];		// ���� ������ �迭 (�� ���Ҵ� �ش� ������ ����� ���� list)
		
		for(int i=1; i<=n; i++) {		// ���� �̸��� 1���� n������ �Ҳ��� (0���� �����ص� �Ǵµ� �򰥸��ϱ�)
			a[i]= new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			// ���� u�� v�� ����Ǿ� �ִ�.
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		
		int[] check = new int[n+1];		// check[i] = 0 (���� �湮����), 1(�湮,������), 2(�湮,�Ķ���)
		
		for(int i=1; i<=n; i++) {
			if(check[i]==0) {		// i ��� ���� �湮 �������� dfs ����
				dfs(check ,a , i, 1);
			}
		}
		
		/////////////////////////////////////////////// dfs ���� ��(��� ���� Ž���ϸ�) �̺� �׷������� �˻��ؾ��Ѵ�.
		// ��� ������ ���ؼ� �� ������ ������ �ٸ���?
		boolean ok = true;
		for(int i=1; i<=n; i++) {
			for(int j : a[i]) {
				if(check[i]==check[j]) {
					ok = false;
				}
			}
		}
		
		if(ok) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		
	}
	
	static void dfs(int[] check, ArrayList<Integer>[] a, int i, int color) {
		check[i]=color;
		for(int k : a[i]) {			// i ���� ����� ��� ������ ���Ͽ�
			if(check[k]==0) {
				dfs(check, a, k, 3-color);
			}
		}
	}
	
	
}
