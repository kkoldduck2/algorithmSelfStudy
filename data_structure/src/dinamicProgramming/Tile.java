package dinamicProgramming;
// https://www.acmicpc.net/problem/2133
// 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.

import java.util.Scanner;

public class Tile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] d = new int[n+1];
		
		
		d[2] = 3;
		for(int i=4; i<n+1; i+=2) {
			d[i] = 3*d[i-2];
			for(int j=i-4; j>=0; j-=2) {
				d[i] += 2*d[j];
			}
		}
		
		System.out.println(d[n]);
	}
}
