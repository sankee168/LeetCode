//This problem is mainly about handling all corner cases
//We have to slowly analyse the problem and write down all the failure cases
//Time complexity: O(n) where n is the size of the input
public String validIPAddress(String IP) {	
	if(validateIPv4Address(IP)) return "IPv4";
	if(validateIPv6Address(IP)) return "IPv6";
	return "Neither";
}

private boolean validateIPv4Address(String IP){
	//each index value is from 0 to 255
	//no leading 0s in index value
    if(IP.length() == 0) return false;
    if(IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.') return false;
    String[] arr = IP.split("\\.");
    if(arr.length !=4) return false;
	for(int i = 0; i < 4; i++){
		String curr = arr[i];
        // System.out.println(curr);
        if(curr.length() == 0 || curr.length() > 3) return false;
		if(curr.charAt(0) == '0' && curr.length() > 1) return false;
        for(int j = 0; j < curr.length(); j++){
            if(curr.charAt(j) < '0' || curr.charAt(j) > '9') return false;
        }
		int val = Integer.parseInt(curr);
		if(val > 255) return false;
	}
	return true;
}

private boolean validateIPv6Address(String IP){
	//we can omit leading 0s
	//each index value represents 16 bits
	//each index value length <= 4 and > 0
    if(IP.length() == 0) return false;
    if(IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':') return false;
	String[] arr = IP.split(":");
    if(arr.length != 8) return false;
	for(int i = 0; i < 8; i++){
		String curr = arr[i];
		if(curr.length() > 4 || curr.length() == 0) return false;
		for(int j = 0; j < curr.length(); j++){
			char hex = curr.charAt(j); 
			if((hex >= '0' && hex <= '9') || (hex >= 'a' && hex <= 'f') || (hex >= 'A' && hex <= 'F') ) continue;
			else return false;
		}
	}
	return true;
}