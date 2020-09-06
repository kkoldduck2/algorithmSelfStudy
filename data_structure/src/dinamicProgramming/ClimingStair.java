package dinamicProgramming;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2579

/*
��� ������ ���� ������ ���� ��Ģ�� �ִ�.

����� �� ���� �� ��ܾ� �Ǵ� �� ��ܾ� ���� �� �ִ�. ��, �� ����� �����鼭 �̾ ���� ����̳�, ���� ���� ������� ���� �� �ִ�.
���ӵ� �� ���� ����� ��� ��Ƽ��� �� �ȴ�. ��, �������� ��ܿ� ���Ե��� �ʴ´�.
������ ���� ����� �ݵ�� ��ƾ� �Ѵ�.
�� ��ܿ� ���� �ִ� ������ �־��� �� �� ���ӿ��� ���� �� �ִ� �� ������ �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * */
public class ClimingStair {
	
	public static void main(String[] args) {
//		int n= 6;
//		int[] a = new int[] {10, 20, 15, 25, 10, 20};
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		int[] d= new int[n+1];	
		
		// sol1) d[i] : a[i]��° ����� ���������� ���� �ִ� ����
		
		// d[i] = max(d[i-2]+a[i] , d[i-3]+a[i-1]+a[i])
		d[1] = a[0];
		d[2] = a[0]+a[1];
		d[3] = (a[0]+a[2])<(a[1]+a[2]) ? (a[1]+a[2]):(a[0]+a[2]) ;
		
		for(int i=4; i<n+1; i++) {
			d[i] = d[i-2]+a[i-1];
			
			if(d[i]<d[i-3]+a[i-2]+a[i-1]) {
				d[i] = d[i-3]+a[i-2]+a[i-1];
			}
		}
		
		System.out.println(d[n]);
		

		// sol2)  d[i][k] : a[i]��° ����� ���������� ���� �ִ� ����  (a[i] ����� k�� �������� ����, k=1,2)
		// d[i][1] :1 ������, a[i-1]�� ������ �ȵ�  , ���� d[i][1] = max( d[i-2][1] , d[i-2][2])+a[i]
		// d[i][2] :2 ������, a[i-1]�� ���� (�̋� a[i-1][1]�̾���Ѵ�. ���� 3�� ����)  ,
		// ���� d[i][2] = d[i-1][1]+a[i]
		
		// �� ������ d[n][1]�� d[n][2] �� �� ū���� ������ �ȴ�. 
		
	}
}