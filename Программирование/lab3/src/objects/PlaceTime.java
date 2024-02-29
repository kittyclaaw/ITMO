package objects;

import Enums.Time;

public class PlaceTime {

    public static void setTime(Time time){
        if (time == Time.NextMorning){
            System.out.print("На следующее утро ");
        }else if (time == Time.Moment){
            System.out.print("в тот момент, когда");
        }
    }
}