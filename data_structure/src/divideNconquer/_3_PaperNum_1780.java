package divideNconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1780
/* ������ Ǯ��, ��Ǯ�� ������ 9���� �����ؼ� �ٽ� Ǭ��.
 * ==> ���� ����
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
	
	// (x,y) ��ǥ���� ���μ��� n���� ���ڴ� (Ǯ�ڴ�)
	public static void solve(int[][]a, int[] cnt, int x, int y, int n) {
		// 1) �� ���ھȿ� ���� ��� ������
		if(isSame(a,x,y,n)) {	
			cnt[a[x][y]+1] +=1;
			return;
		}
		
		// 2) ���� ������ -> 9ĭ(3x3)���� ������(����) -> ������ 9���� ���ڿ� ���ؼ� ���� �ٽ� ������ Ǭ��.
		int m = n/3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				solve(a, cnt, x+i*m,y+j*m,m); // x����, y����  -> 9���� ĭ���� ���� ù��°�� �ش��ϴ� �͵� 
			}
		}
	}
	
	// ���� ���� Ȯ���� �ϱ� 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[][] a = new int[n][n];
		int[] cnt = new int[3];		// cnt[0]: -1�θ� ä���� ������ ����, cnt[1]:0�θ� ä���� ������ ����, cnt[2]:1�θ� ä���� ������ ���� 
		
		for(int i=0; i<n; i++) {	// ����
			String[] line = br.readLine().split(" ");
			for(int j=0; j<n; j++) {	// ����
				a[i][j]= Integer.valueOf(line[j]);
			}
		}
		
		solve(a,cnt,0,0,n);
		
		for(int i=0; i<3; i++) {
			System.out.println(cnt[i]);
		}
	
	
	}
}
