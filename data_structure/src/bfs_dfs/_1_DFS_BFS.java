package bfs_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// DFS : ���̿켱 Ž�� - Stack���� �����Ѵ� -> ��ͷ� �����Ѵ� (����Լ��� Stack�� ������)
// BFS : �ʺ�켱 Ž�� - Queue�� �����Ѵ�. 
// �׷��� ǥ�� : �������  & ��������Ʈ (���⼱ ���� ����Ʈ�� �����Ѵ�.)
public class _1_DFS_BFS {
	// arrays of ArrayLists. 
	/*https://stackoverflow.com/questions/29906131/defining-an-array-of-list-of-integers-in-java?noredirect=1&lq=1*/
	// int Ÿ���� �迭�� int[] a �̷��� �����ϵ���
	// ArrayList<Integer> Ÿ���� �迭�� �Ʒ��� ���� �����Ѵ�.(a �迭�� ���ҷ� ArrayList<Integer>�� ������ ����)
	static ArrayList<Integer>[] a; 	// a[i]  : i�� ����� ���� ����Ʈ ����
	static boolean[] check; 		// ���� �湮 ���� 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// ������ ���� 
		int m = sc.nextInt();	// ������ ����
		int start = sc.nextInt();  // Ž���� ������ ������ ��ȣ 
		
		//arrays of ArrayLists.
		a = new ArrayList[n+1];			// ������ ������ ����Ʈ 
		
		
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();		// �� �������� ����� ���� ����Ʈ ����
		}
		
		// ������ ������ŭ �ݺ��ϸ鼭 ������ �Է� - ����
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();		// u�� v�� ����Ǿ� ����
			int v = sc.nextInt();
			a[u].add(v);				
			a[v].add(u);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(a[i]);
		}
		
		check = new boolean[n+1];
		
		dfs(start);
		System.out.println();
		
		check = new boolean[n+1];
		
		bfs(start);
		System.out.println();
	}
	
	// ��� (����)���� ����
	public static void dfs(int x) {
		if(check[x]) {	// �̹� �湮�ߴ� ���̸� 
			return; 	// stack���� ���� 
		}
		
		check[x] =true;
		System.out.println(x+" ");
		
		for(int y : a[x]) {			// x������ ����� ���� �� �ϳ� ������ 
			if(!check[y]) {			// �� ������ ���� �湮 ���� ���̸�
				dfs(y);				// �� ������ �湮�Ѵ�. 
			}
		}
	}
	
	// �̰� ��� ���� �ƴ�.  ť�� ����
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();		
		// �������� ����� ���� ��� ���⿡ ���, ���� �ϳ� ���� 
		// -> ������ ����(a)���� ���̻� �� ���� ������ -> a�� pop�Ѵ�.
		q.add(start);				// �������� ť�� �ְ� üũ���ش�.
		check[start]=true;
		
		
		while(!q.isEmpty()) {
			int x = q.remove();	// ť�� ����� ������ ��� �ְ��� ���̻� �� ���� ���� ������ pop�� ���ִ� ��
			System.out.println(x+" ");
			for(int y : a[x]) {			// x�� ����� ��� ������ ���ؼ� 
				if(!check[y]) {			// ���� �� ������ �湮���� �ʾҴٸ�
					check[y] = true;	// �湮�� üũ���ְ�
					q.add(y);			// ť�� �߰��Ѵ�. 
				}
			}
			// x�� ����� ���� ��� ť�� �����ϰ� ����, ť�� ������ ������ ������ �ݺ��Ѵ�. 
		}
		
		
	}
}
