package study_programmers;
// https://programmers.co.kr/learn/courses/30/lessons/60063
// 미로 찾기 문제인데 두칸을 차지하는 경우
/* 미로 찾기 : 내가 현재 있는 위치에서 목적지까지가는 길에 있는 경우 
 * 1) 내가 현재 있는 위치가 도착지 거나
 * 2) 이동 or 회전했을때 목적지까지 가는 길이거나
 * */

class Robot{
	int x1=0;
	int y1=0;
	int x2=0;
	int y2=1;
	
	// 1이면 세로, 0이면 가로로 놓인 상태
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
        // basecase (success) : 현재 위치가 도착지 (n-1,n-1)
        if((rb.x1==n-1 && rb.y1==n-1)||(rb.x2==n-1 && rb.y2==n-1)) {
        	return true;
        }
        // basecase(fail) : 현재 위치가 지도 밖  or 벽
        if(rb.x1>n-1 || rb.x1<0||rb.x2>n-1 || rb.x2<0||rb.y1>n-1 || rb.y1<0||rb.y2>n-1 || rb.y2<0 ||
        		board[rb.x1][rb.y1]==1 || board[rb.x1][rb.y1]==1) {
        	return false;
        }
        //recur : 이동. 회전시에는 recur 들어가기 전에 이동방향으로 대각선 방향 체크 
        
        if(solution(이동후 좌표)) {
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
