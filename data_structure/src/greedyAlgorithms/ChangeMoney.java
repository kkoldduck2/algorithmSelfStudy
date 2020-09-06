package greedyAlgorithms;

import java.util.Scanner;

/*https://www.acmicpc.net/problem/11047
 * 
 * �ر԰� ������ �ִ� ������ �� N�����̰�, ������ ������ �ſ� ���� ������ �ִ�.

     ������ ������ ����ؼ� �� ��ġ�� ���� K�� ������� �Ѵ�. �̶� �ʿ��� ���� ������ �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * */

/* ù° �ٿ� N�� K�� �־�����. (1 �� N �� 10, 1 �� K �� 100,000,000)

��° �ٺ��� N���� �ٿ� ������ ��ġ Ai�� ������������ �־�����. 
(1 �� Ai �� 1,000,000, A1 = 1, i �� 2�� ��쿡 Ai�� Ai-1�� ���)		<- �� ���� ������ �׸��� �˰����� �����ȴ�.
�׸��� �ƴ� ���, ���̳������� ������ �ذ��Ѵ�. 
 * 
 * */
public class ChangeMoney {
	public static void main(String[] args) {
		int n=10;			// n ������ ��������
		int k =4200;		// k���� �������� 
		Scanner sc = new Scanner(System.in);
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();	// ���� ��ġ �Է� 
		}
		
		int ans = 0;
        for (int i=n-1; i>=0; i--) {
            ans += k/a[i];	// k���� ���� ������ ū ���� ���� -> ���� ū ������ � 
            k %= a[i];		// �׸��� �� ������ 
        }
        System.out.println(ans);
		
	}
}
