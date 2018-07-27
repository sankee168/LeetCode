//This is a backtracking solution where we explore all the available combinations. 
//Time complexity: O(8^k)
//Space complexity: O(1)
public double knightProbability(int N, int K, int r, int c) {
	int[] res = {0};
       compute(res, r, c, N, K);
       return res[0]/(double)Math.pow(8, K);
}    
private void compute(int[] res, int r, int c, int N, int K){
    if(r < N && r >= 0 && c < N && c >= 0){    	
        if(K == 0){            
        	res[0]++; return;
        }        
        else {
        	int[][] dir = {{-2,1},{-2,-1},{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        	for(int i = 0; i < dir.length; i++){
            	System.out.println((r+dir[i][0]) + " " + (c+dir[i][1]));                
            	compute(res, r+dir[i][0], c+dir[i][1], N, K-1);
        	}            
    	}
    }
    return;
}


//We iterate through the complete chess board and update the probabilites for the next move. As we are asked to calculate the probablity of being on chess board when started at r,c we start with making r,c as 1. 
//Time complexity: O(n2k)
//Space complexity: O(n2) for storing the probablities
public double knightProbability(int N, int K, int r, int c){
	double[][] dp = new double[N][N];
	int[][] dir = {{-2,1},{-2,-1},{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
	dp[r][c] = 1;
	while(K > 0){
		double[][] dp1 = new double[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				for(int k = 0; k < 8; k++){
					int nextMoveX = i+dir[k][0];
					int nextMoveY = j+dir[k][1];
					if(isValid(nextMoveX, nextMoveY, N)) {dp1[nextMoveX][nextMoveY] += dp[i][j]/(double)8;}					
				}
			}
		}
		dp = dp1;
        K--;
	}
	double prob = 0;
	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			prob+=dp[i][j];
		}
	}

	return prob;
}

private boolean isValid(int x, int y, int len){
	if(x>=0 && y>=0 && x<len && y<len) return true;
	return false;
}