package hashTable;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42579
/*�帣 ���� ���� ���� ����� �뷡�� "�� ����" ��� ����Ʈ �ٹ��� ���
 * <�뷡�� �����ϴ� ����>
 * 1. ���� �뷡�� ���� ����� �帣�� ���� �����մϴ�. (��������)
   2. �帣 ������ ���� ����� �뷡�� ���� �����մϴ�. (��������)
   3. �帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�. (��������)*/
public class _200819_BestAlbum {
	// 3���� ���ؿ� ���ؼ� �����ϱ� ���� Music Ŭ������ ����
	public static class Music{
		String genre;
		int musicNum;
		int play;
		public Music(String gen, int mn, int play) {
			this.genre= gen;
			this.musicNum =mn;
			this.play = play;
		}
	}
	public static int[] solution(String[] genres, int[] plays) {
       
        List<Music> musics = new ArrayList<>();
        for(int i=0; i <genres.length; i++) {
        	musics.add(new Music(genres[i], i, plays[i]));
        }
        
        // 1�� ���� -> hashmap�� �帣�� ���Ƚ���� ���� -> key : �帣��, value : ���Ƚ�� 
     	HashMap<String, Integer> hm = new HashMap<>();
     	
     	for(int i=0; i<genres.length; i++) {
     		if(!hm.containsKey(genres[i])) {
     			hm.put(genres[i], plays[i]);
     		}else {
     			hm.put(genres[i], hm.get(genres[i])+plays[i]);
     		}
     	}
     	
     	// ���� (�帣�� ���Ƚ��, �帣 �� �뷡�� ���Ƚ��, �帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡)
     	Collections.sort(musics, new Comparator<Music>() {

			@Override
			public int compare(Music o1, Music o2) {		// �׻� ù��° ���ڰ� �ι�° ���ں��� �۴ٰ� �����ض�
				if(!o1.genre.equals(o2.genre)) {
					return hm.get(o2.genre).compareTo(hm.get(o1.genre));		// �������� ���� (ū�� �տ�����)
				}else {
					if(o1.play!= o2.play) {
						return o2.play-o1.play; 	// �������� ����
					}else {
						return o1.musicNum-o2.musicNum;	// �������� ����
					}
				}
			}
     	});
     	
     	// �帣�� 2� count
     	HashMap<String, Integer> cnt = new HashMap<>();
     	
     	// ���� ��õ ����Ʈ(answer�迭�� ũ�⸦ �����ֱ� ���� ���� ��´�)
     	List<Music> finali = new ArrayList<>();
     	for(Music m : musics) {
     		if(!cnt.containsKey(m.genre)) {
     			cnt.put(m.genre, 1);
     			finali.add(m);
     		}else {
     			if(cnt.get(m.genre)<2) {
     				cnt.put(m.genre, 2);
     				finali.add(m);
     			}
     		}
     	}
     	int[] answer = new int[finali.size()];
     	int k=0;
     	for(Music m : finali) {
     		answer[k++] = m.musicNum;
     	}
        return answer;
    }
	
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		solution(genres,plays);
	}
}
