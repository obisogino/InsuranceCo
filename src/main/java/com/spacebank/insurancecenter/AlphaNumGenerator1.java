package com.spacebank.insurancecenter;

import java.util.Random;

public class AlphaNumGenerator1 {

	static String CHAR_L = "abcdefghijklmnopqrstuvwxyz";

	static String CHAR_U = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	static String NUM = "1234567890";

	static String CHAR_S = "!@# $%^&*()_=+";

//	static final int PASSWORD_LENGTH = 8;
	
	public static String generateNumeric(Integer length) {
		StringBuffer randPass = new StringBuffer();

		char ch;

		for (int i = 0; i < length; i++) {
			if (randPass.length() < length)
			{
				ch = NUM.charAt(getRandomNumber(NUM.length()));
				randPass.append(ch);
			}
		}

		return randPass.toString();
	}

	public static String generateAlphaNum(Integer length) {

		StringBuffer randPass = new StringBuffer();

		char ch;

		for (int i = 0; i < length; i++) {

			if (randPass.length() < length)

			{

				ch = CHAR_L.charAt(getRandomNumber(CHAR_L.length()));

				randPass.append(ch);

			}

			if (randPass.length() < length)

			{

				ch = CHAR_U.charAt(getRandomNumber(CHAR_U.length()));

				randPass.append(ch);

			}

			if (randPass.length() < length)

			{

				ch = NUM.charAt(getRandomNumber(NUM.length()));

				randPass.append(ch);

			}

			// if(randPass.length() < PASSWORD_LENGTH )
			// {
			//
			// ch = CHAR_S.charAt(getRandomNumber(CHAR_S.length()));
			//
			// randPass.append(ch);
			//
			// }

		}

		return randPass.toString();

	}

	public static int getRandomNumber(Integer index) {

		int randomInt = 0;

		Random randomGenerator = new Random();

		randomInt = randomGenerator.nextInt(index - 1);

		return randomInt;

	}


//	public static String generateNumber(Integer length) {
//		
////		return RandomStringUtils.randomNumeric(length);
//	}
}
