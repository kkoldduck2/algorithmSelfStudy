package brute_force_search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/9019
// �־��� ���� �ٸ� �� ���� A�� B(A �� B)�� ���Ͽ� A�� B�� �ٲٴ� �ּ����� ��ɾ �����ϴ� ���α׷��̴�. 
// A���� B�� ��ȯ�ϱ� ���� �ʿ��� �ּ����� ��ɾ� ������ ����Ѵ�.
/* �� ������ �ּҰ��� ���ؾ� �ϴ� �� ������ ��� ������ ���ľ� �ϴ��� ���ؾ� �Ѵ�.
 * -> �迭 �ΰ��� �� �̿��ؼ� 	� ������ ���ƴ��� �����ؾ��Ѵ�.
 * -> from[i] : i�� � ������ ��������� 
 * -> how[i] : i�� ��� ��������� 
 * ��) now -> next
 * dist[next] = dist[now] +1
 * from[next] = now
 * how[next] = 'D' 'S' 'L' 'R'
 * */
public class queue_03_9019 {
	static final int mod = 10000 ;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =  sc.nextInt();
		
		while(t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			boolean[] check = new boolean[10000];
			int[] dist = new int[10001];  // a-> b�� �ٲٱ���� �Ÿ� 
			int[] from = new int[10001];
			Character[] how = new Character[10001];
			
			check[a] =true;
			dist[a] =0;
			from[a] = -1;
			
			Queue<Integer> q = new LinkedList<>();
			q.add(a);
			
			while(!q.isEmpty()) {
				int now = q.poll();
				
				// now -> next�� �����ִ� ��� ����
				// -> D, S, L, R  --> ť�� ���
				
				// 'D'
				int next = (now*2)%10000;
				if(check[next] ==false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now]+1;
					from[next] = now;
					how[next] = 'D';
				}
				
				// 'S'
				next = now-1;
				if(check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now]+1;
					from[next] = now;
					how[next] = 'S';
				}
				
				// 'L' : d2, d3, d4, d1
				next = (now%1000)*10+now/1000;
				if(check[next]==false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now]+1;
					from[next] = now;
					how[next] = 'L';
				}
				
				// 'R' : d4, d1, d2, d3
				next = now/10 + (now%10)*1000;
				if(check[next]==false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now]+1;
					from[next] = now;
					how[next] = 'R';
				}
			}
			
			
			//						how[b]
			// a -> ..... -> from[b] --> b
			StringBuilder ans = new StringBuilder();
			while(a!=b) {
				ans.append(how[b]);	
				b = from[b];
			}
			
			// �������� ����Ѵ�. 
			System.out.println(ans.reverse());
			
		}
		
	}
}
