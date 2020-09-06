package study_beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3055
// * : ���� ���ִ� ���� 
// . : �̵��� �� ����
// S : ���� ����ġ ��ġ
// D : ������ 
// �� �и��� ����ġ�� ���� �ִ� ĭ�� ������ ��ĭ (��, �Ʒ�, ��, ��)���� �̵��� �� �ִ�. 
// ���� �� �и��� ����ִ� ĭ���� Ȯ���Ѵ�. ���� �ִ� ĭ�� �������ִ� ����ִ� ĭ(��� �� ���� ����)�� ���� ���� �ȴ�. 
// ���� ����ġ�� ���� ����� �� ����. ��, ����ġ�� ���� ���ִ� �������� �̵��� �� ����, ���� ����� �ұ��� �̵��� �� ����.
// ����ġ�� ���� �� ������ ĭ���� �̵��� �� ����. ��, ���� �ð��� ���� �� ������ ĭ���� ����ġ�� �̵��� �� ����. 
// ù° �ٿ� ����ġ�� ����� ���� �̵��� �� �ִ� ���� ���� �ð��� ����Ѵ�. ����, �����ϰ� ����� ���� �̵��� �� ���ٸ�, "KAKTUS"�� ����Ѵ�.

// dfs(���)�� �̿��ؼ� Ǯ���� ������ stack over flow �߻� -> bfs�� Ǯ��� �ҵ�
public class _04_3055 {
	static Character[][] map;
	static int minT = Integer.MAX_VALUE;
	static int r;
	static int c;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());	// ��
		c = Integer.parseInt(st.nextToken());	// �� 
		map = new Character[r][c];
		visited = new boolean[r][c];
		
		int di=0;
		int dj=0;
		// map�� ����
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
		
		// ����ġ �̵� (����ġ ���� ��ġ : S, �ð� )
		move(di, dj,0);
		System.out.println(minT);
	}
	
	// ���� ��ġ�� D �� ��� 
	// �̿��� ���� �� �ϳ����� �ⱸ���� ���� ��ΰ� �ְų� (Recursion - ������ true, ������ false)
	static boolean move(int i, int j, int t) {
		// �� �̵�
		waterExpansion();
		
		// ���� : ���� ��ġ�� ���̰ų� ���� ������ �� 			���� ���� ��� Array bound Exception �ȳ���. 
		if(i<0 || j<0 ||i>=r || j>=c || map[i][j]=='X' || map[i][j]=='*' || visited[i][j]== true) {
			return false;
		}else if(map[i][j] == 'D') {		// ���� (���� ��ġ�� D)
			minT = minT > t ? t: minT;
			return true;
		}
		else {
			if(move(i+1,j,t+1) || move(i-1,j,t+1) || move(i,j+1,t+1) || move(i, j-1, t+1)) {// �̿��� ���� �߿� �ⱸ�� ���� ��ΰ� ���� 
				visited[i][j] = true;
				return true;
			}
			
			System.out.println("KAKTUS");
			return false;		// �̿��� ���� �߿� ���� ���  : KAKTUS ���
		}
		
	}
	
	static void waterExpansion() {
		// ���� �ִ� ĭ�� �������ִ� ����ִ� ĭ(��� �� ���� ����)�� ���� ���� �ȴ�. ���� ����ġ�� ���� ����� �� ����. 
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
