import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class RandomWalk {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;
        int dir = 0;
        int stepSize = 1;
        boolean running = true;
        while (running) {
            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < stepSize; i++) {

                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(x, y, 0.45);


                    switch (dir) {
                        case 0 -> x--;
                        case 1 -> y++;
                        case 2 -> x++;
                        case 3 -> y--;
                    }
                    steps++;


                    if (Math.abs(x) > n || Math.abs(y) > n) {
                        running = false;
                        break;
                    }


                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x, y, 0.45);

                    StdDraw.show();
                    StdDraw.pause(40);
                }
                if (!running) break;
                dir = (dir + 1) % 4;
            }
            stepSize++;
        }
        StdOut.println("Total steps = " + steps);
    }

}

