package study_programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42889
class Stage implements Comparable<Stage>{
	int stage_num;
	double fail_rate;
	public Stage(int stage_num){
		this.stage_num = stage_num;
		this.fail_rate=0;
	}
	public int compareTo(Stage o) {
		if(this.fail_rate == o.fail_rate){
			return Integer.compare(stage_num, o.stage_num);
		}
		return Double.compare(o.fail_rate, fail_rate);
	}
}
public class KakaoBlindTest05 {
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        PriorityQueue<Stage> q = new PriorityQueue<>();
        for(int k=1; k<N+1; k++) {
        	Stage s = new Stage(k);
        	int not_clear=0;
        	int arrived_players=0;
        	for(int i=0; i<stages.length; i++) {
        		if(stages[i]>=k) {
        			arrived_players++;
        			if(stages[i]==k) {
        				not_clear++;
        			}
        		}
        	}
        	if(arrived_players==0) {
        		s.fail_rate=0;
        	}else {
        		s.fail_rate = (double)not_clear/arrived_players;
        	}
        	q.add(s);
        }
        for(int i=0; i<answer.length ;i++) {
        	if(!q.isEmpty()) {
        		answer[i]=q.poll().stage_num;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int n = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		int n2 = 4;
		int[] stages2 = {4,4,4,4,4};
		int[] answer = {};
//		answer = solution(n, stages);
		answer = solution(n2, stages2);
		System.out.println(Arrays.toString(answer));
	}
}
