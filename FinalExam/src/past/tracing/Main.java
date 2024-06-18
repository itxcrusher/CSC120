package past.tracing;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Ball> balls = new ArrayList<Ball>();
        balls.add(new Basketball("Orange ball"));
        balls.add(new Baseball("White ball"));

        for (Ball b : balls) {
            bounce(b);
        }
    }

    private static void bounce(Ball b) {
        int oldY = b.getHeight();
        b.bounce(2);
        int newY = b.getHeight();
        System.out.println(b + " bounced with force 2, going from height " + oldY + " to new height " + newY);
    }
}