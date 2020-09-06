package study_samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/16637
/* 
 * ���̰� N�� ������ �ִ�. ������ 0���� ũ�ų� ����, 9���� �۰ų� ���� ������ ������(+, -, ��)�� �̷���� �ִ�. 
 * ������ �켱������ ��� �����ϱ� ������, ������ ����� ���� ���ʿ������� ������� ����ؾ� �Ѵ�. ���� ���, 3+8��7-9��2�� ����� 136�̴�.
	���Ŀ� ��ȣ�� �߰��ϸ�, ��ȣ �ȿ� ����ִ� ���� ���� ����ؾ� �Ѵ�.
	
	��, "��ȣ �ȿ��� �����ڰ� �ϳ���" ��� �־�� �Ѵ�. ���� ���, 3+8��7-9��2�� ��ȣ�� 3+(8��7)-(9��2)�� ���� �߰�������, ���� ����� 41�� �ȴ�. 
	������, ��ø�� ��ȣ�� ����� �� ����. ��, 3+((8��7)-9)��2, 3+((8��7)-(9��2))�� ��� ��ȣ �ȿ� ��ȣ�� �ֱ� ������, �ùٸ� ���� �ƴϴ�.
	
	������ �־����� ��, ��ȣ�� ������ �߰��� ���� �� �ִ� ���� ����� '�ִ�'�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
	�߰��ϴ� ��ȣ ������ ������ ������, �߰����� �ʾƵ� �ȴ�.
	
	�Է� : ù° �ٿ� ������ ���� N(1 �� N �� 19)�� �־�����. ��° �ٿ��� ������ �־�����.���Ŀ� ���Ե� ������ ��� 0���� ũ�ų� ����, 9���� �۰ų� ����
	��� : ù° �ٿ� ��ȣ�� ������ �߰��ؼ� ���� �� �ִ� ����� �ִ��� ����Ѵ�.
	
 * */
/*Ǯ�� ����?
 * ��� ���ɼ� ���غ��� �ִ� ���ϴ� ���� --> ���̳��� ���α׷��� (x)
 * dfs(����Լ�)�� Ǫ�� �����̴�.
 * 
 * 3+8*7-9*2
 * ������ ��ȣ ���� : (3+8), (8*7), (7-9), (9*2)
 * �� ���� �߿��� �ϳ��� ���� ���� �� ����
 * �� ���ڰ� ���ļ��� �ȵ�. �� (3+8) ���������� (8*7) ���� �Ұ� 
 * ��, 
 * */
public class _01_16637 {
	static int N;
	static char[] input;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = br.readLine().toCharArray();
		
		dfs(1,input[0]-'0',0, false);
		System.out.println(max);
		
	}
	
	static void dfs(int op_indx, int val, int pre_val, boolean wasBrace) {
		if(op_indx >= N) {
			if(max < val) {
				max = val;
			}
			return;
		}
		
		// �� �����ڿ� ���ؼ��� ��ȣ�� ġ�� ���� ���
		dfs(op_indx+2, cal(val, input[op_indx], input[op_indx+1]-'0'), val, false);
		
		// ���� ��ȣ�� ĥ�� �ִ��� �˻� -> ��ȣ ġ�� ���
		if(op_indx >1 && !wasBrace) {
			dfs(op_indx+2, cal(pre_val, input[op_indx-2], cal(input[op_indx-1]-'0',
					input[op_indx], input[op_indx+1]-'0')), 0, true);
			
		}
	}
	
	static int cal(int a, char op, int b) {
        if(op == '+') return a + b;
        else if(op == '-') return a - b;
        else return a * b;
    }
}
