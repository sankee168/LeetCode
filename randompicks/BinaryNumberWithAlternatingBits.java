//We know that n%2 will give the last bit. so we track last bit and compare in the next iteration till n is 0
//time complexity: O(1) as integer max value 2^32, while loop runs max of 32 times
public boolean hasAlternatingBits(int n) {
        int curBit = n%2;
        n = n/2;
        while(n != 0){
            if(curBit == n%2) return false;
            curBit = n%2;
            n = n/2;
        }
        return true;
    }

//assume n is the valid number with alternating bits
//then if we right shift by one bit, ones will become zeros and viceversa
//if we xor them, we will have all ones
//if we add 1 to it then we will have most significant bit as 1 and rest as 0
//and it with previous n and you should get 0
public boolean hasAlternatingBits(int n){
	n = n ^ (n>>1)
	return (n & n+1 == 0);
}