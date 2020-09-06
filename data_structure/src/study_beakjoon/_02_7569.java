package study_beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 매개변수는 참조인가?

// https://www.acmicpc.net/problem/7569

/*보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
 * 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 
 * 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
 * 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.*/

// 입력 : 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다. 
//		(M : 가로, N : 세로, H : 높이)
//		둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다. 
//		정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
// 출력 : 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력
//  만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

// 무엇을 check로 정의할 것인지, 어떻게 check 해 줄 것인지 생각하기 
// 이미 익은 토마토 = 1(이미 방문) => 익은 토마토로부터 시작해서 하루가 지날때마다 주변 안익은 토마토 방문(익힌다)
// d[시작부터 익은 토마토 위치] = 1
// d[둘째날 익은 토마토 위치] = d[시작부터 익은 토마토 위치] +1 = 2
// d[n번째 날 익은 토마토 위치] = d[n-1번째 날 익은 토마토 위치] +1

// 모든 토마토를 다 방문했을때 d[x] 값중 가장 큰 값을 구한다.  정답은 max(d[x][y][z])-1;
public class _02_7569 {
	
	// 토마토의 위치 저장 
	static class Pair{
		int x;
		int y;
		int z; 
		
		Pair(int x, int y , int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}
	static final int[] dx = {1,-1,0,0,0,0};		// final 붙이면 변경 불가능 
	static final int[] dy = {0,0,1,-1,0,0};
	static final int[] dz = {0,0,0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[][][] map = new int[h][n][m];		// 현재 상자의 상태
		int[][][] d = new int[h][n][m];			// 방문 여부 
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int k=0; k<m; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k]==-1) {
						d[i][j][k] =-1;  		// 비어있는곳은 그냥 -1로 써준다. 
					} 
				}
			}
		}
		
		bfs(map,d,h,n,m);
		
		
		// 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
		int ans=0;
		boolean ok= true;
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(d[i][j][k]==0) {
						ok = false;
					}
					
					if(d[i][j][k] > ans)
						ans =d[i][j][k];
				}
			}
		}
		
		if(ok) {
			System.out.println(ans-1);
		}else {
			System.out.println(-1);
		}
	
		
	}
	
	public static void bfs(int[][][] map,int[][][] d,int h, int n, int m) {
		Queue<Pair> q = new LinkedList<>();
		
		// 1. 첫날부터 익은 토마토 ->  방문 check  && 큐에 담기
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(map[i][j][k]==1) {
						q.add(new Pair(i,j,k));
						d[i][j][k] =1;  		
					} 
				}
			}
		}
		
		// 2. bfs 시작
		while(!q.isEmpty()) {
			// 가장 앞의 노드 제거
			Pair now = q.remove();
			int x = now.x;
			int y = now.y;
			int z = now.z;
			
			// 인접한 노드 방문 (위, 아래, 좌, 우, 앞, 뒤)
			for(int i=0; i<6; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				int nz = z+dz[i];
				
				// (out of bound exception 처리 해주기) 
				if(nx>=0 && nx<h && ny>=0 && ny<n && nz>=0 && nz<m) {
					// 아직 방문 안한 노드라면
					if(d[nx][ny][nz]==0 && map[nx][ny][nz]==0) {
						q.add(new Pair(nx, ny, nz));
						d[nx][ny][nz] = d[x][y][z]+1;
					}
				}
				
			}
		}
		
	}
}
