//Here we have keep checking the dip in the price. whenever there is a dip, sell the stock
//Time complexity: O(n)
//Space complexity: O(1)
public int maxProfit(int[] prices) {
	int profit = 0;
	if(prices.length == 0) return 0;
	int curProfit = 0;
	for(int i = 1; i< prices.length; i++){
		if(prices[i] > prices[i-1]){
			curProfit += prices[i]-prices[i-1];
		}
		else{
			profit += curProfit;
			curProfit = 0;
		}
	}
	return profit + curProfit;
}


public int maxProfit(int[] prices) {
	int profit = 0;
	if(prices.length == 0) return 0;
	for(int i=1; i<prices.length; i++){
		if(prices[i]>prices[i-1]){
			profit += prices[i]-prices[i-1];
		}
	}
	return profit;
}