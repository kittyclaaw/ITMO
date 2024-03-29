package CommandProvider.Commands;

import java.util.LinkedHashSet;

public class Show {
    public static void ShowCommand(LinkedHashSet collection){
        for (Object o : collection) {
            System.out.println(o);
            System.out.println();
        }
    }
}
