package IgnitersHubAssignment;

import java.util.Scanner;

public class Ch4StringManipulation {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a sentence: ");
	        String sentence = scanner.nextLine();

	        // 1. Count the number of words
	        int wordCount = countWords(sentence);
	        System.out.println("Number of words: " + wordCount);

	        // 2. Reverse the order of words
	        String reversedSentence = reverseWords(sentence);
	        System.out.println("Reversed sentence: " + reversedSentence);

	        // 3. Replace spaces with hyphens
	        String sentenceWithHyphens = replaceSpacesWithHyphens(sentence);
	        System.out.println("Modified sentence: " + sentenceWithHyphens);
	    }

	    public static int countWords(String sentence) {
	        String[] words = sentence.split(" "); // Split by one whitespace characters
	        return words.length;
	    }

	    public static String reverseWords(String sentence) {
	        String[] words = sentence.split(" ");
	        String reversed = "";
	        for (int i = words.length - 1; i >= 0; i--) {
	            reversed= reversed +" "+ words[i];
	        }
	        return reversed; 
	    }

	    public static String replaceSpacesWithHyphens(String sentence) {
	        return sentence.replaceAll(" ", "-");

	}

}
