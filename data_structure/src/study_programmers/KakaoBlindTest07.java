package study_programmers;

import java.util.Stack;

/* 
1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, 
	v는 빈 문자열이 될 수 있습니다. 
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
  4-3. ')'를 다시 붙입니다. 
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
  4-5. 생성된 문자열을 반환합니다.
 * 
 * */
// 올바르다 검사 방법 (stack)
public class KakaoBlindTest07 {
	public static boolean isRight(String w) {
		boolean istrue = true;
		Stack<String> s = new Stack<>();
		for(int i=0; i<w.length(); i++) {
			if(w.charAt(i)=='(') {
				s.push("(");
			}
			if(w.charAt(i)==')') {
				if(!s.isEmpty()) {
					s.pop();
				}else {
					istrue= false;
					break;
				}
			}
		}
		return istrue;
	}
	// w를 u,v로 분리했을때 분리되는 지점의 인덱스 반환 (v시작 직전, u의 끝 인덱스)
	public static int splitUV(String w) {
		int count_open=0;
		int count_close=0;
		int idx=0;
		for(int i=0; i<w.length(); i++) {
			if(w.charAt(i)=='(') {
				count_open++;
			}
			if(w.charAt(i)==')') {
				count_close++;
			}
			if(count_open==count_close) {
				idx=i;
				break;
			}
		}
		return idx;
	}
	public static String solution(String p) {
        String answer = "";
        // base case : 올바르다 or 빈 문자열 -> 문자열 반환 
        if(p.equals("")) {
        	return "";
        }else if(isRight(p)) {
        	return p;
        }
        // recur : 올바르지 않다 -> u,v로 분할
        // u : 균형 잡힌 + 더이상 분리 불가
        int idx = splitUV(p);
        String u = p.substring(0,idx+1);
        String v = p.substring(idx+1);
        // u가 올바르다 -> u+solution(v)
        if(isRight(u)) {
        	answer = u+solution(v);
        }else {// u가 올바르지 않다 -> '('+solution(v)+')' + u의 첫번째 마지막 제거 후 괄호 방향 뒤집어서 뒤에 붙이기
        	String nu = u.substring(1,u.length()-1);// 첫번째 마지막 제거 
        	StringBuilder new_u = new StringBuilder(nu);
        	for(int i=0; i<nu.length(); i++) {
        		if(new_u.charAt(i)=='(') {
        			new_u.setCharAt(i, ')');
        		}
        		else if(new_u.charAt(i)==')') {
        			new_u.setCharAt(i, '(');
        		}
        	}
        	nu = new_u.toString();
        	answer = "("+solution(v)+")"+nu;
        }
        return answer;
	}
	public static void main(String[] args) {
		String p = "(()())()";
		String p2 = ")(";
		String p3 = "()))((()";
//		System.out.println(solution(p));
//		System.out.println(solution(p2));
		System.out.println(solution(p3));
	}
}
