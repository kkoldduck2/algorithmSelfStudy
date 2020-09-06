package dinamicProgramming;

import java.util.Scanner;
// https://www.acmicpc.net/problem/11726
public class Tile2xn {
	public static void main(String[] args) {
		int n= 9;
		// D[N] = 2*N ũ���� ���簢���� 1X2 �Ǵ� 2X1 Ÿ�Ϸ� ä��� ����� ��
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
