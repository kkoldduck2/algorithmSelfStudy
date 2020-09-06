package study_samsungSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/17135
// 이 게임은 궁수의 위치가 중요하다. 격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산해보자.
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
			if(this.x < e.x) {		// x에 대해서 내림차순
				return 1;
			} else if(this.x == e.x){
				if(this.y > e.y) {		// y에 대해서 오름차순 
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
		
		N = Integer.parseInt(st.nextToken()); 		// 격자판 행의 수
		M = Integer.parseInt(st.nextToken()); 		// 격자판 열의 수 
		D = Integer.parseInt(st.nextToken()); 		// 궁수의 공격 거리 제한
		
		map = new int[N+1][M];		// 궁수 배치 고려 : 궁수는 N+1 행에만 존재 
		
		// 기초 작업 
		// map 상에 적들 배치 
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 초기 적들의 위치정보 저장
				if(map[i][j]==1) {
					Enemy e = new Enemy(i,j);
					enemy.add(e);
				}
			}
		}
		
		
		// 궁수 배치 경우의 수 : 모든 case에서 궁수 배치를 저장 
		int possi = (M*(M-1)*(M-2))/6;
		int possiN=0;
		
		int[][] archer = new int[possi][3];  // [case n][r1, r2, r3]
		// 첫번째 궁수 위치
		for(int r1 =0; r1<M-2; r1++) {
			// 두번째 궁수 위치
			for(int r2=r1+1; r2<M-1; r2++) {
				// 세번째 궁수 위치
				for(int r3=r2+1; r3<M; r3++) {
					archer[possiN][0] = r1;		// 첫번째 궁수의 위치 (N+1, r1)
					archer[possiN][1] = r2;		// 두번째 궁수의 위치 (N+1, r2)
					archer[possiN][2] = r3;		// 세번째 궁수의 위치 (N+1, r3)
					possiN++;
				}
			}
		}
		
		int maxKill = 0; 	// kill 수가 가장 클때가 정답
		
		
		//////////////// 게임 시작 : 궁수 배치 경우에 따른 결과 비교할 거임//////////////////////////
		possiN=0;
		while(possiN < possi) {
			int kill =0;
			
			while(true) {
				
				// <궁수 공격> 
				// 세명의 궁수에 대해서 
				ArrayList<Enemy> target= new ArrayList<>(); 
				for(int k=0; k<3; k++) {
					target.clear();
					for(Enemy e : enemy) {
						// |r1-r2| + |c1-c2|
						if( Math.abs(N-e.x) + Math.abs(archer[possiN][k]-e.y) <= D) {
							target.add(e);
						}
					}
				// target x, y 정렬  -> target[0]에 해당하는 e에 대해 e.targeted = true;
					if(!target.isEmpty()) {
						Collections.sort(target);
						target.get(0).targeted = true;
					}
					
				}
				
				// targeted된 적 제거 --> (주의) 인덱스 변하는 것 고려
				int size = enemy.size();
				for(int i=0; i<size; i++) {
					if(enemy.get(i).targeted == true) {
						enemy.remove(i);	// i번째 인덱스에 해당하는 객체 삭제
						kill++;
						size--;
						i--;
					}
				}
				
				
				// <적 이동> 
				// 적들이 사라지는 조건 : 적의 x 값 > N 일 경우  -> enemy.remove(적 object) 
				// 여기 다시 보기 
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
		
		// 각 경우에서 kill이 가장 클 때가 정답 
		System.out.println(maxKill);
		
	}
}
