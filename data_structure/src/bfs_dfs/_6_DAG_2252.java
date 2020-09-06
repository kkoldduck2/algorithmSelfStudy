package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2252
/*N명의 학생들을 키 순서대로 줄을 세우려고 한다. 
 * 각 학생의 키를 직접 재서 정렬하면 간단하겠지만, 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 하였다. 
 * 그나마도 모든 학생들을 다 비교해 본 것이 아니고, 일부 학생들의 키만을 비교해 보았다.

일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오.*/

/*입력 : 첫째 줄에 N(1≤N≤32,000), M(1≤M≤100,000)이 주어진다. M은 키를 비교한 회수이다.
다음 M개의 줄에는 키를 비교한 두 학생의 번호 A, B가 주어진다.
 이는 학생 A가 학생 B의 앞에 서야 한다는 의미이다.
학생들의 번호는 1번부터 N번이다.

 출력: 첫째 줄부터 앞에서부터 줄을 세운 결과를 출력한다. 답이 여러 가지인 경우에는 아무거나 출력한다.
*/

/* 입력 예시 
	3 2
	1 3		1번 학생이 3번 학생보다 앞에 와야
	2 3		2번 학생이 3번 학생보다 앞에 와야  */
/* 출력예시
 * 1 2 3   or 2 1 3 
 * */

public class _6_DAG_2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 학생들의 번호 1~n번
		int m = Integer.parseInt(st.nextToken());	// 비교 횟수 
		
		List<Integer>[] li = new List[n+1];
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList<Integer>();
		}
		
		int[] ind = new int[n+1];		// 각 노드의 in degree 개수 
		
		// m번 비교 
		for(int k=0; k<m; k++) {
			st =new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 방향 그래프 : a->b
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
//		int[] order = new int[n];	// 순서 담을 배열 
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

		
		// sol2) 맨 뒤에서부터 저장  (R의 맨 앞에 추가한다. )
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
		
		// i와 인접한 모든 노드 y에 대하여
		for(int y : li[i]) {
			if(!visited[y]) {
				dfs(y, li, visited, R);
			}
		}
		
		// for문 빠져 나오면  -> out degree가 없는 (마지막)노드에 다달았다 라는 뜻 -> R의 맨 앞에 추가해준다
		R.addFirst(i);
		
	}
}
