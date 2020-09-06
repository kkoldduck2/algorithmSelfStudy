package sort;

import java.util.*;


public class CoordinateSort_beakjoon11650 {
	static class Coor{
		int x;
		int y;
		
		public Coor(int x, int y){
			this.x =x;
			this.y =y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Coor[] coors = new Coor[n];
		
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			coors[i] = new Coor(x, y);
		}
		
		Arrays.sort(coors, new Comparator<Coor>() {
			public int compare(Coor c1, Coor c2) {
				if(c1.x > c2.x) {
					return 1;
				}
				else if(c1.x == c2.x) {
					return Integer.compare(c1.y, c2.y);
				}else {
					return -1;
				}
			}
		});
		
		for(int i=0; i<n; i++) {
			System.out.println(coors[i].x+" "+coors[i].y);
		}
		
	}
}
