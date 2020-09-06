package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/* ������� �˰���
 * �迭�� �ε����� Ư���� �������� ������ ����� ���
 * �迭�� ũ�� : ���� �� �ִ� ���� ����
 * [3,3,7]
 * arr[3] = 2, arr[7] =1 �̷��� ���� ��
 * --> ������ ������ �����ϴ�. 
 * */
// https://www.acmicpc.net/problem/10989
public class _3_NumSort_beakjoon10989 {
	public static void main(String[] args) throws Exception {
		// ������ �Է¹ޱ� ���� BufferedReader ���̺귯�� ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[10001];
		
		for(int i=0; i<n; i++) {
			nums[Integer.parseInt(br.readLine())]++;	// �ش� ���� �ε����� �ش��ϴ� ���� ���� 
		}
		
		// �ѹ��� ������ ����ϱ� ���� StringBuilder ���̺귯�� ���
		StringBuilder result = new StringBuilder();
		for(int i=0; i< 10001; i++) {
			if(nums[i]!=0) {	// ���� �����Ѵٸ�
				for(int j=0; j<nums[i]; j++) {	// �� ���� Ƚ����ŭ ����Ѵ�. 
					result.append(i).append("\n");
				}
			}
		}
		System.out.println(result);
	}
}
