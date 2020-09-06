package brute_force_search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1963

// �� ���ڸ� �Ҽ� N�� M�� �־����� ��, N�� M���� �ٲٴ� '�ּ� ��ȯ Ƚ��'�� ���ϴ� ����
// �ѹ��� N���� ���ڸ��� �ٲ� �� �ְ� 
// �ٲ� ���ڵ� �Ҽ����� �Ѵ�. 
// �̸� ��� 4�ڸ� �Ҽ��� ���س��� �����Ѵ�. (4�ڸ�, 1000�̻� 10000�̸� -> �� ������ ������ 10000�� ���� )
// �� �� ���ڸ��� �ٲٸ鼭 �� ���ڰ� �Ҽ����� �ƴ��� �˻��Ѵ�. (�ѹ��� ���ڸ��� �ٲٹǷ� ������ ������ ����ġ�� 1�̴�)
// '�����佺�׳׽��� ü'�� �Ҽ��� ã�´�.

public class queue_02_1963 {
	
	// num���� index��° �ڸ� ���� digit�� �ٲ۴�. 
	static int change(int num, int index, int digit) {
		// �ٲ� �� ���� ��� : ù��° �ڸ��� 0�� ���
		if(index==0 && digit ==0) {
			return -1;
		}
		String s = Integer.toString(num);
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(index, (char)(digit+'0'));
		return Integer.parseInt(sb.toString());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] prime = new boolean[10001];		// i�� ° �ε��� = i ��� ����, �� ���ڰ� prime���� �ƴ��� ���� 
		
		
		// �̸� ��� �Ҽ� ���ϱ� (�����佺�׳׽��� ü)		10000�� ���϶� �ݹ� ���Ѵ�. 
		for(int i=2; i<=10000; i++) {
			if(prime[i] == false) {
				for(int j=i*i; j<=10000; j+=i) {	// i�� ��� ����� prime �� �ƴϴ�. (���߿� �����´�)
					prime[j] = true;
				}
			}
		}
		
		for(int i=0; i<=10000; i++) {
			prime[i] = !prime[i];
		}
		
		int t = sc.nextInt();	// test case ����
		
		// 
		while(t-- > 0) {		// �� ȸ������ t ����, 0���� Ŭ ������ 
			int n = sc.nextInt();			// n ���� 
			int m = sc.nextInt();			// m ����
			boolean[] c = new boolean[10001];
			int[] d = new int[10001];			// n -> m �ּ� �󸶳� �ɸ����� (distance) // int �迭�� �⺻������ 0���� �ʱ�ȭ��		
			c[n] = true;	// �湮 ���� 
			Queue<Integer> q = new LinkedList<>();
			q.add(n);
			while(!q.isEmpty()) {
				int now = q.remove();		// ���� ��忡�� 
				for(int i=0; i<4; i++) {	// i��° �ڸ� ���ڸ�
					for(int j=0; j<=9; j++) {	// j�� �ٲٱ� (0 <= j <= 9)
						int next = change(now, i, j);		// �ٲ� ���ڴ� next�� ���
						if(next!=-1) {			// next�� -1�� �ƴ϶�� 
							if(prime[next] && c[next]==false) {		// next�� �Ҽ����� �˻� && ���� �湮 ���� ���� 
								q.add(next);		// ť�� �߰� 
								d[next] = d[now] +1;		// dist[next] = dist[now] +1 
								c[next] = true;		// next �湮 ���� Ȯ�� 
							}
						}
					}
				}
				System.out.println(d[m]);		// d[m] : n->m ���� �ɸ� �ð�(�Ÿ�)
			}
		}
	}
}
