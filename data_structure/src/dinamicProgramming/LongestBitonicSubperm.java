package dinamicProgramming;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11054
/*
 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 
 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  
{1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.
 * */ 

// D1 -> i -> D2
// ans = longest D1[i] + longest D2[i] -1;  (-1은 꼭지점에서 겹치는 수 i)
// longest D1[i] : A[i]를 마지막으로 하는 가장 긴 증가하는 부분수열
// longest D2[i] : A[i]를 시작으로 하는 가장 긴 감소하는 부분수열

public class LongestBitonicSubperm {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//        int[] a = new int[n];
//        for (int i=0; i<n; i++) {
//            a[i] = sc.nextInt();
//        }
		
		int n= 10;
		int[] a = new int[] {1, 5, 2, 1, 4, 3, 4, 5, 2, 1};
        
        int[] d1 = new int[n+1];
        for(int i=1; i<n+1; i++) {
			d1[i] = 1; // 기본적으로 모든 수열의 길이는 1이다. 
			for(int j=1; j<i; j++) {  // j<i
				if(a[j-1]<a[i-1] && d1[i] < d1[j]+1) {
					d1[i]=d1[j]+1;
				}
			}
		}
        
        // d2[i] : a[i]에서 시작
        // d1을 구하는 과정과 반대로 돈다.
        // 즉 i <j 인 상태
        int[] d2 = new int[n+1];
        for(int i=n; i>=1; i--) {
			d2[i] = 1;
			for(int j=n; j>=i+1; j--) {
				if(a[j-1]<a[i-1] && d2[i] < d2[j]+1) {
					d2[i] = d2[j]+1;
				}
			}
		}
        
        int ans = d1[1]+d2[1]-1;
        for (int i=2; i<n+1; i++) {
            if (ans < d1[i]+d2[i]-1) {
                ans = d1[i]+d2[i]-1;
            }
        }
        System.out.println(ans);
        
	}
}
