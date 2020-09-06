package bfs_dfs;
// https://www.acmicpc.net/problem/11779
import java.util.*;


// �ռ� ������ ����� ���̸� ���ϴ� �������
// ���� ������ ��� ��ü�� �����ؼ� ���ϴ� ���� 
// ������ ���� ��� ���� v�� ����� relax�� �� �����Ѵ�. 
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
			a[i] = new ArrayList<Edge>();		// i��忡�� ������ ���� ����
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
		int[] v = new int[n+1];		// v[i] : (�ִ� ��ο���) i��° ��忡 �ռ� ���� ��� ����
		dist[start] =0;
		v[start] =-1;
		for(int k=0; k<n-1; k++) {
			int min = inf+1;		//inf�� �ȵ� int+1�̿����� ����� �Ȱ��� �����µ� ä���غ��ϱ� ��Ÿ�� ���� �� ������ �𸣰���
			int x = -1; 		// �� ��带 ����
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
					v[e.to] = x;			// dist���� �ٲ� ��, ��𿡼� �Դ����� �����ؾ� ��.
				}
			}
		}
		System.out.println(dist[end]);		// �ִ� ��� ���
		
		Stack<Integer> st = new Stack<>();		
		
		int x =end;
		while(x!=-1) {
			st.push(x);
			x = v[x]; 
		}
		System.out.println(st.size());		// �ִ� ��ο� ���ԵǾ��ִ� ������ ���� 
		
		while(!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}
		System.out.println();
	}
	
}
