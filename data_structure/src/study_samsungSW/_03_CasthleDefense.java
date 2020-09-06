package study_samsungSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/17135
// �� ������ �ü��� ��ġ�� �߿��ϴ�. �������� ���°� �־����� ��, �ü��� �������� ������ �� �ִ� ���� �ִ� ���� ����غ���.
public class _03_CasthleDefense {
	static class Enemy implements Comparable<Enemy>{
		int x;
		int y;
		boolean targeted = false;

		
		public Enemy(int x, int y){
			this.x = x;
			this.y = y;
		}
	
		public void move() {
			this.x++;
		}
		
		public void targeted() {
			this.targeted =true;
		}
		
		public int compareTo(Enemy e) {
			if(this.x < e.x) {		// x�� ���ؼ� ��������
				return 1;
			} else if(this.x == e.x){
				if(this.y > e.y) {		// y�� ���ؼ� �������� 
					return 1;
				}
			}
			return -1;
		}
		
	}
	
	static int N;
	static int M; 
	static int D;
	static int[][] map;
	static ArrayList<Enemy> enemy = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		
		N = Integer.parseInt(st.nextToken()); 		// ������ ���� ��
		M = Integer.parseInt(st.nextToken()); 		// ������ ���� �� 
		D = Integer.parseInt(st.nextToken()); 		// �ü��� ���� �Ÿ� ����
		
		map = new int[N+1][M];		// �ü� ��ġ ��� : �ü��� N+1 �࿡�� ���� 
		
		// ���� �۾� 
		// map �� ���� ��ġ 
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// �ʱ� ������ ��ġ���� ����
				if(map[i][j]==1) {
					Enemy e = new Enemy(i,j);
					enemy.add(e);
				}
			}
		}
		
		
		// �ü� ��ġ ����� �� : ��� case���� �ü� ��ġ�� ���� 
		int possi = (M*(M-1)*(M-2))/6;
		int possiN=0;
		
		int[][] archer = new int[possi][3];  // [case n][r1, r2, r3]
		// ù��° �ü� ��ġ
		for(int r1 =0; r1<M-2; r1++) {
			// �ι�° �ü� ��ġ
			for(int r2=r1+1; r2<M-1; r2++) {
				// ����° �ü� ��ġ
				for(int r3=r2+1; r3<M; r3++) {
					archer[possiN][0] = r1;		// ù��° �ü��� ��ġ (N+1, r1)
					archer[possiN][1] = r2;		// �ι�° �ü��� ��ġ (N+1, r2)
					archer[possiN][2] = r3;		// ����° �ü��� ��ġ (N+1, r3)
					possiN++;
				}
			}
		}
		
		int maxKill = 0; 	// kill ���� ���� Ŭ���� ����
		
		
		//////////////// ���� ���� : �ü� ��ġ ��쿡 ���� ��� ���� ����//////////////////////////
		possiN=0;
		while(possiN < possi) {
			int kill =0;
			
			while(true) {
				
				// <�ü� ����> 
				// ������ �ü��� ���ؼ� 
				ArrayList<Enemy> target= new ArrayList<>(); 
				for(int k=0; k<3; k++) {
					target.clear();
					for(Enemy e : enemy) {
						// |r1-r2| + |c1-c2|
						if( Math.abs(N-e.x) + Math.abs(archer[possiN][k]-e.y) <= D) {
							target.add(e);
						}
					}
				// target x, y ����  -> target[0]�� �ش��ϴ� e�� ���� e.targeted = true;
					if(!target.isEmpty()) {
						Collections.sort(target);
						target.get(0).targeted = true;
					}
					
				}
				
				// targeted�� �� ���� --> (����) �ε��� ���ϴ� �� ���
				int size = enemy.size();
				for(int i=0; i<size; i++) {
					if(enemy.get(i).targeted == true) {
						enemy.remove(i);	// i��° �ε����� �ش��ϴ� ��ü ����
						kill++;
						size--;
						i--;
					}
				}
				
				
				// <�� �̵�> 
				// ������ ������� ���� : ���� x �� > N �� ���  -> enemy.remove(�� object) 
				// ���� �ٽ� ���� 
				size = enemy.size();
				for(int i=0; i<size; i++) {
					enemy.get(i).move();
					if(enemy.get(i).x > N) {
						enemy.remove(i);
						size--;
					}
				}
			
				if(kill > maxKill) {
					maxKill =kill;
				}
				
				if(enemy.size()==0) {
					break;
				}
			}
			possiN++;
		}
		
		// �� ��쿡�� kill�� ���� Ŭ ���� ���� 
		System.out.println(maxKill);
		
	}
}
