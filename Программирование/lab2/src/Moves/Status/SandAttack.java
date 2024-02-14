package Moves.Status;
import ru.ifmo.se.pokemon.*;

public class SandAttack extends StatusMove{
    public SandAttack(){
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.ACCURACY, -1);
    }

    @Override
    protected String describe(){
        return "is using Sand Attack";
    }
}