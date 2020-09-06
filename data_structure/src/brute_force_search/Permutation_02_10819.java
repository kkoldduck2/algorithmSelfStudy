package brute_force_search;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10819
// 순열
/*N개의 정수로 이루어진 배열 A가 주어진다. 
 * 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서
 * 다음 식의 최댓값을 구하는 프로그램을 작성하시오.

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 * 
 * */
public class Permutation_02_10819 {
	static int max =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// n개의 정수로 이루어진 배열
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		perm(a, 0, n);
		System.out.println(max);
	}
	
	// 이때 k는 현재 위치
	// data[0..k-1]는 prefix 되어있음
	// data[k..n]으로 만들 수 있는 모든 순열을 프린트하되
	// 배열 data에 저장된 값들의 순서는 그대로 둔다. 
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
