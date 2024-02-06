//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
class Calculator{
    public void showOperations(){
     System.out.println("Welcome to the calculator app");
     System.out.println("1.Addition");
     System.out.println("2.Subtraction");
     System.out.println("3.exit");
    }
    public int takeUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();


    }

    public double perFormOperation(int input) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double result = 0;
        switch (input) {
            case 1:
                result = performAddition(num1, num2);
                break;
            case 2:
                result = performSubtraction(num1, num2);
                break;
            default:
                System.out.println("Invalid option");
                break;

        }
        return result;
    }

    private double performSubtraction(double num1,double num2) {
      return num1-num2;
    }

    private double performAddition(double num1,double num2) {
        return num1+num2;
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
            if(input==3){
                System.out.println("exited");
                break;
            }
            double result=calculator.perFormOperation(input);
            System.out.println("result"+result);
        }

    }
}