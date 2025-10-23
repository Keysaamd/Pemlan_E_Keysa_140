package Modul_1;

public class Main {

    public static double f(double x) {
        return x*x - 4; // f(x) = x^2 - 4 (akar = 2)
    }

    public static double bisection(double a, double b, double error) {
        if (f(a) * f(b) >= 0) {
            System.out.println("f(a) dan f(b) harus " + "berbeda tanda!");
            return Double.NaN;
        }

        double c = a;
        while ((b - a) >= error) {
            c = (a + b) / 2;

            if (f(c) == 0.0) break;
            else if (f(a) * f(c) < 0) b = c;
            else a = c;
        }

        return c;
    }

    public static void main(String[] args) {
        double a = 1.0, b = 3.0, error = 0.0001;
        double akar = bisection(a, b, error);

        System.out.printf("Akar persamaan: %.4f\n", akar);
        System.out.printf("f(akar) = %.6f\n", f(akar));
    }
}