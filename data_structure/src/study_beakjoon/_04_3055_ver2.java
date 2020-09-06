package study_beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// ����ġ�� �����ϰ� ����� ���� �̵��ϱ� ���� �ʿ��� '�ּ� �ð�'�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
// �ּҽð� -> �׷������� bfs�� Ǭ�� 
// ���� �����ϴ� ������ ����ġ�� ��� 1�� ��� 
// BFS�� �ִ� ��θ� ���ϴ� �˰����� �ȴ�! �׷��� bfs�� Ǭ�� 

// �ٸ� ��� Ǯ�� ���� ����! BFS ���� 
// https://www.acmicpc.net/problem/3055

class Pair{ //���� ���� ������ ���� ���� ����, BFS���� ����.. ������.
	int x, y;
	
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class _04_3055_ver2 {
	
	static final int[] dx = {1, -1, 0, 0}; // �̰� ���� �׳� �ʼ� ���..
	static final int[] dy = {0, 0, 1, -1};
	
	// ���� ���� bfs
	static void bfsW(int[][] water, Queue<Pair> q, int n, int m) {
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;	// ���� ���� ��ġ
			
			// ���� �� ���ִ� �� bfs	��,��,��,�Ʒ�
			for(int k=0; k<4; k++) {
				int nx = x +dx[k];
				int ny = y + dy[k];
				// map ���� �ȿ� �־���� ���� �ȳ�����
				if(nx >=0 && nx<n && ny>=0 && ny<m) {
					if(water[nx][ny] ==0) {	// -1 : �����־ ��������,  1: �̹� ������ , 0: ���� �ִ� ��
						water[nx][ny] =water[x][y] + 1;	// �� �� �ʵڿ� ���� ������ ����صδ� ��.  water[x][y]�� x�ʿ� ���ٸ� . water[nx][ny]�� x+1�ʿ� ����. 
						q.add(new Pair(nx, ny));
					}
				}
			}
			
		}
	}
	
	//�� bfs���ְ� ��ġ�� bfs
	static void bfsD(int[][] water, int[][] dochi, int dI, int dJ, int n, int m) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(dI, dJ));		// ���� ��ġ ��ġ
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (dochi[nx][ny] == 0) {//��ġ�� �� ������
						if ((dochi[x][y] + 1) < water[nx][ny] || water[nx][ny] == 0) {//���� �� �������ų� ������ ���� ��.. �׷��� �� �� n*m+1�־���
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
		char[][] map = new char[n][m];	// �̰� map�ΰ�?
		int[][] water = new int[n][m];
		int[][] dochi = new int[n][m];  // ������������
		int dI =0, dJ =0, bI=0, bJ=0; 	//��ġ i,j ����� i,j
		int k=0;
		
		for(int i=0; i<n; i++) {
			String s = sc.nextLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='S') {
					dI = i;
					dJ = j;
					dochi[i][j] = 1;	//��ġ ��ġ 1
				}
				if (map[i][j] == 'D') {
					bI = i;
					bJ = j;			// ����� ��ġ 
					water[i][j] = n*m+1; //���� water�� n*m+1�ΰ� ����Ʈ.. n*m�̾��ٰ� �Ǽ���
				}
				if(map[i][j]=='*') {
					qwater.add(new Pair(i,j)); // ���� ��ġ�� ť�� �־���
					water[i][j] = 1;
				}
				if(map[i][j]=='X') {	// ����ġ�� �� ��� ������ ��
					dochi[i][j] = -1;
					water[i][j] = -1;
				}
			}
		}
		
		bfsW(water, qwater, n, m); // ť���Ϳ� �Բ� bfs�� ��
		bfsD(water, dochi, dI, dJ, n, m);	// ��ġ bfs
		
		if(dochi[bI][bJ] !=0) {
			System.out.println(dochi[bI][bJ] - 1);// ��ġ ÷�� ��ġ 1 �������ϱ� -1
		}
		else
			System.out.println("KAKTUS"); //Ĵ�ͽ�
	}
}
