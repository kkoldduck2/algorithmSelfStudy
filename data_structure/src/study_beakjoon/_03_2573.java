package study_beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2573
// https://bcp0109.tistory.com/11
// 백준 토마토 문제랑 유사하다 https://bcp0109.tistory.com/9?category=847904
// 여기 해설을 보자 
// 개어렵네 쉬바 
public class _03_2573 {
	
	static int N;
	static int M;
	static int year;
	static int[][] map;
	static boolean[][] visited;
	static int[][] melt; 	// x,y 좌표에서 얼마나 녹는지 
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				visited[i][j] = false;
			}
		}
		
		int year=0;
		
		
		// 1년동안 map 한바퀴 돌기 
		while(true) {
			int count=0;		// 올해 덩어리 개수 
			
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<M-1; j++) {
					if(map[i][j]!=0 && visited[i][j]==false) {
						dfs(i,j);
						count++;
					}
				}
			}
			
			if(count==0) {	// 전부다 녹을 때까지 두 덩어리 이상으로 분리 되지 않으면 0 출력
				System.out.println(0);
				break;
			}
			else if(count >=2) {
				System.out.println(year);
				break;
			}
			
			melting();
			year++;
		}
		
		
	}
	
	// 이어진 모든 노드 탐색 --> 몇개 녹을지 검사 
	public static void dfs(int x, int y) {
		visited[x][y] =true;
		
		// 주변에 아무것도 없음. 모두 0 -> return; dfs 빠져나온다.
		
		// 동서남북에 있음 -> 해당 위치에서 1년 후에 녹는 빙산의 양 구해서 melt[x,y]에 저장-> 주변 방문(recursively)
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx <N && ny>=0 && ny<M) {
				if(map[nx][ny]==0) {
					melt[x][y]++;
				}
				
				if(map[nx][ny]>0 && visited[nx][ny]==false) {
					dfs(nx, ny);
				}
			}
		}
	}
	static void melting() {
		 /**
	        * 1. 빙산 녹이기
	        * 2. 만약 녹인 높이가 음수가 되면 0으로 바꿔주기
	        * 3. visited 초기화
	        * 4. melt 초기화
	        */    
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] -= melt[i][j];
				
				if(map[i][j] <0) map[i][j]=0;
				visited[i][j] =false;
				melt[i][j] = 0;
			}
		}
	}
	
}
