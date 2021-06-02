package resources;

public class Point {

    private double x;
    private double y;
    private double r;
    private boolean hit;

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = checkHit(x,y,r);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public boolean isHit() {
        return hit;
    }

    public boolean checkHit(double x, double y, double r){
        if ((x >= 0) && (y <= 0)) return y / 2 - x >= -r / 2;
        else if ((x >= 0) && (y >= 0)) return false;
        else if ((x <= 0) && (y >= 0)) return x * x + y * y <= r * r;
        else if ((x <= 0) && (y <= 0)) return (x >= -r) && (y >= -r);
        else return false;
    }

    @Override
    public String toString() {
        return "| X = " + x + ", Y = " + y + " | R = " + r + " |" + " isShot = " + hit + " |";
    }
}
