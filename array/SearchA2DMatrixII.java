//Idea here is to traverse in the direction of target
//we can do this from either from right top or left bottom
//where either side is has lower and greater elements
//time complexity: O(m+n)
//Space complexity: O(1)
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if(m == 0) return false;
    int n = matrix[0].length;
    int i = 0;
    int j = n-1;
    while(i < m && i >= 0 && j < n && j >= 0){
        if(target < matrix[i][j]){
            j--;
        }else if(target > matrix[i][j]){
            i++;
        }else if(target == matrix[i][j]){
            return true;
        }
    }
    return false;
}

//this is O(nlogn) solution
//we are using divide and conquer method for this
//couple of base cases here
//if we observe left top is smallest and right bottom is the largest
//so if target is out of these boundaries we return false
//now we check in the middle column till element is <= target
//that tells us that we don't have element in the right quadrant
//so we do recursive call on the rest of the area
public boolean searchMatrix(int[][] matrix, int target){
    int m = matrix.length;
    if(m == 0) return false;
    int n = matrix[0].length;
    return util(matrix, target, 0, 0, m-1, n-1);
}

private boolean util(int[][] matrix, int target, int left, int top, int bottom, int right){
    if(left > right || top > bottom) return false;
    if(target < matrix[top][left] || target > matrix[bottom][right]) return false;

    int midCol = (left+right)/2;
    int row = top;
    while(row <= bottom && matrix[row][midCol] <= target){
        if(matrix[row][midCol] == target) return true;
        row++;
    }

    return util(matrix, target, left, top, bottom, midCol-1) || util(matrix, target, midCol+1, top, row-1, right);
}