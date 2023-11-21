package tlalim.view.tests;

import tlalim.view.*;
import static tlalim.view.Item.*;
public class DatesMenu {
    public static Item getMenu(){
        Menu menu = new Menu(getItems(), "Dates Operations");
        return null;
    }

    private static Item[] getItems() {
        Item[] items = {
            of("Date after given days", io-> dateAfter(io)),
            of("Date before given days", io->dateBefore(io)),
            of("Number days between two dates", io ->daysBetweenDates(io)),
            exit()    
        };
        return items;
    }

    private static void daysBetweenDates(InputOutput io) {
        //TODO
        io.writeLine("TODO for HW #31; Enter first date, enter second date"
                + "print number days between two days");
    }

    private static void dateBefore(InputOutput io) {
        //TODO
        io.writeLine("TODO - Enter date, enter number days, print date after the dates");
    }

    private static void dateAfter(InputOutput io) {
        //TODO
        io.writeLine("TODO - Enter date, enter number days, print date before the dates");
    }
}
