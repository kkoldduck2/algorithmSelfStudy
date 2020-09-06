package bfs_dfs;

import java.util.ArrayList;
import java.util.Scanner;

/* https://www.acmicpc.net/problem/2331
 * D[1] = A
 * D[n] = D[n-1]�� �� �ڸ��� ���ڸ� P�� ���� ������ ��
 * ���� ��� A=57, P=2�� ��, ���� D�� {57, 74(=5^2+7^2=25+49), 65, 61, '37', 58, 89, 145, 42, 20, 4, 16, '37', ��}�� �ȴ�. 
 * �� �ڿ��� �ռ� ���� ����(57���Ͱ� �ƴ϶� 58����)�� �ݺ��ȴ�.
 * 
 * �̿� ���� ������ ��� ���ϴ� ���� ������ �̿� ���� �ݺ������� �ȴ�. 
 * �̶�, �ݺ��Ǵ� �κ��� �������� ��, ������ ���� �Ǵ� ������ ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 *  ���� �������� {57, 74, 65, 61}�� �� ���� ���� ���� �ȴ�.
 *  
 *  
 *  �Է�)  ù° �ٿ� A(1 �� A �� 9999), P(1 �� P �� 5)�� �־�����.
 *  ���)  ù° �ٿ� �ݺ��Ǵ� �κ��� �������� ��, ������ ���� �Ǵ� ������ ������ ����Ѵ�.
 * */
public class _5_ReputationCycle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> d = new ArrayList<>();
		
		int a = sc.nextInt();
		int p = sc.nextInt();
		
		// �ԷµǾ��� ���� ����. �迭�� ���� �Է��ϸ鼭 
		d.add(a);
		int ans = dfs(d,a,p);
		System.out.println("����: "+ans);
	}
	
	
	static int dfs(ArrayList<Integer> d,  int a, int p) {
		int val=0;
		while(a>0) {		///????????????????
			int t=1;
			int temp=a%10;
			a=a/10;
			for(int k=0; k<p; k++) {
				t=t*temp;
			}
			val+=t;
		}
		System.out.println(val);
		if(d.contains(val)) return d.indexOf(val);
		d.add(val);
		return dfs(d,val,p);
				
	}
}
