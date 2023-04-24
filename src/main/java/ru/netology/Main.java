package ru.netology;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Arrays;

public class Main {
	
	public static AtomicInteger beauty3 = new AtomicInteger(0);
	public static AtomicInteger beauty4 = new AtomicInteger(0);
	public static AtomicInteger beauty5 = new AtomicInteger(0);


	public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

	public static void main(String[] args) {

		Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

		// слово является палиндромом
		new Thread(() -> {
			for (String text: texts) {
				StringBuilder reverse = new StringBuilder();
				for (int i = text.length() - 1; i >= 0; i--) {
					reverse.append(text.charAt(i));
				}
				if (text.equals(reverse.toString())) {
					if(text.length() == 3) beauty3.incrementAndGet();
					if(text.length() == 4) beauty4.incrementAndGet();
					if(text.length() == 5) beauty5.incrementAndGet();
				}
			}	
		}).start();

		// слово состоит из одной и той же буквы,
		new Thread(() -> {
			for (String text: texts) {
				boolean isEquals = true;
				for (int i = 0; i < 0; i++) {
					if (text.charAt(i) != text.charAt(0)) {
						isEquals = false;
					}
				}
				if (isEquals) {
					if(text.length() == 3) beauty3.incrementAndGet();
					if(text.length() == 4) beauty4.incrementAndGet();
					if(text.length() == 5) beauty5.incrementAndGet();
				}
			}
		}).start();

		// буквы в слове идут по возрастанию
		new Thread(() -> {
			for (String text: texts) {
				boolean isSorted = false;
				char[] textChars = text.toCharArray();
				Arrays.sort(textChars);
				String textSorted = new String(textChars);
				if(text.equals(textSorted)) {
					isSorted = true;
				}

				if (isSorted) {
					if(text.length() == 3) beauty3.incrementAndGet();
					if(text.length() == 4) beauty4.incrementAndGet();
					if(text.length() == 5) beauty5.incrementAndGet();
				}
			}
		}).start();

		System.out.println("Красивых слов с длиной 3: " + beauty3 + " шт");
		System.out.println("Красивых слов с длиной 4: " + beauty4 + " шт");
		System.out.println("Красивых слов с длиной 5: " + beauty5 + " шт");
	}
}
