package Moves.Physical;
import ru.ifmo.se.pokemon.*;

public class RockTomb extends SpecialMove{
    public RockTomb(){
        super(Type.ROCK, 60, 95);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.SPEED, -1);
    }

    @Override
    protected String describe(){
        return "is using Rock Tomb";
    }
}
