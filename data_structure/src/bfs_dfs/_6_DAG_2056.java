package bfs_dfs;
// https://www.acmicpc.net/problem/2056

import java.util.*;

/*�����ؾ� �� �۾� N�� (3 �� N �� 10000)�� �ִ�. ������ �۾����� �ɸ��� �ð�(1 �� �ð� �� 100)�� ������ �־�����.

��� �۾��� ���̿��� ���� ������ �� �־, � �۾��� �����ϱ� ���� �ݵ�� ���� �Ϸ�Ǿ�� �� �۾����� �ִ�. 
�� �۾����� ��ȣ�� ���� ���ڰ� �Ű��� �־, K�� �۾��� ���� ���� ���迡 �ִ�(��, K�� �۾��� �����ϱ� ���� �ݵ�� ���� �Ϸ�Ǿ�� �ϴ�) 
�۾����� ��ȣ�� ��� 1 �̻� (K-1) �����̴�. �۾��� �߿���, �װͿ� ���� ���� ���迡 �ִ� �۾��� �ϳ��� ���� �۾��� �ݵ�� �ϳ� �̻� �����Ѵ�.
 (1�� �۾��� �׻� �׷��ϴ�)

��� �۾��� �Ϸ��ϱ� ���� �ʿ��� �ּ� �ð��� ���Ͽ���. ����, ���� ���� ���谡 ���� �۾����� ���ÿ� ���� �����ϴ�.*/
/* �Է� : ù° �ٿ� N�� �־�����. �� ��° �ٺ��� N+1��° �ٱ��� N���� ���� �־�����. 
 * 2��° ���� 1�� �۾�, 3��° ���� 2�� �۾�, ..., N+1��° ���� N�� �۾��� ���� ��Ÿ����.
 * �� ���� ó������, �ش� �۾��� �ɸ��� �ð��� ���� �־�����, �� ������ �� �۾��� ���� ���� ���迡 �ִ� �۾����� ����(0 �� ���� �� 100)�� �־�����. 
 * �׸��� ���� ���迡 �ִ� �۾����� ��ȣ�� �־�����.*/
/* ��� : ù° �ٿ� ��� �۾��� �Ϸ��ϱ� ���� �ּ� �ð��� ����Ѵ�.*/
public class _6_DAG_2056 {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt(); // N���� �۾� (���)
		List<Integer>[] a = (List<Integer>[])new List[n+1];		// list�� ���ҷ� �ϴ� �迭 a 
		
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();		// 1�� �۾� ~ n�� �۾� (�� ������ ���� list�� ����)
		}
		
		int ans1 = dag1(a, n);
		System.out.println(ans1);
//		dag2(a, n);
	}
	
	
	// <1�� Ǯ��>
	static int dag1(List<Integer>[] a, int n) {

		/*���� ����*/
		int[] ind = new int[n+1]; // �� ����� in-degree ���� 
		int[] work = new int[n+1]; // �� �� �۾����� : 1�� �۾�, 2�� �۾�, ...
		
		int[] d = new int[n+1];	// �ּ� �ð��� ���ϱ� ���� ���� (�ִܰŸ�)
		
		/* ������ ���� (in degree�� �߽����� �����Ѵ�)*/
		for(int i=1; i<=n; i++) {
			work[i] = sc.nextInt(); // i�� �۾��� �ɸ��� �ð�
			int cnt = sc.nextInt(); // i���� ����Ǿ�� �ϴ� �۾��� ����
			for(int j = 0; j<cnt; j++) {
				int x = sc.nextInt();	// ���� �۾� ��ȣ 
				a[x].add(i);			// x�� ������ ��忡 i ���� (x -> i)
				ind[i]+=1;				// i ����� in degree ���� +1
			}
		}
		
		/*BFS Ž��*/
		// BFS Ž���� ���� ť ����
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(ind[i]==0) {		// in degree�� 0�� ��� �۾� ���� ť�� �߰�
				q.add(i);
				d[i] = work[i];		// i���� �����ϴµ� �ɸ��� �ð� = (���� i�ۿ� �ȴ�����Ƿ�) i�� �����ϴµ� �ɸ��� �ð�
			}
		}
		
		// n�� ȸ�� (��� ������ŭ)
		for(int i=0; i<n; i++) {
			int x = q.remove();
			
			// x�� ������ y��忡 ���ؼ� -> (x�� �ű⼭ ���� ������ edge �����ϴ� �۾�)
			for(int y : a[x]) {	
				ind[y]-=1;
				if(d[y] < d[x]+work[y]) {	// y�� ������ �� ��, work[y]�� ���� ū �긦 �����ؾ��Ѵ�. 
					// => ��� �̸�ŭ�� �ð��� �귯�� �Ѵ�.(��Ʈ ����)
					d[y] = d[x]+work[y];
				}
				
				if(ind[y]==0) {	//���� y����� in degree�� 0�� �ȴٸ� �굵 ť�� �߰�
					q.add(y);
				}
			}
		}
		int ans =0;
		for(int i=1; i<=n; i++) {
			ans=Math.max(ans, d[i]);		// d[i] �� ���� ū ���� ���� 
		}
		
		return ans;
	}
	
	// <2�� Ǯ��> out degree �߽� : dfs�� �̿��Ѵ�. 
	static void dag2(List<Integer>[] a, int n) {
		int[] work = new int[n+1];	// �� �۾��ϴµ� �ɸ��� �ð� 
		Scanner sc = new Scanner(System.in);
		// �ϴ� ������ ����
		for(int i=1; i<=n; i++) {
			work[i] = sc.nextInt();
			int cnt = sc.nextInt();		// ����Ǿ�� �ϴ� �۾��� ����  
			for(int j=0; j<cnt; j++) {
				int x = sc.nextInt();	// ����Ǿ�� �ϴ� �۾��� ��ȣ 
				a[x].add(i);		// ������ ��� �߰� (x -> i)
			}
		}
		
		boolean[] visited = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			visited[i] = false;
		}
		LinkedList<Integer> R = new LinkedList<>();		// LinkedList�� List, ArrayList�� ���̴� ����? �� LinkedList�� ����� ���ϱ�?
		for(int i=1; i<=n; i++) {	// ������ �湮 ���� ��忡 ���ؼ� 
			if(visited[i]==false) {
				dfs(i, R, a, visited);
			}
		}
		
		// LinkedList ��� -- �̰� �� �� �ִµ� ���� ���� ã�°�.... ��� �ؾ����� �𸣰ڴ�. 
		System.out.println(Arrays.toString(R.toArray()));
		
		Object[] ansli = R.toArray();
		int[] d = new int[n+1];		// i���� �۾��ϴµ� �ɸ��� �� �ð�
		// ansli[k]�ϴµ� �ɸ��� �ð� = 
		
	}
	
	static void dfs(int i, LinkedList<Integer> R, List<Integer>[] a, boolean[] visited) {
		visited[i] = true;
		// i�� ������ ��� �� ���� �湮 ���� ���  dfs�� �湮
		for(int x : a[i]) {
			if(!visited[x]) {
				dfs(x, R, a, visited);
			}
		}
		
		// for�� �������� -> i��忡�� �� �� �ִµ��� �� ������ ���̻� ������ ��� �� �Լ��� ȣ���� ������ �ǵ��� �����ϴ� ������ 
		// i�� ���� ���� ���Ḯ��Ʈ �� �տ� �߰����ش�. 
		R.addFirst(i);
	}
}
