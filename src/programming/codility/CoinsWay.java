package programming.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by truongq on 7/12/18.
 */
public class CoinsWay {
	public int solution(String S) {
		// write your code in Java SE 8
		String[] splited = S.split("\n");

		Map<String, Long> phoneTimeMap = new HashMap<>();
		String maxPhone = null;
		Long maxTime = -1l;
		for (String line : splited) {
			System.out.println(line);
			String[] timeAndPhone = line.split(",");
			String time = timeAndPhone[0];
			String phone = timeAndPhone[1];
			phoneTimeMap.put(phone, phoneTimeMap.getOrDefault(phone, 0l) + getTimeSeond(time));
			if (phoneTimeMap.get(phone) > maxTime) {
				maxPhone = phone;
				maxTime = phoneTimeMap.get(phone);
			}
		}
		phoneTimeMap.remove(maxPhone);

		long money = 0;
		for (String s : phoneTimeMap.keySet()) {
			long time = phoneTimeMap.get(s);
			if (time < 5 * 60) {
				money += time * 3;
			} else if (time == 5 * 60) {
				money += 750;
			} else {
				long minute = time / 60 + 1;
				money += minute * 150;
			}
		}
		return (int) money;
	}

	private Long getTimeSeond(String time) {
		String[] times = time.split(":");
//        System.out.println(Arrays.toString(times));
		return Long.valueOf(times[0]) * 3600 + Long.valueOf(times[1]) * 60 + Long.valueOf(times[2]);
	}

	public static void main(String[] args) {
		String input = "00:01:07,400-234-090\n" +
			"00:05:01,701-080-080\n" +
			"00:05:00,400-234-090";
		int solution = new CoinsWay().solution(input);
		System.out.println(solution);
	}
}
