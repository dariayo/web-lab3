package utils;

public class AreaChecker {

    public static boolean check(double x, double y, double r) {
        return checkCircle(x, y, r) || checkTriangle(x, y, r) || checkSquare(x, y, r);
    }
    public static boolean checkSquare(double x, double y, double r) {
        return (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2) && x >= 0 && y <= 0);
    }
    public static boolean checkCircle(double x, double y, double r) {
        return (Math.abs(x) <= (r) && Math.abs(y) <= r && x <= 0 && y <= 0);
    }
    public static boolean checkTriangle(double x, double y, double r) {
        return (y <= -0.5 * x + r / 2 && x >= 0 && y >= 0);
    }
}
