import java.util.*;

public class Calculator {

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        calculator.getCalculation();
    }

    char[] operations = {'*', '/', '+', '-'};
    char[] numerals = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public Calculator(){

    }

    public int addition(int x, int y){
        return x + y;
    }

    public int subtraction(int x, int y){
        return x - y;
    }

    public int multiply(int x, int y){
        return x * y;
    }

    public int divide(int x, int y){
        return x / y;
    }

    public int getInput(){
        int result;
        Scanner scanner;

        do{
            System.out.println("Number: ");
            scanner = new Scanner(System.in);
            if(!scanner.hasNextInt()){
                System.out.println("Input is not a number");
            }
        }while(!scanner.hasNextInt());

        result = scanner.nextInt();
        return result;
    }

    public String getStringInput(){
        String input;
        System.out.println("Input Calculation");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        input = input.replaceAll("\\s+", "");

        return input;
    }

    public void getCalculation(){
        String calc = getStringInput();
        char[] charCalc = calc.toCharArray();
        List<Integer> numbers = new ArrayList<Integer>();
        List<Character> operators= new ArrayList<Character>();
        StringBuilder value = new StringBuilder();

        for(int i = 0; i < charCalc.length; i++){
            if(checkNumerals(charCalc[i])){
                value.append(charCalc[i]);
                if(i == (charCalc.length - 1)){
                    numbers.add(Integer.parseInt(value.toString()));
                    value = new StringBuilder();
                }
            }else if(checkOperators(charCalc[i])){
                operators.add(charCalc[i]);
                numbers.add(Integer.parseInt(value.toString()));
                value = new StringBuilder();
            }
        }

        runCalculation(numbers, operators);
    }

    public void runCalculation(List<Integer> nums, List<Character> operators){
        int sum = 0;
        int operatorIndex = 0;
        int x = nums.get(0);
        int y;

        for(int i = 1; i < nums.size(); i++){
            y = nums.get(i);
            switch(operators.get(operatorIndex)){
                case '+':
                    x = addition(x, y);
                    break;
                case '-':
                    x = subtraction(x,y);
                    break;
            }

            if(i == (nums.size() - 1)){
                sum = x;
            }

            operatorIndex++;
        }

        System.out.println("Result: " + sum);
    }

    public boolean checkOperators(char compChar){
        boolean value = false;
        for(int i = 0; i < operations.length; i++) {
            if(compChar == operations[i]){
                value = true;
                break;
            }
        }
        return value;
    }

    public boolean checkNumerals(char compChar){
        boolean value = false;
        for(int i = 0; i < numerals.length; i++) {
            if(compChar == numerals[i]){
                value = true;
                break;
            }
        }
        return value;
    }

}

class SortByOperator implements Comparator<Character>{

    ArrayList<Character> operatorOrder = new ArrayList<Character>();

    public SortByOperator(){
        operatorOrder.add(0,'/');
        operatorOrder.add(1, '*');
        operatorOrder.add(2, '+');
        operatorOrder.add(3, '-');
    }

    @Override
    public int compare(Character o1, Character o2) {
        int x = operatorOrder.indexOf(o1);
        int y = operatorOrder.indexOf(o2);

        return x - y;
    }
}