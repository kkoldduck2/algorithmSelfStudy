package greedyAlgorithms;

import java.util.Scanner;

/*https://www.acmicpc.net/problem/11047
 * 
 * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

     동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 * 
 * */

/* 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)

둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. 
(1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)		<- 이 조건 때문에 그리디 알고리즘이 성립된다.
그리디가 아닌 경우, 다이나믹으로 문제를 해결한다. 
 * 
 * */
public class ChangeMoney {
	public static void main(String[] args) {
		int n=10;			// n 종류의 동전으로
		int k =4200;		// k원을 만들어야함 
		Scanner sc = new Scanner(System.in);
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();	// 돈의 가치 입력 
		}
		
		int ans = 0;
        for (int i=n-1; i>=0; i--) {
            ans += k/a[i];	// k원을 가장 단위가 큰 수로 나눔 -> 가장 큰 돈으로 몇개 
            k %= a[i];		// 그리고 그 나머지 
        }
        System.out.println(ans);
		
	}
}
