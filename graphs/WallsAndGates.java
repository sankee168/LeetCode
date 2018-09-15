//inorder to determine the distance to nearest gate, we will do bfs from gates 
//such that surrounding nodes will be assigned first and then add them to queue and so on
//Time complexity: O(mn)
//Space complexity: O(mn)
public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if(m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0) queue.add(new int[]{i,j});
            }
        }
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int k = 0; k < 4; k++){
                int x = curr[0] + dir[k][0];
                int y = curr[1] + dir[k][1];
                if(x < 0 || y < 0 || x >= m || y >= n || rooms[x][y] != Integer.MAX_VALUE) continue;
                rooms[x][y] = rooms[curr[0]][curr[1]]+1;
                queue.add(new int[]{x,y});
            }
        }
        return;
    }