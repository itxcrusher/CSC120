package past.tracing;

public class Baseball implements Ball {
    private int height;
    private String name;

    public Baseball(String name) {
        height = 1;
        this.name = name;
    }

    public String toString() {
        return "Baseball " + name + " with height " + getHeight();
    }

    public int getHeight() {
        return height;
    }

    public void bounce(int force) {
        System.out.println("Bouncing baseball");
        height += (int) (force / 2.0);
    }
}