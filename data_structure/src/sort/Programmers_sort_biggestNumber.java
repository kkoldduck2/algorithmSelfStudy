package sort;

import java.util.Arrays;
import java.util.Comparator;

// 1) 가장 앞에 있는 숫자가 클수록 앞으로 온다
// 2) 가장 앞에 있는 숫자가 같을 경우
// 그다음 자리 숫자를 비교해서 큰 숫자가 앞으로 온다
// 그다음 자리 숫자가 없을 경우 
// ex) 3, 31 -> 313 <331이므로  3이 앞에 온다
//     3, 340 -> 3403 > 3340 이므로 340이 앞에 온다
//     33  330 -> 33033 < 33330 -> 33이 앞에온다
// 따라서 3과 3__ 을 비교할 때는 -> 333과 3__를 비교한다고 생각한다

public class Programmers_sort_biggestNumber {
	
	// main 함수가 static이어서 이거도 static 이어야함 왜?? 
	public static String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        
		String[] strNums = new String[numbers.length];
		for(int i=0; i<numbers.length; i++) {
			strNums[i]= Integer.toString(numbers[i]);
		}
        
        Arrays.sort(strNums,Comparator.reverseOrder()); 
        System.out.println("1차 정렬 : "+Arrays.toString(strNums));
        
        // hashMap으로 시간 복잡도를 줄여보자..
        for(int i=0; i<strNums.length-1; i++) {	
        	for(int j=i+1; j<strNums.length; j++) {
        		if(strNums[i].startsWith(strNums[j])) {
        			String s1=strNums[i]+strNums[j];
        			String s2=strNums[j]+strNums[i];
        			if(Integer.parseInt(s1)<Integer.parseInt(s2)) {
        				String temp =strNums[i];
        				strNums[i]= strNums[j];
        				strNums[j]= temp;
        			} 

        		}
        	}
        }
        
        for(int i=0; i<strNums.length; i++){
            sb3.append(strNums[i]);
        	
        }
        answer=sb3.toString();
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		int numbers[] = {3, 30, 34, 5, 9};
		
        System.out.println(solution(numbers));
	}
}
