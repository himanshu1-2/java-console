//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

class Calculator {
    ArrayList<String> history = new ArrayList<>();

    public void showOperations() {
        System.out.println("Welcome to the calculator app");
        System.out.println("1.Addition");
        System.out.println("2.Subtraction");
        System.out.println("3.Divison");
        System.out.println("4.Multiplication");
        System.out.println("5.Modulus");
        System.out.println("6.Percentage");
        System.out.println("7.Factorial");
        System.out.println("8.Exponential");
        System.out.println("9.Square root");
        System.out.println("10.logarithm");
        System.out.println("15.Show History");
        System.out.println("16.exit");
    }

    public int takeUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    //TODO create more general input
    //TODO restrict user to type anything or show error
    public double perFormOperation(int input) throws ArithmeticException  {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        switch (input) {
            case 1:
                result = performAddition(scanner);
                history.add("Addition" + " = " + result);
                break;
            case 2:
                result = performSubtraction(scanner);
                history.add("Subtraction" + " = " + result);
                break;
            case 3:
                System.out.println("Enter two numbers ");
                double num1 = scanner.nextDouble();
                double num2 = scanner.nextDouble();
                result = performDivision(num1, num2);
                history.add("Division" + num1 + " / " + num2 + " = " + result);
                break;
            case 4:
                result = performMultiplication(scanner);
                history.add("Multiplication" + " = " + result);
                break;

            case 5:
                System.out.println("Enter two numbers ");
                double modNum1 = scanner.nextDouble();
                double modNum2 = scanner.nextDouble();
                result = performModulus(modNum1, modNum2);
                history.add("Modulus " + modNum1 + " % " + modNum2 + " = " + result);
                break;
            case 6:
                System.out.println("Enter two numbers ");
                double perNum1 = scanner.nextDouble();
                double perNum2 = scanner.nextDouble();
                result = performPercentage(perNum1, perNum2);
                history.add("Percentage" + perNum1 + " % " + perNum2 + " = " + result);
                break;

            case 7:
                System.out.println("Enter a number");
                int fact = scanner.nextInt();
                result = performFactorial(fact);
                history.add("Factorial of " + fact + " ! " + " = " + result);
                break;
            case 8:
                System.out.println("Enter base and power");
                int baseNumber = scanner.nextInt();
                int power = scanner.nextInt();
                result = performExponential(baseNumber, power);
                history.add("Exponential" + baseNumber + "a^b " + power + " = " + result);
                break;
            case 9:
                System.out.println("Enter a number");
                int number = scanner.nextInt();
                result = performRoot(number);
                history.add("Square root " + number + " = " + result);
                break;
            case 10:
                System.out.println("Enter base and value");
                int base = scanner.nextInt();
                int value = scanner.nextInt();
                result = performLog(base, value);
                history.add("log of " + base + "to" + value + " = " + result);
                break;
            default:
                System.out.println("Invalid option");
                break;

        }
        return result;
    }

    private double performLog(int num1, int num2) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(Math.log(num1) / Math.log(num2)));
    }

    private double performRoot(int num1) {
        return Math.sqrt(num1);
    }

    private double performFactorial(int fact) {
        int result = 1;
        if (fact == 0)
            return 1;
        for (int i = 1; i <= fact; i++) {
            result *= i;
        }
        return result;
    }

    private double performExponential(int base, int power) {
        return Math.pow(base, power);
    }

    private double performPercentage(double perNum1, double perNum2) {
        if (perNum2 == 0) {
            throw new ArithmeticException("Modulus by zero is not allowed.");
        }
        return (perNum1 / perNum2) * 100;
    }

    private double performModulus(double modNum1, double modNum2) {
        if (modNum2 == 0) {
            throw new ArithmeticException("Percentage by zero is not allowed.");
        }
        return modNum1 % modNum2;
    }

    private double performSubtraction(Scanner scanner) {
        System.out.println("Enter numbers to subtract (separated by space), type 'any' to finish:");
        double result = 0;
        while (scanner.hasNextDouble()) {
            double num = scanner.nextDouble();
            result -= num;
        }
        return result;
    }

    private double performAddition(Scanner scanner) {
        System.out.println("Enter numbers to add (separated by space), type 'any' to finish:");
        double result = 0;
        while (scanner.hasNextDouble()) {
            double num = scanner.nextDouble();
            result += num;
        }
        return result;
    }

    private double performDivision(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.parseDouble(df.format(num1 / num2));
    }

    public void showHistory() {
        for (String s : history) {
            System.out.println(s);
        }
    }

    private double performMultiplication(Scanner scanner) {
        System.out.println("Enter numbers to multiply (separated by space), type 'any' to finish:");
        double result = 1;
        while (scanner.hasNextDouble()) {
            double num = scanner.nextDouble();
            result *= num;
        }
        return result;
    }

}

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Calculator calculator = new Calculator();
        while (true) {
            calculator.showOperations();
            int input = calculator.takeUserInput();
            if (input == 15) {
                calculator.showHistory();
            } else if (input == 16) {
                System.out.println("exited");
                break;
            } else {
                try {
                    double result = calculator.perFormOperation(input);
                    System.out.println("result" + result);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }

    }
}