package brute_force_search;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10972
public class Permutation_01_10972 {
	
	public static boolean next_permutation(int[] a) {
		int i = a.length-1;
		
		// 723'6'541 (a[i]=6, a[i-1] =3) <- 이 지점을 찾는다 
		while(i>0 && a[i-1] >= a[i]) {
			i-=1;
		}
		
		// 못찾음 = 마지막 순열
		if(i<=0) return false;
		
		// 찾음 
		// 723 65'4'1   <- 즉 a[j] = 4
		int j = a.length -1;
		while(a[j] < a[i-1]) {
			j-=1;
		}
		
		// a[i-1]과 a[j] 위치 바꾼다.
		// 72'4'65'3'1
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		// a[i] = 6
		// i번쨰 인덱스 이후의 숫자들 오름차순 정렬 (현재는 내림차순 되어있음)
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
		
		if(next_permutation(a)) {		// 다음 순열이 존재한다.
			for(int i=0; i<n; i++) {
				System.out.println(a[i]+" ");
			}
			System.out.println();
		}else {			// 다음 순열이 존재하지 않는다 (마지막 순열이다) 
			System.out.println("-1");
		}
	}
}
