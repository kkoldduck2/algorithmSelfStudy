package study_programmers;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/17681
public class KakaoBlindTest03 {
	public static String makingBinaryNum(int num, int n) {
		char[] bn = new char[n];  // 0*n 으로 초기화
		for(int i=0; i<n; i++) {
			bn[i] = '0';
		}
		while(num>=1) {
			--n;
			int q = num/2;
			int r = num%2;
			bn[n] = (char) (r+'0');
			num = q;
		}
		String binaryNum = String.valueOf(bn);
		return binaryNum;
	}
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for(int i=0; i<arr1.length; i++) {
        	String s1 = makingBinaryNum(arr1[i], n);
        	String s2 = makingBinaryNum(arr2[i], n);
        	answer[i] ="";
        	for(int k=0; k<s1.length(); k++) {
        		if(s1.charAt(k)=='1' || s2.charAt(k)=='1') {
        			answer[i]+="#";
        		}else if(s1.charAt(k)=='0' && s2.charAt(k)=='0' ) {
        			answer[i]+=" ";
        		}
        	}
        }
        return answer;
    }
	
	public static String[] bitOperation(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
        	String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
        	temp = String.format("%"+n+"s", temp); 	// n자리 중에서 빈칸은 0으로 채워준다.
        	temp = temp.replaceAll("1", "#");
        	temp = temp.replaceAll("0", " ");
        	answer[i] =temp;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		String[] answer = bitOperation(n, arr1, arr2);
		System.out.println(Arrays.toString(answer));
		
	}
}
