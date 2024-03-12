package person;

import dop.*;

public class Creatures {
    private String name;
    private String describe;
    private TypeAttack attack;
    Creatures(String name){
        this.name = name;
    }
    Creatures(String name, String des){
        this.name = name;
        this.describe = des;
        this.attack = TypeAttack.MERCILESSLY;
    }
    public void quietDown(){
        System.out.println(name + " притихли");
    }
    public void attack(Person obj){
        obj.feel();
        System.out.println("на " + obj.toString() + " напали " + describe +" "+ name + " и принялись " + this.attack.toString() + " кусать");
    }
}