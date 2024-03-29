package CommandProvider.Commands;

import Cities.City;
import java.util.LinkedHashSet;

public class AddMin {
    public static void AddMinCommand(LinkedHashSet<City> collection){
        City sp = new City();
        System.out.println("Созданный город");
        System.out.println(sp);
        long minId = 100000000;

        for(City s: collection){
            if(s.getId() < minId){
                minId = s.getId();
            }
        }
        System.out.println("Минимальное значение: "+ String.valueOf(minId));
        System.out.println("Значение созданого: "+ String.valueOf(sp.getId()));
        if(sp.getId() < minId){
            System.out.println("Добавляем!");
            collection.add(sp);
        }else{
            System.out.println("Не добавляем!");
        }
    }
}
