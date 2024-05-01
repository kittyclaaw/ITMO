package CommandProvider.Commands;

import Data.DataProvider;
import Cities.City;
import java.util.LinkedHashSet;
import static Cities.SimpleScanner.Scan;

public class Load {

    /**
     * load file
     *
     * @param dp Data Class that will read the file
     * @return collection where we store City objects from file
     * */

    public static LinkedHashSet<City> LoadCommand(DataProvider dp){
        System.out.print("Введите имя файла, который хотите загрузить: ");
        return dp.Load(Scan());
    }
}