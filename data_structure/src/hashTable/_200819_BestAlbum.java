package hashTable;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42579
/*장르 별로 가장 많이 재생된 노래를 "두 개씩" 모아 베스트 앨범을 출시
 * <노래를 수록하는 기준>
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다. (내림차순)
   2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다. (내림차순)
   3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. (오름차순)*/
public class _200819_BestAlbum {
	// 3가지 기준에 대해서 정렬하기 위해 Music 클래스를 만듦
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
        
        // 1번 조건 -> hashmap에 장르별 재생횟수를 저장 -> key : 장르명, value : 재생횟수 
     	HashMap<String, Integer> hm = new HashMap<>();
     	
     	for(int i=0; i<genres.length; i++) {
     		if(!hm.containsKey(genres[i])) {
     			hm.put(genres[i], plays[i]);
     		}else {
     			hm.put(genres[i], hm.get(genres[i])+plays[i]);
     		}
     	}
     	
     	// 정렬 (장르별 재생횟수, 장르 내 노래의 재생횟수, 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래)
     	Collections.sort(musics, new Comparator<Music>() {

			@Override
			public int compare(Music o1, Music o2) {		// 항상 첫번째 인자가 두번째 인자보다 작다고 생각해라
				if(!o1.genre.equals(o2.genre)) {
					return hm.get(o2.genre).compareTo(hm.get(o1.genre));		// 내림차순 정렬 (큰게 앞에오게)
				}else {
					if(o1.play!= o2.play) {
						return o2.play-o1.play; 	// 내림차순 정렬
					}else {
						return o1.musicNum-o2.musicNum;	// 오름차순 정렬
					}
				}
			}
     	});
     	
     	// 장르당 2곡씩 count
     	HashMap<String, Integer> cnt = new HashMap<>();
     	
     	// 최종 추천 리스트(answer배열의 크기를 정해주기 위해 따로 담는다)
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
