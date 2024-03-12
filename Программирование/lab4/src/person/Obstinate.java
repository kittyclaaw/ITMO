package person;


public class Obstinate extends Person{
    Obstinate(String name){
        super(name);
    }
    public void said(Person obj){
        System.out.println(this.toString() + " сказал " + obj.toString());
        if (obj instanceof Dunno){
            obj.followTheAdvice(this);
            System.out.println("поэтому");
            Thing clothes = new Thing("одежда");
            obj.takeOff(clothes);
        }
    }
}