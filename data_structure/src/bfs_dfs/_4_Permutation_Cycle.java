package bfs_dfs;

import java.util.Scanner;

// 순열 사이클
// https://www.acmicpc.net/problem/10451
/*	i    1	2	3	4	5	6	7	8
 * p[i]	 3	2	7	8	1	4	5	6
 * i --> p[i] 연결하는 간선을 만든다
 * 이때 순열 사이클 개수 찾는 것!   (연결요소의 개수 찾는 문제와 유사하다)
 * dfs로 구현
 * 
 * */


public class _4_Permutation_Cycle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();	
		
		while(testcase>0) {
			testcase--;
			int n = sc.nextInt();
			int[] perm = new int[n+1];			// 순열이 담길 배열 
			boolean[] check = new boolean[n+1];	// 해당 노드 방문 여부
			
			for(int i=1; i<=n ;i++) {
				perm[i] = sc.nextInt();
				check[i]=false;
			}
			
			
			int ans = 0;
			// 모든 노드 탐색
			for(int i=1; i<=n; i++) {
				// 해당 노드를 아직 방문 안했다면
				if(check[i]==false) {
					dfs(perm,check, i);
					ans++;
				}
			}
			System.out.println(ans);
			
		}
	}
	
	// 깊이 우선 탐색
	static void dfs(int[] a, boolean[] check, int i) {
		// i번째 노드랑 연결된 노드 찾자 
		// a[i] =  i -> ?      
		if(check[i]==true) return;
		check[i] = true;
		dfs(a,check, a[i]);
		
	}
	
}
