import java.util.ArrayList;
import java.util.List;

public class SolutionPart1{
    private static final int INPUT = 312051;

    public static void main(String[] args) {
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

        List<Integer> ends = new ArrayList<>();

        //Counter is number of spaces in given direction
        //cr counts the number at that space
        int counter = 0;
        do {
            cr += r;
            r += diff;
            counter++;
        } while(cr < INPUT);
        ends.add(cr);
        System.out.println(counter);

        counter = 0;
        do {
            cl += l;
            l += diff;
            counter++;
        } while(cl < INPUT);
        ends.add(cl);
        System.out.println(counter);

        counter = 0;
        do {
            cu += u;
            u += diff;
            counter++;
        } while(cu < INPUT);
        ends.add(cu);
        System.out.println(counter);

        counter = 0;
        do {
            cd += d;
            d += diff;
            counter++;
        } while(cd < INPUT);
        ends.add(cd);
        System.out.println(counter);

        int diffs = 0;
        for(int i : ends){
            int temp = Math.abs(i - INPUT);

            if(temp < diffs || diffs == 0){
                diffs = temp;
            }
        }

        System.out.println(diffs);
    }
}