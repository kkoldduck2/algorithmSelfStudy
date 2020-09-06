package study_programmers;

import java.util.*;


public class KakaoBlindTest02_ver2 {
	static Coordinate[][] check;
	static class Coordinate{
		int x;
		int y;
		String a;
		List<String> starts ;
		List<String> ends;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
			this.starts = new LinkedList<>();
			this.ends  = new LinkedList<>(); 
		}
		
		// x, y�� ���������� �ϴ� ������ ��ȯ 
		public List<String> findByStart(int x, int y) {
			return this.starts;
		}
		
		// x, y�� �������� �ϴ� ������ ��ȯ
		public List<String> findByEnd(int x, int y) {
			return this.ends;
		}
		
		public void setCoor(int x, int y,String a) {
			this.x = x;
			this.y = y;
			this.a = a;
			this.starts.add(a);
			if(a.equals("0")) {
//				System.out.println(x+", "+y);
				check[x][y+1].ends.add(a);
			}else if(a.equals("1")) {
				check[x+1][y].ends.add(a);
			}
		}
		
		public void delete(int x, int y, String a) {
			this.starts.remove(a);
			this.a ="-1";
			if(a.equals("0") && !check[x][y+1].ends.isEmpty()) {
				check[x][y+1].findByEnd(x,y+1).remove(a);
			}else if(a.equals("1") && !check[x+1][y].ends.isEmpty()) {
				check[x+1][y].findByEnd(x+1,y).remove(a);
			}
			
		}
	}
	
	public static boolean isPossible(int x, int y, String a) {
		// ��ġ
		/* ��� : �ٴ� ��, �� ���� �� ��, �ٸ� ��� ��
		 * �� : ���� �� ��� ��, ���� �� �� 
		 * */
		if(a.equals("0")) {// ���
			if(y==0) {
				return true;
			}else if(!check[x][y].findByStart(x,y).isEmpty() || !check[x][y].findByEnd(x,y).isEmpty()) {
				return true;
			}
		}else if(a.equals("1")){	//��
			if(check[x][y].findByEnd(x,y).contains("0") ||check[x+1][y].findByEnd(x+1,y).contains("0")) {
				return true;
			}
			if(check[x][y].findByEnd(x,y).contains("1") && check[x+1][y].findByStart(x+1, y).contains("1")) {
				return true;
			}
		}
		return false;
	}
	
	
	public static int[][] solution(int n, int[][] bf) {
		
		check = new Coordinate[n+1][n+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				check[i][j] = new Coordinate(i,j);
			}
		}
		
		for(int i=0; i<bf.length; i++) {
			int x = bf[i][0];
			int y = bf[i][1];
			String a = Integer.toString(bf[i][2]); 	// �� ==1 or ���==0
			int b = bf[i][3];   // ��ġ or ����
			
			if(b==1) {  // ��ġ
				if(isPossible(x,y,a)) {
//					System.out.println(x+", "+y+", "+a);
					check[x][y].setCoor(x, y, a);
				}
			}else if(b==0){// ����
				// �� ����
				check[x][y].delete(x, y, a);
				// x, y�� ���� or �����������ϴ� ��� �������� ���ؼ� isPossible �˻�
				for(String ae : check[x][y].starts) {
					if(!isPossible(x,y,ae)) {
						check[x][y].setCoor(x, y, a);
					}
				}
				for(String ae : check[x][y].ends) {
					if(!isPossible(x,y,ae)) {
						check[x][y].setCoor(x, y, a);
					}
				}
				// ��� : (x,y+1)�� ������ or ����
				if(a.equals("0")) {
					for(String ae : check[x][y+1].starts) {
						if(!isPossible(x,y+1,ae)) {
							check[x][y].setCoor(x, y, a);
						}
					}
					for(String ae : check[x][y+1].ends) {
						if(!isPossible(x,y+1,ae)) {
							check[x][y].setCoor(x, y, a);
						}
					}
				}else if(a.equals("1")) {	// �� : (x+1,y)�� ������ or ����
					for(String ae : check[x+1][y].starts) {
						if(!isPossible(x+1,y,ae)) {
							check[x][y].setCoor(x, y, a);
						}
					}
					for(String ae : check[x+1][y].ends) {
						if(!isPossible(x+1,y,ae)) {
							check[x][y].setCoor(x, y, a);
						}
					}
				}
			}
		}
		List<Coordinate> answerli = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(!check[i][j].starts.isEmpty()) {
					answerli.add(check[i][j]);
				}
			}
		}
		int[][] answer = new int[answerli.size()][3];
		int t =0;
		for(Coordinate c : answerli) {
			answer[t][0] = c.x;
			answer[t][1] = c.y;
			answer[t][2] = Integer.parseInt(c.a);
			t++;
		}
		return answer;
	}
	public static void main(String[] args) {
		int n=5;
		int[][] bf = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		
		int n2 =5;
		int[][] bf2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},
				{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1, 1, 1, 0},{2, 2, 0, 1}
				};
		
		int[][] answer = solution(n, bf);
		System.out.println();
//		solution(n2, bf2);
	}
}
