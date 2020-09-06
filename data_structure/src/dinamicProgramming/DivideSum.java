package dinamicProgramming;
import java.math.*;
import java.util.*;
// https://www.acmicpc.net/problem/2225
public class DivideSum {
	public static long mod = 1000000000L;
	public static long recurSum(long[] d, int n, int k) {
		if(d[n]>0 ) return d[n];
		
		if(k==1) return 1;		// 으아아아아아아아아ㅏ아아아아 왜 k==0으로 했을까....ㅠㅠㅠ  변수 범위 정의 똑바로 하자 ㅠㅠ
		
		
		for(int i=0; i<=n; i++) {
			d[n] += recurSum(d, n-i, k-1) ;
			d[n] %= mod;
			// System.out.println("k: "+k+", n: "+n+", d[n]: "+d[n]);
		}
		
		return d[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long[] d = new long[n+1];
		for(int i=0; i<n+1;i++) {
			d[n]=0;
		}
		
		long ans= recurSum(d,n,k)% mod;
		System.out.println(ans);
	}
}
