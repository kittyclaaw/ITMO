package Pokemons;
import ru.ifmo.se.pokemon.*;

public class Haunter extends Gastly {
    public Haunter(String name, int  level){
        super(name, level);
        super.setStats(45, 50, 45, 115, 55, 95);
        super.addMove(new Moves.Status.SandAttack());
    }
}