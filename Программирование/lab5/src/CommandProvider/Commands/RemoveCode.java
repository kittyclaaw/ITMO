package CommandProvider.Commands;

import Cities.City;
import java.util.LinkedHashSet;

public class RemoveCode {
    public static void RemoveCodeCommand(LinkedHashSet<City> collection, String[] commandToWords){
        if (commandToWords.length != 2) {
            System.out.println("Ошибка ввода команды!");
        } else {
            try {
                boolean isCode = true;
                int cmdCode = Integer.parseInt(commandToWords[1]);
                for(City o: collection){
                    if (cmdCode==o.getCarCode()){
                        collection.remove(o);
                        isCode = false;
                        System.out.println("Успешно удален City с CarCode: "+ cmdCode);
                    }
                }
                if(isCode){
                    System.out.println("City с таким CarCode нету!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка CarCode - int!");
            }
        }
    }
}
