package study_programmers;

import java.util.*;

public class Naver {
	public static void main(String[] args) {
		Stack<Character> s = new Stack<>();
		HashSet<Character> open = new HashSet<>();
		HashSet<Character> close = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		inputString = inputString.trim();
		char[] inputArr = inputString.toCharArray();
		
		open.add('[');
		open.add('{');
		open.add('(');
		open.add('<');
		close.add('}');
		close.add(']');
		close.add(')');
		close.add('>');
		
		int answer = 0;
		for(char c: inputArr) {
			if(close.contains(c) && !s.isEmpty()) {
				s.pop();
				answer ++;
				continue;
			}
			else if(open.contains(c)) {
				s.push(c);
			}else if(close.contains(c) && s.isEmpty()) {
				answer = -1;
				break;
			}
			
		}
		
		System.out.println(answer);
	}
}
