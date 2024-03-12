package person;

import dop.*;
import java.util.Objects;

public abstract class Person implements PersonInt, TakeClothes {
    private final String name;
    private final Feeling senseOfSmell;
    private final Feeling senseOfSight;
    private final Feeling senseOfTouch;
    private final Feeling senseOfTaste;
    private final Feeling vestibularSensation;
    private final Feeling senseOfHearing;

    Person(String name) {
        this.name = name;
        senseOfSmell = new Feeling(FeelingEnum.SMELL);
        senseOfHearing = new Feeling(FeelingEnum.HEARING);
        senseOfSight = new Feeling(FeelingEnum.VESTUBULAR_APPARATUS);
        senseOfTaste = new Feeling(FeelingEnum.TASTE);
        vestibularSensation = new Feeling(FeelingEnum.VISION);
        senseOfTouch = new Feeling(FeelingEnum.TACTILITY);
    }

    Person() {
        this.name = "Незнайка";
        senseOfSmell = new Feeling(FeelingEnum.SMELL, true);
        senseOfHearing = new Feeling(FeelingEnum.HEARING);
        senseOfSight = new Feeling(FeelingEnum.VESTUBULAR_APPARATUS);
        senseOfTaste = new Feeling(FeelingEnum.TASTE);
        vestibularSensation = new Feeling(FeelingEnum.VISION);
        senseOfTouch = new Feeling(FeelingEnum.TACTILITY, true);
    }

    public void stretchOnSomething(Thing obj) {
        System.out.println(this + " растянулся на" + obj.toString());
    }

    @Override
    public void feel() {
        System.out.print(this.name + " почувствовал что ");
    }

    public void followTheAdvice(Person obj) {
        System.out.println(this + " решает последовать совету " + obj.toString());
    }

    @Override
    public void smell(Thing obj) {
        System.out.println(obj .toString() + " уже не так тревожил " + this.senseOfSmell.toString() + " " + name);
        System.out.print("но ");
        Environment.Stuffiness stuf = new Environment.Stuffiness();
        stuf.influence();
    }

    @Override
    public void takeOff(Thing obj) {
        if (obj instanceof Clothes) {
            System.out.println(this + " принялся стаскивать с себя " + obj);
        } else {
            notTakeOff();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name) && Objects.equals(senseOfSmell, person.senseOfSmell) && Objects.equals(senseOfSight, person.senseOfSight) && Objects.equals(senseOfTouch, person.senseOfTouch) && Objects.equals(senseOfTaste, person.senseOfTaste) && Objects.equals(vestibularSensation, person.vestibularSensation) && Objects.equals(senseOfHearing, person.senseOfHearing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, senseOfSmell, senseOfSight, senseOfTouch, senseOfTaste, vestibularSensation, senseOfHearing);
    }

    @Override
    public String toString() {
        return name;
    }
}