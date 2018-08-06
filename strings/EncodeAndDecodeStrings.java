//we will be appending size of curr string and then any character which you can identify and then string.
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> iter = strs.iterator();        
		while(iter.hasNext()){
			String curr = iter.next();
			sb.append(curr.length()).append("/").append(curr);
		}
		return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	List<String> list = new ArrayList<>();
        if(s.length() == 0) return list;
        int i = 0, j = 0;
        while(j < s.length()){
        	while(s.charAt(j) != '/') j++;
        	int size = Integer.parseInt(s.substring(i, j));
        	i = j+1; j = i+size;
        	list.add(s.substring(i, j));
        	i = j;
        }

        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
