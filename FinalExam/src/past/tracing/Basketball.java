package past.tracing;

public class Basketball implements Ball {

    private int height;
    private String name;

    public Basketball(String name) {
        height = 2;
        this.name = name;
    }

    public String toString() {
        return "Basketball " + name + " with height " + getHeight();
    }

    public int getHeight() {
        return height;
    }

    public void bounce(int force) {
        System.out.println("Bouncing basketball");
        height += (int) (force * 2.0);
    }
}