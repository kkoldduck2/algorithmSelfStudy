package brute_force_search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2251
/* ���� ���ǰ� A, B, C(1��A, B, C��200) ������ �� ���� ������ �ִ�. 
 * ó������ ���� �� ������ ��� �ְ�, �� ��° ������ ����(C ����) �� �ִ�. 
 * ���� � ���뿡 ����ִ� ���� �ٸ� �������� ��� ���� �� �ִµ�, �̶����� �� ������ ��ų�, �ٸ� �� ������ ���� �� ������ ���� ���� �� �ִ�.
 * �� �������� �սǵǴ� ���� ���ٰ� �����Ѵ�.
�̿� ���� ������ ��ġ�ٺ��� �� ��° ����(�뷮�� C��)�� ����ִ� ���� ���� ���� ���� �ִ�. 
'ù ��° ����(�뷮�� A��)�� ��� ���� ��, �� ��° ����(�뷮�� C��)�� ������� �� �ִ� ���� ��'�� ��� ���س��� ���α׷��� �ۼ��Ͻÿ�.

�Է� : ù° �ٿ� �� ���� A, B, C�� �־�����.
��� : ù° �ٿ� �������� �����Ͽ� ���� ����Ѵ�. �� �뷮�� ������������ �����Ѵ�.
 * */
/*
 * ���� 3���� �� �غ��� ����� ���� ����ص� 200*200*200�� �˳��ϴ�. �׷��Ƿ�
BFS�� ���� ���� Ž���� �ϰ� �� ���߿� A�� ������� �� C�� ���� ���� ����ϸ� �ȴ�.
�ٸ� BFS������ ����ϰ� ���� ���� �� �ִ� ����� ���� ���� ť�� �����鼭 Ž���ϸ� �ȴ�.
���� ���� �� �ִ� ����� ���� 6�����̴�.
C -> A, C -> B, B -> A, B -> C, A -> B, A -> C

a + b + c = C(ó��)
c = C(ó��)-a-b
���� a, b�� ����� ���� üũ�ϸ� �ڵ������� �޶��� c�� üũ�ȴ�. 
*
*/

class Pair implements Comparable<Pair>{
	final int first;
	final int second;
	Pair(int first, int second){
		this.first = first;
		this.second = second;
	}
	
	@Override
	public int compareTo(Pair pair) {
		if(this.first < pair.first) {
			return -1;		// ���� ���� �񱳴�󺸴� ���� ��� -1
		}
		if(this.first > pair.first) {
			return 1;
		}
		if(this.second < pair.second) {
			return -1;
		}
		if(this.second > pair.second) {
			return 1;
		}
		return 0;		// ���ذ��� �񱳴��� ���� ��� 0
	}
	
	public boolean equals(Object object) {
		if(object instanceof Pair) {
			Pair pair = (Pair)object;
			return this.first == pair.first && this.second == pair.second;
		}
		return false;
	}
	
	// ���ڴ�..����
	public int hashCode() {
		int n=3;
		n = 19*n+this.first;
		n = 19*n+this.second;
		return n;
	}
}
public class queue_05_2251 {
	static final int[] from = {0,0,1,1,2,2};
	static final int[] to = {1,2,0,2,0,1};
	// 0->1, 0->2 �̷��� �Ű� ��� ���� �ǹ��Ѵ�. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cap = new int[3];	// ���� 3��
		for(int i=0; i<3; i++) {
			cap[i] = sc.nextInt();
		}
		
		int sum = cap[2];	// C (�ʱⰪ)
		boolean[][] check = new boolean[201][201];
		boolean[] ans = new boolean[201];	// c�� ����� �� 
		
		// ���⼭���� ����� bfs
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0));	// a=0, b=0
		check[0][0] = true;
		ans[cap[2]] = true;
		while(!q.isEmpty()) {
			int[] cur = new int[3];
			Pair p = q.peek();
			cur[0] = p.first;
			cur[1] = p.second;
			cur[2] = sum - cur[0] - cur[1];
			q.remove();
			
			// 6���� ����� ���� ���ؼ� 
			for(int k=0; k<6; k++) {
				int[] next = {cur[0], cur[1], cur[2]};	// ���� ȸ�� a,b,c�� �뷮
				next[to[k]] += next[from[k]];
				next[from[k]] =0;
				
				// ��ġ��
				if(next[to[k]]> cap[to[k]]) {
					next[from[k]] = next[to[k]] - next[from[k]];
					next[to[k]] = cap[to[k]];
				}
				
				// ���� �湮 ���� ��� (���ο� �뷮)�̸�  -> check! & ť�� �߰� 
				if(!check[next[0]][next[1]]) {
					check[next[0]][next[1]] = true;
					q.add(new Pair(next[0], next[1]));
					
					// �׸��� a ������ �뷮�� 0�̸� 
					// ans(c �뷮 üũ �迭)�� �ش� �뷮�� true��� ���� 
					// �� ��带 �湮�ߴٴ� ��
					if(next[0] ==0) {
						ans[next[2]] = true;
					}
				}
			}
		}
		
		// q�� empty�� �� 
		// C(ó�� c�� �뷮)��ŭ ���鼭 c�� �󸶸�ŭ�� �뷮�� �������� ����Ʈ �Ѵ�. 
		for(int i=0; i<=cap[2]; i++) {
			// i�뷮�� �湮 ������ 
			if(ans[i]) {
				System.out.println(i+" ");
			}
		}
		System.out.println();
	}
}
