import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionPart1{
    private static final int INPUT = 312051;

    private class Cell {
        private Point p;

        public Point getPoint() {
            return p;
        }

        public void setPoint(Point p) {
            this.p = p;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }

        private Integer end;

        public Cell(Point p, Integer end){
            setEnd(end);
            setPoint(p);
        }


    }

    public static void main(String[] args) {
        new SolutionPart1().solve();
    }

    private void solve() {
        // Initial differences between squares from center in each direction
        int r = 1;
        int u = 3;
        int l = 5;
        int d = 7;

        // After initial difference, the differences increase by 8
        int diff = 8;

        int center = 1;
        int cr = center;
        int cl = center;
        int cu = center;
        int cd = center;

        List<Cell> ends = new ArrayList<>();

        //Counter is number of spaces in given direction
        //cr counts the number at that space
        int counter = 0;
        do {
            cr += r;
            r += diff;
            counter++;
        } while(cr < INPUT);
        ends.add(new Cell(new Point(counter,0), cr));
        System.out.println(counter);

        counter = 0;
        do {
            cl += l;
            l += diff;
            counter++;
        } while(cl < INPUT);
        ends.add(new Cell(new Point(counter,0), cl));
        System.out.println(counter);

        counter = 0;
        do {
            cu += u;
            u += diff;
            counter++;
        } while(cu < INPUT);
        ends.add(new Cell(new Point(0,counter), cu));
        System.out.println(counter);

        counter = 0;
        do {
            cd += d;
            d += diff;
            counter++;
        } while(cd < INPUT);
        ends.add(new Cell(new Point(0,counter), cd));
        System.out.println(counter);

        int abs_diff = 0;
        Point closest = new Point(0,0);
        for(Cell c : ends){
            Point p = c.getPoint();
            int i = c.getEnd();

            int dd = i - INPUT;
            int temp = Math.abs(dd);

            if(temp < abs_diff || abs_diff == 0){
                abs_diff = temp;
                closest.x = p.x != 0 ? p.x : abs_diff;
                closest.y = p.y != 0 ? p.y : abs_diff;
            }
        }

        System.out.println(Math.abs(closest.x) + Math.abs(closest.y));
    }

}