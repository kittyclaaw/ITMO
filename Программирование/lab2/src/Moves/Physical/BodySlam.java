package Moves.Physical;
import ru.ifmo.se.pokemon.*;

public class BodySlam extends PhysicalMove{
    public BodySlam(){
        super(Type.NORMAL, 85, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        Effect e = new Effect().chance(0.3).turns(1).condition(Status.PARALYZE);
        p.addEffect(e);
    }

    @Override
    protected String describe(){
        return "is using Body Slam";
    }
}