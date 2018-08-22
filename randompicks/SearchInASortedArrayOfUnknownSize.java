//First we try to find the length of the array and then do a binary search
//For that to find the length of the array, we keep multipling the index by 2
//and check if that index value is accessible
//if not we take that as limit and do the binary search to find the length
//next do the binary search with that limit to find the target
//time complexity: 
//O(logn) for multplying by 2 every time we will be doing logn multiplications
//O(log(n/2)) as search space is n/2 to find the final n
//O(logn) for finding the target
//So overall it is logn
    public int search(ArrayReader reader, int target) {
        int i = 1;
        while(reader.get(i) != 2147483647) i *= 2;
        int n = findLast(reader, i/2, i);
        return findTarget(reader, target, n);
    }
    
    private int findLast(ArrayReader reader, int i, int j){
        while(i <= j){
            int mid = (i+j)/2;
            if(reader.get(mid) != 2147483647){
                i = mid+1;
            }else j = mid-1;
        }
        if(reader.get(i) != 2147483647) return i;
        else return i-1;
    }
    
    private int findTarget(ArrayReader reader, int target, int n){
        int i = 0, j = n;
        while(i <= j){
            int mid = (i+j)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target) j = mid-1;
            else i = mid+1;
        }
        return -1;
    }


//As given in the problem all the numbers are unique and can range from -9999 to 9999
//search space has limit of 20000 so do a binary search of 20000

public int search(ArrayReader reader, int target) {      
        return findTarget(reader, target, 20000);
    }
    
    private int findTarget(ArrayReader reader, int target, int n){
        int i = 0, j = n;
        while(i <= j){
            int mid = (i+j)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target) j = mid-1;
            else i = mid+1;
        }
        return -1;
    }