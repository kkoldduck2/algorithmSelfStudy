package stack;
import java.util.Stack;

// stack을 정렬하는 함수를 만드시오
// 단, 하나의 stack을 추가로 사용할 수 있고, Array 등 다른 데이터 구조는 사용할 수 없음
public class stacksort {
	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(3);
		s1.push(5);
		s1.push(1);
		s1.push(6);
		sort(s1);
		
		while(!s1.isEmpty()) {
			System.out.println(s1.pop());
		}
		
	}
	
	private static void sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		
		while(!s1.isEmpty()) {
			int temp = s1.pop();
			
			// s2에서 temp보다 작은게 나올 때까지 반복
			while(!s2.isEmpty() && s2.peek() > temp) {
				s1.push(s2.pop());
			}
			// 드디어 작은게 나옴!
			s2.push(temp);
		}
		
		// 첫번째 스택을 다 돌고 비어있음 
		// 이제 s2에서 s1으로 모두 옮길 차례
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	
	
}
