package vn.tdtin.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] params = input.split(" ");

        Point P1 = new Point(Integer.parseInt(params[0]), Integer.parseInt(params[1]));

        input = br.readLine();
        params = input.split(" ");

        Point P2 = new Point(Integer.parseInt(params[0]), Integer.parseInt(params[1]));

        input = br.readLine();
        params = input.split(" ");

        Point P3 = new Point(Integer.parseInt(params[0]), Integer.parseInt(params[1]));

        Point result = findPoint(P1,P2,P3);
        System.out.println(result.getX() + " " + result.getY());
    }
    private static Point findPoint(Point p1, Point p2, Point p3) {
        double distance1 = p1.distance(p2) ;
        double distance2 = p1.distance(p3) ;
        if(distance1 == distance2){
            return createPoint(p1, p2,p3);
        }
        return distance1 < distance2 ? createPoint(p2,p1,p3) : createPoint(p3, p1, p2);

    }
    private static Point createPoint(Point pointHasTwoEdge, Point p1, Point p2) {
       Point vector = new Point(pointHasTwoEdge.getX() -p1.getX(), pointHasTwoEdge.getY() - p1.getY());
       return new Point(p2.getX() - vector.getX(), p2.getY() - vector.getY());

    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public double distance(Point p) {
            return Math.sqrt(Math.pow(Float.valueOf(p.getX() - this.getX()),2)  + Math.pow(Float.valueOf(p.getY() - this.getY()),2));
        }
    }
}
