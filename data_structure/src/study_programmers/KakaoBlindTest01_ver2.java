package study_programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://saintbeller96.tistory.com/7    : Ʈ���� ������ Ȱ���� Ǯ�� 
// https://leveloper.tistory.com/99
// ����Ž���� �̿��� Ǯ�� (�ð����⵵ : O(NM) --> O(M*logN))
public class KakaoBlindTest01_ver2 {
	
	public static int[] binarySearch(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		// 1. ���� word�� '����'�� ���ؼ� ���� ����Ʈ(Ȥ�� �迭)�� ����� �ܾ ����ְ�, �������� ���� 
		// �ε��� : ������ ���� (���� �ܾ��� �ִ� ���� =10000)
		List[] arrange_words = new ArrayList[10001]; 
		List[] reversed_words = new ArrayList[10001];
		
		for(int i=0; i<10001; i++) {
			arrange_words[i] = new ArrayList();
			reversed_words[i] = new ArrayList();
		}
		
		for(String w : words) {
//			System.out.println(w+", "+w.length());
			arrange_words[w.length()].add(w);
			reversed_words[w.length()].add(new StringBuffer(w).reverse().toString());
		}
		
		// 2. ����
		for(int i=0; i<10001; i++) {
			Collections.sort(arrange_words[i]);
			Collections.sort(reversed_words[i]);
		}
		
		// 3. ����Ž�� �����Ѵ�. 
		for(int i=0; i<queries.length; i++) {
			int len = queries[i].length();
			if(queries[i].charAt(0)=='?') {
				String reverseq = new StringBuffer(queries[i]).reverse().toString();
				int cnt = count_by_array(reverseq, reversed_words[len]);
				answer[i]+=cnt;
			}else if(queries[i].charAt(queries[i].length()-1)=='?') {
				int cnt = count_by_array(queries[i], arrange_words[len]);
				answer[i]+=cnt;
			}
		}
		return answer;
		
	}
	static int count_by_array(String query, List words) {
		int cnt=0;
		for(Object w : words) {
			String word = (String)w;
			if(word.compareTo(query.replace("?", "a"))>0 && 
					word.compareTo(query.replace("?", "z"))<0) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] answer = new int[queries.length];
		answer = binarySearch(words, queries);
		System.out.println(Arrays.toString(answer));
	}
}
