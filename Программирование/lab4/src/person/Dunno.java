package person;

import dop.*;

public class Dunno extends Person {
    Dunno(){

    }
    public void decideToGoToBed(){
        System.out.print(super.toString() + " решает лечь спать ");
    }
    public void itch(){
        System.out.println(super.toString() + " чесался ");
    }
    public void rend(Thing obj){
        class Informator{
            private String information = "но это не помогало";
            public void getInformation(){
                System.out.print(information);
            }
        }
        if (obj != null){
            Thing blood = new Thing("кровь");
            System.out.println(super.toString() + " раздирал " + obj.toString() + " до " + blood.toString());
        }
        Informator inf = new Informator();
        inf.getInformation();
    }
    public void climbUp(Thing obj){
        System.out.println("Недолго думая " + this.toString() + " залез");
    }
    public void see(Object obj) throws NotMatressAndPillowException {
        System.out.println("и увидел что");
        class Something{

            public boolean check(Object obj){
                if (obj instanceof Shelf && ((Shelf) obj).matress && ((Shelf) obj).pillow){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        Something something = new Something();
        if (something.check(obj)){
            System.out.println("здесь был матрац");
        }
        else{
            throw new NotMatressAndPillowException("здесь не было матраца");
        }
    }
}