package study_programmers;

import java.util.*;

// https://www.welcomekakao.com/learn/courses/30/lessons/60061
/* 규칙 )
 * 구조물을 어떻게 저장할 것인가)  노드 -> 큐에 저장
 * 
 * 
 * */
class Structure{
	int x1, x2, y1, y2;
	int kind;
//	int action;
	List<Structure> connected = new LinkedList<>();

	Structure(int x, int y, int a){
		this.x1 = x;
		this.y1 = y;
		this.kind = a;
//		this.action = b;
		if(a== 0) { // 기둥
			this.x2 = this.x1;
			this.y2 = this.y1+1;
		}else if(a==1) {	// 보 
			this.x2 = this.x1+1;
			this.y2 = this.y1;
		}
	}
	
	public void setConnection(Structure s, int act) {
		if(act==1) {
			this.connected.add(s);
		}else if(act==0) {
			this.connected.remove(s);
		}
	}
	public List getConnection(Structure s) {	// s와 연결된 애들을 반환
		return this.connected;
	}
	
	
}
public class KakaoBlindTest02 {
	// 조건 검사 
	public static boolean checkCondition(HashMap<String, Structure> hm, Structure s, int action){
		int k = s.kind;
		// s : 기둥
		if(k==0) {
			if(s.y1==0) {
				return true;
			}else {
				for(Structure next : hm.values()) {
					if(next.kind==0 && s.x1==next.x2 && s.y1 == next.y2) {
						next.setConnection(s, action);
						s.setConnection(next, action);
						return true;
					}else if(next.kind==1) {
						if((s.x1==next.x1 && s.y1 == next.y1)|| (s.x1==next.x2 && s.y1==next.y2)||
							(s.x2==next.x1 && s.y2 == next.y1)|| (s.x2==next.x2 && s.y2==next.y2)) {
							next.setConnection(s, action);
							s.setConnection(next, action);
							return true;
						}
					}
				}
			}
		}else if(k==1) {	// s : 보
			boolean first_coor = false;
			boolean second_coor=false;
			for(Structure next :hm.values()) {
				if(next.kind==0) {// next : 기둥
					if((s.x1 == next.x2 && s.y1 == next.y2)||(s.x2 == next.x2 && s.y2 == next.y2)) {
						next.setConnection(s, action);
						s.setConnection(next, action);
						return true;
					}
				}else if(next.kind ==1) {// next : 보
					if((next.x1==s.x1 && next.y1 == s.y1) || (next.x2==s.x1 && next.y2 == s.y1)) {
						first_coor = true;
					}
					if((next.x1==s.x2 && next.y1 == s.y2) || (next.x2==s.x2 && next.y2 == s.y2)) {
						second_coor = true;
					}
					if(first_coor && second_coor) {
						next.setConnection(s, action);
						s.setConnection(next, action);
						return true;
					}
				}
			}
		}

		return false;
	}
	public static int[][] solution(int n, int[][] build_frame) {
		HashMap<String, Structure> hm = new HashMap<>();

        for(int i=0; i<build_frame.length; i++) {
        	
        	Structure s = new Structure(build_frame[i][0], build_frame[i][1],build_frame[i][2]);
        	//n 범위 안에 있고
        	if(s.x1>=0 && s.x1<=n && s.y1>=0 && s.y1<=n 
        		&& s.x2>=0 && s.x2<=n && s.y2>=0 && s.y2<=n ) {
        		if(build_frame[i][3]==1) {	// 추가
        			if(checkCondition(hm, s, 1)) {
        				hm.put(s.x1+"_"+s.y1+"_"+s.kind, s);
        			}
        		}else if(build_frame[i][3]==0) { // 삭제
        			if(hm.containsKey(s.x1+"_"+s.y1+"_"+s.kind)) {
        				hm.remove(s.x1+"_"+s.y1+"_"+s.kind);
        				// s와 연결된 Structure에 대해서 조건 검사
            			List<Structure> con = s.connected;
            			for(Structure next : con) {
            				// 삭제를 먼저 한다음 검사 
            				if(checkCondition(hm, next, 0)==false) {
            					hm.put(s.x1+"_"+s.y1+"_"+s.kind, s);
            				}
            			}
        			}
        		}
        	}
        }
        
        List<Structure> li = new LinkedList<>();
        for(Structure s : hm.values()) {
        	li.add(s);
        }
        
        Collections.sort(li, new Comparator<Structure>() {
        	public int compare(Structure s1, Structure s2) {
        		if(s1.x1!=s2.x1) {
        			return s1.x1-s2.x1;
        		}else {
        			if(s1.y1 != s2.y1) {
        				return s1.y1-s2.y1;
        			}else {
        				return s1.kind - s2.kind;
        			}
        		}
        	}
        });
        
        int[][] answer = new int[li.size()][3];
        int t =0;
        for(Structure s : li) {
        	answer[t][0] = s.x1;
        	answer[t][1] = s.y1;
        	answer[t][2] = s.kind;
        	t++;
        }
        return answer;
    }
	public static void main(String[] args) {
		int n=5;
		int[][] build_frame= {
				{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}
		};
		
		int[][] build_frame2= {
				{0, 0, 0, 1},{2, 0, 0, 1},{4, 0, 0, 1},{0, 1, 1, 1},{1, 1, 1, 1},{2, 1, 1, 1},
				{3, 1, 1, 1},{2, 0, 0, 0},{1, 1, 1, 0},{2, 2, 0, 1}
		};
		
		int[][] answer;
		answer = solution(n, build_frame2);
		for(int i=0; i<answer.length; i++) {
			System.out.println(Arrays.toString(answer[i]));
		}
	}
}
