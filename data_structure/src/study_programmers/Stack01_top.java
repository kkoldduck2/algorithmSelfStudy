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
			int x = s.pop();	// �۽� ž�� ����
			int idx = findIdx(heights, x);	// �۽� ž�� �ε��� 
			for(int i= idx-1; i>=0; i--) {
				if(heights[i]>x) {		// ����ž(�۽�ž���� ���� && ���� ������ �ִ�)�� �ε����� ����
					answer[idx] = i+1;	
					break;
				}else {// for�� �� ���Ҵµ� �� ū ���� ��ã�� ��� 
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
