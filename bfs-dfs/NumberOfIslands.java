//This is a dfs approach
//When we encounter 1 in the grid, we do dfs and change all the nodes adjacent to them to 0 in a dfs manner
//Time complexity: O(mn)
//Space compelxity: O(mn) worst case for recursion stack
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = '0';
        int[][] dir= {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        for(int p = 0; p < 4; p++){
            int x = i+dir[p][0];
            int y = j+dir[p][1];
            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '0'){
                dfs(grid, x, y);
            }
        }
    }

//BFS version of the same solution
//Time complexity: O(mn)
//Space complexity: O(Min(m, n))
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    queue.add(i*n+j);
                    while(!queue.isEmpty()){
                        int num = queue.poll();
                        int x = num/n;
                        int y = num%n;
                        int[][] dir= {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
                        for(int p = 0; p < 4; p++){
                            int q = x+dir[p][0];
                            int r = y+dir[p][1];
                            if(q >= 0 && q < m && r >= 0 && r < n && grid[q][r] != '0'){
                                queue.add(q*n+r);
                                grid[q][r] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }