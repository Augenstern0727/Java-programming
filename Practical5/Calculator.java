class NotDivisibleException extends Exception {
    public NotDivisibleException(String message) {
        super(message);
    }
}

public class Calculator {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) throws NotDivisibleException {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero");
        }

        if (num1 % num2 != 0) {
            throw new NotDivisibleException("Not divisible");
        }

        return num1 / num2;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int resultAdd = calculator.add(5, 3);
        int resultSubtract = calculator.subtract(10, 4);
        int resultMultiply = calculator.multiply(6, 2);

        System.out.println("Addition: " + resultAdd);
        System.out.println("Subtraction: " + resultSubtract);
        System.out.println("Multiplication: " + resultMultiply);
    }
}