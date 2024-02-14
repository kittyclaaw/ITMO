package Moves.Physical;
import ru.ifmo.se.pokemon.*;

public class MegaPunch extends PhysicalMove {
    public MegaPunch(){
        super(Type.NORMAL, 80, 85);
    }

    @Override
    protected String describe(){
        return "is using Mega Punch";
    }
}
