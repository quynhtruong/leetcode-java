package programming.codility;

import java.util.*;


public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        if (friend.equals(this)) return true;
        Set<Friend> friendSet = new HashSet<>();
        friendSet.add(this);
        Deque<Friend> queue = new LinkedList<>();
        queue.addLast(this);
        while(!queue.isEmpty()) {
            Friend first = queue.removeFirst();
            if (first.friends != null) {
                for(Friend neighbor: first.friends) {
                    if (neighbor.equals(friend)) return true;
                    if (!friendSet.contains(neighbor)) {
                        friendSet.add(neighbor);
                        queue.addLast(neighbor);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        Friend d = new Friend("D");
        Friend e= new Friend("E");

        a.addFriendship(b);
        b.addFriendship(c);
        b.addFriendship(d);

        System.out.println(a.canBeConnected(b));
    }
}
