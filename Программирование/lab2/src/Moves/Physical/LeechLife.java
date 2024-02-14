package Moves.Physical;
import ru.ifmo.se.pokemon.*;

public class LeechLife extends PhysicalMove {
    public LeechLife(){
        super(Type.NORMAL, 80, 100);
    }

    @Override
    protected String describe(){
        return "is using Leech Life";
    }
}
