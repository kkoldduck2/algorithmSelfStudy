package study_beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/6603
// 조합 + 모든 경우의 수 (완전 탐색, 백트래킹)
/* 백트래킹 문제
 * 백트래킹은 모든 경우의 수를  탐색을 진행 할때 탐색을 한 후에 다시 값을 탐색하기 이전으로 되돌리는 형태의 알고리즘 이다. 
 * */
public class _01_6603 {
	public static int k;			// 집합 S의 원소의 개수 
	public static int[] S;
	public static boolean[] visited;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k ==  0) break;
			
			S = new int[k];					// 전체 집합, 여기서 일부를 선택한다. 
			visited = new boolean[k];		// S에서 i번째 인덱스의 원소를 방문했는지 여부 
			
			for(int i=0; i<k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			System.out.println();
		}
	} 
	
	// 백트래킹 시작 (매개변수 : 내가 현재 (상태공간)트리의 어떤 노드에 있는지를 지정)
	// 트리는 엄밀히 말해서 배열이다. 그냥 우리가 상상하는 모양이 그렇게 생긴거임. 물리적으로는 배열
	// 이 문제는 경우의 수가 하나만 존재하는게 아니고 여러 경우의 수를 모두 print 하는 문제이므로 
	// if else 보다는 if 하고 + 또 찾기 이렇게 가야한다. 
	
	// start번째 인덱스 원소(노드)를 방문함 
	// i) 원소 개수가 6개면  --> 끝남
	// ii) 아직 아니면 --> 그 다음에 선택할 원소 고르기 (for문)
	public static void dfs(int start, int depth) {
		
		// 6개 모두 선택 
		if(depth==6) {
			print();
			return;
		}
	
		// 순차적인 배열에서 인덱스 start 이후 노드들 중 어떤 노드를 방문할 것인가.   visit children recursively (자식 노드 방문)
		// 현재 노드 바로 다음에 방문하는 노드가 : i+1 인 경우, i+2인 경우, i+3 인 경우 ...  
		// sol 1)  ex) N queens 문제 
//		for(int i=start; i<k; i++) {
//			visited[i]= true;
//			dfs(i+1, depth+1);
//			visited[i] = false;	// 백트래킹 : 탐색을 한 후에 다시 값을 탐색하기 이전으로 되돌림
//		}
		
		// sol 2) 
		// 권오흠 교수님 st 풀이!!ㅋㅋㅋ 아싸 성공
		// 이 풀이는 start 노드를 포함했을때 /포함하지 않을때 로 나눠서 경우의 수를 구하는 것
		if(start <k) {
			visited[start] = true;
			dfs(start+1, depth+1);
			
			visited[start] = false;
			dfs(start+1, depth);	// start를 방문 안했다면 dept는 여전하다 
		}
		

		
	}
	
	public static void print() {
		for(int i=0; i<k; i++) {
			if(visited[i]==true) {
				System.out.print(S[i]+" ");
			}
		}

		System.out.println();
	}
	
}
