//Time complexity: O(nlogk) where n is the total number of elements in the words array and k is the number of elements being popped. 
//Space complexity: O(n)
class Freq {
	String word;
	int frequency;

	public Freq(String word, int frequency){
		this.word = word;
		this.frequency = frequency;
	}
}

class FreqComparator implements Comparator<Freq>{
	@Override
	public int compare(Freq freq1, Freq freq2){
		if(freq1.frequency > freq2.frequency) return -1;
		if(freq1.frequency == freq2.frequency){
            return (freq1.word).compareTo(freq2.word);
        } 
		else return 1;
	}
}
public List<String> topKFrequent(String[] words, int k) {
	Map<String, Integer> map = new HashMap<>();
	for(String curr: words){
		map.put(curr, map.getOrDefault(curr, 0)+1);
	}
	PriorityQueue<Freq> pq = new PriorityQueue<>(map.keySet().size(), new FreqComparator());
	for(Map.Entry<String, Integer> entry : map.entrySet()){
		Freq freq = new Freq(entry.getKey(), entry.getValue());
		pq.add(freq);
	}
	List<String> list = new ArrayList<>();
	while(pq.size() > 0 && k > 0){
		list.add(pq.remove().word);
       	k--;
	}
	return list;
}

//Rather than using frequency inner class we can write comparator based on map values.
//This is also same complexity
Map<String, Integer> map = new HashMap<>();
class FreqComparator implements Comparator<String>{
	@Override
	public int compare(String str1, String str2){
		if(map.get(str1) > map.get(str2)) return -1;
		if(map.get(str1) == map.get(str2)){
            return (str1).compareTo(str2);
        } 
		else return 1;
	}
}
public List<String> topKFrequent(String[] words, int k) {
	
	for(String curr: words){
		map.put(curr, map.getOrDefault(curr, 0)+1);
	}
	PriorityQueue<String> pq = new PriorityQueue<>(map.keySet().size(), new FreqComparator());
	for(Map.Entry<String, Integer> entry : map.entrySet()){
		pq.add(entry.getKey());
	}
	List<String> list = new ArrayList<>();
	while(pq.size() > 0 && k > 0){
		list.add(pq.remove());
       	k--;
	}
	return list;
}
