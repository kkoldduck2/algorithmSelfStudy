package study_programmers;

public class Naver02 {
	public static void main(String[] args) {
		int answer=-1;
		String answer_sheet = "4132315142";
		String[] sheets = {"3241523133","4121314445","3243523133","4433325251","2412313253"};
		// �������� ���ɼ� ���� = �� �ǽ� ������ �� + (���� �� ���ӵ� �ǽ� ������ ��)2
		
		
		for(int i=0; i<sheets.length-1; i++) {	// i �л���
			for(int j=i+1; j<sheets.length; j++) {	// j �л� ��
				int q = 0; // �ǽ� ����
				boolean[] qn = new boolean[answer_sheet.length()];	// �ǽ� ���� ��ȣ 
				for(int k=0; k<answer_sheet.length(); k++) {	// k ���׿� ���ؼ�
					if(sheets[i].charAt(k)== sheets[j].charAt(k) 	// ������ ������  ������ �ƴ�
							&& sheets[i].charAt(k)!=answer_sheet.charAt(k)) {
						q++;
						qn[k] = true;
					}
				}
				int max = 0;  // ���ӵ� �ǽɹ��� ���� 	
				int seq = 0;  // ���ӵ� �ǽɹ���
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
