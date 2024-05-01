package CommandProvider.Commands;

import java.util.LinkedHashSet;

public class Show {

    /**
     * display all the elements
     * <p>
     * display to standard output all the elements of the collection in string representation
     *
     * @param collection collection where we store City objects
     * */

    public static void ShowCommand(LinkedHashSet collection){
        for (Object o : collection) {
            System.out.println(o);
            System.out.println();
        }
    }
}
