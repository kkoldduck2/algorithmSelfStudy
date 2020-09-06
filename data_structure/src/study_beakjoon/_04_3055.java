package study_beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3055
// * : 물이 차있는 지역 
// . : 이동할 수 있음
// S : 현재 고슴도치 위치
// D : 목적지 
// 매 분마다 고슴도치는 현재 있는 칸과 인접한 네칸 (위, 아래, 오, 왼)으로 이동할 수 있다. 
// 물도 매 분마다 비어있는 칸으로 확장한다. 물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 
// 물과 고슴도치는 돌을 통과할 수 없다. 또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.
// 고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 
// 첫째 줄에 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간을 출력한다. 만약, 안전하게 비버의 굴로 이동할 수 없다면, "KAKTUS"를 출력한다.

// dfs(재귀)를 이용해서 풀려고 했으나 stack over flow 발생 -> bfs로 풀어야 할듯
public class _04_3055 {
	static Character[][] map;
	static int minT = Integer.MAX_VALUE;
	static int r;
	static int c;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());	// 행
		c = Integer.parseInt(st.nextToken());	// 열 
		map = new Character[r][c];
		visited = new boolean[r][c];
		
		int di=0;
		int dj=0;
		// map에 저장
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			String ri = st.nextToken();
			for(int j=0; j<ri.length(); j++) {
				map[i][j] = ri.charAt(j);
				if(map[i][j]=='S') {
					di=i;
					dj=j;
				}
			}
		}
		
		// 고슴도치 이동 (고슴도치 현재 위치 : S, 시간 )
		move(di, dj,0);
		System.out.println(minT);
	}
	
	// 현재 위치가 D 인 경우 
	// 이웃한 셀들 중 하나에서 출구까지 가는 경로가 있거나 (Recursion - 있으면 true, 없으면 false)
	static boolean move(int i, int j, int t) {
		// 물 이동
		waterExpansion();
		
		// 실패 : 현재 위치가 돌이거나 물이 차오른 곳 			실패 부터 써야 Array bound Exception 안난다. 
		if(i<0 || j<0 ||i>=r || j>=c || map[i][j]=='X' || map[i][j]=='*' || visited[i][j]== true) {
			return false;
		}else if(map[i][j] == 'D') {		// 성공 (현재 위치가 D)
			minT = minT > t ? t: minT;
			return true;
		}
		else {
			if(move(i+1,j,t+1) || move(i-1,j,t+1) || move(i,j+1,t+1) || move(i, j-1, t+1)) {// 이웃한 셀들 중에 출구로 가는 경로가 있음 
				visited[i][j] = true;
				return true;
			}
			
			System.out.println("KAKTUS");
			return false;		// 이웃한 셀들 중에 없을 경우  : KAKTUS 출력
		}
		
	}
	
	static void waterExpansion() {
		// 물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 물과 고슴도치는 돌을 통과할 수 없다. 
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]=='*') {
					if(i+1<r && map[i+1][j] != 'X' && map[i+1][j] == '.') map[i+1][j]='*';
					if(i-1>0 && map[i-1][j] != 'X' && map[i-1][j] == '.') map[i-1][j]='*';
					if(j+1<r && map[i][j+1] != 'X' && map[i][j+1] == '.') map[i][j+1]='*';
					if(j-1>0 && map[i][j-1] != 'X' && map[i][j-1] == '.') map[i][j-1]='*';
					
				}
			}
		}
	}
}
