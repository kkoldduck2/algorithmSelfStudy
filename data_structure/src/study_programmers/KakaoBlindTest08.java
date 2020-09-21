package study_programmers;
// https://programmers.co.kr/learn/courses/30/lessons/60063
// �̷� ã�� �����ε� ��ĭ�� �����ϴ� ���
/* �̷� ã�� : ���� ���� �ִ� ��ġ���� �������������� �濡 �ִ� ��� 
 * 1) ���� ���� �ִ� ��ġ�� ������ �ų�
 * 2) �̵� or ȸ�������� ���������� ���� ���̰ų�
 * */

class Robot{
	int x1=0;
	int y1=0;
	int x2=0;
	int y2=1;
	
	// 1�̸� ����, 0�̸� ���η� ���� ����
	public int state() {
		if(this.x1==this.x2) {
			return 0;
		}else{
			return 1;
		}
	}
}
public class KakaoBlindTest08 {
	public static boolean recursion(int[][] board, int time, Robot rb) {
        int n = board.length;
        // basecase (success) : ���� ��ġ�� ������ (n-1,n-1)
        if((rb.x1==n-1 && rb.y1==n-1)||(rb.x2==n-1 && rb.y2==n-1)) {
        	return true;
        }
        // basecase(fail) : ���� ��ġ�� ���� ��  or ��
        if(rb.x1>n-1 || rb.x1<0||rb.x2>n-1 || rb.x2<0||rb.y1>n-1 || rb.y1<0||rb.y2>n-1 || rb.y2<0 ||
        		board[rb.x1][rb.y1]==1 || board[rb.x1][rb.y1]==1) {
        	return false;
        }
        //recur : �̵�. ȸ���ÿ��� recur ���� ���� �̵��������� �밢�� ���� üũ 
        
        if(solution(�̵��� ��ǥ)) {
        	return true;
        }
	}
	public static int solution(int[][] board) {
        int answer = 0;
        Robot rb = new Robot();
        recursion(board, 0,rb);
        return answer;
    }
	public static void main(String[] args) {
		int [][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},
				{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		System.out.println(solution(board));
	}
}
