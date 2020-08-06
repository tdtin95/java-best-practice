package vn.tdtin.contest;

import java.util.*;

public class BalanceStringSlidingWindow {

    public static int getShortestBalanceLength(String s) {
        if(s.length() < 2) return -1;
        int min = Integer.MAX_VALUE;
        int maxSubStringLength = 2;
        while (min == Integer.MAX_VALUE && maxSubStringLength <= s.length()) {
            for (int i = 0; i <= s.length() - maxSubStringLength ; i++) {
                String subString = s.substring(i,i + maxSubStringLength);
                if(isStringBalance(subString)) {
                    return subString.length();
                }
            }
            maxSubStringLength++;
        }

        return -1;

    }

    public static boolean isStringBalance(String s) {
        Set<Character> unbalanceChars = new HashSet<>();
        Set<Character> balanceChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            balanceChars.add(c);
            if (isBalance(balanceChars, c)) {
                removeBalanceChar(unbalanceChars, c);

            } else {
                unbalanceChars.add(c);
            }
        }
        return unbalanceChars.isEmpty();

    }

    public static boolean isBalance(Set<Character> s, Character c) {
        return s.contains(Character.toLowerCase(c)) && s.contains(Character.toUpperCase(c));
    }

    public static void removeBalanceChar(Set<Character> unbalanceChars, Character c) {
        unbalanceChars.remove(Character.toLowerCase(c));
        unbalanceChars.remove(Character.toUpperCase(c));
    }

    public static void main(String[] args) {
        System.out.println(getShortestBalanceLength("azABaabza"));
        System.out.println(getShortestBalanceLength("TacoCat"));
        System.out.println(getShortestBalanceLength("AcZCbaBz"));
        System.out.println(getShortestBalanceLength("ABCDabcdABCabc"));
        System.out.println(getShortestBalanceLength("ABCDzabcdABCabc"));

    }
}
