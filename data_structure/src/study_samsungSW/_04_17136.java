package study_samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17136
// https://lshdv.tistory.com/81      <- �ؼ� 1 (����Ž��)
// https://sophia2730.tistory.com/entry/Algorithm-%EB%B0%B1%EC%A4%8017136-%EC%83%89%EC%A2%85%EC%9D%B4-%EB%B6%99%EC%9D%B4%EA%B8%B0
// <- �ؼ�2 (��Ʈ��ŷ)
// ��Ž�� �Ϸ��� 1x1�� �����̸� ���̰� ��� ��츦 �� �� ����, �ٽ� ���ƿͼ� 2x2�� �����̸� ���̴� ������� �ٿ��� �߱� ������, dfs�� ���� Ǯ����.
public class _04_17136 {
	public static StringTokenizer stk;
    public static StringBuilder sb = new StringBuilder();
    public static int[] paper = {0, 5, 5, 5, 5, 5};
    public static int[][] map = new int[10][10];
    public static int ans = Integer.MAX_VALUE, one_cnt = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                one_cnt += map[i][j];       //1�� ���� ����
            }
        }
        
      //r = ���� row, cnt = ����� �����̼�, total = ������ 1�� ���� (���� 1�� ����)
        Backtracking(0, 0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	
	public static void Backtracking(int r, int cnt, int total) {
        if (ans <= cnt) return;      // ���� ������ �����̸� ���̾��� ����ġ�� (����� �� ����)
        if (total == one_cnt) {      // 1�� �� ���� ��� (������ ���)
            ans = Math.min(ans, cnt);
            return;
        }
        
        for (int i = r; i < 10; i++) {     // r(���� ��) ���� ����
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) {
                    boolean flag = false;  //ū �����̷� ���� �� ������ ���� �����̴� Ȯ���� ���� �ʾƵ� �ȴ�
                    for (int k = 5; k >= 1; k--) {	// 5*5 ���̺��� 1*1 ���̱��� �˻� 
                        if ((i + k) <= 10 && (j + k) <= 10 && paper[k] > 0) {
                            if (!flag) {		// flag == false
                                flag = check(i, j, k); //k*k �����̸� ���� �� ������ check = true
                            }
                            if (flag) {			// flag == true
                                setVisited(i, j, k);
                                paper[k]--;
                                Backtracking(i, cnt + 1, total + k * k);
                                
                                //��Ʈ��ŷ : Ž���� �� �Ŀ� �ٽ� ���� Ž���ϱ� �������� �ǵ���
                                paper[k]++;
                                setVisited(i, j, k);
                            }
                        }
                    }
                    if (!flag) return;          //�����̸� ������ ���
                }
                if (map[i][j] == 1) return;     //�������� �ش���ǥ�� ������°��
            }
        }
    }
 
    //size��ŭ�� �����̸� ����� �� �ִ��� Ȯ��
    public static boolean check(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }
 
    //�湮�� ���� XOR ���� (������ 0 �ٸ��� 1)
    public static void setVisited(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = map[i][j] ^ 1;
            }
        }
    }
//    public static void fill(int r, int c, int size, int state) {
//        for(int i=0; i<size; i++) {
//            for(int j=0; j<size; j++) {
//                a[r+i][c+j] = state;
//            }
//        }
//    }
}
