package CommandProvider.Commands;

import Cities.City;
import java.util.Date;
import java.util.LinkedHashSet;

public class Info {
    private Date Date;
    public static void InfoCommand(LinkedHashSet<City> collection){
        System.out.println("Размер коллекции: "+ String.valueOf(collection.size()));
        if(collection.size() > 0) {
            Date maxDate = collection.getLast().getDate();

            for (City sp : collection) {
                if (maxDate.before(sp.getDate())) {
                    maxDate = sp.getDate();
                }
            }
            System.out.println("Дата последнего изменения коллекции: "+maxDate);
        }

        System.out.println("Кол-во элементов: "+collection.size());

    }
}
