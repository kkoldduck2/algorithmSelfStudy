package study_programmers;

import java.util.Arrays;
import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/60057
public class KakaoBlindTest06 {
	// s�� n�� ������ �ڸ���. 
	public static int splitlen(int n, String s) {
		String[] a = {};
		int len = s.length();
		if(len%n !=0) {
			a = new String[len/n+1];
		}else {
			a = new String[len/n];
		}
		// a�� n�� ������ �߸� ���ڿ� ���
		int k=0;
		int j=0;
		while(k<s.length()) {
			int temp = k+n;
			if(temp > s.length()) {
				a[j] = s.substring(k, s.length());
				break;
			}
			a[j] = s.substring(k, temp);
			k = temp;
			j++;
		}
//		System.out.println("a :"+ Arrays.toString(a));
		// ���ϸ鼭 �����ϱ�
		String ns = "";	// stringBuilder�� ���� ����.
		Stack<String> st = new Stack<>();
		st.add(a[0]);
		for(int i=1; i<a.length; i++) {
			if(st.peek().equals(a[i])) {
				st.add(a[i]);
			}else {
				if(st.size()==1) {
					ns+=st.pop();
				}else {
					int c = st.size();
					ns+= Integer.toString(c);
					ns+= st.pop();
				}
				st.clear();
				st.add(a[i]);
			}
		}
		// stack�� �����ִ°� �� �ٿ��ֱ� 
		if(st.size()==1) {
			ns+=st.pop();
		}else {
			int c = st.size();
			ns+= Integer.toString(c);
			ns+= st.pop();
		}
		return ns.length();
	}
	public static int solution(String s) {
        int answer = 0;
        int min = s.length();
        for(int i=1; i<=s.length()/2; i++) {
        	int k = splitlen(i, s);
        	min = min > k ? k : min;
        }
        answer = min;
        return answer;
    }
	public static void main(String[] args) {
		String[] S = {"aabbaccc","ababcdcdababcdcd","abcabcdede","abcabcabcabcdededededede",
				"xababcdcdababcdcd"};
		for(int i=0; i<S.length; i++) {
			System.out.println(solution(S[i]));
		}
	}
}
