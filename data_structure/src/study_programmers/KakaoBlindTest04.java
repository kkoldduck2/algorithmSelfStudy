package study_programmers;
// https://programmers.co.kr/learn/courses/30/lessons/17682
public class KakaoBlindTest04 {
	static int cvtbonus(char b) {
		if(b=='S') {
			return 1;
		} else if(b=='D') {
			return 2;
		} else if(b=='T') {
			return 3;
		}else {
			return 0;
		}
	}
	static int[] calculate(String[] round_sc) {
		int[] each_round_score = new int[3];
		for(int i=0; i<3; i++) {
			int score=0;
			int bonus = 0;
			for(int idx =0 ; idx<round_sc[i].length(); idx++) {
				// ���� �ε��� ����
				if(round_sc[i].charAt(idx)-'0'>=0 && round_sc[i].charAt(idx)-'0'<=10 ) {
					if(idx>0 && round_sc[i].charAt(idx-1)-'0'>=0 && round_sc[i].charAt(idx-1)-'0'<=10) {
						// ���� �ε��� ����, �ٷ� ���� �ε����� ���� -> ���ڰ� 10
						score =10;
					}
					else {
						score = round_sc[i].charAt(idx)-'0';
					}
				}else {	// ���� �ε��� ����
					if(cvtbonus(round_sc[i].charAt(idx))!=0) {
						bonus = cvtbonus(round_sc[i].charAt(idx));
						each_round_score[i]+= Math.pow(score, bonus);
//						System.out.println(i+" round score :"+score +", bonus :"+ bonus+", eachsc: "+each_round_score[i]);
					}else {
						if(round_sc[i].charAt(idx)=='*') {
							if(i!=0) {
								each_round_score[i-1] = each_round_score[i-1]*2;
							}
							each_round_score[i] = each_round_score[i]*2;
						}else if(round_sc[i].charAt(idx)=='#') {
							each_round_score[i] = each_round_score[i]*(-1);
						}
					}
				}
			}
		}
		return each_round_score;
	}
	public static int solution(String dartResult) {
        int answer = 0; 
        String[] round_sc = new String[3];		// round�� 3ȸ
        int round =0;
        
        // �Է� -> �迭�� �� ������ ��� 
        for(int i=0; i<3; i++) {
        	round_sc[i]="";
        }
        for(int i=0; i<dartResult.length(); i++) {
        	// �ٷ� �������� ���ʽ� or �ɼ� && �̹����� ����
    		if(i>0 && !(dartResult.charAt(i-1)-'0'>=0 && dartResult.charAt(i-1)-'0'<=10)
    				&& (dartResult.charAt(i)-'0'>=0 && dartResult.charAt(i)-'0'<=10)) {
    			round++;
    		}
    		round_sc[round]+=dartResult.charAt(i);
        }
        // input test
//        for(int i=0; i<3; i++) {
//        	System.out.println(round_sc[i]);
//        }
              
        // �迭 �� ���� ����ϱ�
        int [] ra = calculate(round_sc);
        for(int a : ra) {
        	answer+=a;
        }
        return answer;
    }
	public static void main(String[] args) {
		String dartResult = "1D2S#10S";
		System.out.println(solution(dartResult));
//		char c = '0';
//		int a = c-'0';
//		System.out.println(a);
	}
}
