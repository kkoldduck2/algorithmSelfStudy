package study_beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2573
// https://bcp0109.tistory.com/11
// ���� �丶�� ������ �����ϴ� https://bcp0109.tistory.com/9?category=847904
// ���� �ؼ��� ���� 
// ����Ƴ� ���� 
public class _03_2573 {
	
	static int N;
	static int M;
	static int year;
	static int[][] map;
	static boolean[][] visited;
	static int[][] melt; 	// x,y ��ǥ���� �󸶳� ����� 
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
		
		
		// 1�⵿�� map �ѹ��� ���� 
		while(true) {
			int count=0;		// ���� ��� ���� 
			
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<M-1; j++) {
					if(map[i][j]!=0 && visited[i][j]==false) {
						dfs(i,j);
						count++;
					}
				}
			}
			
			if(count==0) {	// ���δ� ���� ������ �� ��� �̻����� �и� ���� ������ 0 ���
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
	
	// �̾��� ��� ��� Ž�� --> � ������ �˻� 
	public static void dfs(int x, int y) {
		visited[x][y] =true;
		
		// �ֺ��� �ƹ��͵� ����. ��� 0 -> return; dfs �������´�.
		
		// �������Ͽ� ���� -> �ش� ��ġ���� 1�� �Ŀ� ��� ������ �� ���ؼ� melt[x,y]�� ����-> �ֺ� �湮(recursively)
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
	        * 1. ���� ���̱�
	        * 2. ���� ���� ���̰� ������ �Ǹ� 0���� �ٲ��ֱ�
	        * 3. visited �ʱ�ȭ
	        * 4. melt �ʱ�ȭ
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
