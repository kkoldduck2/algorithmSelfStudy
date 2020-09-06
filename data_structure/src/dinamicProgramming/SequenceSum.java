package dinamicProgramming;
// https://www.acmicpc.net/problem/1912
/*
n���� ������ �̷���� ������ ������ �־�����. �츮�� �� �� ���ӵ� �� ���� ���� �����ؼ� ���� �� �ִ� �� �� ���� ū ���� ���Ϸ��� �Ѵ�.
 ��, ���� �� �� �̻� �����ؾ� �Ѵ�.

���� �� 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 �̶�� ������ �־����ٰ� ����. ���⼭ ������ 12+21�� 33�� ������ �ȴ�.
 * */

// d[i] : a[i]�� ������ �ִ� ������
// 1) a[i-1]�� ������ �������� ���ԵǴ� ���  ->  d[i-1]+a[i]
// 2) ���ο� �������� ����� ��� -> a[i]
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
