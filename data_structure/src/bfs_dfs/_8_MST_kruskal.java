package bfs_dfs;

import java.util.*;

//https://www.acmicpc.net/problem/1197

/* Kruskal
 * 간선들을 가중치에 따라 오름차순 정렬
 * 하나씩 선택. 단, 사이클을 만들면 안됨
 * 사이클을 만들지 않는다 -> 간선의 두 정점이 같은 집합 내에 존재하지 않는다. 
 * 같은 집합 내에 존재하는지 어떻게 아냐? 
 * p[x] : x의 부모를 담은 배열  
 * dfs를 이용해서 x가 포함된 트리의 루트 노드를 찾는다.
 * 선택한 간선의 두 노드 start, end의 부모 노드가 같으면 -> 한 집합 내에 존재한다. 
 * 
 * */

public class _8_MST_kruskal {
	static class Edge{
		public int u;
		public int v;
		int weight;
		
		// 생성자 (매개변수 x)
		public Edge() {
			this(0,0,0); 
		}

		// 생성자(매개변수 o)
		public Edge(int s, int e, int w) {
			this.u = s;
			this.v = e;
			this.weight = w;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//////// 그래프 저장방법 기존과 다름!! 주의!!///////
		/* 원래방식대로 하면 Collection.sort에서 이런 오류가 발생한다.
		 * The method sort(List<T>, Comparator<? super T>) in the type Collections 
		 is not applicable for the arguments 
		 (List<_8_MST_kruskal.Edge>[], new Comparator<_8_MST_kruskal.Edge>(){})*/
		
//		List<Edge>[] a = new List[n+1];		
		ArrayList<Edge> a = new ArrayList();

		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
//			a[u].add(new Edge(u,v,w));
			a.add(new Edge(u,v,w));
		}
		
		int[] p = new int [n+1];
		for(int i=1; i<=n; i++) {
			p[i] =i;		// {1}, {2}, {3}, .. 이렇게 각 노드별로 집합 만들기 -> 나중에 합쳐줄 예정
		}
		
		// 가중치에 따라 간선 정렬
		Collections.sort(a, new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
			
		});
		
		int ans =0;
		// 간선에서 하나 뽑는다 -> 그 간선의 두 정점이 한 집합내에 있는지 검사한다 (find)
		// 다른 집합에 있으면 -> 두 집합을 합쳐준다. (Union)
		// 같은 집합에 있으면 -> 넘어가고 다음 간선
		for(Edge e : a) {
			int x = find(p, e.u);	// u의 루트 노드
			int y = find(p, e.v);	// v의 루트 노드 
			
			if(x!=y) {		// 다른 집합 내에 존재 -> 합쳐준다.
				union(p, x, y);		// x를 y의 부모 노드로 설정한다. (혹은 반대로, 높이가 작은 트리를 더 큰 높이에 포함 시키는게 효과적)
				ans+=e.weight;
			}
		}
		System.out.println(ans);
		
	}
	

	public static int find(int[] p, int x) {
		// sol1_ dfs
		// 루트 노드에 도달 
		if(x==p[x]) {	
			return x;
		}else {  // 나 != 나의 부모 노드 
			return find(p, p[x]);
		}
		
		// sol2_ 그냥 while
//		while(x!=p[x]) {
//			x=p[x];
//		}
//		return x;
	}
	
	public static void union(int[] p, int x, int y) {
		p[x] = p[y];
	}
	
}
