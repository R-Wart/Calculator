import java.util.*;

public class Calculator {

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        calculator.getCalculation();
    }

    char[] operators = {'+', '-', '*', '/'};

    public Calculator(){

    }

    public double addition(double x, double y){
        return x + y;
    }

    public double subtraction(double x, double y){
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

    public String getStringInout(){
        String input;
        System.out.println("Input Calculation");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        input = input.replaceAll("\\s+", "");

        return input;
    }

    public void getCalculation(){
        String calc = getStringInout();
        char[] charCalc = calc.toCharArray();
        List<Double> numbers = new ArrayList<Double>();
        String value = "";
        for(int i = 0; i < charCalc.length; i++){
            for(int j =0; j < operators.length; j++){
                if(operators[j] != charCalc[i]){
                    value += charCalc[i];
                    //System.out.println(value);
                    break;
                } else{
                    //System.out.println(value);
                    numbers.add(Double.parseDouble(value));
                    value = "";
                }
            }
        }

        for(double n: numbers){
            System.out.println(n);
        }
    }

}
