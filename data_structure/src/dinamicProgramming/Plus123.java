package dinamicProgramming;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9095
/*
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 * D[n] = n을 1, 2, 3의 합으로 나타내는 방법의 수
 * D[n] = D[N-1] + D[N-2] + D[N-3]
 * */
public class Plus123 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("n을 입력하세요");
		int n = sc.nextInt();
		int[] D = new int[n+1];
		D[0]=0;			// 상관 없는데 대충 초기화
		D[1]=1;
		D[2]=2;
		D[3]=4;
		
		for(int i=4; i<D.length; i++) {
			D[i]= D[i-1]+D[i-2]+D[i-3];
		}
		
		System.out.println(D[n]);
	}
}
