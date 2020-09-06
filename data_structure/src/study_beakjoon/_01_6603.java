package study_beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/6603
// ���� + ��� ����� �� (���� Ž��, ��Ʈ��ŷ)
/* ��Ʈ��ŷ ����
 * ��Ʈ��ŷ�� ��� ����� ����  Ž���� ���� �Ҷ� Ž���� �� �Ŀ� �ٽ� ���� Ž���ϱ� �������� �ǵ����� ������ �˰��� �̴�. 
 * */
public class _01_6603 {
	public static int k;			// ���� S�� ������ ���� 
	public static int[] S;
	public static boolean[] visited;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k ==  0) break;
			
			S = new int[k];					// ��ü ����, ���⼭ �Ϻθ� �����Ѵ�. 
			visited = new boolean[k];		// S���� i��° �ε����� ���Ҹ� �湮�ߴ��� ���� 
			
			for(int i=0; i<k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			System.out.println();
		}
	} 
	
	// ��Ʈ��ŷ ���� (�Ű����� : ���� ���� (���°���)Ʈ���� � ��忡 �ִ����� ����)
	// Ʈ���� ������ ���ؼ� �迭�̴�. �׳� �츮�� ����ϴ� ����� �׷��� �������. ���������δ� �迭
	// �� ������ ����� ���� �ϳ��� �����ϴ°� �ƴϰ� ���� ����� ���� ��� print �ϴ� �����̹Ƿ� 
	// if else ���ٴ� if �ϰ� + �� ã�� �̷��� �����Ѵ�. 
	
	// start��° �ε��� ����(���)�� �湮�� 
	// i) ���� ������ 6����  --> ����
	// ii) ���� �ƴϸ� --> �� ������ ������ ���� ���� (for��)
	public static void dfs(int start, int depth) {
		
		// 6�� ��� ���� 
		if(depth==6) {
			print();
			return;
		}
	
		// �������� �迭���� �ε��� start ���� ���� �� � ��带 �湮�� ���ΰ�.   visit children recursively (�ڽ� ��� �湮)
		// ���� ��� �ٷ� ������ �湮�ϴ� ��尡 : i+1 �� ���, i+2�� ���, i+3 �� ��� ...  
		// sol 1)  ex) N queens ���� 
//		for(int i=start; i<k; i++) {
//			visited[i]= true;
//			dfs(i+1, depth+1);
//			visited[i] = false;	// ��Ʈ��ŷ : Ž���� �� �Ŀ� �ٽ� ���� Ž���ϱ� �������� �ǵ���
//		}
		
		// sol 2) 
		// �ǿ��� ������ st Ǯ��!!������ �ƽ� ����
		// �� Ǯ�̴� start ��带 ���������� /�������� ������ �� ������ ����� ���� ���ϴ� ��
		if(start <k) {
			visited[start] = true;
			dfs(start+1, depth+1);
			
			visited[start] = false;
			dfs(start+1, depth);	// start�� �湮 ���ߴٸ� dept�� �����ϴ� 
		}
		

		
	}
	
	public static void print() {
		for(int i=0; i<k; i++) {
			if(visited[i]==true) {
				System.out.print(S[i]+" ");
			}
		}

		System.out.println();
	}
	
}
