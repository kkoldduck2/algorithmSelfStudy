package study_programmers;

public class Naver02 {
	public static void main(String[] args) {
		int answer=-1;
		String answer_sheet = "4132315142";
		String[] sheets = {"3241523133","4121314445","3243523133","4433325251","2412313253"};
		// 부정행위 가능성 지수 = 총 의심 문항의 수 + (가장 긴 연속된 의심 문항의 수)2
		
		
		for(int i=0; i<sheets.length-1; i++) {	// i 학생과
			for(int j=i+1; j<sheets.length; j++) {	// j 학생 비교
				int q = 0; // 의심 문항
				boolean[] qn = new boolean[answer_sheet.length()];	// 의심 문항 번호 
				for(int k=0; k<answer_sheet.length(); k++) {	// k 문항에 대해서
					if(sheets[i].charAt(k)== sheets[j].charAt(k) 	// 문항이 같지만  정답이 아님
							&& sheets[i].charAt(k)!=answer_sheet.charAt(k)) {
						q++;
						qn[k] = true;
					}
				}
				int max = 0;  // 연속된 의심문항 길이 	
				int seq = 0;  // 연속된 의심문항
				for(int a=0; a<qn.length; a++) {
					if(qn[a]== true) {
						seq++;
						max = max<seq ? seq : max;
					}else {
						seq=0;
					}
				}
				
				if(answer < (int) (q+Math.pow(max,2))) {
					answer = (int) (q+Math.pow(max,2));
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
