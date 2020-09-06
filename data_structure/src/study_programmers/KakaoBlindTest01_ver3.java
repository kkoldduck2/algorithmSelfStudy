package study_programmers;
// https://the-dev.tistory.com/3
import java.util.*;
class TrieNode{
	// 자식 노드 맵
	private Map<Character, TrieNode> childNodes = new HashMap<>();
	
	// 마지막 글자인지 여부 
	private boolean isLastChar;
	
	
	// Getter, Setter
	// 자식 노드 맵 getter
	Map<Character, TrieNode> getChildNodes(){
		return this.childNodes;
	}
	// 마지막 글자인지 여부 getter
	boolean isLastChar() {
		return this.isLastChar;
	}
	// 마지막 글자인지 여부 setter
	void setIsLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
	}
	
}
class Trie{
	// 루트노드 (공백)
	private TrieNode rootNode;
	// 생성자
	Trie(){
		rootNode=new TrieNode();
	}
	
	// 메서드
	void insert(String word) {
		TrieNode thisNode = this.rootNode;
		for(int i=0; i<word.length(); i++) {
			thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c->new TrieNode());
		}
		thisNode.setIsLastChar(true);
	}
	
	boolean contains(String word) {
		TrieNode thisNode = this.rootNode;
		
		for(int i=0; i<word.length(); i++) {
			char character = word.charAt(i);
			TrieNode node = thisNode.getChildNodes().get(character);
			
			if(node == null) {
				return false;
			}
			thisNode = node;
		}
		return thisNode.isLastChar();
	}
	
	
}

public class KakaoBlindTest01_ver3 {
	
	public static int[] TrieSearch(String[] words, String[] queries) {
		Trie[] tries = new Trie[10001];
		
		
	}
	
	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] answer = new int[queries.length];
		answer = TrieSearch(words, queries);
		System.out.println(Arrays.toString(answer));
	}
}
