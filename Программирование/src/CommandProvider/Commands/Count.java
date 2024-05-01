package CommandProvider.Commands;

import java.util.LinkedHashSet;
import Cities.City;
import Cities.StandardOfLiving;

public class Count {

    /**
     * display the number of elements greater than specified
     * <p>
     * display the number of elements whose standardOfLiving field value is greater than the specified one
     *
     * @param collection collection where we store Сity objects
     * @param userString command argument meaning standard of living value
     * */

    public static void CountLessCommand(LinkedHashSet<City> collection, String userString){
        try{
            int userValue = Integer.parseInt(userString);
            int count = 0;

            for(City sp: collection){
                int value = 0;
                StandardOfLiving standardOfLiving = sp.getStandardOfLiving();
                switch (standardOfLiving){
                    case ULTRA_HIGH:
                        value=4;
                        break;
                    case VERY_HIGH:
                        value=3;
                        break;
                    case MEDIUM:
                        value=2;
                        break;
                    case VERY_LOW:
                        value=1;
                        break;
                }
                if(value < userValue){
                    count++;}

            }
            System.out.println("Кол-во элементов, значение поля StandardOfLiving которых меньше заданного: " + count);


        } catch (NumberFormatException e) {
            System.out.println("Значение должно быть StandardOfLiving int!");
        }
    }
}
