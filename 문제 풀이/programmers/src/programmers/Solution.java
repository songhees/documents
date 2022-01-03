package programmers;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
    	int countZero = 0;
    	int score = 0;
    	for (int i=0; i<lottos.length; i++) {
    		if (lottos[i]==0) {
    			countZero++;
    		}
    		for (int j=0; j<win_nums.length;j++) {
    			if (lottos[i] == win_nums[j]) {
    				score++;
    			}
    		}
    	}
    	
    	int[] answer = {getGrade(score+countZero),getGrade(score)};
    
        return answer;
    }
    
    public int getGrade(int score) {
    	int grade = 0;
    	switch (score) {
		case 6:
			grade = 1;
			break;
		case 5:
			grade = 2;
			break;
		case 4:
			grade = 3;
			break;
		case 3:
			grade = 4;
			break;
		case 2:
			grade = 5;
			break;
		default:
			grade = 6;
			break;
		}
    	
    	return grade;
    }
}
