package programmers;

import java.util.*;
/*
 * command[a][b] : a번째 명령, b : 0 ~ 2
 * command[a][0] : i, command[a][1] : j, command[a][2] : k
 * array를 i부터 j까지 자르고 정렬, k번째 값을 꺼내라 
 * */
public class sort_kNumber {
	public static int[] solution2(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int i=0;
		for(int a=0; a<commands.length; a++) {
			int[] temp = Arrays.copyOfRange(array, commands[a][0]-1, commands[a][1]);
			Arrays.sort(temp);
			answer[i++] = temp[commands[a][2]-1];
		}
		return answer;
	}
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] newArr;
//        System.out.println("oldArr :"+Arrays.toString(array));
        for(int i=0; i<commands.length; i++){
            newArr= new int[commands[i][1]-commands[i][0]+1];
            int k=0;
            // 1. 일부분 잘라서 새로운 배열에 담기
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                
                newArr[k]=array[j];
                k++;
            }
            // 2. 정렬하기 
            Arrays.sort(newArr);
            
            // 3. k 번째 숫자 구하기
            //ls.add(newArr[commands[i][2]]);
//            System.out.println("newArr : "+ Arrays.toString(newArr));
//            System.out.println("k : "+newArr[commands[i][2]-1]);
            answer[i]=newArr[commands[i][2]-1];
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] array = {1, 5, 2, 6, 3, 7, 4};
    	int[][] commands= {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    	
//    	System.out.println("answer: "+Arrays.toString(solution(array,commands)));
    	System.out.println("answer: "+Arrays.toString(solution2(array,commands)));
	}
}