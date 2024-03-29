package CommandProvider.Commands;

import Cities.City;
import java.util.LinkedHashSet;

public class Update {
    public static void UpdateCommand(LinkedHashSet<City> collection, String[] commandToWords) {

        if (commandToWords[1]!="id") {
            System.out.println("Ошибка ввода команды!");
        } else {
            try {
                boolean isId = true;
                int cmdId = Integer.parseInt(commandToWords[2]);
                for(City o: collection){
                    if (cmdId == o.getId()){
                        o.setId();
                        System.out.println("Значение обновленно! Новое значение: " + String.valueOf(o.getId()));
                        isId = false;
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
