package ru.netology;

import java.util.Random;

public class Main {
	
	public static String beauty3 = "";
	public static String beauty4 = "";
	public static String beauty5 = "";


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

		new Thread(() -> {
			
		});
		new Thread(() -> {
			
		});
		new Thread(() -> {
			
		});

		System.out.println("Красивых слов с длиной 3: " + beauty3 + " шт");
		System.out.println("Красивых слов с длиной 4: " + beauty4 + " шт");
		System.out.println("Красивых слов с длиной 5: " + beauty5 + " шт");


	}
}
