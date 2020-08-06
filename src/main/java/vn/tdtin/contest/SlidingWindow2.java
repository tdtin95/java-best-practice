package vn.tdtin.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindow2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        long W = Long.parseLong(input);
        Long currentIndex;
        List<Long> S = new ArrayList<>();
        S.add(Long.parseLong(br.readLine()));

        long max = S.get(0);

        for(currentIndex = Long.valueOf(1); currentIndex < W; currentIndex++) {
            S.add(Long.parseLong(br.readLine()));
            max = Math.max(max, S.get(currentIndex.intValue()));
        }
        System.out.println(max);
        currentIndex = W;
        Long windowFront = Long.valueOf(0);


        //O(n)
        while(true ) {
            long number =  Long.parseLong(br.readLine());
            S.add(number);
            if (S.get(currentIndex.intValue()) >= max) {
                max = S.get(currentIndex.intValue());
                System.out.println(max);
            }else if (S.get(windowFront.intValue()) < max) {
                System.out.println(max);
            }else {
                max = S.get(windowFront.intValue() + 1);
                for (int j = windowFront.intValue() + 2; j <= currentIndex; j++) {
                    max = Math.max(max, S.get(j));
                }
                System.out.println(max);
            }
            currentIndex++;
            windowFront++;
        }
    }
}
