package divideNconquer;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1074
/* 2차원 배열의 크기가 2^N * 2^N,
 * N이 주어졌을 때, (r, c)를 몇 번째로 방문하는지 출력
 * */
public class _5_Z_1074 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		int ans = solve(r,c,n,0);
		System.out.println(ans);
	}
	
	// 상자 한변의 길이 2^n
	static int solve(int r, int c, int n, int defaultVal) {
		// i) 더이상 나눠지지 않을 경우 (base case)
		if(n==1) {
			if(r%2==0 && c%2==0) {  // 1사분면
				return defaultVal;
			}
			else if(r%2==0 && c%2==1) { // 2사분면: 0,1
				return defaultVal+1;
			}else if(r%2==1 && c%2==0) {// 3사분면: 1,0
				return defaultVal+2;
			} else {		// 4사분면
				return defaultVal+3;
			}
		}else {
			// ii) 작은 상자 4개로 나눈다.
			int N = (int)Math.pow(2, n-1);		// 작은 상자 한변의 길이 or 중간 값
			int newDefault = (int)Math.pow(N, 2);		// 작은 상자 1사분면의 가장 오른쪽 아래 값+1 (사분면마다 더해지는 횟수 다름)
			
			if(r<N && c<N) {		// 1사분면
				return solve(r,c,n-1,defaultVal);
			}
			else if(r<N && c>=N) {	// 2사분면
				return solve(r,c-=N,n-1,defaultVal+newDefault);
			}else if(r>=N && c<N) {	// 3사분면
				return solve(r-=N,c,n-1,defaultVal+newDefault*2);
			}else {						// 4사분면
				return solve(r-=N,c-=N,n-1,defaultVal+newDefault*3);
			}
		}
	}
}
