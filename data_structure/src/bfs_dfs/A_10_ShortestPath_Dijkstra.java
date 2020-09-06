package bfs_dfs;

import java.util.*;

/* ���������� ���� : ���� ����ġ�� ���� �� ��밡��
 * ���������� ���� : �����ɸ� (��� �����鿡 ���ؼ� �Ź� relax -> �� ������ ���ؼ� relax�� �ʹ� ���� �Ͼ)
 * -> ���ͽ�Ʈ�� : Ư�� ������ �����ϴ� ������ ���ؼ��� relax�ϰڴ�.
 * 
 * ���ͽ�Ʈ��  
 * - ���� ����ġ�� ���ٰ� ����
 * - �� round���� �̹� ������ ���(= �ִ� ����� ���̸� �̹� �˾Ƴ� ��� ����)�� ������ ������ ���� �߿� distance�� �ּ��� ��带 ã�´�. 
 * - �� ��尡 �� ������ �����ִ� d���� �ٷ� ��������� �� ������ ���� �ִ� ����� �����̹Ƿ�
 * 	 �� ����� distance ���� ���Ӱ� ���ŵ� ���� ����.  (��, �� ���κ��� ������ ������ ������ �ٽ� relax�� ���� ����)
 * - �� ��忡�� ������ �����鸸 relax �Ѵ�. 
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
		List<Edge>[] a = new List[n+1]; // ���۳��

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
		
		for(int k=0; k<n-1; k++) {		// ��� ������ �� �ѹ��� check�� ������ 
			
			// check �ȵǾ��ְ� dist�� �ּ��� ��带 �ϳ� ã�Ƽ� �����Ѵ�.
			int min = inf+1;
			int x = -1;
			for(int i=1; i<=n; i++) {
				if(check[i]==false && min > dist[i]) {
					min = dist[i];
					x = i;
				}
			}
			// for�� ������ ������ check==false && dist �ּ��� ��� ã���� ����
			check[x] =true;
			
			for(Edge e : a[x] ) {		// x���� ������ ��� ����(out degree)�� ���ؼ� relax
				if(dist[e.to] > dist[x]+e.cost) {
					dist[e.to] = dist[x]+e.cost;
				}
			}
		}
		System.out.println(dist[end]);
	}
}
