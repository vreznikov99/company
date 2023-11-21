package tlalim.view.tests;
import tlalim.view.*;
import static tlalim.view.Item.*;


public class NumbersMenu {
    public static Item getMenu(){
        Menu menu = new Menu(getItems(), "Arithmetic operations");
        return menu;
    }

    private static Item[] getItems() {
        return ArithmeticSimpleCalculatorAppl.getItems();
    }

}
