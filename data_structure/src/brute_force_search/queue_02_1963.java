package brute_force_search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1963

// 두 네자리 소수 N과 M이 주어졌을 때, N을 M으로 바꾸는 '최소 변환 횟수'를 구하는 문제
// 한번에 N에서 한자리만 바꿀 수 있고 
// 바꾼 숫자도 소수여야 한다. 
// 미리 모든 4자리 소수를 구해놓고 시작한다. (4자리, 1000이상 10000미만 -> 총 정점의 개수도 10000개 이하 )
// 그 후 한자리씩 바꾸면서 그 숫자가 소수인지 아닌지 검사한다. (한번에 한자리씩 바꾸므로 각각의 간선의 가중치도 1이다)
// '에라토스테네스의 체'로 소수를 찾는다.

public class queue_02_1963 {
	
	// num에서 index번째 자리 수를 digit로 바꾼다. 
	static int change(int num, int index, int digit) {
		// 바꿀 수 없는 경우 : 첫번째 자리가 0인 경우
		if(index==0 && digit ==0) {
			return -1;
		}
		String s = Integer.toString(num);
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(index, (char)(digit+'0'));
		return Integer.parseInt(sb.toString());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] prime = new boolean[10001];		// i번 째 인덱스 = i 라고 생각, 그 숫자가 prime인지 아닌지 여부 
		
		
		// 미리 모든 소수 구하기 (에라토스테네스의 체)		10000개 이하라서 금방 구한다. 
		for(int i=2; i<=10000; i++) {
			if(prime[i] == false) {
				for(int j=i*i; j<=10000; j+=i) {	// i의 모든 배수는 prime 이 아니다. (나중에 뒤집는다)
					prime[j] = true;
				}
			}
		}
		
		for(int i=0; i<=10000; i++) {
			prime[i] = !prime[i];
		}
		
		int t = sc.nextInt();	// test case 개수
		
		// 
		while(t-- > 0) {		// 매 회전마다 t 감소, 0보다 클 때까지 
			int n = sc.nextInt();			// n 에서 
			int m = sc.nextInt();			// m 까지
			boolean[] c = new boolean[10001];
			int[] d = new int[10001];			// n -> m 최소 얼마나 걸리는지 (distance) // int 배열은 기본적으로 0으로 초기화됨		
			c[n] = true;	// 방문 여부 
			Queue<Integer> q = new LinkedList<>();
			q.add(n);
			while(!q.isEmpty()) {
				int now = q.remove();		// 현재 노드에서 
				for(int i=0; i<4; i++) {	// i번째 자리 숫자를
					for(int j=0; j<=9; j++) {	// j로 바꾸기 (0 <= j <= 9)
						int next = change(now, i, j);		// 바꾼 숫자는 next에 담고
						if(next!=-1) {			// next가 -1이 아니라면 
							if(prime[next] && c[next]==false) {		// next가 소수인지 검사 && 아직 방문 안한 숫자 
								q.add(next);		// 큐에 추가 
								d[next] = d[now] +1;		// dist[next] = dist[now] +1 
								c[next] = true;		// next 방문 여부 확인 
							}
						}
					}
				}
				System.out.println(d[m]);		// d[m] : n->m 까지 걸린 시간(거리)
			}
		}
	}
}
