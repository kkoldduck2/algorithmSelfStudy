package dinamicProgramming;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11054
/*
 ���� S�� � �� Sk�� �������� S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN�� �����Ѵٸ�, 
 �� ������ ������� �����̶�� �Ѵ�.

���� ���, {10, 20, 30, 25, 20}�� {10, 20, 30, 40}, {50, 40, 25, 10} �� ������� ����������,  
{1, 2, 3, 2, 1, 2, 3, 2, 1}�� {10, 20, 30, 40, 20, 30} �� ������� ������ �ƴϴ�.

���� A�� �־����� ��, �� ������ �κ� ���� �� ������� �����̸鼭 ���� �� ������ ���̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * */ 

// D1 -> i -> D2
// ans = longest D1[i] + longest D2[i] -1;  (-1�� ���������� ��ġ�� �� i)
// longest D1[i] : A[i]�� ���������� �ϴ� ���� �� �����ϴ� �κм���
// longest D2[i] : A[i]�� �������� �ϴ� ���� �� �����ϴ� �κм���

public class LongestBitonicSubperm {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//        int[] a = new int[n];
//        for (int i=0; i<n; i++) {
//            a[i] = sc.nextInt();
//        }
		
		int n= 10;
		int[] a = new int[] {1, 5, 2, 1, 4, 3, 4, 5, 2, 1};
        
        int[] d1 = new int[n+1];
        for(int i=1; i<n+1; i++) {
			d1[i] = 1; // �⺻������ ��� ������ ���̴� 1�̴�. 
			for(int j=1; j<i; j++) {  // j<i
				if(a[j-1]<a[i-1] && d1[i] < d1[j]+1) {
					d1[i]=d1[j]+1;
				}
			}
		}
        
        // d2[i] : a[i]���� ����
        // d1�� ���ϴ� ������ �ݴ�� ����.
        // �� i <j �� ����
        int[] d2 = new int[n+1];
        for(int i=n; i>=1; i--) {
			d2[i] = 1;
			for(int j=n; j>=i+1; j--) {
				if(a[j-1]<a[i-1] && d2[i] < d2[j]+1) {
					d2[i] = d2[j]+1;
				}
			}
		}
        
        int ans = d1[1]+d2[1]-1;
        for (int i=2; i<n+1; i++) {
            if (ans < d1[i]+d2[i]-1) {
                ans = d1[i]+d2[i]-1;
            }
        }
        System.out.println(ans);
        
	}
}
