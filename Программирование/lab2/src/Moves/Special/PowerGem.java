package Moves.Special;
import ru.ifmo.se.pokemon.*;

public class PowerGem extends PhysicalMove {
    public PowerGem(){
        super(Type.ROCK, 80, 100);
    }

    @Override
    protected String describe(){
        return "is using Power Gem";
    }
}
