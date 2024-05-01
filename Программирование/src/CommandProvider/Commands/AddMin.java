package CommandProvider.Commands;

import Cities.City;
import java.util.LinkedHashSet;

public class AddMin {

    /**
     * add if element value is min
     * <p>
     * add a new element to a collection if its value is less than the value of the smallest element of this collection
     *
     * @param collection collection where we store City objects
     * */

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
