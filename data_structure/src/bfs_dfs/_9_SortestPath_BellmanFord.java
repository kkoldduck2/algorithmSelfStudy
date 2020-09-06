package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11657
/* N���� ���� 
 * �� ���ÿ��� ����Ͽ� �ٸ� ���ÿ� �����ϴ� ������ M�� �ִ�.
 * �� ������ A, B, C�� ��Ÿ�� �� �ִµ�, A�� ���۵���, B�� ��������, C�� �̵��ϴµ� �ɸ��� �ð��̴�.
 * (�̋�, �ð� C�� ����� �ƴ� ��찡 �ִ�.)
 * C=0�� ���� ���� �̵��� �ϴ� ���, C<0�� ���� Ÿ�Ӹӽ����� �ð��� �ǵ��ư��� ����̴�.
 * 1�� ���ÿ��� ����ؼ� ������ ���÷� ���� ���� ���� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * */

/* �������� : �� ��忡�� ������ ��� ������ ���� �ִ� ��� ���̸� ã�� �˰���
 *  - 1Round : ��� ������ ���ؼ� Relax
 *  - Round�� n-1�� �ݺ��Ѵ�. (��?)
 *  - ������ ������ �ִ� ���, n�� �ݺ� -> n��°�� relax�� �̷����ٸ� ���� ����Ŭ�� ����  
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
		
		int n = Integer.parseInt(st.nextToken());		// ���
		int m = Integer.parseInt(st.nextToken());		// ����
		
		// 1. �׷����� ���� : 
		// ������  Ư�� ������ ����Ǿ� �ִ� ������ ȿ�������� ã�� ���� '��������Ʈ'(Ȥ�� �������)�� ����Ͽ�����,
		// ��������� ������ ��� �����鿡 ���ؼ� relax�� �ϱ� ������ ���� ��������Ʈ �������� �������� �ʰ�, '�迭'���ٰ� ������ �����Ѵ�. 
		Edge[] a = new Edge[m];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			a[i] = new Edge(u,v,w);
		}
		
		// d[i] : ���۳����� i��°������ �ִ� ��� ����
		int[] d = new int[n+1];		
		for(int i=1; i<=n; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		d[1] = 0;
		boolean negative_cycle=false;
		// n�� �ݺ� (n��°�� negative_cycle Ȯ�� �뵵) 		// n�� ����� ����
		for(int i=1; i<=n; i++) {
			
			// Round : ��� ������ ���ؼ� relax
			//   relax : s->v ���� s -> u -> v �϶� �� �ִ� ���̶�� �׷��� �ٲ��ش�. 
			for(int j=0; j<m; j++) {
				int u = a[j].start;
				int v = a[j].end;
				int w = a[j].weight;
				if(d[v] > d[u] + w ) {
					d[v] = d[u]+w;
					if(i==n) {	// n��°���� �� relax�� �Ͼ�ٸ� 
						negative_cycle = true;
					}
				}
			}
		}
		
		if(negative_cycle) {
			System.out.println("-1");	// �ð��� ������ ���� ������ ���� �� �ִٸ� -1�� ���
		}else {
			for(int i=2; i<=n; i++) {
				if(d[i]== Integer.MAX_VALUE) {
					d[i] =-1;		// �ش� ���÷� ���� ��ΰ� ���ٸ� ��� -1�� ��� 
				}
				System.out.println(d[i]);
			}
		}
		
	}
}
