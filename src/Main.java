//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
class Calculator{
    ArrayList<String> history = new ArrayList<>();
    public void showOperations(){
     System.out.println("Welcome to the calculator app");
     System.out.println("1.Addition");
     System.out.println("2.Subtraction");
     System.out.println("3.Divison");
     System.out.println("4.Multiplication");
     System.out.println("5.Modulus");
     System.out.println("6.Percentage");
     System.out.println("10.Show History");

     System.out.println("11.exit");
    }
    public int takeUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public double perFormOperation(int input) throws ArithmeticException {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        switch (input) {
            case 1:
                result = performAddition(scanner);
                history.add("Addition"+ " = "  + result);
                break;
            case 2:
                result = performSubtraction(scanner);
                history.add("Subtraction" +  " = " + result);
                break;
            case 3:
                System.out.println("Enter two numbers ");
                double num1 =scanner.nextDouble();
                double num2 =scanner.nextDouble();
                result = performDivision(num1, num2);
                history.add("Division"+num1 + " / " + num2 + " = " + result);
                break;
            case 4:
                result = performMutiplication(scanner);
                history.add("Multiplication"+ " = " + result);
                break;

            case 5:
                System.out.println("Enter two numbers ");
                double modNum1 =scanner.nextDouble();
                double modNum2 =scanner.nextDouble();
                result = performModulus(modNum1, modNum2);
                history.add("Modulus "+modNum1 + " % " + modNum2 + " = " + result);
                break;
            case 6:
                System.out.println("Enter two numbers ");
                double perNum1 =scanner.nextDouble();
                double perNum2 =scanner.nextDouble();
                result = performPercentage(perNum1, perNum2);
                history.add("Percentage"+perNum1 + " % " + perNum2 + " = " + result);
                break;
//
//            case 5:
//                result = performFactorial(num1, num2);
//                history.add("Subtraction"+num1 + " - " + num2 + " = " + result);
//                break;
//            case 6:
//                result = performExpontienal(num1, num2);
//                history.add("Subtraction"+num1 + " - " + num2 + " = " + result);
//                break;
//            case 6:
//                result = performRoot(num1, num2);
//                history.add("Subtraction"+num1 + " - " + num2 + " = " + result);
//                break;
//            case 7:
//                result = performLog(num1, num2);
//                history.add("Subtraction"+num1 + " - " + num2 + " = " + result);
//                break;
            default:
                System.out.println("Invalid option");
                break;

        }
        return result;
    }

    private double performPercentage(double perNum1, double perNum2) {
        if (perNum2 == 0) {
            throw new ArithmeticException("Modulus by zero is not allowed.");
        }
        return (perNum1/perNum2)*100;
    }

    private double performModulus(double modNum1, double modNum2) {
        if (modNum2 == 0) {
            throw new ArithmeticException("Percentage by zero is not allowed.");
        }
        return modNum1%modNum2;
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

    private double performDivision(double num1 ,double num2)  {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.parseDouble(df.format(num1/num2));
    }
    public void showHistory(){
        for(String s:history){
          System.out.println(s);
      }
    }
    private double performMutiplication(Scanner scanner) {
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
        while(true) {
            calculator.showOperations();
            int input = calculator.takeUserInput();
            if(input==10){
                calculator.showHistory();
            }
           else if(input==11){
                System.out.println("exited");
                break;
            } else {
               try {
                   double result = calculator.perFormOperation(input);
                   System.out.println("result" + result);
               }
               catch (Exception e){
                   System.out.println(e.getMessage());
               }

            }
        }

    }
}