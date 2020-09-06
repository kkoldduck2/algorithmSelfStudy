package study_programmers;

import java.util.Arrays;
import java.util.Stack;

public class Stack01_top {
	
	public static void main(String[] args) {
		int [] heights = {1,5,3,6,7,6,5};
		int[] answer = new int[heights.length];
		
		Stack<Integer> s = new Stack<>();
		for(int h : heights) {
			s.push(h);
		}
		
		while(!s.isEmpty()) {
			int x = s.pop();	// 송신 탑의 높이
			int idx = findIdx(heights, x);	// 송신 탑의 인덱스 
			for(int i= idx-1; i>=0; i--) {
				if(heights[i]>x) {		// 수신탑(송신탑보다 높은 && 가장 가까이 있는)의 인덱스를 저장
					answer[idx] = i+1;	
					break;
				}else {// for문 다 돌았는데 더 큰 숫자 못찾은 경우 
					answer[idx] =0;
				}
			}
		}
		
		
		
		System.out.println(Arrays.toString(answer));
	}
	static int findIdx(int[] heights, int x ) {
		int index=-1;
		for(int i=0; i<heights.length; i++) {
			if(heights[i]==x) {
				index = i;
			}
		}
		return index;
	}
}
