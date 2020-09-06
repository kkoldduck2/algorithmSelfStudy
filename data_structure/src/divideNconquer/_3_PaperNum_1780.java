package divideNconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1780
/* 문제를 풀고, 못풀면 문제를 9개로 분할해서 다시 푼다.
 * ==> 분할 정복
 * 
   
 * */
public class _3_PaperNum_1780 {
	public static boolean isSame(int[][] a, int x, int y, int n) {
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(a[x][y] !=a[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	// (x,y) 좌표에서 가로세로 n개를 보겠다 (풀겠다)
	public static void solve(int[][]a, int[] cnt, int x, int y, int n) {
		// 1) 한 상자안에 숫자 모두 같으면
		if(isSame(a,x,y,n)) {	
			cnt[a[x][y]+1] +=1;
			return;
		}
		
		// 2) 같지 않으면 -> 9칸(3x3)으로 나눈다(분할) -> 나눠진 9개의 상자에 대해서 각각 다시 문제를 푼다.
		int m = n/3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				solve(a, cnt, x+i*m,y+j*m,m); // x고정, y증가  -> 9개의 칸에서 각각 첫번째에 해당하는 것들 
			}
		}
	}
	
	// 변수 정의 확실히 하기 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[][] a = new int[n][n];
		int[] cnt = new int[3];		// cnt[0]: -1로만 채워진 종이의 개수, cnt[1]:0로만 채워진 종이의 개수, cnt[2]:1로만 채워진 종이의 개수 
		
		for(int i=0; i<n; i++) {	// 세로
			String[] line = br.readLine().split(" ");
			for(int j=0; j<n; j++) {	// 가로
				a[i][j]= Integer.valueOf(line[j]);
			}
		}
		
		solve(a,cnt,0,0,n);
		
		for(int i=0; i<3; i++) {
			System.out.println(cnt[i]);
		}
	
	
	}
}
