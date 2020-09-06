package dinamicProgramming;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9465

/* 스티커 2n개가 2xn 모양으로 배치되어있다.
 * 스티커 한장을 떼면 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없다. 
 * 점수의 합을 최대로 만드는 문제 
 */

// D[N] : 2xn 에서 점수의 최대
//    D[N-1]	[L] : 0,1,2
// |	...			 |o x x	|
// |	...			 |x o x	|


public class Sticker {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		int n = 5;
		int n2 =7;
		int[][] D = new int[n2+1][3];
		
		int[][] A1 = new int[][] {{50, 10, 100, 20, 40},
								 {30, 50, 70, 10, 60}};
								 
		
		int[][] A2 = new int[][] {
			{10, 30, 10, 50, 100, 20, 40},
			{20, 40, 30, 50, 60, 20, 80}
		};
								 
		// D[n][0] = Math.max(D[n-1][1] , D[n-1][2]) + A1[n][0]
		// D[n][1] = Math.max(D[n-1][0] , D[n-1][2]) + A1[n][1]
		// D[n][2] = Math.max(D[n-1][0] , D[n-1][1], D[n-1][2]) 
		// max = Math.max(D[n][0], D[n][1], D[n][2])
								 
		
//		D[1][0] = A1[0][0];
//		D[1][1] = A1[1][0];
		
		D[1][0] = A2[0][0];
		D[1][1] = A2[1][0];
		D[1][2] = 0;
		
		for(int i=2; i<=n2; i++) {
			D[i][0] = Math.max(D[i-1][1], D[i-1][2]) + A2[0][i-1];
			D[i][1] = Math.max(D[i-1][0] , D[i-1][2]) + A2[1][i-1];
			D[i][2] = Math.max(Math.max(D[i-1][0] , D[i-1][1]), D[i-1][2]);
		}
		
		int max =D[n2][0]; 
		for(int i=1; i<3; i++) {
			max = (max < D[n2][i] ? D[n2][i] : max);
		}
		
		System.out.println(max);
		
	}
}
