package example_09_08_method;

import java.util.Date;
import java.util.Random;

public class Sample4 {
	
	void currentDate() {
		Date now = new Date();
		System.out.println(now);
	}
	
	int Number() {
		return 100;
	}
	
	int getRandomNumber() {
		Random num = new Random();
		int value = num.nextInt(6)+1;
		return value;
	}
	
	int totalScore(Sample4App score) {
		int total = score.eng + score.kor + score.math;
		return total;
	}
	
	double averageScore(Sample4App score) {
		double average = this.totalScore(score)/3.0;
		return average;
	}
	
}
