package vn.tdtin.java.practice.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class BalanceStringTest {

    @Test
    public void should_return_balance_string() {
        Assert.assertTrue(isBalanceString("AaBb"));
    }

    @Test
    public void should_return_false_when_found_unbalance_string() {
        Assert.assertFalse(isBalanceString("AbCa"));
    }

    @Test
    public void should_found_shortest_balance_subString_length() {
        Assert.assertEquals(getShortestBalanceStringLengthOptimized("azABaabza"), 5);
        Assert.assertEquals(getShortestBalanceStringLengthOptimized("AcZCbaBz"), 8);
        Assert.assertEquals(getShortestBalanceStringLengthOptimized("ABCDabcdABCabc"), 6);
        Assert.assertEquals(getShortestBalanceStringLengthOptimized("ABCDabcdzABCabc"), 6);

    }

    @Test
    public void should_return_negativeone_when_no_balance_string() {
        Assert.assertEquals(getShortestBalanceStringLengthOptimized("TacoCat"), -1);
        Assert.assertEquals(getShortestBalanceStringLengthOptimized("qwertyhjk"), -1);
    }

    private int getShortestBalanceStringLength(String s) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                if(isBalanceString(subString)) {
                    min = min > subString.length() ? subString.length() :  min;
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private int getShortestBalanceStringLengthOptimized(String s) {
        int min = Integer.MAX_VALUE;
        int maxLength = 2 ;
        while (maxLength <= s.length()) {
            for(int i= 0; i <= s.length() - maxLength; i++) {
                String subString = s.substring(i, i + maxLength);
                if(isBalanceString(subString)) {
                    return subString.length();
                }
            }
            maxLength++;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean isBalanceString(String s) {
        Set<Character> balanceChars = new HashSet<>();
        Set<Character> unbalanceChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            balanceChars.add(currentChar);
            if (balanceChars.contains(Character.toUpperCase(currentChar)) && balanceChars.contains(Character.toLowerCase(currentChar))) {
                unbalanceChars.remove(Character.toUpperCase(currentChar));
                unbalanceChars.remove(Character.toLowerCase(currentChar));
            } else {
                unbalanceChars.add(currentChar);
            }
        }
        return unbalanceChars.isEmpty();

    }
}
