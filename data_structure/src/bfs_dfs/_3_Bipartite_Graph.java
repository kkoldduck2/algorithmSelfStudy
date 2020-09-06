package bfs_dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class _3_Bipartite_Graph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 정점의 개수 입력
		int m = sc.nextInt();	// 간선의 개수 입력
		
		ArrayList<Integer>[] a = new ArrayList[n+1];		// 정점 저장할 배열 (각 원소는 해당 정점과 연결된 간선 list)
		
		for(int i=1; i<=n; i++) {		// 정점 이름은 1부터 n까지로 할꺼야 (0부터 시작해도 되는데 헷갈리니까)
			a[i]= new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			// 정점 u와 v는 연결되어 있다.
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		
		int[] check = new int[n+1];		// check[i] = 0 (아직 방문안함), 1(방문,빨간색), 2(방문,파란색)
		
		for(int i=1; i<=n; i++) {
			if(check[i]==0) {		// i 노드 아직 방문 안했으면 dfs 실행
				dfs(check ,a , i, 1);
			}
		}
		
		/////////////////////////////////////////////// dfs 실행 후(모든 정점 탐색하면) 이분 그래프인지 검사해야한다.
		// 모든 간선에 대해서 양 끝점의 색깔이 다른가?
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
		for(int k : a[i]) {			// i 노드와 연결된 모든 정점에 대하여
			if(check[k]==0) {
				dfs(check, a, k, 3-color);
			}
		}
	}
	
	
}
