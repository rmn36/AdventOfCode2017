import java.awt.*;

public class SolutionPart2 {
    private static final int INPUT = 312051;

    public static void main(String[] args) {
        SolutionPart2 solution = new SolutionPart2();
        System.out.println(solution.solve());
    }

    private int solve() {
        int[][] grid = new int[64][64];
		Point origin= new Point(grid.length / 2, grid.length / 2);
		store(grid, origin, 1);
		int max= 1000;
		for (int i = 2; i < max; i++) {
			Point spiralPoint= spiral(i);
			Point target= withOrigin(origin, spiralPoint);
			int value= sumOfNeighbours(grid, target);
			if (value > INPUT) {
				return value;
			}
			store(grid, target, value);
		}
		return -1;
	}

	private void store(int[][] grid, Point target, int value) {
		grid[target.x][target.y]= value;
	}

	private int sumOfNeighbours(int[][] grid, Point target) {
		int sum= 0;
		sum+= grid[target.x + 1][target.y];
		sum+= grid[target.x + 1][target.y + 1];
		sum+= grid[target.x][target.y + 1];
		sum+= grid[target.x - 1][target.y + 1];
		sum+= grid[target.x - 1][target.y];
		sum+= grid[target.x - 1][target.y - 1];
		sum+= grid[target.x][target.y - 1];
		sum+= grid[target.x + 1][target.y - 1];
		return sum;
	}

	private Point spiral(int target) {
		double k= Math.ceil((Math.sqrt(target)-1)/2);
		double t= 2*k+1;
		double m= t * t;
		t=t-1;

		if (target >= m-t) {
			return point(k-(m-target), -k);
		} else {
			m=m-t;
		}

		if (target >= m-t) {
			return point(-k, -k+(m-target));
		} else  {
			m=m-t;
		}

		if (target >= m-t) {
			return point(-k+(m-target), k);
		}  else  {
			return point(k, k-(m-target-t));
		}
	}

	private Point point(double x, double y) {
		return new Point((int)x, (int)y);
    }
    
    private Point withOrigin(Point origin, Point target) {
		return new Point(origin.x + target.x, origin.y + target.y);
	}
}
