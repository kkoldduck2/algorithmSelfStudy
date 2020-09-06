package dinamicProgramming;
// https://www.acmicpc.net/problem/11053

/* 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 
가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
 * 
 * */ 

// D[i] : A[i] 을 마지막을 하는 가장 긴 증가하는 부분 수열의 길이 
// D[i] = max(D[j]) +1   ( j= 1~ i-1)
// 이때, j<i  && A[j] <A[i] 조건을 만족하는 j를 찾아야 한다. 

public class LongestRisingSubPerm {
	public static void main(String[] args) {
		int n = 6;
		int[] A = new int [] {10, 20, 10, 30, 20, 50};
		
		int[] D = new int[n+1];
		for(int i=1; i<n+1; i++) {
			D[i] = 1; // 기본적으로 모든 수열의 길이는 1이다. 
			for(int j=1; j<i; j++) {  // j<i
				if(A[j-1]<A[i-1] && D[i] < D[j]+1) {
					D[i]=D[j]+1;
				}
			}
		}
		
		System.out.println(D[n]);
		
	}
}
