package study_programmers;

import java.util.Arrays;

// 내가 푼건데 효율성 테스트 통과 못함
//https://www.welcomekakao.com/learn/courses/30/lessons/60060?language=java
public class KakaoBlindTest01 {
	static boolean check(String query, String word) {
		for(int k=0; k<query.length(); k++) {
			char c = query.charAt(k); // k번째 인덱스에 있는 문자 반환
			if(c !='?') {
				if(word.charAt(k) !=c) {
					return false;
				}
			}   
		}
		return true;
	}
	
	static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		
		// 시간복잡도 O(NM)
		for(int i=0; i<queries.length; i++) {
			for(int j=0; j<words.length; j++) {
				if(words[j].length()==queries[i].length()) {
					if(check(queries[i], words[j])) {
						answer[i]++;
					}
				}
			}
			
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] answer = new int[queries.length];
		answer = solution(words, queries);
		System.out.println(Arrays.toString(answer));
	}
}
