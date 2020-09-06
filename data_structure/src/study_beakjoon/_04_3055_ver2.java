package study_beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// °í½¿µµÄ¡°¡ ¾ÈÀüÇÏ°Ô ºñ¹öÀÇ ±¼·Î ÀÌµ¿ÇÏ±â À§ÇØ ÇÊ¿äÇÑ 'ÃÖ¼Ò ½Ã°£'À» ±¸ÇÏ´Â ÇÁ·Î±×·¥À» ÀÛ¼ºÇÏ½Ã¿À.
// ÃÖ¼Ò½Ã°£ -> ±×·¡ÇÁ¿¡¼­ bfs·Î Ç¬´Ù 
// »óÅÂ ¿¬°áÇÏ´Â °£¼±ÀÇ °¡ÁßÄ¡°¡ ¸ðµÎ 1ÀÏ °æ¿ì 
// BFS´Â ÃÖ´Ü °æ·Î¸¦ ±¸ÇÏ´Â ¾Ë°í¸®ÁòÀÌ µÈ´Ù! ±×·¡¼­ bfs·Î Ç¬´Ù 

// ´Ù¸¥ »ç¶÷ Ç®ÀÌ º¸°í °øºÎ! BFS ¹®Á¦ 
// https://www.acmicpc.net/problem/3055

class Pair{ //¹°¿¡ ´ëÇÑ Á¤º¸¸¦ ³ÖÀ» ¶§µµ ¾²°í, BFS¶§µµ ¾²°í.. ¿ëÀÌÇÔ.
	int x, y;
	
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class _04_3055_ver2 {
	
	static final int[] dx = {1, -1, 0, 0}; // ÀÌ°Ç Á¤¸» ±×³É ÇÊ¼ö »ó¼ö..
	static final int[] dy = {0, 0, 1, -1};
	
	// ¹°¿¡ ´ëÇÑ bfs
	static void bfsW(int[][] water, Queue<Pair> q, int n, int m) {
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;	// ÇöÀç ¹°ÀÇ À§Ä¡
			
			// ¹°ÀÌ °¥ ¼öÀÖ´Â °÷ bfs	ÁÂ,¿ì,À§,¾Æ·¡
			for(int k=0; k<4; k++) {
				int nx = x +dx[k];
				int ny = y + dy[k];
				// map ¹üÀ§ ¾È¿¡ ÀÖ¾î¾ßÇÔ ¿À·ù ¾È³ª·Á¸é
				if(nx >=0 && nx<n && ny>=0 && ny<m) {
					if(water[nx][ny] ==0) {	// -1 : ¹ÙÀ§ÀÖ¾î¼­ ¸øÁö³ª°¨,  1: ÀÌ¹Ì Áö³ª°¨ , 0: °¥¼ö ÀÖ´Â °÷
						water[nx][ny] =water[x][y] + 1;	// ¾Æ ¸î ÃÊµÚ¿¡ ¹°ÀÌ Â÷´ÂÁö ±â·ÏÇØµÎ´Â °Í.  water[x][y]°¡ xÃÊ¿¡ Âù´Ù¸é . water[nx][ny]´Â x+1ÃÊ¿¡ Âù´Ù. 
						q.add(new Pair(nx, ny));
					}
				}
			}
			
		}
	}
	
	//¹° bfsÇØÁÖ°í µµÄ¡µµ bfs
	static void bfsD(int[][] water, int[][] dochi, int dI, int dJ, int n, int m) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(dI, dJ));		// ÇöÀç µµÄ¡ À§Ä¡
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (dochi[nx][ny] == 0) {//µµÄ¡°¡ ¾È Áö³ª°¨
						if ((dochi[x][y] + 1) < water[nx][ny] || water[nx][ny] == 0) {//¹°ÀÌ ¾È Áö³ª°¬°Å³ª ¹°º¸´Ù ÀÛÀ» ¶§.. ±×·¡¼­ ¹° Àº n*m+1³Ö¾îÁÜ
							dochi[nx][ny] = dochi[x][y] + 1;
							q.add(new Pair(nx, ny));
						}
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Queue<Pair> qwater = new LinkedList<Pair>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[n][m];	// ÀÌ°Å mapÀÎ°¡?
		int[][] water = new int[n][m];
		int[][] dochi = new int[n][m];  // °í½¿µµ¯ƒ¤»¤»¤»
		int dI =0, dJ =0, bI=0, bJ=0; 	//µµÄ¡ i,j ºñ¹ö±¼ i,j
		int k=0;
		
		for(int i=0; i<n; i++) {
			String s = sc.nextLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='S') {
					dI = i;
					dJ = j;
					dochi[i][j] = 1;	//µµÄ¡ À§Ä¡ 1
				}
				if (map[i][j] == 'D') {
					bI = i;
					bJ = j;			// ºñ¹ö±¼ À§Ä¡ 
					water[i][j] = n*m+1; //¿¡¼­ water´Â n*m+1ÀÎ°Ô Æ÷ÀÎÆ®.. n*mÀÌ¾ú´Ù°¡ ½Ç¼ö³ª
				}
				if(map[i][j]=='*') {
					qwater.add(new Pair(i,j)); // ¹°ÀÇ À§Ä¡¸¦ Å¥¿¡ ³Ö¾îÁÜ
					water[i][j] = 1;
				}
				if(map[i][j]=='X') {	// °í½¿µµÄ¡¿Í ¹° ¸ðµÎ ¸ø°¡´Â °÷
					dochi[i][j] = -1;
					water[i][j] = -1;
				}
			}
		}
		
		bfsW(water, qwater, n, m); // Å¥¿öÅÍ¿Í ÇÔ²² bfs·Î ½¹
		bfsD(water, dochi, dI, dJ, n, m);	// µµÄ¡ bfs
		
		if(dochi[bI][bJ] !=0) {
			System.out.println(dochi[bI][bJ] - 1);// µµÄ¡ Ã·¿¡ À§Ä¡ 1 ÇØÁáÀ¸´Ï±î -1
		}
		else
			System.out.println("KAKTUS"); //Ä´ÅÍ½º
	}
}
