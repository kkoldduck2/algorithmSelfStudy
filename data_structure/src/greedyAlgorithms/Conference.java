package greedyAlgorithms;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1931

// https://ju-nam2.tistory.com/44			(해설 1)
// https://zoonvivor.tistory.com/52			(해설 2)
// https://code0xff.tistory.com/18    <- comparator에 대한 설명
public class Conference {
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
			 
		int n = sc.nextInt();// 회의 개수
		int [][] arr = new int[n][2]; // 회의 정보 
		
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt(); 	// 회의 시작 시간
			arr[i][1] = sc.nextInt();   // 회의 종료 시간 
		}
		
		
		// 배열 정렬 (회의실 순서를 정한다. 일찍 끝나는 회의가 앞에온다. )
		Arrays.sort(arr, new Comparator<int[]>() {
			// conference1과 conference 2 중 빨리 끝나는 거를 앞에 정렬할 것이다.
			// conference1[0] : conference1의 시작시간,   conference2[0] : conference2의 시작시간
			// conference1[1] : conference1의 끝나는 시간,   conference2[1] : conference2의 끝나는 시간 
			
			@Override
			public int compare(int[] conference1, int[] conference2) {
				// 만약 종료시간이 같을 경우, 시작 시간을 기준으로 정렬한다. 
				if(conference1[1]== conference2[1]) {
					return Integer.compare(conference1[0], conference2[0]);
				}
				// (기본적으로) 종료시간에 따라 정렬한다. 
				return Integer.compare(conference1[1], conference2[1]);
			}
			
			/*
			 * Integer.compare(int x, int y)
			 * x == y 일 경우 0 리턴
			 * x < y 일 경우 음수 리턴
			 * x > y 일 경우 양수 리턴
			 */			
		});
		
		int cnt =0;			// 최댓값 (ans)
		int endTime = -1; 	// 마지막 시간 
		for(int i=0; i<n ;i++) {
			
			// 마지막 시간보다 회의 시작 시간이 더 뒤에 있을 경우 -> 그 회의를 마지막으로 둔다
			if(endTime <= arr[i][0]) {
				endTime = arr[i][0];
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
