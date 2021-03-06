package dinamicProgramming;
// https://www.acmicpc.net/problem/11722
/* 수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.
예를 들어, 수열 A = {10, 30, 10, 20, 20, 10} 인 경우에 
가장 긴 감소하는 부분 수열은 A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3이다.
 * 
 * */

import java.util.Scanner;

// d[i] : A[i]를 마지막으로 하는 가장 긴 감소하는 부분수열
// d[j] : A[j]를 마지막으로 하는 가장 긴 감소하는 부분수열  (for j=0; j<i; j++) -> 가장 긴 d[j]찾을 거임
// d[i] = d[j]+1,    j<i && A[j] > A[i]

public class LongestDecSubperm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("배열의 크기를 입력");
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<n; i++) {
			//System.out.println(i+"번째 숫자를 입력하세요 ");
			a[i] = sc.nextInt();
		}
		
		int[] d = new int[n+1];
		
		for(int i=1; i<n+1; i++) {
			d[i] = 1;
			for(int j=1; j<i; j++) {
				if(a[j-1]>a[i-1] && d[i] < d[j]+1) {
					d[i] = d[j]+1;
				}
			}
		}
		
		int ans = d[1];
		for(int i=2; i<n+1;i++) {
			if(ans < d[i]) {
				ans = d[i];
			}
		}
		System.out.println(ans);
		
	}
}
