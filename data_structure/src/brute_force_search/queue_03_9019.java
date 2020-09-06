package brute_force_search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/9019
// 주어진 서로 다른 두 정수 A와 B(A ≠ B)에 대하여 A를 B로 바꾸는 최소한의 명령어를 생성하는 프로그램이다. 
// A에서 B로 변환하기 위해 필요한 최소한의 명령어 나열을 출력한다.
/* 이 문제는 최소값을 구해야 하는 건 맞지만 어떠한 과정을 거쳐야 하는지 구해야 한다.
 * -> 배열 두개를 더 이용해서 	어떤 과정을 거쳤는지 저장해야한다.
 * -> from[i] : i를 어떤 수에서 만들었는지 
 * -> how[i] : i를 어떻게 만들었는지 
 * 예) now -> next
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
			int[] dist = new int[10001];  // a-> b로 바꾸기까지 거리 
			int[] from = new int[10001];
			Character[] how = new Character[10001];
			
			check[a] =true;
			dist[a] =0;
			from[a] = -1;
			
			Queue<Integer> q = new LinkedList<>();
			q.add(a);
			
			while(!q.isEmpty()) {
				int now = q.poll();
				
				// now -> next로 갈수있는 모든 방향
				// -> D, S, L, R  --> 큐에 담기
				
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
			
			// 역순으로 출력한다. 
			System.out.println(ans.reverse());
			
		}
		
	}
}
