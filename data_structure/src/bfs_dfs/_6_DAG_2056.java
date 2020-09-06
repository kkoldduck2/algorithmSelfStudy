package bfs_dfs;
// https://www.acmicpc.net/problem/2056

import java.util.*;

/*수행해야 할 작업 N개 (3 ≤ N ≤ 10000)가 있다. 각각의 작업마다 걸리는 시간(1 ≤ 시간 ≤ 100)이 정수로 주어진다.

몇몇 작업들 사이에는 선행 관계라는 게 있어서, 어떤 작업을 수행하기 위해 반드시 먼저 완료되어야 할 작업들이 있다. 
이 작업들은 번호가 아주 예쁘게 매겨져 있어서, K번 작업에 대해 선행 관계에 있는(즉, K번 작업을 시작하기 전에 반드시 먼저 완료되어야 하는) 
작업들의 번호는 모두 1 이상 (K-1) 이하이다. 작업들 중에는, 그것에 대해 선행 관계에 있는 작업이 하나도 없는 작업이 반드시 하나 이상 존재한다.
 (1번 작업이 항상 그러하다)

모든 작업을 완료하기 위해 필요한 최소 시간을 구하여라. 물론, 서로 선행 관계가 없는 작업들은 동시에 수행 가능하다.*/
/* 입력 : 첫째 줄에 N이 주어진다. 두 번째 줄부터 N+1번째 줄까지 N개의 줄이 주어진다. 
 * 2번째 줄은 1번 작업, 3번째 줄은 2번 작업, ..., N+1번째 줄은 N번 작업을 각각 나타낸다.
 * 각 줄의 처음에는, 해당 작업에 걸리는 시간이 먼저 주어지고, 그 다음에 그 작업에 대해 선행 관계에 있는 작업들의 개수(0 ≤ 개수 ≤ 100)가 주어진다. 
 * 그리고 선행 관계에 있는 작업들의 번호가 주어진다.*/
/* 출력 : 첫째 줄에 모든 작업을 완료하기 위한 최소 시간을 출력한다.*/
public class _6_DAG_2056 {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt(); // N개의 작업 (노드)
		List<Integer>[] a = (List<Integer>[])new List[n+1];		// list를 원소로 하는 배열 a 
		
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();		// 1번 작업 ~ n번 작업 (에 인접한 노드들 list로 저장)
		}
		
		int ans1 = dag1(a, n);
		System.out.println(ans1);
//		dag2(a, n);
	}
	
	
	// <1번 풀이>
	static int dag1(List<Integer>[] a, int n) {

		/*변수 설정*/
		int[] ind = new int[n+1]; // 각 노드의 in-degree 개수 
		int[] work = new int[n+1]; // 몇 번 작업인지 : 1번 작업, 2번 작업, ...
		
		int[] d = new int[n+1];	// 최소 시간을 구하기 위한 변수 (최단거리)
		
		/* 데이터 저장 (in degree를 중심으로 저장한다)*/
		for(int i=1; i<=n; i++) {
			work[i] = sc.nextInt(); // i번 작업에 걸리는 시간
			int cnt = sc.nextInt(); // i보다 선행되어야 하는 작업의 개수
			for(int j = 0; j<cnt; j++) {
				int x = sc.nextInt();	// 선행 작업 번호 
				a[x].add(i);			// x와 인접한 노드에 i 저장 (x -> i)
				ind[i]+=1;				// i 노드의 in degree 개수 +1
			}
		}
		
		/*BFS 탐색*/
		// BFS 탐색을 위한 큐 생성
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(ind[i]==0) {		// in degree가 0인 모든 작업 먼저 큐에 추가
				q.add(i);
				d[i] = work[i];		// i까지 실행하는데 걸리는 시간 = (아직 i밖에 안담겼으므로) i를 실행하는데 걸리는 시간
			}
		}
		
		// n번 회전 (노드 개수만큼)
		for(int i=0; i<n; i++) {
			int x = q.remove();
			
			// x와 인접한 y노드에 대해서 -> (x와 거기서 뻗어 나가는 edge 삭제하는 작업)
			for(int y : a[x]) {	
				ind[y]-=1;
				if(d[y] < d[x]+work[y]) {	// y가 여러개 일 때, work[y]가 가장 큰 얘를 저장해야한다. 
					// => 적어도 이만큼의 시간이 흘러야 한다.(노트 참고)
					d[y] = d[x]+work[y];
				}
				
				if(ind[y]==0) {	//만약 y노드의 in degree가 0이 된다면 얘도 큐에 추가
					q.add(y);
				}
			}
		}
		int ans =0;
		for(int i=1; i<=n; i++) {
			ans=Math.max(ans, d[i]);		// d[i] 중 가장 큰 값을 저장 
		}
		
		return ans;
	}
	
	// <2번 풀이> out degree 중심 : dfs를 이용한다. 
	static void dag2(List<Integer>[] a, int n) {
		int[] work = new int[n+1];	// 각 작업하는데 걸리는 시간 
		Scanner sc = new Scanner(System.in);
		// 일단 데이터 저장
		for(int i=1; i<=n; i++) {
			work[i] = sc.nextInt();
			int cnt = sc.nextInt();		// 선행되어야 하는 작업의 개수  
			for(int j=0; j<cnt; j++) {
				int x = sc.nextInt();	// 선행되어야 하는 작업의 번호 
				a[x].add(i);		// 인접한 노드 추가 (x -> i)
			}
		}
		
		boolean[] visited = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			visited[i] = false;
		}
		LinkedList<Integer> R = new LinkedList<>();		// LinkedList와 List, ArrayList의 차이는 뭘까? 왜 LinkedList를 사용한 것일까?
		for(int i=1; i<=n; i++) {	// 임의의 방문 안한 노드에 대해서 
			if(visited[i]==false) {
				dfs(i, R, a, visited);
			}
		}
		
		// LinkedList 출력 -- 이건 할 수 있는데 문제 정답 찾는건.... 어떻게 해야할지 모르겠다. 
		System.out.println(Arrays.toString(R.toArray()));
		
		Object[] ansli = R.toArray();
		int[] d = new int[n+1];		// i까지 작업하는데 걸리는 총 시간
		// ansli[k]하는데 걸리는 시간 = 
		
	}
	
	static void dfs(int i, LinkedList<Integer> R, List<Integer>[] a, boolean[] visited) {
		visited[i] = true;
		// i와 인접한 노드 중 아직 방문 안한 노드  dfs로 방문
		for(int x : a[i]) {
			if(!visited[x]) {
				dfs(x, R, a, visited);
			}
		}
		
		// for문 빠져나옴 -> i노드에서 갈 수 있는데는 다 가보고 더이상 갈데가 없어서 이 함수를 호출한 곳으로 되돌아 가야하는 시점에 
		// i를 내가 받은 연결리스트 맨 앞에 추가해준다. 
		R.addFirst(i);
	}
}
