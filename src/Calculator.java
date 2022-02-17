import java.util.*;

public class Calculator {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.runCalc();
    }

    public Calculator() {

    }

    public void runCalc() {
        System.out.println("Welcome!");

        boolean end = false;
        double temp = numInput();
        double sum = 0;

        do {
            char operator = operatorInput();

            if(operator == '='){
                sum = temp;
                end = true;
            }

            if(!end) {
                double number = numInput();
                switch (operator) {
                    case '+' -> temp = addition(temp, number);
                    case '-' -> temp = subtraction(temp, number);
                    case '*' -> temp = multiply(temp, number);
                    case '/' -> temp = divide(temp, number);
                }
            }
        } while (!end);

        System.out.println("Result: " + sum);
    }

    public double addition(double x, double y) {
        return x + y;
    }

    public double subtraction(double x, double y) {
        return x - y;
    }

    public double multiply(double x, double y) {
        return x * y;
    }

    public double divide(double x, double y) {
        return x / y;
    }

    public double numInput() {
        double input;
        Scanner scanner;

        do {
            System.out.println("Enter Number: ");
            scanner = new Scanner(System.in);
            if (!scanner.hasNextDouble()) {
                System.out.println("Input is not a valid number!");
            }
        } while (!scanner.hasNextDouble());

        input = scanner.nextDouble();
        return input;
    }

    public char operatorInput() {
        char input;
        String in;
        Scanner scanner;

        boolean exit = false;

        do {
            System.out.println("Enter Operator: ");
            scanner = new Scanner(System.in);
            in = scanner.nextLine();

            switch (in.charAt(0)) {
                case '+', '-', '*', '/', '=' -> exit = true;
                default -> System.out.println("Input is not a valid operator!");
            }

        } while (!exit);

        input = in.charAt(0);
        return input;
    }

    public int getInput() {
        int result;
        Scanner scanner;

        do {
            System.out.println("Number: ");
            scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()) {
                System.out.println("Input is not a number");
            }
        } while (!scanner.hasNextInt());

        result = scanner.nextInt();
        return result;
    }

    public String getStringInput() {
        String input;
        System.out.println("Input Calculation");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        input = input.replaceAll("\\s+", "");

        return input;
    }
}
    /*
        char[] operations = {'/', '*', '+', '-'};
        char[] numerals = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

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

        operators.sort(new SortByOperator(operations));
        System.out.println("Sorted List: ");
        for(char c: operators){
            System.out.println(c);
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
        for (char operation : operations) {
            if (compChar == operation) {
                value = true;
                break;
            }
        }
        return value;
    }

    public boolean checkNumerals(char compChar){
        boolean value = false;
        for (char numeral : numerals) {
            if (compChar == numeral) {
                value = true;
                break;
            }
        }
        return value;
    }

}

class SortByOperator implements Comparator<Character>{

    ArrayList<Character> operatorOrder = new ArrayList<>();

    public SortByOperator(char[] operator){
        for(char c: operator){
            operatorOrder.add(c);
        }
    }

    @Override
    public int compare(Character o1, Character o2) {
        int x = operatorOrder.indexOf(o1);
        int y = operatorOrder.indexOf(o2);

        return x - y;
    }
}*/