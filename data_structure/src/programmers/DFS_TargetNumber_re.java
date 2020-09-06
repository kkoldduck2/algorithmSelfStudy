package programmers;

import java.util.LinkedList;
import java.util.Queue;

class solutionA{
	
	// solutionR()의 반환 값 -> (int) 경우의 수  
	public int solutionR(int[] numbers, int target,int start) {	// !queue 매개변수 주의!
		// <종료 조건>
		if(start>numbers.length-1) {
			if(target==0) {
				return 1;
			}else {
				return 0;
			}
			
		}
		
    	// <반복 형태>	: target + nums   && target - nums
		// 			=> 각각의 경우에 대해서 branch가 또 나뉜다.
		else {
			return solutionR(numbers,target+numbers[start],start+1)
					+ solutionR(numbers,target-numbers[start],start+1);
		}
		
	}
	
	public int solution(int[] numbers, int target) {
        int answer = 0;
		answer = solutionR(numbers, target,0);
        return answer;
    }
}


public class DFS_TargetNumber_re {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		solutionA s = new solutionA();
		int answer=s.solution(numbers, target);
		System.out.println("결과??"+answer);
	}
}
