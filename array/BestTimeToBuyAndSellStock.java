//Idea here is simple. We have to try to find min price and max price after that index. 
//Time complexity: O(n)
//Space complexity: O(1)
public int maxProfit(int[] prices) {
	if(prices.length == 0) return 0;
	int low = prices[0];
	int maxProfit = 0;

	for(int i = 0; i < prices.length; i++){
		maxProfit = Math.max(maxProfit, prices[i]-low);
		if(prices[i] < low) low = prices[i];
	}
	return maxProfit;
}