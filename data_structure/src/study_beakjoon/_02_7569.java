package study_beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// �Ű������� �����ΰ�?

// https://www.acmicpc.net/problem/7569

/*���� �� �Ϸ簡 ������, ���� �丶����� ������ ���� �ִ� ���� ���� �丶����� ���� �丶���� ������ �޾� �Ͱ� �ȴ�. 
 * �ϳ��� �丶�信 ������ ���� ��, �Ʒ�, ����, ������, ��, �� ���� ���⿡ �ִ� �丶�並 �ǹ��Ѵ�. 
 * �밢�� ���⿡ �ִ� �丶��鿡�Դ� ������ ���� ���ϸ�, �丶�䰡 ȥ�� ������ �ʹ� ���� ���ٰ� �����Ѵ�. 
 * ö���� â�� ������ �丶����� ��ĥ�� ������ �� �Ͱ� �Ǵ��� �� �ּ� �ϼ��� �˰� �;� �Ѵ�.*/

// �Է� : ù �ٿ��� ������ ũ�⸦ ��Ÿ���� �� ���� M,N�� �׾ƿ÷����� ������ ���� ��Ÿ���� H�� �־�����. 
//		(M : ����, N : ����, H : ����)
//		��° �ٺ��ʹ� ���� ���� ���ں��� ���� ���� ���ڱ����� ����� �丶����� ������ �־�����. 
//		���� 1�� ���� �丶��, ���� 0 �� ���� ���� �丶��, ���� -1�� �丶�䰡 ������� ���� ĭ�� ��Ÿ����.
// ��� : �丶�䰡 ��� ���� ������ �ּ� ��ĥ�� �ɸ������� ����ؼ� ���
//  ����, ����� ������ ��� �丶�䰡 �;��ִ� �����̸� 0�� ����ؾ� �ϰ�, �丶�䰡 ��� ������ ���ϴ� ��Ȳ�̸� -1�� ����ؾ� �Ѵ�.

// ������ check�� ������ ������, ��� check �� �� ������ �����ϱ� 
// �̹� ���� �丶�� = 1(�̹� �湮) => ���� �丶��κ��� �����ؼ� �Ϸ簡 ���������� �ֺ� ������ �丶�� �湮(������)
// d[���ۺ��� ���� �丶�� ��ġ] = 1
// d[��°�� ���� �丶�� ��ġ] = d[���ۺ��� ���� �丶�� ��ġ] +1 = 2
// d[n��° �� ���� �丶�� ��ġ] = d[n-1��° �� ���� �丶�� ��ġ] +1

// ��� �丶�並 �� �湮������ d[x] ���� ���� ū ���� ���Ѵ�.  ������ max(d[x][y][z])-1;
public class _02_7569 {
	
	// �丶���� ��ġ ���� 
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
	static final int[] dx = {1,-1,0,0,0,0};		// final ���̸� ���� �Ұ��� 
	static final int[] dy = {0,0,1,-1,0,0};
	static final int[] dz = {0,0,0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[][][] map = new int[h][n][m];		// ���� ������ ����
		int[][][] d = new int[h][n][m];			// �湮 ���� 
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int k=0; k<m; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k]==-1) {
						d[i][j][k] =-1;  		// ����ִ°��� �׳� -1�� ���ش�. 
					} 
				}
			}
		}
		
		bfs(map,d,h,n,m);
		
		
		// ����, ����� ������ ��� �丶�䰡 �;��ִ� �����̸� 0�� ����ؾ� �ϰ�, �丶�䰡 ��� ������ ���ϴ� ��Ȳ�̸� -1�� ����ؾ� �Ѵ�.
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
		
		// 1. ù������ ���� �丶�� ->  �湮 check  && ť�� ���
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
		
		// 2. bfs ����
		while(!q.isEmpty()) {
			// ���� ���� ��� ����
			Pair now = q.remove();
			int x = now.x;
			int y = now.y;
			int z = now.z;
			
			// ������ ��� �湮 (��, �Ʒ�, ��, ��, ��, ��)
			for(int i=0; i<6; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				int nz = z+dz[i];
				
				// (out of bound exception ó�� ���ֱ�) 
				if(nx>=0 && nx<h && ny>=0 && ny<n && nz>=0 && nz<m) {
					// ���� �湮 ���� �����
					if(d[nx][ny][nz]==0 && map[nx][ny][nz]==0) {
						q.add(new Pair(nx, ny, nz));
						d[nx][ny][nz] = d[x][y][z]+1;
					}
				}
				
			}
		}
		
	}
}
