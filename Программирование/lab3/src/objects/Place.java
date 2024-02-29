package objects;

import Enums.*;
import Interfaces.*;

public class Place extends Obj implements Coordinate, Property{
    String name;

    public Place(String name){
        super(name);
        this.name = name;
    }
    @Override
    public void getPropertyRight(String property){
        super.name = this.name;
        super.name = property + " " + super.name;
    }
    @Override
    public void getPropertyLeft(String property){
        super.name = this.name;
        super.name =  super.name + " " + property;
    }
    @Override
    public void getPropertyAll(String property1, String property2) {
        super.name = this.name;
        this.name = property1 + " " + super.name + " " + property2;
    }
    @Override
    public void getCoordinate(Thing place) {
        super.name = super.name + " в " + place.name;
    }

    @Override
    public void getCoordinate(Place place) {
        super.name = super.name + " в " + place.name;
    }
}