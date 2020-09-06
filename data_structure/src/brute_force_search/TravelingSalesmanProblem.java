package brute_force_search;
// https://www.acmicpc.net/problem/10971
/* ���ǿ� ��ȸ ������ ����� Traveling Salesman problem (TSP) ��� �Ҹ��� ������ 
 * computer science �о߿��� ���� �߿��ϰ� ��޵Ǵ� ���� �� �ϳ��̴�.
	���� ���� ���� ������ ������, ���⼭�� ���� �Ϲ����� ������ ������ ���캸��.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* ���� : ������ �߿��� 
 * � ������ �ؾ� ����� �ּҷ� ��� 
 * ù° �ٿ� ������ �� N�� �־�����. (2 �� N �� 10) ���� N���� �ٿ��� ��� ����� �־�����. 
 * W[i][j]�� ���� i���� j�� ���� ���� ����� ��Ÿ����.
 * **** ��쿡 ���� ���� i���� ���� j�� �� �� ���� ��쵵 ������ �̷� ��� W[i][j]=0�̶�� ����.
 * */

public class TravelingSalesmanProblem {
	static int N;
	static int[][] W;
	static int MIN = Integer.MAX_VALUE;
	static int[] order;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �湮 ���� ���� : �ϴ� 0, 1, 2, 3, 4, ..., N-1 ������ �湮�Ѵٰ� ����
		order = new int[N];
		for(int i=0; i<N; i++) {
			order[i] = i;
		}
		
		// ���� - ��� ��� 
		// order[0] ���⿡ ���� �������� ���� (�̹� ������ �ŷ� ġ�� ����)
		for(int i=0; i<N; i++) {
			swap(0,i);
			perm(1, 0);
			swap(0,i);
		}
		
		System.out.println(MIN);
		
	}
	
	// k-1 ��°���� ���� ������ �� 
	static void perm (int k, int result) {
		if(k==N && W[order[N-1]][order[0]]!=0) {		/* i ->j �� ���� ����� ���� ��쵵 üũ  */
			result += W[order[N-1]][order[0]];
			if(MIN > result) {
				MIN = result;
			}
			return;
		}

		for(int i=k; i<N; i++) {
			swap(i, k);
			if(W[order[k-1]][order[k]]!=0) {		/* i ->j �� ���� ����� ���� ��쵵 üũ  */
				perm(k+1, result+ W[order[k-1]][order[k]]);
			}
			swap(i, k);
		}
	}
	
	static void swap(int i, int j) {
		int temp = order[i];
		order[i] = order[j];
		order[j] = temp;
	}

	
}
