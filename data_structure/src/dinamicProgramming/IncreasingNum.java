package dinamicProgramming;

import java.util.Scanner;

/* 오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.
예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.
수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.
 * 
 * 
 * d[n][l] = 길이 N이 주어졌을 때, 오르막 수의 개수, 마지막 숫자 : l
 * d
 * */
public class IncreasingNum {
	
	public static long recurSol(long[][] d, int n, int l) {
		
		if(n==1) {
			d[n][l] =1;
			return 1;
		} 
		//if(l==0) return 1;   -> 굳이 안해줘도 됨 l==0 이면 for문을 한번 밖에 안돌아
		if(d[n][l]>0) return d[n][l];	// memorization (이미 계산된 값이 있을 경우 저장된 값을 반환)
		
		
		for(int i=0; i<=l; i++) {
			d[n][l] += recurSol(d,n-1,i);
		} 
		// System.out.println(n+" , "+l+" , "+d[n][l]);   -> 역시 찍어봐야 알 수 있다 
		d[n][l] %= 10007;
		
		return d[n][l];
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		long[][] d = new long[n+1][11];
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<=9; j++) {
				d[i][j]= 0;
			}
		}
		
		long ans =0; 
		for(int i=0; i<=9; i++) {
			long temp = recurSol(d, n, i);
			ans +=temp;
			ans %= 10007;
		}
		ans %=  10007;
		System.out.println(ans);
	}
}
