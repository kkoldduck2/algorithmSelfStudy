package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11657
/* N개의 도시 
 * 한 도시에서 출발하여 다른 도시에 도착하는 버스가 M개 있다.
 * 각 버스는 A, B, C로 나타낼 수 있는데, A는 시작도시, B는 도착도시, C는 이동하는데 걸리는 시간이다.
 * (이떄, 시간 C가 양수가 아닌 경우가 있다.)
 * C=0인 경우는 순간 이동을 하는 경우, C<0인 경우는 타임머신으로 시간을 되돌아가는 경우이다.
 * 1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오. 
 * */

/* 벨만포드 : 한 노드에서 나머지 모든 노드까지 가는 최단 경로 길이를 찾는 알고리즘
 *  - 1Round : 모든 에지에 대해서 Relax
 *  - Round를 n-1번 반복한다. (왜?)
 *  - 음수인 에지가 있는 경우, n번 반복 -> n번째에 relax가 이뤄진다면 음수 사이클이 존재  
 * */
public class _9_SortestPath_BellmanFord {
	static class Edge{
		int start;
		int end;
		int weight;
		
		public Edge() {
			this(0,0,0);
		}
		public Edge(int u, int v, int w) {
			this.start = u;
			this.end = v;
			this.weight = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());		// 노드
		int m = Integer.parseInt(st.nextToken());		// 간선
		
		// 1. 그래프를 저장 : 
		// 원래는  특정 정점에 연결되어 있는 간선을 효율적으로 찾기 위해 '인접리스트'(혹은 인접행렬)을 사용하였으나,
		// 벨만포드는 어차피 모든 에지들에 대해서 relax를 하기 때문에 굳이 인접리스트 형식으로 저장하지 않고, '배열'에다가 간선을 저장한다. 
		Edge[] a = new Edge[m];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			a[i] = new Edge(u,v,w);
		}
		
		// d[i] : 시작노드부터 i번째까지의 최단 경로 길이
		int[] d = new int[n+1];		
		for(int i=1; i<=n; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		d[1] = 0;
		boolean negative_cycle=false;
		// n번 반복 (n번째는 negative_cycle 확인 용도) 		// n은 노드의 개수
		for(int i=1; i<=n; i++) {
			
			// Round : 모든 간선에 대해서 relax
			//   relax : s->v 보다 s -> u -> v 일때 더 최단 길이라면 그렇게 바꿔준다. 
			for(int j=0; j<m; j++) {
				int u = a[j].start;
				int v = a[j].end;
				int w = a[j].weight;
				if(d[v] > d[u] + w ) {
					d[v] = d[u]+w;
					if(i==n) {	// n번째에서 또 relax가 일어난다면 
						negative_cycle = true;
					}
				}
			}
		}
		
		if(negative_cycle) {
			System.out.println("-1");	// 시간을 무한히 오래 전으로 돌릴 수 있다면 -1을 출력
		}else {
			for(int i=2; i<=n; i++) {
				if(d[i]== Integer.MAX_VALUE) {
					d[i] =-1;		// 해당 도시로 가는 경로가 없다면 대신 -1을 출력 
				}
				System.out.println(d[i]);
			}
		}
		
	}
}
