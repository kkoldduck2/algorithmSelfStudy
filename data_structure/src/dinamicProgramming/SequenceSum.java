package dinamicProgramming;
// https://www.acmicpc.net/problem/1912
/*
n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
 단, 수는 한 개 이상 선택해야 한다.

예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.
 * */

// d[i] : a[i]로 끝나는 최대 연속합
// 1) a[i-1]로 끝나는 연속합이 포함되는 경우  ->  d[i-1]+a[i]
// 2) 새로운 연속합을 만드는 경우 -> a[i]
public class SequenceSum {
	public static void main(String[] args) {
		int n= 10;
		int[] a = new int[] {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
		
		int[] d = new int[n+1];
		d[1]=a[0];
		for(int i=2; i<n+1; i++) {
			d[i]=0;
			if(a[i-1] > d[i-1]+a[i-1]) {
				d[i] = a[i-1];
			} else {
				d[i] = d[i-1]+a[i-1];
			}
		}
		
		int ans =d[1];
		for(int i=2; i<n+1;i++) {
			ans = (ans<d[i] ? d[i] : ans );
		}
		
		System.out.println(ans);
	}
}
