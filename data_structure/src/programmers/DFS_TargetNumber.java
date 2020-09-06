package programmers;

/*DFS�� �� �̾ Ž���ϱ� ������ ���� ��͸� ����Ͽ� �����մϴ�. 
 * �̸� �����ϱ� ���ؼ��� '���� ����'�� '��ͷ� ȣ���� ����'�� �����ؾ� �մϴ�.

�� ���������� numbers ����Ʈ���� ������� ���� �ҷ��� �Ʒ��� ���� �� ������ �����ؾ� �մϴ�.

	1. target �� a
	2. (target �� a) �� b �� A �� b
	3. (A �� b) �� c �� B �� c
	
	���� ��͵Ǵ� ���� X �� Y �� �����̸�, 
	X�� target���� ��� ����Ǿ� �� ���̰�
	Y�� numbers���� �ϳ��� �̾Ƽ� ������ ���Դϴ�. 
	�̴� �� solution�� ���ڿ� �����Ǿ� �� �� �ֽ��ϴ�. 
	solution(Y, X)�� ������ ���Դϴ�.
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
    	
    	// ����� <��������>�� numbers�� ���� �������� �ʴ� ���(if not numbers)�Դϴ�. 
        // ���� ���갪�� 0�̸� ����� ���� ������ ���̹Ƿ� 1��, 
        if(numbers.length==0 && target==0) {
        	return 1;		// ������ -> ����� �� +1
        }
        // �׷��� �ʴٸ� 0�� �����մϴ�.
        else if(numbers.length==0) {
        	return 0;
        }
        
        // ó�� ������ ���۵Ǵ� ���� target �� a �̹Ƿ�, �� �ѷ� ����� ȣ���� �����մϴ�. 
        // �� �ѷ� ������� '����� ��'�� ���������� ��� �ջ�Ǿ�� �ϹǷ� +�� �����մϴ�. 
        // �׸��� �� �������� numbers���� ���� ���� �� ���� �ε����� ��� �̾����� �ϹǷ�, �Ʒ��� ���� ǥ���� �� �ֽ��ϴ�.
        
        return solutionR(numbers, target+numbers[index], index++) 
        		+ solutionR(numbers, target-numbers[index],index++);
    }
}


public class DFS_TargetNumber {
	public static void main(String[] args) {
		
	}
}
