package dinamicProgramming;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9095
/*
 * ���� n�� �־����� ��, n�� 1, 2, 3�� ������ ��Ÿ���� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * D[n] = n�� 1, 2, 3�� ������ ��Ÿ���� ����� ��
 * D[n] = D[N-1] + D[N-2] + D[N-3]
 * */
public class Plus123 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("n�� �Է��ϼ���");
		int n = sc.nextInt();
		int[] D = new int[n+1];
		D[0]=0;			// ��� ���µ� ���� �ʱ�ȭ
		D[1]=1;
		D[2]=2;
		D[3]=4;
		
		for(int i=4; i<D.length; i++) {
			D[i]= D[i-1]+D[i-2]+D[i-3];
		}
		
		System.out.println(D[n]);
	}
}
