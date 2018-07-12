//Time complexity: O(n)
//Space complexity: O(1)
public int findCelebrity(int n) {
	int celebrity = 0;

	//if celebrity knows guest, then he is not celebrity. update the celebrity with guest. he might be potential celebrity
	//when actualy celebrity index is reached, he will not know any of the guests so celebrity entity is not updated
	for(int guest = 0; guest < n; guest++){
		if(knows(celebrity, guest)) celebrity = guest;
	}

	//double check if celebrity doesn't know guest from begining. In the first loop, we checked indices after celebrity. 
	//In this loop we will check previous indices
	for(int guest = 0; guest < celebrity; guest++){
		if(knows(celebrity, guest)) return -1;
	}

	//This loop is to check if all the guests know celebrity. 
	for(int guest = 0; guest < n; guest++){
		if(!knows(guest, celebrity)) return -1;
	}

	return celebrity;
}