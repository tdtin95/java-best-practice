package vn.tdtin.contest;

import java.io.*;
import java.util.*;

public class Pair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] sticks = input.split(" ");
        int target = Integer.parseInt(input = br.readLine());

        Set<Integer> traversedStrick = new HashSet<>();
        HashMap<Integer, Integer> results = new HashMap<>();

        for (int i = 0; i < sticks.length; i++) {
            int length = Integer.parseInt(sticks[i]);
            if (traversedStrick.contains(target - length)) {
                if (length > (target - length)) {
                    results.put(target - length, length);
                } else {
                    results.put(length, target - length);
                }
            } else {
                traversedStrick.add(length);
            }
        }


        int min = Integer.MAX_VALUE;

        Iterator<Integer> keys = results.keySet().iterator();
        while(keys.hasNext()) {
            int key = keys.next();
            min = key < min ? key : min;
        }

        System.out.println(min + " " + results.get(min));


        //Complexity is O(n), since we must loop n time throughout n sticks
    }
}
