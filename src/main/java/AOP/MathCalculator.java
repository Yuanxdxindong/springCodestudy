package AOP;

public class MathCalculator {
    public int div(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }
}