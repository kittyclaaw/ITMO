package CommandProvider.Commands;

import java.util.LinkedHashSet;

public class Print {
    public static void PrintCommand(LinkedHashSet collection){
        collection = (LinkedHashSet) collection.stream().sorted();
        for (Object o : collection) {
            System.out.println(o);
            System.out.println();
        }
    }
}
