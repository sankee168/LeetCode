//As given in the question, every player plays optimally. Think how each player decides optimal step. 
//You calculate how much other party will be getting when he picks up from front or last and decides 
//which one minimize the difference if other person makes more in either case
//Time complexity: O(n)
//Space complexity: O(1)
public boolean stoneGame(int[] piles) {
	int i = 0, j = piles.length-1;
	int alex = 0, lee = 0;
	boolean isAlex = true;
	while(i < j){
		int p1 = arr[i]-Math.max(arr[i+1], arr[j]);
		int p2 = arr[j]-Math.max(arr[i], arr[j-1]);

		if(p1 > p2){
			if(isAlex) alex += arr[i];
			else lee += arr[i];
			i++;
		}else{
			if(isAlex) alex += arr[j];
			else lee += arr[j];
			j--;
		}
	}

	if(alex > lee) return true;
	return false;
}

