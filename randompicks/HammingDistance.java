//we have to count the number of 1 bits in the xor.
//we can do that by xor and keep checking if last bit is one or not
//iterate over 32 bits
public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int count = 0;
    for(int i = 0; i < 32; i++){
    	count += (xor >> i)&1;
    }
    return count;
}

public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int count = 0;
    while(xor != 0){
        xor = xor & (xor-1);
        count++;
    }
    return count;
}