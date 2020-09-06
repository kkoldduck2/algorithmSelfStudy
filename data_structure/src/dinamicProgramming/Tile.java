package dinamicProgramming;
// https://www.acmicpc.net/problem/2133
// 3��N ũ���� ���� 2��1, 1��2 ũ���� Ÿ�Ϸ� ä��� ����� ���� ���غ���.

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
