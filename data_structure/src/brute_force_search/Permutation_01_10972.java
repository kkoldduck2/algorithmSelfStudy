package brute_force_search;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10972
public class Permutation_01_10972 {
	
	public static boolean next_permutation(int[] a) {
		int i = a.length-1;
		
		// 723'6'541 (a[i]=6, a[i-1] =3) <- �� ������ ã�´� 
		while(i>0 && a[i-1] >= a[i]) {
			i-=1;
		}
		
		// ��ã�� = ������ ����
		if(i<=0) return false;
		
		// ã�� 
		// 723 65'4'1   <- �� a[j] = 4
		int j = a.length -1;
		while(a[j] < a[i-1]) {
			j-=1;
		}
		
		// a[i-1]�� a[j] ��ġ �ٲ۴�.
		// 72'4'65'3'1
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		// a[i] = 6
		// i���� �ε��� ������ ���ڵ� �������� ���� (����� �������� �Ǿ�����)
		j = a.length -1;
		while(i<j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i+=1;
			j-=1;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		if(next_permutation(a)) {		// ���� ������ �����Ѵ�.
			for(int i=0; i<n; i++) {
				System.out.println(a[i]+" ");
			}
			System.out.println();
		}else {			// ���� ������ �������� �ʴ´� (������ �����̴�) 
			System.out.println("-1");
		}
	}
}
