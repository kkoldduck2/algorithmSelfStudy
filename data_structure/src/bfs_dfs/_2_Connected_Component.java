package bfs_dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class _2_Connected_Component {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer>[] a = new ArrayList[n+1];		// ���� ������ array  (a �迭�� ���Ҵ� ArrayList<Integer> Ÿ���̴�.)
		// a���� �������, �� ������ ����� ���� list�� �����Ѵ�.
		
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();			// �̰�ó��  i������ ����� ���� list
		}
		
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		
		/*------������� �׷��� ����(= ���� ����)-------*/
		
		boolean[] check = new boolean[n+1];
		
		int components = 0;
		
		// ��� ������ ���ؼ� start�� �Ѵ�. (�� �� ������ üũ���� ���� ���¿��� �Ѵ�.)
		// üũ�� ������ ���, �̹� �� ������Ʈ �ȿ� ���ԵǾ� �ִٰ� �Ǵ�
		for(int i=1; i<=n; i++) {
			if(check[i]==false) {
				dfs(a, i, check);		
				components++;
			}
		}
		System.out.println(components);
	}
	
	static void dfs(ArrayList<Integer>[] a, int i, boolean[] check) {
		if(check[i]==true) {
			return;
		}
		
		// �ش� ����(i)�� üũ�� �ȵǾ� ������ �̿� ����� ������ ���ؼ� ��� dfs Ž���� �ؾ��Ѵ�.
		check[i] = true;
		for(int x : a[i]) {				// ���� i�� ����� ������ x�� �̾Ƽ�
			if(check[x]==false) {
				dfs(a, x, check);
			}
		}
		
		
	}
	
}
