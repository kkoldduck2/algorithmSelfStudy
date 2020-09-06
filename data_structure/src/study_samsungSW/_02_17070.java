package study_samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17070
// �ؼ�: https://zunoxi.tistory.com/9
// �׷������� �������� �̵���Ű�� ����� �� ���ϴ� ���� 
/*����������, dfs(���) �̿��ؼ� Ǫ�� ������*/
public class _02_17070 {
	static int cnt, N;
	static int[][] arr;
	static boolean [][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+2][N+2];
		
		// �׷����� �迭�� ��Ƶδ� �۾� : ��ĭ: 2, ��: 1, ������: 5, �׵θ�: 0
		for(int x=1; x<N+1; x++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for(int y=1; y<N+1; y++) {
				int c = Integer.parseInt(st.nextToken());
				if(c==0) {
					arr[x][y]=2;
				}
				else {
					arr[x][y] =c;
				}
			}
		}
		arr[1][1]=5; arr[1][2]=5; // ó�� ������ ����
		cnt=0;
		int x=1; int y=2;  // �������� ������ �� ��ġ (�ʱ�)
		dfs(x,y);
		System.out.println(cnt);
	}
	
	public static void dfs(int x, int y) {
		// ����!
		if(x==N && y==N) {
			cnt++;
			return;
		}
		else {
			if(arr[x][y-1]==5) { // �����϶� -> 2���� ��� ��
				if(arr[x][y+1]==2) { // ���η� �̵��� �� �ִ��� Ȯ��
					arr[x][y-1]=2;	// ���� �ٽ� ��ĭ�� ��
					arr[x][y+1]=5;	// �̵� �Ѱ��� 5�� ����
					dfs(x,y+1);
					arr[x][y-1]=5; arr[x][y+1]=2;	// �ǵ�������(���� ��츦 ����)
	
				}
				if(arr[x+1][y+1]==2 && arr[x][y+1]!=1 && arr[x+1][y]!=1) {	// �밢�� Ȯ��
					arr[x][y-1]=2;
					arr[x+1][y+1]=5;
					dfs(x+1,y+1);
					arr[x][y-1]=5; arr[x+1][y+1]=2;
				}
			}
			else if(arr[x-1][y]==5) {	//�����϶� -> ������ ��� 2����
				if(arr[x+1][y]==2) {	// ���� �̵����� ���� Ȯ��
					 arr[x-1][y]=2; arr[x+1][y]=5;
                     dfs(x+1,y);
                     arr[x-1][y]=5; arr[x+1][y]=2;
				}
				if(arr[x+1][y+1]==2 && arr[x][y+1]!=1 && arr[x+1][y]!=1) { // �밢�� Ȯ��
                    arr[x-1][y]=2; arr[x+1][y+1]=5;
                    dfs(x+1,y+1);
                    arr[x-1][y]=5; arr[x+1][y+1]=2;
                }
			}
			else if(arr[x-1][y-1]==5) {
                if(arr[x][y+1]==2) { // ����Ȯ��
                    arr[x-1][y-1]=2; arr[x][y+1]=5;
                    dfs(x,y+1);
                    arr[x-1][y-1]=5; arr[x][y+1]=2;
                }
                if(arr[x+1][y]==2) { // ����Ȯ��
                    arr[x-1][y-1]=2; arr[x+1][y]=5;
                    dfs(x+1,y);
                    arr[x-1][y-1]=5; arr[x+1][y]=2;
                }
                if(arr[x+1][y+1]==2 && arr[x][y+1]!=1 && arr[x+1][y]!=1) { // �밢�� Ȯ��
                    arr[x-1][y-1]=2; arr[x+1][y+1]=5;
                    dfs(x+1,y+1);
                    arr[x-1][y-1]=5; arr[x+1][y+1]=2;
                }
            }
		}
	}
}
