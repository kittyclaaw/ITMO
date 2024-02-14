package Pokemons;
import ru.ifmo.se.pokemon.*;

public class Aerodactyl extends Pokemon {
    public Aerodactyl(String name, int  level){
        super(name, level);
        super.setStats(80, 105, 65, 60, 75, 130);
        super.setType(Type.ROCK);
        super.addMove(new Moves.Physical.RockTomb());
        super.addMove(new Moves.Status.Swagger());
        super.addMove(new Moves.Physical.MegaPunch());
        super.addMove(new Moves.Physical.RockClimb());
    }
}