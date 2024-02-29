package objects;

import Enums.*;
import Interfaces.*;
import java.util.Objects;

public class Entity extends Obj implements Property, Coordinate {

    //проверка игнорирующая регистр
    @Override
    public boolean equals(Object o) {
        Entity entity = (Entity) o;
        return Objects.equals(ending, entity.ending) && Objects.equals(name.toLowerCase(), entity.name.toLowerCase());
    }

    //сравнение по полу
    @Override
    public int hashCode() {
        return Objects.hash(ending);
    }

    //вывод имени и пола объекта
    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    private String ending;
    final private String name;
    final private Gender sex;

    public Entity(String name, Gender sex) {
        super(name);
        this.name = name;
        this.sex = sex;
        this.ending = sex.getName();
    }

    public void doSomething(Action act) {
        System.out.print(super.name + " ");
        if (act == Action.Ended) {
            System.out.print("закончилась");
        } else if (act == Action.Was) {
            System.out.print("были" + ending);
        } else if (act == Action.Photographed) {
            System.out.print("сфотографирован " + ending);
        } else if (act == Action.WentOff){
            System.out.print("вылез " + ending);
        } else if (act == Action.ComeInto){
            System.out.print("появился" + ending);
        }
    }
    public void doSomethingAboutSb(Action act, Obj e){
        if (act == Action.Published){
            System.out.print(super.name + " печатались " + e.name);
        }else if (act == Action.Appeared){
            System.out.print(super.name + " попало " + e.name);
        }else if (act == Action.Nothing) {
            System.out.print(super.name);
        }else if (act == Action.WentOut){
            System.out.print(super.name + " вышел из " + e.name);
        }
    }

    @Override
    public void getPropertyLeft(String property) {
        super.name = this.name;
        super.name = super.name + " " + property;
    }
    @Override
    public void getPropertyRight(String property){
        super.name = this.name;
        super.name = property + " " + super.name;
    }

    @Override
    public void getPropertyAll(String property1, String property2) {
        super.name = this.name;
        super.name = property1 + " " + super.name + " " + property2 + " ";
    }

    public void getCoordinate(Thing place){
        super.name = super.name + " в " + place.name + "е";
    }
    public void getCoordinate(Place place){
        super.name = super.name + " в " + place.name + "е";
    }
}