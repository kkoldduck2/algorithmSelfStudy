package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/* 계수정렬 알고리즘
 * 배열의 인덱스를 특정한 데이터의 값으로 여기는 방법
 * 배열의 크기 : 나올 수 있는 값의 구간
 * [3,3,7]
 * arr[3] = 2, arr[7] =1 이렇게 세는 것
 * --> 빠르게 정렬이 가능하다. 
 * */
// https://www.acmicpc.net/problem/10989
public class _3_NumSort_beakjoon10989 {
	public static void main(String[] args) throws Exception {
		// 빠르게 입력받기 위해 BufferedReader 라이브러리 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[10001];
		
		for(int i=0; i<n; i++) {
			nums[Integer.parseInt(br.readLine())]++;	// 해당 값의 인덱스에 해당하는 값이 증가 
		}
		
		// 한번에 빠르게 출력하기 위해 StringBuilder 라이브러리 사용
		StringBuilder result = new StringBuilder();
		for(int i=0; i< 10001; i++) {
			if(nums[i]!=0) {	// 값이 존재한다면
				for(int j=0; j<nums[i]; j++) {	// 그 값의 횟수만큼 출력한다. 
					result.append(i).append("\n");
				}
			}
		}
		System.out.println(result);
	}
}
