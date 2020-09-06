package bfs_dfs;

import java.util.*;

//https://www.acmicpc.net/problem/1197

/* Kruskal
 * �������� ����ġ�� ���� �������� ����
 * �ϳ��� ����. ��, ����Ŭ�� ����� �ȵ�
 * ����Ŭ�� ������ �ʴ´� -> ������ �� ������ ���� ���� ���� �������� �ʴ´�. 
 * ���� ���� ���� �����ϴ��� ��� �Ƴ�? 
 * p[x] : x�� �θ� ���� �迭  
 * dfs�� �̿��ؼ� x�� ���Ե� Ʈ���� ��Ʈ ��带 ã�´�.
 * ������ ������ �� ��� start, end�� �θ� ��尡 ������ -> �� ���� ���� �����Ѵ�. 
 * 
 * */

public class _8_MST_kruskal {
	static class Edge{
		public int u;
		public int v;
		int weight;
		
		// ������ (�Ű����� x)
		public Edge() {
			this(0,0,0); 
		}

		// ������(�Ű����� o)
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
		
		//////// �׷��� ������ ������ �ٸ�!! ����!!///////
		/* ������Ĵ�� �ϸ� Collection.sort���� �̷� ������ �߻��Ѵ�.
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
			p[i] =i;		// {1}, {2}, {3}, .. �̷��� �� ��庰�� ���� ����� -> ���߿� ������ ����
		}
		
		// ����ġ�� ���� ���� ����
		Collections.sort(a, new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
			
		});
		
		int ans =0;
		// �������� �ϳ� �̴´� -> �� ������ �� ������ �� ���ճ��� �ִ��� �˻��Ѵ� (find)
		// �ٸ� ���տ� ������ -> �� ������ �����ش�. (Union)
		// ���� ���տ� ������ -> �Ѿ�� ���� ����
		for(Edge e : a) {
			int x = find(p, e.u);	// u�� ��Ʈ ���
			int y = find(p, e.v);	// v�� ��Ʈ ��� 
			
			if(x!=y) {		// �ٸ� ���� ���� ���� -> �����ش�.
				union(p, x, y);		// x�� y�� �θ� ���� �����Ѵ�. (Ȥ�� �ݴ��, ���̰� ���� Ʈ���� �� ū ���̿� ���� ��Ű�°� ȿ����)
				ans+=e.weight;
			}
		}
		System.out.println(ans);
		
	}
	

	public static int find(int[] p, int x) {
		// sol1_ dfs
		// ��Ʈ ��忡 ���� 
		if(x==p[x]) {	
			return x;
		}else {  // �� != ���� �θ� ��� 
			return find(p, p[x]);
		}
		
		// sol2_ �׳� while
//		while(x!=p[x]) {
//			x=p[x];
//		}
//		return x;
	}
	
	public static void union(int[] p, int x, int y) {
		p[x] = p[y];
	}
	
}
