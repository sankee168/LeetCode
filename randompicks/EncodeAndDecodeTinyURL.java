//We can use integer as key but we will be restricted with size of integers
//We can use hashcode of the string but we might have collisions
//We can use hybrid approach hashcode plus randomly generated string as shown below to decrease the collision
//here we are using these alphanumeric string and generating random 6 char string as the key
private static String prefix = "http://tinyurl.com/";
private static String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
Map<String, String> map = new HashMap<>();
private String getString(String longUrl){
    Random rand = new Random();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 6; i++){
        sb.append(alphabet.charAt(rand.nextInt(62)));
    }
    return sb.toString();
}
// Encodes a URL to a shortened URL.
public String encode(String longUrl) {
    String key = getString(longUrl);
    while(map.containsKey(key)){key = getString(longUrl);}
    map.put(key, longUrl);
    return prefix+key;
}
// Decodes a shortened URL to its original URL.
public String decode(String shortUrl) {
    String key = shortUrl.substring(prefix.length());
    System.out.println(key);
    return map.get(key);
}