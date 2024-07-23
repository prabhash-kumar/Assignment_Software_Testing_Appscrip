package prabhash.utilsFiles;

import java.util.Random;

public class RandomDataUtils {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String generateRandomMobileNumber() {
        Random random = new Random();
        StringBuilder mobileNumber = new StringBuilder("7"); 
        for (int i = 0; i < 9; i++) {
            mobileNumber.append(random.nextInt(10));
        }
        return mobileNumber.toString();
    }

    public static String generateRandomEmail() {
        Random random = new Random();
        StringBuilder email = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            email.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        email.append("@yopmail.com");
        return email.toString();
    }
}
