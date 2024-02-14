package Pokemons;
import ru.ifmo.se.pokemon.*;

public class Gastly extends Pokemon {
    public Gastly(String name, int  level){
        super(name, level);
        super.setStats(30, 35, 30, 100, 35, 80);
        super.setType(Type.GHOST);
        super.addMove(new Moves.Physical.Astonish());
        super.addMove(new Moves.Status.Confide());
    }
}