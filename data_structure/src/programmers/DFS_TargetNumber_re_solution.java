package programmers;

class SolutionREAL {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) 
        		+ dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
public class DFS_TargetNumber_re_solution {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		SolutionREAL s = new SolutionREAL();
		int answer=s.solution(numbers, target);
		System.out.println("°á°ú??"+answer);
	}
}
