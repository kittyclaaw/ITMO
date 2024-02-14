package Pokemons;
import ru.ifmo.se.pokemon.*;

public class Gengar extends Haunter {
    public Gengar(String name, int  level){
        super(name, level);
        super.setStats(60, 65, 60, 130, 75, 110);
        super.addMove(new Moves.Physical.LeechLife());
    }
}