package Moves.Physical;
import ru.ifmo.se.pokemon.*;

public class RockClimb extends PhysicalMove {
    public RockClimb(){
        super(Type.NORMAL, 90, 85);
    }

    private boolean isConfused = false;

    @Override
    protected void applyOppEffects(Pokemon p) {
        if(Math.random() < 0.2){
            isConfused = true;
            Effect.confuse(p);
        }
    }

    @Override
    protected String describe(){
        return "is using Rock Climb";
    }
}
