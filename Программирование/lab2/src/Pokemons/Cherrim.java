package Pokemons;
import ru.ifmo.se.pokemon.*;

public class Cherrim extends Cherubi {
    public Cherrim(String name, int  level){
        super(name, level);
        super.setStats(70, 60, 70, 87, 78, 85);
        super.addMove(new Moves.Special.PowerGem());
    }
}