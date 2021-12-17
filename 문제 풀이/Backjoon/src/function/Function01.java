package function;


class Test {
	long sumNum;
	long sum(int[] a) {
		for(int i:a) {
			sumNum += i;				
		}
		return sumNum; 
	}
}	

