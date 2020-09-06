package study_programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42839
/* 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
 * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.*/
public class BruteForce_Find_PrimeNum {
	static String[] number;
	static boolean[] check;
	static StringBuilder sb;
	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<String> select = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numbers = sc.next();
		number = numbers.split("");
		check = new boolean[number.length];
		
		
		for(int i=0; i<check.length; i++) {
			check[i] = false;
		}
		
		// 모든 조합구하기 -> select에 저장
		makecomb(0,0,0);
		
		// select에 대해서 순열 시작 
		for(int i=0; i< select.size(); i++) {
			String[] selected = select.get(i).split("");
			perm(selected,0);

		}
		System.out.println(arr.size());
	}
	
	// k-1 번째 까지는 정해짐 
	static void makecomb(int k, int dept, int checkcount) {
		if(dept==number.length) {
			sb = new StringBuilder();
			// check된 숫자 -> sb에 쭉 이어서 하나의 문자열로 만든뒤 select에 저장
			for(int i=0; i<number.length; i++) {
				if(check[i]==true) {
					sb.append(number[i]);
				}
			}
			
			if(!select.contains(sb.toString()) && !sb.toString().equals("")) {
				select.add(sb.toString());
			}

			return;
		}
		
		// k를 선택함
		check[k] = true;
		makecomb(k+1, dept+1, checkcount+1);
		
		// k를 선택 안함 
		check[k] = false;
		makecomb(k+1, dept+1, checkcount);
		
		
	}
	
	// 순열 : k-1 번째까지 순서 정해진 상황
	static void perm(String[] select, int k) {
		
		// 모든 순서가 다 정해짐 -> 그 숫자가 prime 인지 확인 -> 맞으면 이미 있는 숫자인지 확인하고 count++
		if(k==select.length-1) {
			sb = new StringBuilder();
			for(String s : select) {
				sb.append(s);
			}
			
			int makeNum = Integer.parseInt(sb.toString());
			if(isPrime(makeNum) && !arr.contains(makeNum) && makeNum!=0 && makeNum!=1) {
				arr.add(makeNum);
			}
			
			return;
		}
		
		for(int i=k; i<select.length; i++) {
			swap(select,k, i);
			perm(select, k+1);
			swap(select,k, i);
		}
		
		
	}
	
	// prime인지 확인하는 함수 
	static boolean isPrime(int num) {
		int primeCount=0;
		for(int i=2; i<num; i++) {
			if(num%i==0) {
				primeCount++;
			}
		}
		
		if(primeCount==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	static void swap(String[] select,int a, int b) {
		String temp = select[a];
		select[a] = select[b];
		select[b] = temp;
	}
	
}
