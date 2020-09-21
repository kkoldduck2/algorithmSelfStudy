package study_beakjoon;

import java.util.*;
// https://www.acmicpc.net/problem/19236
class Fish{
	int x;
	int y;
	int num;	// ������ ��ȣ
	int d;	// ����
	public Fish(int x, int y, int num, int d){
		this.x = x;
		this.y = y;
		this.d = d;
		this.num = num;
	}
}
class Shark{
	int x;
	int y;
	int direct;
	public Shark(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.direct =d;
	}
}
public class _6_teenshark {
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	public static boolean goShark(int tempx, int tempy) {
			
		if(tempx <0 || tempx>3 ||tempy <0 || tempy>3 ) {
			return false;
		}
		
		return true;
	}
	public static boolean canmove(Shark shark, int tx, int ty, int td) {
		if((shark.x == tx && shark.y == ty)||(tx<0|| tx>3||ty<0|| ty>3)) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Fish> hm = new HashMap<>();
		Fish[][] loc = new Fish[4][4];
		int sum=0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				int ai = sc.nextInt();		// ������ ��ȣ
				int bi = sc.nextInt();		// ������ ����
				sum+=ai;
				loc[i][j] = new Fish(i,j,ai,bi);
				hm.put(ai, loc[i][j]);
			}
		}
		// Ű�� ����
		Arrays.sort(hm.keySet().toArray());
		Fish first = loc[0][0];
		hm.remove(first.num);
		int score =first.num;		// ù��° ������ ����
		Shark shark = new Shark(0,0,first.d);
		int[] d = new int[sum+1];
		int k=0;
		while(true) {
			int possible =0;
			for(int i=1; i<4; i++) {
				int tempx = shark.x + dx[shark.direct-1]*i;
				int tempy = shark.y = shark.y + dy[shark.direct-1]*i;
				if(goShark(tempx, tempy)) {
					// ��� �̵� ���� : �ش� �������� �� �� �ִ� �ĺ� �������  
					shark.x = shark.x + dx[shark.direct-1];
					shark.y = shark.y + dy[shark.direct-1];	
					Fish dead = loc[shark.x][shark.y];
					loc[shark.x][shark.y] = null;
					hm.remove(dead.num);
					shark.direct = dead.d;			// ��� : x, y ��ġ�� �ִ� �������� ���� ȹ��
					if(k==0) {
						d[k] =score; 
					}
					d[k++] += dead.num;
				}else {
					possible++;
				}
			}
			// ��� �̵� �Ұ�
			if(possible==3) {
				break;
			}
			
			
			// ������ �̵� (1�� ~16�� ������)
			for(Integer nfish : hm.keySet()) {
				Fish nowFish = hm.get(nfish);
				int nx = nowFish.x;
				int ny = nowFish.y;
				int nd = nowFish.d;
				int tx = nx + dx[nd-1];		// �ٲ� �� x��ǥ
				int ty = ny + dy[nd-1];		// �ٲ� �� y��ǥ
				
				// �� �ְų� out of bound -> ȸ��
				int cnt =0;
				while(!canmove(shark, tx, ty, nd)) {
					nd++;
					if(nd>8) {
						nd =1;
					}
					tx = nx + dx[nd-1];
					ty = ny + dy[nd-1];	
					cnt++;
					if(cnt ==8) {
						break;
					}
				}
				if(cnt==8) {
					continue;
				}
				// tx, ty�� �ִ� ������� ��ġ �ٲٱ� (null�̸� �׳� �ϳ��� �ű��)
				Fish changeFish = loc[tx][ty];
				if(changeFish!=null) {
					loc[tx][ty] = nowFish;
					nowFish.x = tx;
					nowFish.y = ty;
					loc[nx][ny] = changeFish;
					changeFish.x = nx;
					changeFish.y = ny;
				}else {
					loc[tx][ty] = nowFish;
					nowFish.x = tx;
					nowFish.y = ty;
				}
			}
			
		}
		
		System.out.println(score);
		
	}
}