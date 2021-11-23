package example_09_13_coding;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentApp3 {
	public static void main(String[] args) {
		// 학생정보/성적정보를 입력하고, 조회하고, 변경하는 프로그램
		
		// AtomicInteger은 자동으로 업데이터되는 숫자를 제공하는 객체다.
		// new AtomicInteger(숫자) : 지정된 숫자부터 시작한다. 안하면 0부터 시작
		AtomicInteger atomic = new AtomicInteger(101); 
		Scanner scan = new Scanner(System.in);
		
		Student[] students = new Student[100];
		int position = 0;						// 새로 입력한 학생/시험성적 정보를 저장하는 위치정보를 가지고 있는 객체
		
		// 샘플 학생정보 미리 입력해두기
		students[position++] = new Student(atomic.getAndIncrement(), 1, "김유신", new ScoreDetail(100, 90, 70));
		students[position++] = new Student(atomic.getAndIncrement(), 1, "강감찬", new ScoreDetail(70, 70, 40));
		students[position++] = new Student(atomic.getAndIncrement(), 1, "이순신", new ScoreDetail(80, 90, 10));
		students[position++] = new Student(atomic.getAndIncrement(), 1, "류관순", new ScoreDetail(100, 90, 100));
		students[position++] = new Student(atomic.getAndIncrement(), 1, "홍길동", new ScoreDetail(60, 40, 70));
		
		while(true) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.조회	2.입력	3.수정	4.삭제	0.종료");
			System.out.println("------------------------------------------------------");
			
			System.out.print("메뉴번호 선택: ");
			int menuNo = scan.nextInt();
			
			if ( menuNo == 1 ) {
				System.out.println("[전체 학생/성적 정보 출력]");
				if (position == 0) {
					System.out.println("### 등록된 학생/시험 정보가 존재하지 않습니다.");
				} else {
					System.out.println("학번\t학년\t이름\t국어\t영어\t수학\t총점\t평균");
					for (Student student : students) {
						// student참조변수에 null이 대입되면 반복을 중단하고 for문을 탈출한다.
						if (student == null) {
							break;
						}
						System.out.print(student.getNo() + "\t");
						System.out.print(student.getGrade() + "\t");
						System.out.print(student.getName() + "\t");
						System.out.print(student.getScore().getKor() + "\t");
						System.out.print(student.getScore().getEng() + "\t");
						System.out.print(student.getScore().getMath() + "\t");
						System.out.print(student.getScore().getTotal() + "\t");
						System.out.println(student.getScore().getAverage());
					}	
					System.out.println("### 등록된 학생/시험성적 정보의 출력이 완료되었습니다.");
				}
				
				
			} else if ( menuNo == 2 ) {
				System.out.println("[신규 학생/성적 정보 입력]");
				System.out.println("### 신규 학생/시험성적 점수를 입력하세요.");
				
				// AtomicInterger객체의 getAndIncrement()메소드를 실행해서 객체의 현재 값을 가져온 다음, 값을 1증가 시킨다.
				int no = atomic.getAndIncrement();
				System.out.print("학년입력: ");
				int grade = scan.nextInt();
				System.out.print("이름입력: ");
				String name = scan.next();
				System.out.print("국어입력: ");
				int kor = scan.nextInt();
				System.out.print("영어입력: ");
				int eng = scan.nextInt();
				System.out.print("수학입력: ");
				int math = scan.nextInt();
				
				ScoreDetail score = new ScoreDetail(kor, eng, math);
				students[position] = new Student(no, grade, name, score);
				position++;
				System.out.println("### 학생/시험성적 정보의 저장이 완료되었습니다.");
				
				
			} else if ( menuNo == 3 ) {
				System.out.println("[학생/성적 정보 변경]");
				System.out.println("### 시험 성적 정보를 수정합니다.");
				
				System.out.println("수정할 학생의 학번 입력: ");
				int num = scan.nextInt();				
				
				System.out.print("수정할 과목명 입력: ");
				String subject = scan.next();
				
				System.out.print("수정된 점수 입력: ");
				int value = scan.nextInt();
				// 입력한 한번과 같은 학번을 가진 Student객체의 주소값을 저장할 변수 생성
				Student foundStudent = null;
				for (Student student : students) {
					// student에 null이 대입되면 검색을 중단한다.
					if (student == null) {
						break;
					}
					// 배열에서 순서대로 꺼낸 Student객체의 학번과 입력한 한번이 같은 경우
					if (student.getNo() == num) {
						// student변수에 저장된 Student객체의 주소값을 fountStudent에 저장
						foundStudent = student;
						break;
					}
				}
				// 만약, 존재하지 않는 학번을 입력했다면 foundStudent는 null이다.
				if (foundStudent != null) {
					// 검색된 학생의 성적정보를 변경한다.
					// foundStudent객체가 참조하는 Student객체의 getScore메소드를 통해 ScoreDetail
					// 객체의 주소값을 score에 대입
					ScoreDetail score = foundStudent.getScore();
					// switch문을 사용해서 subject변수에 저장된 값이 각각 일때 해당과목의 성적을 변경한다.
					switch (subject) {
						case "국어":
							score.setKor(value);
							break;
						case "영어":
							score.setEng(value);							
							break;
						case "수학":
							score.setMath(value);							
							break;
					}
					System.out.println("### 시험성적 정보의 수정이 완료되었습니다.");	
				} else {
					System.out.println("### 학번과 일치하는 학생정보를 찾을 수 없습니다.");					
				}
				
				
			} else if ( menuNo == 4 ) {
				// 삭제란 주소값을 없애는것 = null
				System.out.println("[학생/성적 정보 삭제]");
				// 배열번호를 담을 지역변수 설정 // 배열이나 collect는 0번째가 있으므로
				// null값의 오류를 해결하기 위해 존재할 수 없는 인덱스 값인 -1를 넣는다.
				int foundIndex = -1;
				System.out.println("삭제할 학생의 학번을 입력하세요: ");
				int num = scan.nextInt();
					
				// 삭제할 학생의 학번을 받아서 그에 맞는 정보를 가진 객체를 가져온다.
				for (int i = 0; i < position; i++) {
					if (students[i] == null) {
						break;
					} else if (students[i].getNo() == num) {
						foundIndex = i;
						break;
					}
				}
				//foundStudnet에 저장한 객체의 주소를 활용하여 정보를 삭제한다.
				if (foundIndex == -1) {
					System.out.println("### 학번과 일치하는 학생정보를 찾을 수 없습니다.");					
				} else {
					students[foundIndex] = students[position-1];
					students[position-1] = null;
					position --;
					System.out.println("### 학생/시험성적 정보의 삭제가 완료되었습니다.");
				}
				
				
			} else if ( menuNo == 0 ) {
				System.out.println("[프로그램 종료]");
				break;
			}
			System.out.println("\n\n\n");
		}
		scan.close();
	}
}
