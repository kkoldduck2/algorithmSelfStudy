package greedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1541
public class _20_01_11_1541 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String [] input = br.readLine().split("\\-");		// - 기준으로 나누기
		// +로 연결된 얘들끼리 묶일 꺼임. 이하 +덩어리
		
		int minResult =0;
		
		for(int i=0; i<input.length; i++) {
			// 맨 앞에는 일단 +
			// 나중에 오는 +덩어리들은 앞에 -가 붙어야한다. 
			int calcNum=calc(input[i].split("\\+"));
			
			if(i==0) {
				calcNum *=-1;
			}
			
			minResult -=calcNum;
			
		}
		System.out.println(minResult);
		
	}
	
	
	// +덩어리 계산
	public static int calc(String[] subNums) {
		int result =0;
		for(String num : subNums) {
			result += Integer.parseInt(num);
		}
		return result;
	}
	
}
