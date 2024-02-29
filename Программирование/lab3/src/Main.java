import Enums.*;
import objects.*;

public class Main {

    public static void main(String[] args){
        //объекты, которые могут действовать
        Entity show = new Entity("передача", Gender.Female);
        Entity places = new Entity("места", Gender.All);
        Entity magazine = new Entity("газеты", Gender.Female);
        Entity Neznaika = new Entity("Незнайка", Gender.Male);
        Entity travaler = new Entity("путешественник", Gender.Male);
        Entity pictures = new Entity("снимки", Gender.All);

        //объекты не умеющие действовать
        Thing photo = new Thing("фотографии");
        Thing massage = new Thing("сообщение");
        Thing spacesuit = new Thing("скафандр");
        Thing arrival = new Thing("прибытии");
        Thing car = new Thing("Автомашины ");
        Thing hotel = new Thing("гостиниц");

        //объекты места
        Place town = new Place("город");

        System.out.println("=================================================================================\n");
        //1 предложение
        show.getPropertyRight("Телевизионная");
        show.doSomething(Action.Ended);
        System.out.print(". ");

        //2 предложение
        PlaceTime.setTime(Time.NextMorning);
        magazine.getPropertyRight("во всех");
        massage.getDescription(arrival);
        town.getPropertyAll("лунном", "Давилтон");
        massage.getCoordinate(town);
        magazine.doSomethingAboutSb(Action.Appeared, massage);
        travaler.getPropertyRight("космического");
        travaler.doSomething(Action.Nothing);
        System.out.print(". ");

        //3 предложени
        places.getPropertyRight("На самые видные");
        photo.getPropertyLeft("Незнайки");
        places.getCoordinate(spacesuit);
        places.doSomethingAboutSb(Action.Published, photo);
        System.out.print(". ");

        //4 предложение
        pictures.getPropertyRight("Здесь");
        pictures.doSomething(Action.Was);
        System.out.print(", ");
        Neznaika.getPropertyRight("на которых");
        Neznaika.doSomething(Action.Photographed);
        PlaceTime.setTime(Time.Moment);
        Neznaika.getPropertyRight("");
        Neznaika.doSomethingAboutSb(Action.WentOut, car);
        PlaceTime.setTime(Time.Moment);
        Neznaika.doSomething(Action.WentOff);
        PlaceTime.setTime(Time.Moment);
        Neznaika.getCoordinate(hotel);
        Neznaika.doSomething(Action.ComeInto);
        System.out.print(". ");
        System.out.println("\n\n=================================================================================");
    }
}