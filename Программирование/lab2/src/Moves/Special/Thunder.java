package Moves.Special;

import ru.ifmo.se.pokemon.*;

public class Thunder extends SpecialMove{
    public Thunder(){
        super(Type.ELECTRIC, 110, 70);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        Effect e = new Effect().chance(0.3).turns(1).condition(Status.PARALYZE);
        p.addEffect(e);
    }

    @Override
    protected String describe(){
        return "is using Thunder";
    }

}
