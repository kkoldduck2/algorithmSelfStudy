package dinamicProgramming;

import java.util.Scanner;
// https://www.acmicpc.net/problem/11726
public class Tile2xn {
	public static void main(String[] args) {
		int n= 9;
		// D[N] = 2*N 크기의 직사각형을 1X2 또는 2X1 타일로 채우는 방법의 수
		// D[N] = D[N-1] + D[N-2]
		int[] d = new int[n+1];
		d[0]=1;
		d[1]=1;
		d[2]=2;
		for(int i=3; i<=n; i++) {
			d[i] = d[i-1]+d[i-2]; 
		}
		System.out.println(d[n]);
	}
}
