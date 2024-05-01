package CommandProvider.Commands;

import Cities.City;
import CommandProvider.CompareCity;

import java.util.LinkedHashSet;

public class Add {

    /**
     * add a new element to the collection
     *
     * @param collection collection where we store City objects
     * */

    public static void AddCommand(LinkedHashSet collection){
        City sp = new City();
        collection.add(sp);
    }
}
