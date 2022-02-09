import java.util.Scanner;

public class Calculator {

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        double x = calculator.getInput();
        double y = calculator.getInput();
        double z = calculator.getInput();
        System.out.println("Results: ");
        System.out.println("    -Addition: " + calculator.sum(x, y));
        System.out.println("    -Subtraction: " + calculator.sub(x, y));
        System.out.println("    -Multiplication: " + calculator.multiply(x, y));
        System.out.println("    -Division: " + calculator.divide(x, y));
    }

    public Calculator(){

    }

    public double sum(double x, double y){
        return x + y;
    }

    public double sub(double x, double y){
        return x - y;
    }

    public double multiply(double x, double y){
        return x * y;
    }

    public double divide(double x, double y){
        return x / y;
    }

    public double getInput(){
        double result;
        Scanner scanner;

        do{
            System.out.println("Number: ");
            scanner = new Scanner(System.in);
            if(!scanner.hasNextDouble()){
                System.out.println("Input is not a number");
            }
        }while(!scanner.hasNextDouble());

        result = scanner.nextDouble();
        return result;
    }
}
