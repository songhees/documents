package example_09_29_string;

public class StringApp2 {

	public static void main(String[] args) {
		String text = "넷플릭스 한국 오리지널 드라마 ‘오징어 게임’이 전 세계적으로 돌풍을 일으키자 해외 주요 매체들도 앞다퉈 열풍을 조명하고 있다.미국 CNN방송은 “정말 죽여준다”며 엄지를 치켜세웠고, 뉴욕포스트는 “전 세계에 대혼란을 일으켰다”고 평했다.CNN방송은 29일(현지시간) “‘오징어 게임’은 무엇이고 왜 사로잡는가”라는 제목의 기사에서 “넷플릭스의 최신 히트작(오징어 게임)은 정말 죽여준다”고 보도했다.이어 “오징어 게임이 화제를 불러일으킨다고 말하는 것은 절제된 표현”이라며 ‘오징어 게임’ 흥행이 “한국 영화 ‘기생충’에서 드러났던 것과 매우 비슷한 현상”이라고 평했다.‘오징어 게임’을 “빚더미 수렁에 깊이 빠진 참가자들이 거액의 상금을 타기 위해 어린이 게임에 참가한다는 내용의 드라마”라며 간략한 줄거리를 소개했다.";
		/*
		 *  위의 내용에서 "오징어"라는 단어는 몇번이나 나왔을까?
		 *
		 * 1. text의 내용을 split(String " ")을 사용해서 배열로 획득
		 * 2. 배열에 저장된 모든 단어들을 처음부터 끝까지 순서대로 한 단어씩 조회한다.
		 * 3. 조회된 단어에 "오징어"라는 문자열이 포함되어 있으면 등장획수를 1증가시킨다.
		 * 4. 등장횟수를 화면에 출력한다.
		 */
		
		int count = 0;
		String[] names = text.split(" ");
		
		for (String name:names) {
			count += name.contains("오징어")? 1 : 0;
		}	
		System.out.println("오징어 등장 횟수: " + count);
		System.out.println(text.split("오징어 게임").length - 1);
		System.out.println(text.split("오징어").length - 1);
	}
}

