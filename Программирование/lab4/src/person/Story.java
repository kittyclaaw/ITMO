package person;

import dop.*;

public class  Story {
    public static void main(String[] args) {
        Dunno dunno = new Dunno();
        Shelf shelf = new Shelf();
        Shelf.Chump chump = shelf.new Chump();
        dunno.climbUp(shelf);

        StoryDetails strd = new StoryDetails() {
            @Override
            public void description() {
                System.out.println(", а вместо подушки");
            }
        };
        try {
            dunno.see(shelf);
        } catch (NotMatressAndPillowException e) {
            System.out.print(e.getMessage());
            strd.description();
            chump.lie();
        }
        Creatures shorties = new Creatures("Коротышки");
        shorties.quietDown();
        Thing smell = new Thing("запах", "отвратительный");
        dunno.smell(smell);
        dunno.decideToGoToBed();
        Obstinate obstinate = new Obstinate("Строптивый");
        Clothes shirt = new Clothes("рубашка");
        dunno.takeOff(shirt);
        try{
            obstinate.said(dunno);
        }
        catch(NotTakeOffClothes e){
            System.out.println (e.getMessage());
        }
        dunno.stretchOnSomething(shelf);
        Creatures animals = new Creatures("зверушки", "мелкие");
        animals.attack(dunno);
        Thing body = new Thing("тело");
        dunno.itch();
        dunno.rend(body);
    }
}