package study_programmers;

import java.util.Stack;

/* 
1. �Է��� �� ���ڿ��� ���, �� ���ڿ��� ��ȯ�մϴ�. 
2. ���ڿ� w�� �� "�������� ��ȣ ���ڿ�" u, v�� �и��մϴ�. ��, u�� "�������� ��ȣ ���ڿ�"�� �� �̻� �и��� �� ����� �ϸ�, 
	v�� �� ���ڿ��� �� �� �ֽ��ϴ�. 
3. ���ڿ� u�� "�ùٸ� ��ȣ ���ڿ�" �̶�� ���ڿ� v�� ���� 1�ܰ���� �ٽ� �����մϴ�. 
  3-1. ������ ��� ���ڿ��� u�� �̾� ���� �� ��ȯ�մϴ�. 
4. ���ڿ� u�� "�ùٸ� ��ȣ ���ڿ�"�� �ƴ϶�� �Ʒ� ������ �����մϴ�. 
  4-1. �� ���ڿ��� ù ��° ���ڷ� '('�� ���Դϴ�. 
  4-2. ���ڿ� v�� ���� 1�ܰ���� ��������� ������ ��� ���ڿ��� �̾� ���Դϴ�. 
  4-3. ')'�� �ٽ� ���Դϴ�. 
  4-4. u�� ù ��°�� ������ ���ڸ� �����ϰ�, ������ ���ڿ��� ��ȣ ������ ����� �ڿ� ���Դϴ�. 
  4-5. ������ ���ڿ��� ��ȯ�մϴ�.
 * 
 * */
// �ùٸ��� �˻� ��� (stack)
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
	// w�� u,v�� �и������� �и��Ǵ� ������ �ε��� ��ȯ (v���� ����, u�� �� �ε���)
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
        // base case : �ùٸ��� or �� ���ڿ� -> ���ڿ� ��ȯ 
        if(p.equals("")) {
        	return "";
        }else if(isRight(p)) {
        	return p;
        }
        // recur : �ùٸ��� �ʴ� -> u,v�� ����
        // u : ���� ���� + ���̻� �и� �Ұ�
        int idx = splitUV(p);
        String u = p.substring(0,idx+1);
        String v = p.substring(idx+1);
        // u�� �ùٸ��� -> u+solution(v)
        if(isRight(u)) {
        	answer = u+solution(v);
        }else {// u�� �ùٸ��� �ʴ� -> '('+solution(v)+')' + u�� ù��° ������ ���� �� ��ȣ ���� ����� �ڿ� ���̱�
        	String nu = u.substring(1,u.length()-1);// ù��° ������ ���� 
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
