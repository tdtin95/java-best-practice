package vn.tdtin.contest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReverseString {

    private static String reverseWord(String s) {
        String reversedWord = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            reversedWord = reversedWord + s.charAt(i);
        }
        return reversedWord;
    }

    private static String reverseString (String s) {
        s = s.trim();
        String []words = s.split(" ");
        String reverseString = "";
        for (int i = 0 ; i < words.length ; i ++) {
            reverseString = reverseString + reverseWord(words[i]);
            if(i != words.length -1) {
                reverseString = reverseString + " ";
            }
        }
        return reverseString;
    }


    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        final int lineNumber = Integer.parseInt(input.trim());

        List<String> outputTexts = new ArrayList<>();
        for(int i = 0 ; i < lineNumber ; i ++) {
            String text = br.readLine();
            outputTexts.add(reverseString(text));
        }

        outputTexts.forEach(System.out::println);
    }
}
