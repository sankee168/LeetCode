//we store the given timestamp and log id in the List<String[]> where each string[] is of size 2
//in retrieve we compare the substring of the timestamp till that granularity index. 
//put is O(1) time complexity
//retrieve is O(n) time complexity
public class LogSystem {
    
    List<String[]> timestamps = new LinkedList<>();
    List<String> units = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
    int[] indices = new int[]{4,7,10,13,16,19};
    
    public void put(int id, String timestamp) { timestamps.add(new String[]{Integer.toString(id), timestamp}); }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new LinkedList<>();
        int idx = indices[units.indexOf(gra)];
        for (String[] timestamp : timestamps) {
            if (timestamp[1].substring(0, idx).compareTo(s.substring(0, idx)) >= 0 &&
               	timestamp[1].substring(0, idx).compareTo(e.substring(0, idx)) <= 0) res.add(Integer.parseInt(timestamp[0]));
        }
        return res;
    }
}