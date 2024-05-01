package CommandProvider.Commands;

import Cities.City;
import java.util.LinkedHashSet;
import static Cities.SimpleScanner.Scan;

public class Save {

    /**
     * save the collection to a file
     *
     * @param collection collection where we store City objects
     * @return name of the file to save
     * */

    public static String SaveCommand(LinkedHashSet<City> collection){
        System.out.println("Напише файл в который надо сохранить: ");
        String fileName = Scan();
        fileName.replaceAll(" ", "");
        fileName.replaceAll(".", "");
        if (fileName == ""){
            return "data.csv";
        }
        return fileName+".csv";
    }
}
