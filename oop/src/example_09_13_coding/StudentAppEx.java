package example_09_13_coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentAppEx {

	public static void main(String[] args) {
		// 학생정보/성적정보를 입력하고, 조회하고, 변경하는 프로그램
		
		// AtomicInteger은 자동으로 업데이터되는 숫자를 제공하는 객체다.
		// new AtomicInteger(숫자) : 지정된 숫자부터 시작한다. 안하면 0부터 시작
		AtomicInteger atomic = new AtomicInteger(101); 
		Scanner scan = new Scanner(System.in);
		
		List<Student> list = new ArrayList<>(); 
		
		// 샘플 학생정보 미리 입력해두기
		list.add(new Student(atomic.getAndIncrement(), 1, "김유신", new ScoreDetail(100, 90, 70)));
		list.add(new Student(atomic.getAndIncrement(), 1, "강감찬", new ScoreDetail(70, 70, 40)));
		list.add(new Student(atomic.getAndIncrement(), 1, "이순신", new ScoreDetail(80, 90, 10)));
		list.add(new Student(atomic.getAndIncrement(), 1, "류관순", new ScoreDetail(100, 90, 100)));
		list.add(new Student(atomic.getAndIncrement(), 1, "홍길동", new ScoreDetail(60, 40, 70)));
		
		while(true) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.조회	2.입력	3.수정	4.삭제	0.종료");
			System.out.println("------------------------------------------------------");
			
			System.out.print("메뉴번호 선택: ");
			int menuNo = scan.nextInt();
			
			if ( menuNo == 1 ) {
				System.out.println("[전체 학생/성적 정보 출력]");
				
				if (list.isEmpty()) {
					System.out.println("### 등록된 학생/시험 정보가 존재하지 않습니다.");
					continue;
				}
				
				System.out.println("학번\t학년\t이름\t국어\t영어\t수학\t총점\t평균");
				for (Student student : list) {
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
				list.add(new Student(no, grade, name, score));
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
				for (Student student : list) {
					if (student.getNo() == num) {
						foundStudent = student;
					}
				}
				if (foundStudent == null) {
					System.out.println("존재하는 학생 정보가 없습니다.");
					continue;
				}
				ScoreDetail score = foundStudent.getScore();
				
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
				
				
				
			} else if ( menuNo == 4 ) {
				System.out.println("[학생/성적 정보 삭제]");
				System.out.println("삭제할 학생의 학번을 입력하세요: ");
				int num = scan.nextInt();
					
				Student foundStudent = null;
				for (Student student : list) {
					if (student.getNo() == num) {
						foundStudent = student;
					}
				}
				if (foundStudent == null) {
					System.out.println("존재하는 학생 정보가 없습니다.");
					continue;
				}
				
				list.remove(foundStudent);

				System.out.println("### 학생/시험성적 정보의 삭제가 완료되었습니다.");
	
				
				
			} else if ( menuNo == 0 ) {
				System.out.println("[프로그램 종료]");
				break;
			}
			System.out.println("\n\n\n");
		}
		scan.close();
	}
}