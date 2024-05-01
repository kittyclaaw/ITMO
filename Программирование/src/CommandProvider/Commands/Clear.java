package CommandProvider.Commands;

import java.util.LinkedHashSet;

public class Clear{

    /**
     * clear collection
     *
     * @param collection collection where we store City objects
     * */

    public static void ClearCommand(LinkedHashSet collection){
        collection.clear();
        System.out.println("Коллекция очищена.");
    }
}
