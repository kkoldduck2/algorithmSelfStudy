package programmers;

import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/42578
 H1, H2, B1 �� ������  (�̋� H1,H2�� ���� H �����̰�, B1�� �ٸ� �����̴�)
 H1�� ����, H2�� ����, H1&H2 �Ѵ� ���� ����   -> 3���� (���� ���ǻ� H1, H2�� ���ÿ� ������ �� ����)
 B1 �� ����, B1 ���� ����	-> 2���� 
 �̹Ƿ� ��ü ����� ���� 3*2 -1 �̴�
 �� (H�� ������+1)*(B�� ������+1)-1 �̶�� �� �� �ִ�.

// clothes[�ǻ��� �̸�, �ǻ��� ����]

public class Hash_disguise {
	public static int solution(String[][] clothes) {
		int answer = 0;
		// clothes�� �ǻ� ������ ������ hash�� value 1 ����
		// HashMap(�ǻ� ����, �ش� ���� �ǻ��� ���� )
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i=0; i<clothes.length; i++) {
			// �ش� ������ clothes�� �̹� ������ �ִ� ��� -> value(����)+1
			if(hm.containsKey(clothes[i][1])) {
				hm.replace(clothes[i][1], hm.get(clothes[i][1])+1);
			}
			// ������ �ش� �ǻ� ����(key)�� value(����)=1�� ����
			else {
				hm.put(clothes[i][1], 1);
			}
		}
		 answer=1;
		 // Collection values()  :  HashMap�� ����� ��� ���� �÷��� ���·� ��ȯ�Ѵ�. 
		 for(int value : hm.values()) {
			 answer*=(value+1);
		 }
		 answer--;
        return answer;
	}
	
	public static void main(String[] args) {
		
	}
}
