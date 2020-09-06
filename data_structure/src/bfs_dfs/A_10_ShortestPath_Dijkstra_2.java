package bfs_dfs;
// https://www.acmicpc.net/problem/11779
import java.util.*;


// 앞선 문제는 경로의 길이를 구하는 문제라면
// 지금 문제는 경로 자체를 추적해서 구하는 문제 
// 이전에 오는 노드 변수 v를 만들고 relax할 때 수정한다. 
public class A_10_ShortestPath_Dijkstra_2 {
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
		int m = sc.nextInt();
		
		List<Edge>[] a = new List[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Edge>();		// i노드에서 나가는 에지 저장
		}
		
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			a[x].add(new Edge(y,z));
		}
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		int[] dist = new int[n+1];
		boolean[] check = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			dist[i] = inf;
			check[i] =false;
		}
		int[] v = new int[n+1];		// v[i] : (최단 경로에서) i번째 노드에 앞서 오는 노드 저장
		dist[start] =0;
		v[start] =-1;
		for(int k=0; k<n-1; k++) {
			int min = inf+1;		//inf면 안됨 int+1이여야함 결과는 똑같이 나오는데 채점해보니까 런타임 에러 뜸 왜인진 모르겠음
			int x = -1; 		// 그 노드를 저장
			for(int i=1; i<=n; i++) {
				if(check[i]==false && min > dist[i]) {
					min = dist[i];
					x = i;
				}
			}
			
			check[x] = true;
			for(Edge e : a[x]) {
				if(dist[e.to] > dist[x]+ e.cost) {
					dist[e.to] = dist[x]+e.cost;
					v[e.to] = x;			// dist값이 바뀔 때, 어디에서 왔는지를 저장해야 함.
				}
			}
		}
		System.out.println(dist[end]);		// 최단 경로 비용
		
		Stack<Integer> st = new Stack<>();		
		
		int x =end;
		while(x!=-1) {
			st.push(x);
			x = v[x]; 
		}
		System.out.println(st.size());		// 최단 경로에 포함되어있는 도시의 개수 
		
		while(!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}
		System.out.println();
	}
	
}
