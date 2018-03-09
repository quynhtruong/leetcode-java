package programming.leetcode;

import java.util.Arrays;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        if (n == 0) return 0;
        int maxDeadline = 0;
        for (int[] course : courses) {
            maxDeadline = Math.max(maxDeadline, course[1]);
        }
        int[] f = new int[maxDeadline];
        Arrays.fill(f, 0);
        for (int i = 1; i <= maxDeadline; i++) {
            f[i] = f[i - 1];
            for (int[] course : courses) {
                if (i <= course[1] && i >= course[0]) {
                    f[i] = Math.max(f[i], f[i - course[0]] + 1);
                }
            }//end for course
        }//end for i
        return f[maxDeadline];
    }

}
