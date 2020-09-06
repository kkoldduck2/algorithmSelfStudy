package study_programmers;

import java.util.HashMap;
import java.util.Scanner;
// https://programmers.co.kr/learn/courses/30/lessons/42895
// N은 1이상 9이하
// number는 1 이상 32,000 이하
// 놀랍게도 방향은 맞음. 구현하다가 뭔가 빼먹은 부분이 있을것이다. 
public class DP_ExpressN_42895 {
	static final  HashMap<Integer, Integer> k = new HashMap<>();
	static int N;
	static int number;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("N을 입력하세요");
		N = sc.nextInt();
		
		System.out.println("number를 입력하세요 ");
		number = sc.nextInt();
		int[] d = new int[number*number];		// d[i] : N을 사용해서 i를 만든 최소 횟수
		
		// 초기화 : 전부 (N/N) 1로 만들어서 더한다고 생각할 때 
		for(int i=0; i<number*number; i++) {
			d[i] = i*2;
		}
		
		// 가능한 K 경우 HashMap에 담기 
		k.put(N, 1);
		int temp = N;
		insertK(temp, 2);
		/* d[num] = + k : d[num-k] + k를 만들기 위해 사용한 N 횟수 
		 * 		  = - k : d[num+k] 
		 * 		  = * k : d[num/k] 
		 * 		  = / k : d[num*k] 
		 * 1<= k < num, N으로 만들 수 있는 모든 숫자 
		 * d[num] > 8 이면 -1을 리턴한다. 
		 * */
//		System.out.println("keySet을 알아보자 ");
//		for(int key : k.keySet()) {
//			System.out.println("key : "+key+", "+"value : "+k.get(key));
//		}
		
		
		
		
		
		if(d[number]>8) {
			System.out.println(-1);
		}else {
			System.out.println(d[number]);
		}

		
	}
	
	
	/* 가능한 K의 경우
	 * N을
	 * 1번 사용 : N     1개
	 * 2번 사용 : N/N, N+N, N*10+N (=NN), N-N (0이라 무쓸모, 없앰)		// 4개
	 * 3번 사용 : 2번 사용에   +N , -N, *10+N (=NNN), /N, *N			// 5개
	 * 4번 사용 : 3번 사용에  ... 										// 5개
	 * 8번 사용 : 
	 * */
	static void insertK(int temp, int cnt) {
		if(temp <=0 || cnt > 8 || temp > number*number) {
			return;
		}
		
		// 나누기
		if(temp/N >0 &&!k.containsKey(temp/N)) {
			 k.put(temp/N, cnt);
			 insertK(temp/N,cnt++);
		}
		// 더하기
		if(!k.containsKey(temp+N)) {
			 k.put(temp+N, cnt);
			 insertK(temp+N,cnt++);
		}
		// 빼기 
		if(temp-N>0 && !k.containsKey(temp-N)) {
			 k.put(temp-N, cnt);
			 insertK(temp-N,cnt++);
		}
		
		// 곱하기 
		if(temp*N < number*3 && !k.containsKey(temp*N)) {
			 k.put(temp*N, cnt);
			 insertK(temp*N,cnt++);
		}
		
		// 
		if(temp*10+N < number*3 && !k.containsKey(temp*10+N)) {
			 k.put(temp*10+N, cnt);
			 insertK(temp*10+N,cnt++); 
		}
		
	}
}
