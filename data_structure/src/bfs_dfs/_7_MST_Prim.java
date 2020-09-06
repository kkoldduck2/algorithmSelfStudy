package bfs_dfs;
// https://www.acmicpc.net/problem/1922

import java.util.*;

/*�����̴� ��ǻ�Ϳ� ��ǻ�͸� "��� ����"�ϴ� ��Ʈ��ũ�� �����Ϸ� �Ѵ�. 
 *�̿��̸� ��ǻ�͸� �����ϴ� "����� �ּ�"�� �ؾ���
 *���� �� ��ǻ�͸� �����ϴµ� �ʿ��� ����� �־����� �� ��� ��ǻ�͸� �����ϴµ� �ʿ��� "�ּҺ���� ���"�϶�.*/
// �Է� : ù° �ٿ� ��ǻ���� �� N (1 �� N �� 1000), ��° �ٿ��� ������ �� �ִ� ���� �� M , 
// ��° �ٺ��� �� M���� �ٿ� �� ��ǻ�͸� �����ϴµ� ��� ����� �־�����. 
// -> ���࿡ a b c �� �־��� �ִٰ� �ϸ� a��ǻ�Ϳ� b��ǻ�͸� �����ϴµ� ����� c (1 �� c �� 10,000) ��ŭ ��ٴ� ���� �ǹ��Ѵ�.

// ���: ��� ��ǻ�͸� �����ϴµ� �ʿ��� �ּҺ���� ù° �ٿ� ����Ѵ�.

/* Prim ���� 
 * '����'�� �߽����� 
 * 1. ������ ������ ��� ���� �����Ѵ�. 
 * 2. ���� u�� ���õ�, v�� ���� ���� �ȵ�  ���� (u,v) �߿��� '����ġ�� �ּ��� ����'�� �����Ѵ�. 
 * -> ������ '����'�� MST�� �߰��ϰ�, v�� �����Ѵ�. 
 * 3. ��� ���� �������� �ʾҴٸ�, 2�� �ܰ�� ���ư���. 
 * 
 * 
 * ���� Edge Ŭ���� : ���� & �� ����, ����ġ�� ������ ������. 
 * */

public class _7_MST_Prim {
	static class Edge{
		public int start; // u
		public int end; // v
		public int weight; // ����ġ
		
		// ������ (�Ű����� ���� ���)
		public Edge(){
			this(0,0,0);
		}
		
		// ������ (�Ű����� ���� ��� )
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
		
		// ���� ����ġ �� ����
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			// ������ ����ġ �׷���! ����!
			a[u].add(new Edge(u,v,w));
			a[v].add(new Edge(v,u,w));
		}
		
		boolean[] c = new boolean[n+1]; // ���� �湮 ����
		
		// ��߳�� 1��, �켱 ���� ť�� ���� ���� (����ġ�� ���� �������� ����)
		PriorityQueue<Edge> q = new PriorityQueue<Edge>(1, new Comparator<Edge>() {
			// override
			public int compare(Edge one, Edge two) {
				return Integer.compare(one.weight, two.weight);		// �������� ����. cf_���������� �� ������ ��ġ�� �ٲ۴�.
			}
		}
		);
		
		c[1] = true;
		for(Edge e : a[1]) {		// 1�� ������ ����� ��� ����(���)�� ���ؼ�
			q.add(e);
		}
		
		int ans =0;
		for(int i=0; i<n-1; i++) {		// n-1�� �ݺ� 
			Edge e = new Edge();
			while(!q.isEmpty()) {
				e = q.poll();
				if(c[e.end]==false) {	// ť���� �ϳ� ������(����ġ �ּ��� �����) �� ������ end ��尡 ���� �湮 ���� ���¶�� 
					break;
				}
			}
			c[e.end] =true;			// �� ��带 Ʈ���� �߰��Ѵ�. 
			ans += e.weight;
			
			// e�� end�� start�� �Ǵ� ��� ������ q�� �߰��Ѵ�. (���ο� �ĺ��� ť�� �߰�)
			for(Edge ee : a[e.end]) {
				q.add(ee);
			}
		}
		System.out.println(ans);
	}
}
