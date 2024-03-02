package Main;

public class Point {

    private int x;
    private int y;

    private boolean toRemove;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        toRemove = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public boolean isToRemove() {
        return toRemove;
    }

    public void setToRemove(boolean toRemove) {
        this.toRemove = toRemove;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public double odleglosc(Point point){
        return Math.sqrt((this.x-point.x)*(this.x-point.x)+(this.y-point.y)*(this.y-point.y));
    }
}
