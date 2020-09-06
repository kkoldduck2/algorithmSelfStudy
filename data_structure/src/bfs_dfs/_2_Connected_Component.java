package bfs_dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class _2_Connected_Component {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer>[] a = new ArrayList[n+1];		// 간선 저장할 array  (a 배열의 원소는 ArrayList<Integer> 타입이다.)
		// a에는 정점들과, 그 정점에 연결된 간선 list를 저장한다.
		
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();			// 이거처럼  i정점에 연결된 간선 list
		}
		
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		
		/*------여기까지 그래프 저장(= 간선 저장)-------*/
		
		boolean[] check = new boolean[n+1];
		
		int components = 0;
		
		// 모든 정점에 대해서 start를 한다. (단 그 정점은 체크되지 않은 상태여야 한다.)
		// 체크된 정점일 경우, 이미 한 컴포넌트 안에 포함되어 있다고 판단
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
		
		// 해당 정점(i)가 체크가 안되어 있으면 이와 연결된 정점에 대해서 계속 dfs 탐색을 해야한다.
		check[i] = true;
		for(int x : a[i]) {				// 정점 i와 연결된 정점들 x를 뽑아서
			if(check[x]==false) {
				dfs(a, x, check);
			}
		}
		
		
	}
	
}
