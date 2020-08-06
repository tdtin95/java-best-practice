package vn.tdtin.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindow {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int k = Integer.parseInt(input);
        Deque<Integer> maxValueStorage = new LinkedList<Integer>();

        int i;
        List<Integer> S = new ArrayList<>();
        for(i = 0 ; i < k; i++) {
            S.add(Integer.parseInt(br.readLine()));
            while (!maxValueStorage.isEmpty() && S.get(i) >= S.get(maxValueStorage.peekLast())){
                maxValueStorage.removeLast();
            }
            maxValueStorage.addLast(i);
        }
        System.out.println(S.get(maxValueStorage.peek()));
        while(true) {
            int number = Integer.parseInt( br.readLine());
            S.add(number);
            while ((!maxValueStorage.isEmpty()) && maxValueStorage.peek() <= i - k)
                maxValueStorage.removeFirst();

            while ((!maxValueStorage.isEmpty()) && S.get(i) >= S.get(maxValueStorage.peekLast())) {
                maxValueStorage.removeLast();
            }
            maxValueStorage.add(i);
            i++;
            System.out.println(S.get(maxValueStorage.peek()));
        }

    }
}
