package greedyAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11399

/* �� �������� ������ ���ΰ�
 * p[i]�� ���� Ŭ ���� ���� �ڿ� �־���Ѵ�
 * �տ� ������ �� p[i]�� �������� Ƚ���� �������ϱ�
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
		Arrays.sort(p); //���� ���� ���� 		cf_ Arrays.sort(p, Collections.reverseOrder()); �������� ����
		
		for(int i=0; i<n; i++) {
			sum+=p[i];
			ans +=sum;
		}
		
		System.out.println(ans);
		
		
		
	}
	
}
