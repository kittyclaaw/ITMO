package CommandProvider.Commands;

import Cities.City;
import java.util.LinkedHashSet;

public class AddMax {
    public static void AddMaxCommand(LinkedHashSet<City> collection){
        City sp = new City();
        System.out.println("Созданный город");
        System.out.println(sp);
        long maxId = 0;

        for(City s: collection){
            if(s.getId() > maxId){
                maxId = s.getId();
            }
        }
        System.out.println("Максимальное значение: "+ String.valueOf(maxId));
        System.out.println("Значение созданого: "+ String.valueOf(sp.getId()));
        if(sp.getId() > maxId){
            System.out.println("Добавляем!");
            collection.add(sp);
        }else{
            System.out.println("Не добавляем!");
        }
    }
}
