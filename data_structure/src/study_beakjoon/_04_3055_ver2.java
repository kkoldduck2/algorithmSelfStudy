package study_beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 '최소 시간'을 구하는 프로그램을 작성하시오.
// 최소시간 -> 그래프에서 bfs로 푼다 
// 상태 연결하는 간선의 가중치가 모두 1일 경우 
// BFS는 최단 경로를 구하는 알고리즘이 된다! 그래서 bfs로 푼다 

// 다른 사람 풀이 보고 공부! BFS 문제 
// https://www.acmicpc.net/problem/3055

class Pair{ //물에 대한 정보를 넣을 때도 쓰고, BFS때도 쓰고.. 용이함.
	int x, y;
	
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class _04_3055_ver2 {
	
	static final int[] dx = {1, -1, 0, 0}; // 이건 정말 그냥 필수 상수..
	static final int[] dy = {0, 0, 1, -1};
	
	// 물에 대한 bfs
	static void bfsW(int[][] water, Queue<Pair> q, int n, int m) {
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;	// 현재 물의 위치
			
			// 물이 갈 수있는 곳 bfs	좌,우,위,아래
			for(int k=0; k<4; k++) {
				int nx = x +dx[k];
				int ny = y + dy[k];
				// map 범위 안에 있어야함 오류 안나려면
				if(nx >=0 && nx<n && ny>=0 && ny<m) {
					if(water[nx][ny] ==0) {	// -1 : 바위있어서 못지나감,  1: 이미 지나감 , 0: 갈수 있는 곳
						water[nx][ny] =water[x][y] + 1;	// 아 몇 초뒤에 물이 차는지 기록해두는 것.  water[x][y]가 x초에 찬다면 . water[nx][ny]는 x+1초에 찬다. 
						q.add(new Pair(nx, ny));
					}
				}
			}
			
		}
	}
	
	//물 bfs해주고 도치도 bfs
	static void bfsD(int[][] water, int[][] dochi, int dI, int dJ, int n, int m) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(dI, dJ));		// 현재 도치 위치
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (dochi[nx][ny] == 0) {//도치가 안 지나감
						if ((dochi[x][y] + 1) < water[nx][ny] || water[nx][ny] == 0) {//물이 안 지나갔거나 물보다 작을 때.. 그래서 물 은 n*m+1넣어줌
							dochi[nx][ny] = dochi[x][y] + 1;
							q.add(new Pair(nx, ny));
						}
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Queue<Pair> qwater = new LinkedList<Pair>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[n][m];	// 이거 map인가?
		int[][] water = new int[n][m];
		int[][] dochi = new int[n][m];  // 고슴도칰ㅋㅋㅋ
		int dI =0, dJ =0, bI=0, bJ=0; 	//도치 i,j 비버굴 i,j
		int k=0;
		
		for(int i=0; i<n; i++) {
			String s = sc.nextLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='S') {
					dI = i;
					dJ = j;
					dochi[i][j] = 1;	//도치 위치 1
				}
				if (map[i][j] == 'D') {
					bI = i;
					bJ = j;			// 비버굴 위치 
					water[i][j] = n*m+1; //에서 water는 n*m+1인게 포인트.. n*m이었다가 실수나
				}
				if(map[i][j]=='*') {
					qwater.add(new Pair(i,j)); // 물의 위치를 큐에 넣어줌
					water[i][j] = 1;
				}
				if(map[i][j]=='X') {	// 고슴도치와 물 모두 못가는 곳
					dochi[i][j] = -1;
					water[i][j] = -1;
				}
			}
		}
		
		bfsW(water, qwater, n, m); // 큐워터와 함께 bfs로 슝
		bfsD(water, dochi, dI, dJ, n, m);	// 도치 bfs
		
		if(dochi[bI][bJ] !=0) {
			System.out.println(dochi[bI][bJ] - 1);// 도치 첨에 위치 1 해줬으니까 -1
		}
		else
			System.out.println("KAKTUS"); //캑터스
	}
}
