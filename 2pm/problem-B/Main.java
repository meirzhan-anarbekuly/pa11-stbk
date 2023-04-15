import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your text: ");
        String text = in.nextLine();
        text = text.toUpperCase();

        HashMap<Character, Integer> counts = new HashMap<>();
        
        // count
        for (char c: text.toCharArray()) {
            if (counts.containsKey(c)) {
                // increment old value
                int oldCount = counts.get(c);
                counts.put(c, oldCount + 1);
                // System.out.println("seeing " + c + " again. incrementing its count to " + (oldCount + 1));
            } else {
                // we are seeing this char for the first time
                counts.put(c, 1);
                // System.out.println("seeing " + c  + " for the first time.");
            }
        }

        // print hashmap
        // first way
        // for (char c : counts.keySet()) {
        //     int countOfC = counts.get(c);
        //     System.out.println(String.format("%c -> %d", c, countOfC));
        // }

        // second way
        for (Map.Entry entry: counts.entrySet()) {
            System.out.println(String.format("%c -> %d", entry.getKey(), entry.getValue()));
        }

        // third way
        // System.out.println(counts);
    }
}