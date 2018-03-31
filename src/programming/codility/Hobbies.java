package programming.codility;

import java.util.*;

public class Hobbies {

    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();
    private Map<String, List<String>> hobbyMap = new HashMap<>();

    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
        for(String hobby: hobbies) {
            List<String> hobbyList = this.hobbyMap.get(hobby);
            if (hobbyList == null) hobbyList = new ArrayList<>();
            hobbyList.add(hobbyist);
            this.hobbyMap.put(hobby, hobbyList);
        }
    }

    public List<String> findHobbyists(String hobby) {
        return hobbyMap.get(hobby) != null ? hobbyMap.get(hobby) : new ArrayList<>();
    }

    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("John", "Piano", "Puzzles", "Yoga");
        hobbies.add("Adam", "Drama", "Fashion", "Pets");
        hobbies.add("Mary", "Magic", "Pets", "Puzzles");
        System.out.println(hobbies.findHobbyists("Yoga").size());
        System.out.println(Arrays.toString(hobbies.findHobbyists("Puzzles").toArray()));
    }
}