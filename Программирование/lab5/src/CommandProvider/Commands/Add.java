package CommandProvider.Commands;

import Cities.City;
import CommandProvider.CompareCity;

import java.util.LinkedHashSet;

public class Add {
    public static void AddCommand(LinkedHashSet collection, CompareCity CSM){
        City sp = new City();
        collection.add(sp);
    }
}
