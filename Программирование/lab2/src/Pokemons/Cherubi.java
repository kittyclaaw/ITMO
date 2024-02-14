package Pokemons;
import ru.ifmo.se.pokemon.*;

public class Cherubi extends Pokemon {
    public Cherubi(String name, int  level){
        super(name, level);
        super.setStats(45, 35, 45, 62, 53, 35);
        super.setType(Type.GRASS);
        super.addMove(new Moves.Status.Swagger());
        super.addMove(new Moves.Physical.BodySlam());
        super.addMove(new Moves.Special.Thunder());
    }
}