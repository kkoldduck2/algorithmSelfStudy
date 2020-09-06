package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2252
/*N���� �л����� Ű ������� ���� ������� �Ѵ�. 
 * �� �л��� Ű�� ���� �缭 �����ϸ� �����ϰ�����, ������ ����� ��� �� �л��� Ű�� ���ϴ� ����� ����ϱ�� �Ͽ���. 
 * �׳����� ��� �л����� �� ���� �� ���� �ƴϰ�, �Ϻ� �л����� Ű���� ���� ���Ҵ�.

�Ϻ� �л����� Ű�� ���� ����� �־����� ��, ���� ����� ���α׷��� �ۼ��Ͻÿ�.*/

/*�Է� : ù° �ٿ� N(1��N��32,000), M(1��M��100,000)�� �־�����. M�� Ű�� ���� ȸ���̴�.
���� M���� �ٿ��� Ű�� ���� �� �л��� ��ȣ A, B�� �־�����.
 �̴� �л� A�� �л� B�� �տ� ���� �Ѵٴ� �ǹ��̴�.
�л����� ��ȣ�� 1������ N���̴�.

 ���: ù° �ٺ��� �տ������� ���� ���� ����� ����Ѵ�. ���� ���� ������ ��쿡�� �ƹ��ų� ����Ѵ�.
*/

/* �Է� ���� 
	3 2
	1 3		1�� �л��� 3�� �л����� �տ� �;�
	2 3		2�� �л��� 3�� �л����� �տ� �;�  */
/* ��¿���
 * 1 2 3   or 2 1 3 
 * */

public class _6_DAG_2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// �л����� ��ȣ 1~n��
		int m = Integer.parseInt(st.nextToken());	// �� Ƚ�� 
		
		List<Integer>[] li = new List[n+1];
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList<Integer>();
		}
		
		int[] ind = new int[n+1];		// �� ����� in degree ���� 
		
		// m�� �� 
		for(int k=0; k<m; k++) {
			st =new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// ���� �׷��� : a->b
			li[a].add(b);
			ind[b]+=1;
		}
		
		
		// sol 1
//		Queue<Integer> q= new LinkedList<>();
//		for(int i=1; i<=n; i++) {
//			if(ind[i]==0) {
//				q.add(i);
//			}
//		}
//		
//		int[] order = new int[n];	// ���� ���� �迭 
//		int k=0;
//		for(int i=1; i<=n; i++) {
//			int x = q.remove();
//			System.out.print(x + " ");
////			order[k++] = x;
//			for(int y : li[x]) {
//				ind[y]-=1;
//				
//				if(ind[y]==0) {
//					q.add(y);
//				}
//			}
//		}

		
		// sol2) �� �ڿ������� ����  (R�� �� �տ� �߰��Ѵ�. )
		boolean[] visited = new boolean[n+1];
		LinkedList<Integer> R = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				dfs(i, li, visited, R);
			}
		}

		for(int t : R) {
			System.out.print(t+" ");
		}
		
	}
	
	static void dfs(int i, List<Integer>[] li, boolean[] visited, LinkedList<Integer> R) {
		visited[i] = true;
		
		// i�� ������ ��� ��� y�� ���Ͽ�
		for(int y : li[i]) {
			if(!visited[y]) {
				dfs(y, li, visited, R);
			}
		}
		
		// for�� ���� ������  -> out degree�� ���� (������)��忡 �ٴ޾Ҵ� ��� �� -> R�� �� �տ� �߰����ش�
		R.addFirst(i);
		
	}
}
