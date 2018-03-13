package programming.codility;

import java.util.*;

public class Hobbies {

    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();

    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);

    }

    public List<String> findHobbyists(String hobby) {
        List<String> result = new ArrayList<>();
        for(String person: hobbies.keySet()) {
            for(String value: hobbies.get(person)) {
                if (value.equals(hobby)) {
                    result.add(person);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("John", "Piano", "Puzzles", "Yoga");
        hobbies.add("Adam", "Drama", "Fashion", "Pets");
        hobbies.add("Mary", "Magic", "Pets", "Reading");
        System.out.println(hobbies.findHobbyists("Yoga").size());
        System.out.println(Arrays.toString(hobbies.findHobbyists("Yoga").toArray()));
    }
}