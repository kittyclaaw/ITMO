package person;

public class Shelf extends Thing{
    boolean matress = false;
    boolean pillow = false;
    Shelf(){
        super();
    }
    public class Chump{
        String name = "чурбан";
        String description = "простой деревянный";
        public void lie(){
            System.out.println("лежал " + description + " " + name);
        }
    }
}