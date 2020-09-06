package programmers;

import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/42578
 H1, H2, B1 이 있을때  (이떄 H1,H2는 같은 H 종류이고, B1은 다른 종류이다)
 H1를 선택, H2를 선택, H1&H2 둘다 선택 안함   -> 3가지 (문제 조건상 H1, H2를 동시에 선택할 수 없다)
 B1 을 선택, B1 선택 안함	-> 2가지 
 이므로 전체 경우의 수는 3*2 -1 이다
 즉 (H의 가짓수+1)*(B의 가짓수+1)-1 이라고 볼 수 있다.

// clothes[의상의 이름, 의상의 종류]

public class Hash_disguise {
	public static int solution(String[][] clothes) {
		int answer = 0;
		// clothes의 의상 종류가 같으면 hash의 value 1 증가
		// HashMap(의상 종류, 해당 종류 의상의 개수 )
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i=0; i<clothes.length; i++) {
			// 해당 종류의 clothes를 이미 가지고 있는 경우 -> value(개수)+1
			if(hm.containsKey(clothes[i][1])) {
				hm.replace(clothes[i][1], hm.get(clothes[i][1])+1);
			}
			// 없으면 해당 의상 종류(key)와 value(개수)=1로 저장
			else {
				hm.put(clothes[i][1], 1);
			}
		}
		 answer=1;
		 // Collection values()  :  HashMap에 저장된 모든 값을 컬렉션 형태로 반환한다. 
		 for(int value : hm.values()) {
			 answer*=(value+1);
		 }
		 answer--;
        return answer;
	}
	
	public static void main(String[] args) {
		
	}
}
