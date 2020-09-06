package brute_force_search;

import java.util.*;
// https://www.acmicpc.net/problem/1697
// Ʋ...��.... 
// ���̳������� Ǯ��� �ߴµ� �� ������ ���� ����!
// ����Ž�� : ���̳��� + ť(BFS, ���� ���� Ʈ�� �����ض�)

public class queue_01_1697 {
	public static final int MAX = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean[] check = new boolean[MAX];
		int[] dist = new int[MAX]; 	// ���̳���  dist[k] : k�� �� �� ���� �湮�ߴ��� 
		
		/* 1) ������ ť�� */
		check[n] = true; // �����̰� ���� �ִ� ��ġ�� �̹� �湮����
		dist[n] = 0; // n->n 0��
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		
		while(!q.isEmpty()) {
			/* 2) pop : ���� �����̰� ��� �ִ���*/
			int now = q.poll();
			
			/* 3) ���� ���� push : n-1, n+1, 2n */
			if(now-1 >=0 && check[now-1]==false) {
				q.add(now-1);
				check[now-1] = true;
				dist[now-1] = dist[now]+1;
			}
			
			if(now+1 <MAX && check[now+1]==false) {
				q.add(now+1);
				check[now+1] = true;
				dist[now+1] = dist[now]+1;
			}
			
			if(now*2 <MAX && check[now*2]==false) {
				q.add(now*2);
				check[now*2] = true;
				dist[now*2] = dist[now]+1;
			}
		}
		
		System.out.println(dist[k]);
		
	}	
}
