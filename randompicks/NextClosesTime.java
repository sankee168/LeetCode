public String nextClosestTime(String s) {
	int[] arr = new int[4];
	arr[0] = s.charAt(0)-'0';
	arr[1] = s.charAt(1)-'0';
	arr[2] = s.charAt(3)-'0';
	arr[3] = s.charAt(4)-'0';
	int minElement = arr[0];
	int givenMin = (arr[0]*10+arr[1])*60 + (arr[2]*10+arr[3]);
	int curClosest = Integer.MAX_VALUE;
	int max = 23*60 + 59;
	for(int i = 0; i < 4; i++){
		minElement = Math.min(arr[i], minElement);
		for(int j = 0; j < 4; j++){
            int hr = arr[i]*10+arr[j];
            if(hr < 24 && hr >= arr[0]*10+arr[1]){
			for(int p = 0; p < 4; p++){
				for(int q = 0; q < 4; q++){
					int min = arr[p]*10+arr[q];
					if(min < 60 && (hr*60+min > givenMin) && (hr*60+min < curClosest)){
						curClosest = hr*60 + min;
					}
				}
			}
            }
		}		
	}

	if(curClosest == Integer.MAX_VALUE){
		curClosest = (minElement*10 + minElement)*60 + (minElement*10+ minElement);
	}

	int minutes = curClosest%60 ;
	int hours = curClosest/60;
    StringBuilder sb = new StringBuilder();
    if(hours < 10) sb.append(0);
    sb.append(hours).append(":");
    if(minutes < 10) sb.append(0);
    sb.append(minutes);
	return sb.toString(); 

}