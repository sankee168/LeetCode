//This is math version of counting bits. 
public int[] countBits(int num) {
	int[] res = new int[num];
	for(int i = 0; i < num; i++){
		if(i == 0) res[i] = 0;
		else if(i == 1) res[i] = 1;
		else {
			int count = 1;
			while((int) Math.pow(2, count) <= i){
				count++;
			}

			int temp = (int) Math.pow(2, count-1);
			res[i] = res[i%temp -1] + 1;
		}
	}

	return res;
}