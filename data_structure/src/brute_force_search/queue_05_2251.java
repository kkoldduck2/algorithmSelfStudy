package brute_force_search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2251
/* 각각 부피가 A, B, C(1≤A, B, C≤200) 리터인 세 개의 물통이 있다. 
 * 처음에는 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C 리터) 차 있다. 
 * 이제 어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있는데, 이때에는 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다.
 * 이 과정에서 손실되는 물은 없다고 가정한다.
이와 같은 과정을 거치다보면 세 번째 물통(용량이 C인)에 담겨있는 물의 양이 변할 수도 있다. 
'첫 번째 물통(용량이 A인)이 비어 있을 때, 세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양'을 모두 구해내는 프로그램을 작성하시오.

입력 : 첫째 줄에 세 정수 A, B, C가 주어진다.
출력 : 첫째 줄에 공백으로 구분하여 답을 출력한다. 각 용량은 오름차순으로 정렬한다.
 * */
/*
 * 물통 3개를 다 해보는 경우의 수로 계산해도 200*200*200로 넉넉하다. 그러므로
BFS를 통한 완전 탐색을 하고 그 와중에 A가 비어있을 때 C의 물의 양을 출력하면 된다.
다른 BFS문제와 비슷하게 물을 부을 수 있는 경우의 수를 전부 큐에 넣으면서 탐색하면 된다.
물을 부을 수 있는 경우의 수는 6가지이다.
C -> A, C -> B, B -> A, B -> C, A -> B, A -> C

a + b + c = C(처음)
c = C(처음)-a-b
따라서 a, b의 경우의 수를 체크하면 자동적으로 달라진 c도 체크된다. 
*
*/

class Pair implements Comparable<Pair>{
	final int first;
	final int second;
	Pair(int first, int second){
		this.first = first;
		this.second = second;
	}
	
	@Override
	public int compareTo(Pair pair) {
		if(this.first < pair.first) {
			return -1;		// 기준 값이 비교대상보다 작은 경우 -1
		}
		if(this.first > pair.first) {
			return 1;
		}
		if(this.second < pair.second) {
			return -1;
		}
		if(this.second > pair.second) {
			return 1;
		}
		return 0;		// 기준값이 비교대상과 같을 경우 0
	}
	
	public boolean equals(Object object) {
		if(object instanceof Pair) {
			Pair pair = (Pair)object;
			return this.first == pair.first && this.second == pair.second;
		}
		return false;
	}
	
	// 몰겠다..ㅅㅂ
	public int hashCode() {
		int n=3;
		n = 19*n+this.first;
		n = 19*n+this.second;
		return n;
	}
}
public class queue_05_2251 {
	static final int[] from = {0,0,1,1,2,2};
	static final int[] to = {1,2,0,2,0,1};
	// 0->1, 0->2 이렇게 옮겨 담는 것을 의미한다. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cap = new int[3];	// 물통 3개
		for(int i=0; i<3; i++) {
			cap[i] = sc.nextInt();
		}
		
		int sum = cap[2];	// C (초기값)
		boolean[][] check = new boolean[201][201];
		boolean[] ans = new boolean[201];	// c의 경우의 수 
		
		// 여기서부턴 평범한 bfs
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0));	// a=0, b=0
		check[0][0] = true;
		ans[cap[2]] = true;
		while(!q.isEmpty()) {
			int[] cur = new int[3];
			Pair p = q.peek();
			cur[0] = p.first;
			cur[1] = p.second;
			cur[2] = sum - cur[0] - cur[1];
			q.remove();
			
			// 6가지 경우의 수에 대해서 
			for(int k=0; k<6; k++) {
				int[] next = {cur[0], cur[1], cur[2]};	// 다음 회차 a,b,c의 용량
				next[to[k]] += next[from[k]];
				next[from[k]] =0;
				
				// 넘치면
				if(next[to[k]]> cap[to[k]]) {
					next[from[k]] = next[to[k]] - next[from[k]];
					next[to[k]] = cap[to[k]];
				}
				
				// 아직 방문 안한 노드 (새로운 용량)이면  -> check! & 큐에 추가 
				if(!check[next[0]][next[1]]) {
					check[next[0]][next[1]] = true;
					q.add(new Pair(next[0], next[1]));
					
					// 그리고 a 물통의 용량이 0이면 
					// ans(c 용량 체크 배열)의 해당 용량에 true라고 해줌 
					// 그 노드를 방문했다는 뜻
					if(next[0] ==0) {
						ans[next[2]] = true;
					}
				}
			}
		}
		
		// q가 empty가 됨 
		// C(처음 c의 용량)만큼 돌면서 c에 얼마만큼의 용량이 담겼었는지 프린트 한다. 
		for(int i=0; i<=cap[2]; i++) {
			// i용량을 방문 했으면 
			if(ans[i]) {
				System.out.println(i+" ");
			}
		}
		System.out.println();
	}
}
