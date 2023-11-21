package tlalim.view.tests;
import tlalim.view.*;
import static tlalim.view.Item.*;
public class ArithmeticSimpleCalculatorAppl {
    public static void main(String[] args) {
        InputOutput io = new StandardInputOutput();
        Item[] items = getItems();
        Menu menu = new Menu(items, "Simple Calculator");
        menu.perform(io);
    }

    public static Item[] getItems() {
        Item[] items = {of("Add numbers", io -> addNumbers(io)),
                        of("Subtract numbers", io -> subtractNumbers(io)),
                        of("Multiply numbers", io -> multilpyNumbers(io)),
                        of("Divide numbers", io -> divideNumbers(io)),
                        exit()};
        return items;
    }

    private static void multilpyNumbers(InputOutput io) {
        double[] numbers = getNumbers(io);
        io.writeLine(numbers[0] * numbers[1]);
    }

    private static void subtractNumbers(InputOutput io) {
        double[] numbers = getNumbers(io);
        io.writeLine(numbers[0] - numbers[1]);
    }

    private static void addNumbers(InputOutput io) {
        double[] numbers = getNumbers(io);
        io.writeLine(numbers[0] + numbers[1]);
    }

    private static void divideNumbers(InputOutput io) {
        double[] numbers = getNumbers(io);
        io.writeLine(numbers[0] / numbers[1]);
    }

    private static double[] getNumbers(InputOutput io) {
        double number1 = io.readDouble("Enter first number", "Wrong number");
        double number2 = io.readDouble("Enter second number", "Wrong number");

        return new double[] {number1, number2};
    }


}
