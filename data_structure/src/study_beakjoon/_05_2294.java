package study_beakjoon;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2294
public class _05_2294 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a= new int[n];
		int[] d = new int[100001]; // k���� ���� �� �ִ� �ּ� ���� memoization
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			d[a[i]] = 1;
		}
		for(int i=1; i<k+1; i++) {
			for(int j=0; j<a.length; j++) {
				if(i-a[j]>0) {
					int temp = d[i-a[j]];
					if(temp < 1) {	
						continue;
					}else {	// �����ϸ�
						if(d[i]<1) {
							d[i] = temp+1;
						}else {
							d[i] = d[i] > temp+1 ? temp+1 : d[i];
						}
					}
				}
			}
			
		}
		
		int answer;
		if(d[k]<1) {
			answer = -1;
		}else {
			answer = d[k];
		}
		System.out.println(answer);
	}
}