package IgnitersHubAssignment;

import java.util.Scanner;

public class Ch2pallindromeChecker {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);		
		int i=0;	
		String rev="";
		System.out.print("Enter a string : racecar -");
		String str= s.nextLine();
		
		for(i=str.length()-1;i>=0;i--) {		
			rev= rev + str.charAt(i);
		}
		if (str.equals(rev))
		{
			System.out.println("The string '"+str+"' is a palindrome.");
		}
		else {
			System.out.println("Not a Palindrome");
		}

	}

}
