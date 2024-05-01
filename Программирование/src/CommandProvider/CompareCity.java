package CommandProvider;

import Cities.City;
import java.util.Comparator;

public class CompareCity implements Comparator<City> {
    @Override
    public int compare(City sp1, City sp2){
        return sp1.getName().length() - sp2.getName().length();
    }
}
