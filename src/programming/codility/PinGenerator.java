package programming.codility;

import java.util.*;

/**
 * Created by truongq on 10/6/18.
 */
public class PinGenerator {
	public static List<String> generatePin(int nPin) {
		Set<String> pinSet = new HashSet<>();
		Random rand = new Random();
		while(pinSet.size() < nPin) {
			String newPin = generateNewPin(rand);
			if (isValid(newPin)) {
				pinSet.add(newPin);
			}
		}
		return new ArrayList<>(pinSet);
	}

	private static String generateNewPin(Random rand) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			result.append(rand.nextInt(10));
		}
		return result.toString();
	}


	private static boolean isValid(String newPin) {
		for(int i = 1; i < 4; i++) {
			if (newPin.charAt(i) == newPin.charAt(i - 1)) return false;
			if (i > 1 && newPin.charAt(i) > newPin.charAt(i - 1) && newPin.charAt(i - 1) > newPin.charAt(i - 2)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		List<String> pinList = generatePin(1000);
		for(String pin: pinList) System.out.println(pin);
	}
}
