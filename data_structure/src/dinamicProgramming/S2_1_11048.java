package dinamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11048
public class S2_1_11048 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 행
		int m = Integer.parseInt(st.nextToken());	// 열
		
		int[][] arr = new int [n+1][m+1];

		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// d[i][j]  : (i,j)로 이동할 때, 가져올 수 있는 최대 사탕의 개수 
		int[][] d = new int[n+1][m+1];
		d[1][1] = arr[1][1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(i==1 && j==1) {
					d[i][j] = arr[1][1];
				}
				else if(i==1) {
					d[i][j] = d[i][j-1]+arr[i][j];
				}
				else if(j==1) {
					d[i][j] = d[i-1][j]+arr[i][j];
				}
				else {
					d[i][j] = Math.max(d[i][j-1], Math.max(d[i-1][j], d[i-1][j-1]))+ arr[i][j];
				}
			}
		}
		
		System.out.println(d[n][m]);
	}
}
