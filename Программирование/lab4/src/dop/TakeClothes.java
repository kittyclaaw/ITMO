package dop;

import person.*;

public interface TakeClothes {
    default void notTakeOff(){
        throw new NotTakeOffClothes("он не снимал одежду");
    }

    void takeOff(Thing obj);
}