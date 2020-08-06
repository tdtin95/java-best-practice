package vn.tdtin.contest;

import java.util.Scanner;

public class AreaOfRectangle {

    //Algorithm complexity O(1)
    public static int getArea (int width, int height) throws Exception {
        if( width > 1024 || height > 1024 ) throw  new Exception("Input is greater than 1024");

        return width * height;

    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in).useRadix(10);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        System.out.println(getArea(width, height));
    }
}
