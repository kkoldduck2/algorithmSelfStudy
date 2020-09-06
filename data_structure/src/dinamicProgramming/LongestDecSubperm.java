package dinamicProgramming;
// https://www.acmicpc.net/problem/11722
/* ���� A�� �־����� ��, ���� �� �����ϴ� �κ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
���� ���, ���� A = {10, 30, 10, 20, 20, 10} �� ��쿡 
���� �� �����ϴ� �κ� ������ A = {10, 30, 10, 20, 20, 10}  �̰�, ���̴� 3�̴�.
 * 
 * */

import java.util.Scanner;

// d[i] : A[i]�� ���������� �ϴ� ���� �� �����ϴ� �κм���
// d[j] : A[j]�� ���������� �ϴ� ���� �� �����ϴ� �κм���  (for j=0; j<i; j++) -> ���� �� d[j]ã�� ����
// d[i] = d[j]+1,    j<i && A[j] > A[i]

public class LongestDecSubperm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("�迭�� ũ�⸦ �Է�");
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<n; i++) {
			//System.out.println(i+"��° ���ڸ� �Է��ϼ��� ");
			a[i] = sc.nextInt();
		}
		
		int[] d = new int[n+1];
		
		for(int i=1; i<n+1; i++) {
			d[i] = 1;
			for(int j=1; j<i; j++) {
				if(a[j-1]>a[i-1] && d[i] < d[j]+1) {
					d[i] = d[j]+1;
				}
			}
		}
		
		int ans = d[1];
		for(int i=2; i<n+1;i++) {
			if(ans < d[i]) {
				ans = d[i];
			}
		}
		System.out.println(ans);
		
	}
}
