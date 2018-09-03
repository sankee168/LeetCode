//We start by checking all the ones and then we iterate over all the directions
//Time complexity: O(mn*(m+n))
//Space complexity: O(k) where k is the number of 1s
public int longestLine(int[][] M) {
        int m = M.length;
        if(m == 0) return 0;
        int n = M[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(M[i][j] == 1) list.add(new int[]{i,j});
            }
        }
        
        int[][] direction = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        int longest = 0;
        for(int[] curr : list){
            int x = curr[0];
            int y = curr[1];
            for(int i = 0; i < 8; i++){
                longest = Math.max(longest, findLongest(x, y, M, i, direction));
            }
        }
        return longest;
    }
    
    private int findLongest(int x, int y, int[][] M, int dir, int[][] direction){
        int count = 0;
        while(x >= 0 && y >= 0 && x <M.length && y < M[0].length && M[x][y] == 1){
            count++;
            x += direction[dir][0];
            y += direction[dir][1];
        }
        return count;
    }

//Here we note that for each iteration we are recalculating the problem
//So we maintain 4 2d arrays(3d array) for storing horizontal, vertical, diognal and anti-diognal
//Time complexity: O(mn)
//Space complexity: O(mn)    
public int longestLine(int[][] M){
    int m = M.length;
    if(m == 0) return 0;
    int n = M[0].length;
    int longest = 0;
    int[][][] dp = new int[m][n][4];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(M[i][j] == 1){
                //horizontal
                if(j > 0){
                    dp[i][j][0] = dp[i][j-1][0]+1;
                }else dp[i][j][0] = 1;
                longest = Math.max(longest, dp[i][j][0]);
                //vertical
                if(i > 0){
                    dp[i][j][1] = dp[i-1][j][0]+1;
                }else dp[i][j][1] = 1;
                longest = Math.max(longest, dp[i][j][1]);
                if(i > 0 && j > 0){
                    dp[i][j][2] = dp[i-1][j-1][2]+1;
                }else dp[i][j][2] = 1;
                longest = Math.max(longest, dp[i][j][2]);
                if(i > 0 && j < n-1){
                    dp[i][j][3] = dp[i-1][j+1][3]+1;
                }else dp[i][j][3] = 1;
                longest = Math.max(longest, dp[i][j][3]);
            }
        }
    }
    return longest;
}