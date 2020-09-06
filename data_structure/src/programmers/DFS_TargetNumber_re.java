package programmers;

import java.util.LinkedList;
import java.util.Queue;

class solutionA{
	
	// solutionR()�� ��ȯ �� -> (int) ����� ��  
	public int solutionR(int[] numbers, int target,int start) {	// !queue �Ű����� ����!
		// <���� ����>
		if(start>numbers.length-1) {
			if(target==0) {
				return 1;
			}else {
				return 0;
			}
			
		}
		
    	// <�ݺ� ����>	: target + nums   && target - nums
		// 			=> ������ ��쿡 ���ؼ� branch�� �� ������.
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
		System.out.println("���??"+answer);
	}
}
