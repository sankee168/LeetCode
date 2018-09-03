//This approach is dp
//we keep checking from left top in one iteration and if it is 0 then distance is 0
//else dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + 1
//similarly there might be shortest distance from bottom
//so do the same from right bottom
//Time complexity: O(mn)
//Space complexity: O(mn)
public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return matrix;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        
        int[][] first = {{-1,0},{0,-1}};
        int[][] second = {{1,0},{0, 1}};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(matrix[i][j] == 0) res[i][j] = 0;
                else{
                    int min =  Integer.MAX_VALUE;
                    for(int k = 0; k < 2; k++){
                        int x = i+first[k][0];
                        int y = j+first[k][1];
                        if(x >= 0 && y >= 0 && x < m && y < n && res[x][y] != Integer.MAX_VALUE){
                            min = Math.min(res[x][y]+1, min);
                        }
                    }
                    res[i][j] = min;
                }               
            }
        }
        
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                
                if(matrix[i][j] == 0) {res[i][j] = 0;}
                else{
                    int min = Integer.MAX_VALUE;
                    for(int k = 0; k < 2; k++){
                        int x = i+second[k][0];
                        int y = j+second[k][1];
                        if(x >= 0 && y >= 0 && x < m && y < n && res[x][y] != Integer.MAX_VALUE){
                            min = Math.min(res[x][y]+1, min);
                        }
                    }
                    res[i][j] = Math.min(min, res[i][j]);
                }
            }
        }
        
        return res;
    }
//This is bfs approach where we start with nodes whose values is 0 and spread across
//Time complexity: O(mn)
//Space complexity: O(1)
public int[][] updateMatrix(int[][] matrix) {
    Queue<int[]> queue = new LinkedList<>();
    int m = matrix.length;
    int n = matrix[0].length;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(matrix[i][j] == 0){
                queue.add(new int[]{i, j});
            }else{
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    while(!queue.isEmpty()){
        int[] curr = queue.poll();
        for(int i = 0; i < 4; i++){
            int x = curr[0] + dir[i][0];
            int y = curr[1] + dir[i][1];
            if(x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[curr[0]][curr[1]]+1){
                queue.add(new int[]{x, y});
                matrix[x][y] = matrix[curr[0]][curr[1]]+1;
            }
        }
    }
    return matrix;
}