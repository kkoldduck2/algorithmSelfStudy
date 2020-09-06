package brute_force_search;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10819
// ����
/*N���� ������ �̷���� �迭 A�� �־�����. 
 * �̶�, �迭�� ����ִ� ������ ������ ������ �ٲ㼭
 * ���� ���� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 * 
 * */
public class Permutation_02_10819 {
	static int max =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// n���� ������ �̷���� �迭
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		perm(a, 0, n);
		System.out.println(max);
	}
	
	// �̶� k�� ���� ��ġ
	// data[0..k-1]�� prefix �Ǿ�����
	// data[k..n]���� ���� �� �ִ� ��� ������ ����Ʈ�ϵ�
	// �迭 data�� ����� ������ ������ �״�� �д�. 
	public static void perm(int[] a, int k, int n) {
		if(k==n) {
			calculate(a);
			return;
		}
		
		for(int i=k; i<n; i++) {
			swap(a, i, k);
			perm(a, k+1, n);
			swap(a, i, k);	
		}
	}
	
	public static void swap(int[] a, int i, int k) {
		int temp = a[i];
		a[i] = a[k];
		a[k] = temp;
	}
	
	public static void calculate(int a[]) {
		int sum =0;
		for(int i=1; i<a.length; i++) {
			sum+=Math.abs(a[i]-a[i-1]);
		}
		
		if(max < sum) {
			max = sum;
		}
	}
	
	
}
