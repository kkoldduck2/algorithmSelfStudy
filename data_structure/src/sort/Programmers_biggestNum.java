package sort;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_biggestNum {
	public static String solution(int[] numbers) {
		String answer = "";
		String[] transStr = new String[numbers.length];
		int i=0;
		for(int num : numbers) {
			transStr[i++]=Integer.toString(num);
		}
		Arrays.sort(transStr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String op1 = o1+o2;
				String op2 = o2+o1;
				return op1.compareTo(op2)*-1;
				
				// 이 풀이는 왜 안되지...
				/*반례: 34 와 345, 343 비교
				 * 34, 345 -> '345''34'
				 * 34, 343 -> '34''343'
				 * */
//				if(o2.startsWith(o1)) {
//					if(o2.charAt(o1.length())>= o1.charAt(o1.length()-1) {	//o2: 34, o1 :3
//						return 1;		
//					}else {			// o2: 31, o1:3
//						return -1;
//					}
//				}else if(o1.startsWith(o2)) {
//					if(o1.charAt(o2.length())>= o2.charAt(o2.length()-1)) {	//o1: 34, o2 :3
//						return -1;		
//					}else {
//						return 1;
//					}
//				}
//				return o1.compareTo(o2)*-1;
			}
			
		});
		
		for(String str : transStr) {
			answer+=str;
		}
		if(answer.charAt(0)=='0') {
			return "0";
		}else {
			return answer;
		}
		
	}
	
	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
		int[] numbers2 = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers));
	}
}
