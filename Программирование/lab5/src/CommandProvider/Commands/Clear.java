package CommandProvider.Commands;

import java.util.LinkedHashSet;

public class Clear{
    public static void ClearCommand(LinkedHashSet collection){
        collection.clear();
        System.out.println("Коллекция очищена.");
    }
}
