package CommandProvider.Commands;

import Cities.City;

import java.util.LinkedHashSet;

public class RemoveGreater {

    public static void RemoveGreaterCommand(LinkedHashSet<City> collection, String[] commandToWords){
        if (commandToWords.length != 2) {
            System.out.println("Ошибка ввода команды!");
        } else {
            try {
                int cmdId = Integer.parseInt(commandToWords[1]);
                for(City o: collection){
                    if (cmdId < o.getId()){
                        collection.remove(o);
                    }
                }
                System.out.println("Все элементы больше заданного Id удалены!");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка id - int!");
            }
        }
    }
}
