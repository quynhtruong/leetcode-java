package programming.leetcode;


import java.util.*;

class NestedInteger {
    public NestedInteger(){

    }
    public NestedInteger(int value){};
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){
        return 1;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){};

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){};

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){
        return null;
    }
}

public class MiniParser {
    public NestedInteger deserialize(String s) {
        int n = s.length();
        if (n == 0) return null;
        if (s.indexOf('[') < 0) {
            return new NestedInteger(Integer.parseInt(s));
        }
        Deque<Object> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        NestedInteger result = null;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '[':
                    stack.addLast("[");
                    sb = new StringBuilder();
                    break;
                case ',':
                    if (sb.length() > 0) {
                        stack.addLast(new NestedInteger(Integer.parseInt(sb.toString())));
                    }
                    sb = new StringBuilder();
                    break;
                case ']':
                    if (sb.length() > 0) {
                        stack.addLast(new NestedInteger(Integer.parseInt(sb.toString())));
                    }
                    sb = new StringBuilder();
                    Object top;
                    List<NestedInteger> tempList = new ArrayList<>();
                    while ((top = stack.removeLast()) != "[") {
                        tempList.add((NestedInteger) top);
                    }
                    NestedInteger newInteger = new NestedInteger();
                    Collections.reverse(tempList);
                    for(NestedInteger integer: tempList) newInteger.add(integer);
                    result = newInteger;
                    stack.addLast(newInteger);
                    break;
                default:
                    sb.append(ch);
                    break;
            }
        }
        return result;
    }
}
