package bfs_dfs;
// https://www.acmicpc.net/problem/1922

import java.util.*;

/*도현이는 컴퓨터와 컴퓨터를 "모두 연결"하는 네트워크를 구축하려 한다. 
 *이왕이면 컴퓨터를 연결하는 "비용을 최소"로 해야함
 *이제 각 컴퓨터를 연결하는데 필요한 비용이 주어졌을 때 모든 컴퓨터를 연결하는데 필요한 "최소비용을 출력"하라.*/
// 입력 : 첫째 줄에 컴퓨터의 수 N (1 ≤ N ≤ 1000), 둘째 줄에는 연결할 수 있는 선의 수 M , 
// 셋째 줄부터 총 M개의 줄에 각 컴퓨터를 연결하는데 드는 비용이 주어진다. 
// -> 만약에 a b c 가 주어져 있다고 하면 a컴퓨터와 b컴퓨터를 연결하는데 비용이 c (1 ≤ c ≤ 10,000) 만큼 든다는 것을 의미한다.

// 출력: 모든 컴퓨터를 연결하는데 필요한 최소비용을 첫째 줄에 출력한다.

/* Prim 정리 
 * '정점'을 중심으로 
 * 1. 임의의 정점을 출발 노드로 선택한다. 
 * 2. 정점 u는 선택됨, v는 아직 선택 안된  간선 (u,v) 중에서 '가중치가 최소인 간선'을 선택한다. 
 * -> 선택한 '간선'을 MST에 추가하고, v를 선택한다. 
 * 3. 모든 정점 선택하지 않았다면, 2번 단계로 돌아간다. 
 * 
 * 
 * 간선 Edge 클래스 : 시작 & 끝 정점, 가중치를 변수로 가진다. 
 * */

public class _7_MST_Prim {
	static class Edge{
		public int start; // u
		public int end; // v
		public int weight; // 가중치
		
		// 생성자 (매개변수 없을 경우)
		public Edge(){
			this(0,0,0);
		}
		
		// 생성자 (매개변수 있을 경우 )
		public Edge(int u, int v, int w){
			this.start = u;
			this.end = v;
			this.weight = w;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		List<Edge>[] a = new List[n+1]; 
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Edge>();
		}
		
		// 간선 가중치 값 저장
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			// 무방향 가중치 그래프! 주의!
			a[u].add(new Edge(u,v,w));
			a[v].add(new Edge(v,u,w));
		}
		
		boolean[] c = new boolean[n+1]; // 정점 방문 상태
		
		// 출발노드 1번, 우선 순위 큐에 간선 저장 (가중치에 따라 오름차순 정렬)
		PriorityQueue<Edge> q = new PriorityQueue<Edge>(1, new Comparator<Edge>() {
			// override
			public int compare(Edge one, Edge two) {
				return Integer.compare(one.weight, two.weight);		// 오름차순 정렬. cf_내림차순은 두 변수의 위치를 바꾼다.
			}
		}
		);
		
		c[1] = true;
		for(Edge e : a[1]) {		// 1번 정점과 연결된 모든 간선(노드)에 대해서
			q.add(e);
		}
		
		int ans =0;
		for(int i=0; i<n-1; i++) {		// n-1번 반복 
			Edge e = new Edge();
			while(!q.isEmpty()) {
				e = q.poll();
				if(c[e.end]==false) {	// 큐에서 하나 꺼내서(가중치 최소인 얘겠지) 그 에지의 end 노드가 아직 방문 안한 상태라면 
					break;
				}
			}
			c[e.end] =true;			// 그 노드를 트리에 추가한다. 
			ans += e.weight;
			
			// e의 end가 start가 되는 모든 간선을 q에 추가한다. (새로운 후보군 큐에 추가)
			for(Edge ee : a[e.end]) {
				q.add(ee);
			}
		}
		System.out.println(ans);
	}
}
