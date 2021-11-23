package example_09_10_coding;

public class Sample {
	
	// 학생성적정보 객체를 전달받아서 화면에 출력하는 기능
	void printScore(Score score) {
		System.out.println("번   호: " + score.no);
		System.out.println("이   름: " + score.name);
		System.out.println("국어점수: " + score.kor);
		System.out.println("영어점수: " + score.eng);
		System.out.println("수학점수: " + score.math);
		System.out.println("총   점: " + score.total);
		System.out.println("평균점수: " + score.average);
		System.out.println();
	}
	
	// 학생성적정보가 포함된 배열을 전달받아서 화면에 출력하는 기능
	void printAllScores(Score[] scores) {
		for (Score score: scores) {
			printScore(score);
			System.out.println();
		}
	}
	
	// 학생성적정보가 포함된 배열을 전달받아서 최고 성적을 받은 성적정보를 출력하는 기능
	void printTop1(Score[] scores) {
		Score topScore = scores[0];
		for (Score score : scores) {
			if(score.total > topScore.total) {
				topScore = score;
			}
		}
		printScore(topScore);
	}
	
	// 학생성적정보가 포함된 배열을 전달받아서 평균점수를 출력하는 기능
	void printAverage(Score[] scores) {
		int average = getAllScoresAverage(scores);
		System.out.println("전체 학생의 평균점수: " + average);
		System.out.println();
	}

	
	// 학생성적정보가 포함된 배열을 전달받아서 평균점수보다 낮은 점수를 받은 성적정보를 출력하는 기능
	void printLowerScore(Score[] scores) {
		int average = getAllScoresAverage(scores);
		for (Score score : scores) {
			if (score.average < average) {
				printScore(score);
			}
		}
	}
	
	// 학생성적정보가 포함된 배열을 전달받아서 불합격한 학생들의 성적정보를 출력하는 기능(평균 60점 미만 불합격)
	void printUnPassedScores(Score[] scores) {
		for (Score score : scores) {
			if (score.average < 60) {
				printScore(score);
			}
		}
	}
	
	// 학생성적정보가 포함된 배열을 전달받아서 불합격한 학생들의 성적정보를 출력하는 기능(평균 60점 미만, 과목과락(과목잠수가 40점 미만)은 불합격)
	void printUnPasswordScores2(Score[] scores) {
		for (Score score : scores) {
			if (score.average < 60 || isFailedSubject(score)) {
				printScore(score);
			}
		}
	}
	// 과목낙제 여부를 판단한다.
	boolean isFailedSubject(Score score) {
		boolean isFailed = false;
		if (score.kor < 40 || score.eng < 40 || score.math < 40) {
			isFailed = true;
		}
		return isFailed;
	}
	
	// 학생성적정보가 포함된 배열을 전달받아서 평균점수와 가장 가까운 점수를 가진 학생의 성적정보를 출력하는 기능
	void printClosestAverageScore(Score[] scores) {
		Score closestScore = scores[0];
		int average = getAllScoresAverage(scores);
		for(Score score : scores) {
			if (Math.abs(score.average-average) < Math.abs(closestScore.average-average)) {
				closestScore = score;
			}
		}
		printScore(closestScore);
	}
	
	// 학생성적정보가 포함된 배열을 전달받아서 평균점수별 학생수를 출력하는 기능(10점이하 0명, 20점이하 0명, 30점이하 1명, 40점이하 2명, ...)
	void printCountByAverage(Score[] scores) {
		int[] numberStudents = new int[10];
		for(Score score: scores) {
			if(score.average>90) {
				numberStudents[9]++;
			} else if (score.average > 80) {
				numberStudents[8]++;
			} else if (score.average > 70) {
				numberStudents[7]++;
			} else if (score.average > 60) {
				numberStudents[6]++;
			} else if (score.average > 50) {
				numberStudents[5]++;
			} else if (score.average > 40) {
				numberStudents[4]++;
			} else if (score.average > 30) {
				numberStudents[3]++;
			} else if (score.average > 20) {
				numberStudents[2]++;
			} else if (score.average > 10) {
				numberStudents[1]++;
			} else {
				numberStudents[0]++;
			}
		for(int numberStudent : numberStudents) {
			System.out.println(numberStudent);
		}
			
			
			
			
		}
	}
	
	// 학생성적정보가 포함된 배열을 전달받아서 평균점수를 계산하고 반환하는 기능
	private int getAllScoresAverage(Score[] scores) {
		int total = 0;
		for(Score score : scores) {
			total += score.average;
		}
		int average = total/scores.length;
		return average;
	}


	
	
}
