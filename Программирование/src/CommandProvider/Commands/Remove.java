package CommandProvider.Commands;

import Cities.City;
import java.util.LinkedHashSet;

public class Remove {

    /**
     * remove an element from a collection by its id
     *
     * @param collection collection where we store City objects
     * @param commandToWords the string entered by the user, divided into words
     * */

    public static void RemoveCommand(LinkedHashSet<City> collection, String[] commandToWords){
        if (commandToWords.length != 2) {
            System.out.println("Ошибка ввода команды!");
        } else {
            try {
                boolean isId = true;
                int cmdId = Integer.parseInt(commandToWords[1]);
                for(City o: collection){
                    if (cmdId==o.getId()){
                        collection.remove(o);
                        isId = false;
                        System.out.println("Успешно удален City с id: "+ cmdId);
                    }
                }
                if(isId){
                    System.out.println("City с таким id нету!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка id - int!");
            }
        }
    }
}
