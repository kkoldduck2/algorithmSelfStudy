package dinamicProgramming;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2579

/*
계단 오르는 데는 다음과 같은 규칙이 있다.

계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
마지막 도착 계단은 반드시 밟아야 한다.
각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
 * */
public class ClimingStair {
	
	public static void main(String[] args) {
//		int n= 6;
//		int[] a = new int[] {10, 20, 15, 25, 10, 20};
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		int[] d= new int[n+1];	
		
		// sol1) d[i] : a[i]번째 계단을 마지막으로 밟은 최대 점수
		
		// d[i] = max(d[i-2]+a[i] , d[i-3]+a[i-1]+a[i])
		d[1] = a[0];
		d[2] = a[0]+a[1];
		d[3] = (a[0]+a[2])<(a[1]+a[2]) ? (a[1]+a[2]):(a[0]+a[2]) ;
		
		for(int i=4; i<n+1; i++) {
			d[i] = d[i-2]+a[i-1];
			
			if(d[i]<d[i-3]+a[i-2]+a[i-1]) {
				d[i] = d[i-3]+a[i-2]+a[i-1];
			}
		}
		
		System.out.println(d[n]);
		

		// sol2)  d[i][k] : a[i]번째 계단을 마지막으로 밟은 최대 점수  (a[i] 계단을 k번 연속으로 밟음, k=1,2)
		// d[i][1] :1 개연속, a[i-1]은 밟으면 안됨  , 따라서 d[i][1] = max( d[i-2][1] , d[i-2][2])+a[i]
		// d[i][2] :2 개연속, a[i-1]을 밟음 (이떄 a[i-1][1]이어야한다. 연속 3개 방지)  ,
		// 따라서 d[i][2] = d[i-1][1]+a[i]
		
		// 즉 정답은 d[n][1]과 d[n][2] 중 더 큰값을 고르면 된다. 
		
	}
}
