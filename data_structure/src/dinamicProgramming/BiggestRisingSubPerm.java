package dinamicProgramming;
// https://www.acmicpc.net/problem/11055
public class BiggestRisingSubPerm {
	public static void main(String[] args) {
		
		int n = 10;
		int[] a = new int[] {1, 100, 2, 50, 60, 3, 5, 6, 7, 8};
		int[] d = new int[n+1];
		
		
		for(int i=1; i<n+1; i++) {
			d[i] =a[i-1];
			for(int j=1; j<i; j++) {
				if(a[j-1]<a[i-1] && d[i] <d[j]+a[i-1]) {
					d[i] = d[j]+a[i-1];
				}
			}
		}

		int ans = d[1];
		for(int i=2; i<n+1;i++) {
			if(ans < d[i]) {
				ans = d[i];
			}
		}
		System.out.println(ans);
	}
}
