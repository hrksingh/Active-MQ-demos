package com.atrium;

public class PalindromeHamming {

	public static void main(String[] args) {

		String word = "Nurses run";
		String reverseOfWord = new StringBuilder(word.toLowerCase()).reverse().toString();
		long totalTimeTaken = 0L;
		PalindromeHamming palindromeHamming = new PalindromeHamming();

		for (int i = 0; i <= 1000000; i++) {
			long startTime = System.nanoTime();
			palindromeHamming.isStringPalindrome(word, reverseOfWord);
			long duration = System.nanoTime() - startTime;
			totalTimeTaken += duration;
		}
		
		System.out.println("Total Time Taken by Hamming method for 1 million iterations is : "+totalTimeTaken/10000000+ " ms");
	}

	private boolean isStringPalindrome(String word, String reverseOfWord) {
		return (xorOfTwoString(word.toLowerCase(), reverseOfWord).contains("1")) ? false : true;

	}

	private StringBuilder stringToBinary(String s) {
		StringBuilder binaryRepOfString = new StringBuilder();
		byte[] bytes = s.getBytes();
		for (byte b : bytes) {
			binaryRepOfString.append(Integer.toBinaryString(b));
		}
		return binaryRepOfString;
	}

	private String xorOfTwoString(String word, String reverseOfWord) {
		stringToBinary(word);
		stringToBinary(reverseOfWord);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			builder.append(word.charAt(i) ^ reverseOfWord.charAt(i));
		}
		return builder.toString();

	}
}
