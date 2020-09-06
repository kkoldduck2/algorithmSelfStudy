package sort;

import java.util.Arrays;
import java.util.Comparator;

// 1) ���� �տ� �ִ� ���ڰ� Ŭ���� ������ �´�
// 2) ���� �տ� �ִ� ���ڰ� ���� ���
// �״��� �ڸ� ���ڸ� ���ؼ� ū ���ڰ� ������ �´�
// �״��� �ڸ� ���ڰ� ���� ��� 
// ex) 3, 31 -> 313 <331�̹Ƿ�  3�� �տ� �´�
//     3, 340 -> 3403 > 3340 �̹Ƿ� 340�� �տ� �´�
//     33  330 -> 33033 < 33330 -> 33�� �տ��´�
// ���� 3�� 3__ �� ���� ���� -> 333�� 3__�� ���Ѵٰ� �����Ѵ�

public class Programmers_sort_biggestNumber {
	
	// main �Լ��� static�̾ �̰ŵ� static �̾���� ��?? 
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
        System.out.println("1�� ���� : "+Arrays.toString(strNums));
        
        // hashMap���� �ð� ���⵵�� �ٿ�����..
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
