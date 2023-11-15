package tlalim.company.objects;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class CreationPointAppl {
    public static void main(String[] args) throws Exception {
        List<Point> points = new ArrayList<>();
        points.add(new Point(3, 4));
        points.add(new Point(5, 6));
        points.add(new Point(9, 8));
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("points.data"))) {
            output.writeObject(points);
        }
        System.out.println(points);


    }
}
