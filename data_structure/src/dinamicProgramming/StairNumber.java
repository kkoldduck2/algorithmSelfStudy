package dinamicProgramming;

import java.util.Scanner;

/*
 * 45656이란 수를 보자.

이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.

세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.

N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)
(첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.)
 * */

/* D[N] : 길이가 N인 계단 수가 총 몇 개
 * D[N][L] : 길이가 N이고 마지막 수가 L인 계단 수가 총 몇 개
 *  D[N][0] = D[N-1][1],   D[N][9] = D[N-1][8]   => 즉 0개라고 봐도 무방 (이전 개수랑 같으니까 )
 * D[N][L'] = D[N-1][L'-1] + D[N-1][L'+1]
 * (이때 1<=L'<=8)
 * */

public class StairNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[][] D = new long[n+1][10];
		
		// 길이가 1인 계단수 : 1개 (1~9)
		for(int i=1; i<=9; i++) D[1][i] = 1;
		D[1][0] =0;
		
		// 길이가 2 이상인 계단수 
		for(int i=2; i<D.length; i++) {
			for(int j=0; j<=9; j++) {
				D[i][j] =0;
				if(j==0) D[i][j] = D[i-1][1];
				if(j==9) D[i][j] = D[i-1][8];
				if(j>0 && j<9) {
					D[i][j] = D[i-1][j+1] + D[i-1][j-1]; // 이때 j는 2이상 8이하
				}
				
				D[i][j] %=1000000000;
				// 점화식을 통해 합을 계산하는 경우에도, type 범위를 초과해서 원치 않는 값을 배열에 저장하는 경우가 발생하기 때문
			}
		}

		long ans =0;
		for(int j=0; j<=9; j++) {
			ans+=D[n][j];
		}
		ans %=1000000000;
		System.out.println(ans);
	}
}
