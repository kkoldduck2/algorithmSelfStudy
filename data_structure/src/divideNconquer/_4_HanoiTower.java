package divideNconquer;

import java.util.Scanner;
// 과정: 분할정복(재귀)
// 모든 과정을 출력하는 것은 분할 정복임
// 최소 이동 횟수는 다이내믹으로 푼다.
public class _4_HanoiTower {
	
	// n개의 원판을 x기둥에서 y기둥으로 옮긴다. 
	// 기둥은 1,2,3번 기둥이 있고,
	// 따라서 x+y+z = 6   (z는 옮기려는 기둥이 아닌 다른 기둥)
	// solve (1~n개의 원판을, x에서 , y로 ) 옮긴다. 
	public static void solve(int n, int x, int y) {
		if(n==0) return;
		solve(n-1, x, 6-x-y);		// 1) 1~n-1개의 원판을 x에서 6-x-y(임시)로 옮긴다. 
		System.out.println(x+" "+y);		// 2) n번 원판을 x에서 y로 옮긴다
		solve(n-1, 6-x-y, y);		// 3) 1~n-1개의 원판을 6-x-y(임시)에서 y(목적지)로 옮긴다.
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		// 최소 이동 횟수  by 다이내믹 프로그래밍
		int[] d= new int[n+1];		//n개의 원판을 다른 장대로 이동시키는 최소한의 횟수
		//  d[n] = 2*d[n-1]+1
		
		d[1]= 1;
		for(int i=2; i<n+1; i++) {
			d[i] = d[i-1]*2 +1;		// 1~n-1개를 움직이는 작업 두번 + n번 원판을 옮기는거 1번
		}
		System.out.println(d[n]);
		
		//위 내용을 일반화 하면 d[n] = 2^n-1이다. 따라서 	
		//System.out.println((1<<n)-1);
		
		
		solve(n,1,3);	// n개의 원반을 1번째 기둥에서 3번째 기둥으로 옮기는 과정?
	}
}
