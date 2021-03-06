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
				// 현재 인덱스 숫자
				if(round_sc[i].charAt(idx)-'0'>=0 && round_sc[i].charAt(idx)-'0'<=10 ) {
					if(idx>0 && round_sc[i].charAt(idx-1)-'0'>=0 && round_sc[i].charAt(idx-1)-'0'<=10) {
						// 현재 인덱스 숫자, 바로 이전 인덱스도 숫자 -> 숫자가 10
						score =10;
					}
					else {
						score = round_sc[i].charAt(idx)-'0';
					}
				}else {	// 현재 인덱스 문자
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
        String[] round_sc = new String[3];		// round는 3회
        int round =0;
        
        // 입력 -> 배열에 잘 나눠서 담기 
        for(int i=0; i<3; i++) {
        	round_sc[i]="";
        }
        for(int i=0; i<dartResult.length(); i++) {
        	// 바로 이전꺼가 보너스 or 옵션 && 이번꺼가 숫자
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
              
        // 배열 각 원소 계산하기
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
