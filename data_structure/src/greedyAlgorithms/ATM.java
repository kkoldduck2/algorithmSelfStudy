package greedyAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11399

/* 뭘 기준으로 정렬할 것인가
 * p[i]가 가장 클 수록 가장 뒤에 있어야한다
 * 앞에 있으면 그 p[i]가 더해지는 횟수가 많아지니까
 * 
 * */

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		
		for(int i=0; i<n; i++) {
			p[i] = sc.nextInt();
		}
		
		int sum=0;
		int ans =0;
		Arrays.sort(p); //오름 차순 정렬 		cf_ Arrays.sort(p, Collections.reverseOrder()); 내림차순 정렬
		
		for(int i=0; i<n; i++) {
			sum+=p[i];
			ans +=sum;
		}
		
		System.out.println(ans);
		
		
		
	}
	
}
