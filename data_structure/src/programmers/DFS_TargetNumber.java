package programmers;

/*DFS는 쭉 이어서 탐색하기 때문에 흔히 재귀를 사용하여 구현합니다. 
 * 이를 구현하기 위해서는 '종료 조건'과 '재귀로 호출할 형태'를 구성해야 합니다.

이 문제에서는 numbers 리스트에서 순서대로 값을 불러와 아래와 같이 ± 연산을 수행해야 합니다.

	1. target ± a
	2. (target ± a) ± b → A ± b
	3. (A ± b) ± c → B ± c
	
	따라서 재귀되는 식은 X ± Y 의 형태이며, 
	X는 target부터 계속 연산되어 온 값이고
	Y는 numbers에서 하나씩 뽑아서 연산할 값입니다. 
	이는 곧 solution의 인자에 대응되어 들어갈 수 있습니다. 
	solution(Y, X)의 형태인 셈입니다.
 * 
 * 
 * 
 * */
class SolutionTN {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = solutionR(numbers, target, 0);
        return answer;
    }
    
    public int solutionR(int[] numbers, int target, int index) {
    	
    	// 재귀의 <종료조건>은 numbers에 값이 존재하지 않는 경우(if not numbers)입니다. 
        // 최종 연산값이 0이면 경우의 수를 만족한 것이므로 1을, 
        if(numbers.length==0 && target==0) {
        	return 1;		// 만족함 -> 경우의 수 +1
        }
        // 그렇지 않다면 0을 리턴합니다.
        else if(numbers.length==0) {
        	return 0;
        }
        
        // 처음 연산이 시작되는 값은 target ± a 이므로, 이 둘로 재귀의 호출을 시작합니다. 
        // 이 둘로 뻗어나가는 '경우의 수'는 최종적으로 모두 합산되어야 하므로 +로 연결합니다. 
        // 그리고 그 다음으로 numbers에서 뽑힐 값은 그 다음 인덱스로 계속 이어져야 하므로, 아래와 같이 표현할 수 있습니다.
        
        return solutionR(numbers, target+numbers[index], index++) 
        		+ solutionR(numbers, target-numbers[index],index++);
    }
}


public class DFS_TargetNumber {
	public static void main(String[] args) {
		
	}
}
