package Moves.Physical;
import ru.ifmo.se.pokemon.*;

public class Astonish extends PhysicalMove {
    public Astonish(){
        super(Type.NORMAL, 30, 100);
    }

    private boolean isFlinched = false;

    @Override
    protected void applyOppEffects(Pokemon p) {
        if(Math.random() < 0.3){
            isFlinched = true;
            Effect.flinch(p);
        }
    }

    @Override
    protected String describe(){
        return "is using Astonish";
    }
}
