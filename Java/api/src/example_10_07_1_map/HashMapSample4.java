package example_10_07_1_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapSample4 {
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		books.add(new Book("소설", "남한산성"));
		books.add(new Book("소설", "칼의 노래"));
		books.add(new Book("컴퓨터", "이것이 자바다"));
		books.add(new Book("외국어", "토익 보카"));
		books.add(new Book("소설", "레터의 연가"));
		books.add(new Book("컴퓨터", "자바의 정석"));
		books.add(new Book("외국어", "토익 기출문제"));
		books.add(new Book("컴퓨터", "빅데이터 실무"));
		books.add(new Book("컴퓨터", "머신러닝 가이드"));
		books.add(new Book("기술", "고속도로 건설 공학"));
		books.add(new Book("수험서", "2022 정보처리"));
		books.add(new Book("대학교재", "공업수학"));
		books.add(new Book("대학교재", "전자기학"));
		books.add(new Book("인문", "동양철학의 이해"));
		books.add(new Book("인문", "한국 근현대문학"));
		
		// 장르의 종류를 모를때
//		int 소설책개수 = 0;
//		int 외국어책개수 = 0;
//		int 컴퓨터책개수 = 0; 불가능
		
		// Key는 장르명, Value는 장르명 도서개수로 하는 Map객체를 생성한다.
		Map<String, Integer> genreSummary = new HashMap<>();
		
		for(Book book: books) {	
			//장르명을 조회
			String genre = book.getGenre();
			// Map객체에 조회된 장르명이 포함되어 있는지 체크
			if (genreSummary.containsKey(genre)) {
				// Map객체에 장르명이 존재하는 경우
				// 해당 장르명으로 저장된 도서 개수를 조회
				int count = genreSummary.get(genre);
				// Map객체에 해당 장르명과 1증가된 도서개수를 다시 저장한다.
				genreSummary.put(genre, count+1);
				
			} else {								
				// Map객체에 장르명이 존재하지 않는 경우
				// 해당 장르를 key, 1을 value로 Map에 저장
				genreSummary.put(genre, 1);
			}
		}
		System.out.println(genreSummary);
	}
	
	static class Book {
		private String genre;
		private String title;
		
		public Book(String genre, String title) {
			super();
			this.genre = genre;
			this.title = title;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		
	}
	
	
	
	
}
