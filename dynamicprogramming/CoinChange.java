//Time complexity: O(mn) where n is the amount and m is the lenght of coins array
//Space complexity: O(n)
//We will go from 1 to amount and keep storing the least number of coins required for that number
//Idea is to check in the coins array and get the remaining amount from the array
public int coinChange(int[] coins, int amount) {
    if(amount == 0) return 0;
	int[] arr = new int[amount+1];
	Arrays.fill(arr, amount+1);
	arr[0] = 0;
	for(int i = 1; i <= amount; i++){
		for(int j = 0; j < coins.length; j++){
			if(i - coins[j] >= 0){
				arr[i] = Math.min(arr[i], arr[i-coins[j]]+1);	
			}
		}
	}

	if(arr[amount] > amount) return -1;
    return arr[amount];
}