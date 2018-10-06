package programming.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by truongq on 6/17/18.
 */
public class ExamRoom {
	int N;
	TreeSet<Integer> seat;

	public ExamRoom(int N) {
		this.N = N;
		seat = new TreeSet<>();
	}

	public int seat() {
		if (seat.size() == 0) {
			seat.add(0);
			return 0;
		} else {
			Iterator<Integer> it = seat.iterator();
			Integer result = null, max = - 1;
			if (!seat.contains(N - 1)) {
				result = N - 1;
				max = N - 1 - seat.last();
			}
			if (!seat.contains(0) && seat.first() >= max) {
				result =  0;
				max = seat.first();
			}
			List<Integer> seatList = new ArrayList<>();
			while(it.hasNext()) {
				seatList.add(it.next());
			}
			for(int i = 1; i < seatList.size();i++) {
				int mid = (seatList.get(i) + seatList.get(i - 1))/2;
				int dis = Math.min(mid - seatList.get(i - 1), seatList.get(i) - mid);
				if (dis > max || (dis == max && (result == null || mid < result))) {
					result = mid;
					max = dis;
				}
			}
			seat.add(result);
			return result;
		}
	}

	public void leave(int p) {
		seat.remove(p);
	}
}
