package programming.leetcode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExclusiveFunctionCall {
    class Entity {
        public int type, index, value;

        public Entity(int type, int index, int value) {
            this.type = type;
            this.index = index;
            this.value = value;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (n == 0) return result;
        LinkedList<Entity> stack = new LinkedList<>();
        Map<Integer, Integer> timeMap = new HashMap<>();
        for (String line : logs) {
            String[] tokens = line.split(":");
            Integer index = Integer.parseInt(tokens[0]);
            Integer time = Integer.parseInt(tokens[2]);
            if ("start".equals(tokens[1])) {
                stack.addLast(new Entity(0, index, time));
            } else {
                int totalMinusTime = 0;
                while (!stack.isEmpty() && stack.peekLast().type == 1) {
                    totalMinusTime += stack.removeLast().value;
                }
                Entity entity = stack.removeLast();
                index = entity.index;
                Integer consumedTime = time - entity.value + 1 - totalMinusTime;
                Integer totalTime = timeMap.get(index);
                if (totalTime == null) totalTime = 0;
                timeMap.put(index, totalTime + consumedTime);
                stack.addLast(new Entity(1, index, time - entity.value + 1));
            }
        }//end for line
        for (Integer i = 0; i < n; i++) {
            if (timeMap.get(i) == null) result[i] = 0;
            else result[i] = timeMap.get(i);
        }
        return result;

    }


}