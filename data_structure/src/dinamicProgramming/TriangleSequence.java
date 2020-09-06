package dinamicProgramming;
// https://www.acmicpc.net/problem/9461
import java.util.Scanner;

public class TriangleSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int[] ans = new int[r];
		for(int j=0; j<r; j++) {
			int n = sc.nextInt();
			int[] p = new int [n+1];
			
			p[1]= 1;
			p[2]= 1;
			p[3]= 1;
			p[4]= 2;
			p[5]= 2;
			
			for(int i=6; i<=n; i++) {
				p[i] = p[i-5] + p[i-1];
			}
			
			ans[r] = p[n];
		}
		
	}
}
