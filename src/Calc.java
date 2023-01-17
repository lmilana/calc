import java.util.Arrays;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        {
            Scanner reader = new Scanner(System.in);
            System.out.print("input:\n");
            String expression = reader.nextLine();
            System.out.print(calculate(expression));
        }
    }
    public static Integer calculate(String expression) {
        expression = expression.replace(" ", "");

        if (!expression.matches("^(\\d{1,}[-+*/]){1,}\\d{1,}$")) {
            throw new RuntimeException("error");
        }

        Integer[] ints = Arrays.stream(expression.split("[-+*/]")).map(Integer::parseInt).toArray(Integer[]::new);

        int result = ints[0];
        int counter = 1;
        for (char op : expression.replaceAll("[0-9]","").toCharArray()) {
            if (op == '-') result -= ints[counter];
            if (op == '+') result += ints[counter];
            if (op == '*') result *= ints[counter];
            if (op == '/') result /= ints[counter];
            counter++;
            }
        System.out.println("Output:");
        return result;
    }
}
