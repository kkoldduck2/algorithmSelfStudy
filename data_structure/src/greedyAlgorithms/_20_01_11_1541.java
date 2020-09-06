package greedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1541
public class _20_01_11_1541 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String [] input = br.readLine().split("\\-");		// - �������� ������
		// +�� ����� ��鳢�� ���� ����. ���� +���
		
		int minResult =0;
		
		for(int i=0; i<input.length; i++) {
			// �� �տ��� �ϴ� +
			// ���߿� ���� +������� �տ� -�� �پ���Ѵ�. 
			int calcNum=calc(input[i].split("\\+"));
			
			if(i==0) {
				calcNum *=-1;
			}
			
			minResult -=calcNum;
			
		}
		System.out.println(minResult);
		
	}
	
	
	// +��� ���
	public static int calc(String[] subNums) {
		int result =0;
		for(String num : subNums) {
			result += Integer.parseInt(num);
		}
		return result;
	}
	
}
