import java.util.HashMap;
import java.util.Set;

public class HashMapJava {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("After Hours", "Test Lyrics 1");
        trackList.put("In Your Eyes", "Test Lyrics 2");
        trackList.put("Blind Lights", "Test Lyrics 3");
        trackList.put("Faith", "Test Lyrics 4");

        String name = trackList.get("In Your Eyes");
        System.out.println(name);

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key + ": " + trackList.get(key));
        }
    }
}