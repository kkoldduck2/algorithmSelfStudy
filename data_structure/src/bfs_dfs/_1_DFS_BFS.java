package bfs_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// DFS : 깊이우선 탐색 - Stack으로 구현한다 -> 재귀로 구현한다 (재귀함수가 Stack의 형태임)
// BFS : 너비우선 탐색 - Queue로 구현한다. 
// 그래프 표현 : 인접행렬  & 인접리스트 (여기선 인접 리스트로 구현한다.)
public class _1_DFS_BFS {
	// arrays of ArrayLists. 
	/*https://stackoverflow.com/questions/29906131/defining-an-array-of-list-of-integers-in-java?noredirect=1&lq=1*/
	// int 타입의 배열을 int[] a 이렇게 정의하듯이
	// ArrayList<Integer> 타입의 배열을 아래와 같이 정의한다.(a 배열의 원소로 ArrayList<Integer>를 저장할 거임)
	static ArrayList<Integer>[] a; 	// a[i]  : i와 연결된 정점 리스트 저장
	static boolean[] check; 		// 정점 방문 여부 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 정점의 개수 
		int m = sc.nextInt();	// 간선의 개수
		int start = sc.nextInt();  // 탐색을 시작할 정점의 번호 
		
		//arrays of ArrayLists.
		a = new ArrayList[n+1];			// 간선을 저장할 리스트 
		
		
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();		// 각 정점마다 연결된 정점 리스트 생성
		}
		
		// 간선의 개수만큼 반복하면서 간선들 입력 - 저장
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();		// u와 v는 연결되어 있음
			int v = sc.nextInt();
			a[u].add(v);				
			a[v].add(u);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(a[i]);
		}
		
		check = new boolean[n+1];
		
		dfs(start);
		System.out.println();
		
		check = new boolean[n+1];
		
		bfs(start);
		System.out.println();
	}
	
	// 재귀 (스택)으로 구현
	public static void dfs(int x) {
		if(check[x]) {	// 이미 방문했던 점이면 
			return; 	// stack에서 뺀다 
		}
		
		check[x] =true;
		System.out.println(x+" ");
		
		for(int y : a[x]) {			// x정점에 연결된 정점 중 하나 꺼내서 
			if(!check[y]) {			// 그 정점이 아직 방문 안한 점이면
				dfs(y);				// 그 정점을 방문한다. 
			}
		}
	}
	
	// 이건 재귀 개념 아님.  큐로 구현
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();		
		// 한정점과 연결된 정점 모두 여기에 담고, 그중 하나 선택 
		// -> 선택한 정점(a)에서 더이상 갈 곳이 없으면 -> a를 pop한다.
		q.add(start);				// 시작점을 큐에 넣고 체크해준다.
		check[start]=true;
		
		
		while(!q.isEmpty()) {
			int x = q.remove();	// 큐에 연결된 정점을 모두 넣고나면 더이상 갈 곳이 없기 때문에 pop을 해주는 것
			System.out.println(x+" ");
			for(int y : a[x]) {			// x와 연결된 모든 정점에 대해서 
				if(!check[y]) {			// 아직 그 정점을 방문하지 않았다면
					check[y] = true;	// 방문후 체크해주고
					q.add(y);			// 큐에 추가한다. 
				}
			}
			// x와 연결된 정점 모두 큐에 저장하고 나면, 큐가 완전히 비어버릴 때까지 반복한다. 
		}
		
		
	}
}
