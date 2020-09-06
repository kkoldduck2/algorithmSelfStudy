package bfs_dfs;

import java.util.*;

/* 벨만포드의 장점 : 음수 가중치가 있을 때 사용가능
 * 벨만포드의 단점 : 오래걸림 (모든 에지들에 대해서 매번 relax -> 한 에지에 대해서 relax가 너무 자주 일어남)
 * -> 다익스트라 : 특정 조건을 만족하는 에지에 대해서만 relax하겠다.
 * 
 * 다익스트라  
 * - 음수 가중치가 없다고 가정
 * - 매 round에서 이미 선택한 노드(= 최단 경로의 길이를 이미 알아낸 노드 집합)를 제외한 나머지 노드들 중엣 distance가 최소인 노드를 찾는다. 
 * - 그 노드가 그 시점에 갖고있는 d값이 바로 출발점에서 그 노드까지 가는 최단 경로의 길이이므로
 * 	 그 노드의 distance 값이 새롭게 갱신될 일은 없다.  (즉, 이 노드로부터 나가는 에지를 언젠가 다시 relax할 일은 없다)
 * - 그 노드에서 나가는 에지들만 relax 한다. 
 * 
 * 
 * */
public class A_10_ShortestPath_Dijkstra {
	static class Edge{
		int to;
		int cost;
		
		public Edge(int to, int w) {
			this.to = to;
			this.cost = w;
		}
	}
	static final int inf = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Edge>[] a = new List[n+1]; // 시작노드

		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Edge>();
		}
		
		int m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			a[x].add(new Edge(y,z));
		}
		
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		int dist[] = new int[n+1];
		boolean check[] = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			dist[i] = inf;
			check[i] =false;
		}
		
		dist[start] = 0;
		
		for(int k=0; k<n-1; k++) {		// 모든 노드들을 다 한번씩 check할 때까지 
			
			// check 안되어있고 dist가 최소인 노드를 하나 찾아서 선택한다.
			int min = inf+1;
			int x = -1;
			for(int i=1; i<=n; i++) {
				if(check[i]==false && min > dist[i]) {
					min = dist[i];
					x = i;
				}
			}
			// for문 밖으로 나오면 check==false && dist 최소인 노드 찾아진 상태
			check[x] =true;
			
			for(Edge e : a[x] ) {		// x에서 나가는 모든 에지(out degree)에 대해서 relax
				if(dist[e.to] > dist[x]+e.cost) {
					dist[e.to] = dist[x]+e.cost;
				}
			}
		}
		System.out.println(dist[end]);
	}
}
