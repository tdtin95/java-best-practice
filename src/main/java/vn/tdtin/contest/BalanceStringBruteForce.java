package vn.tdtin.contest;

import java.util.*;


public class BalanceStringBruteForce {

    public static int getShortestBalanceLength(String s) {

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < s.length() ; i++) {
            for(int j = i+1 ; j <= s.length() ; j++){
                String subString = s.substring(i, j);
                //System.out.println(subString);
                if(isStringBalance(subString)) {
                    min = min > subString.length() ? subString.length() : min;
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min ;
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
