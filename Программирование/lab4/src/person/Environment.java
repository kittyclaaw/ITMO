package person;

import dop.*;

public class Environment {
    static private State TYPE1 = State.UNBEARABLY;
    static private State TYPE2 = State.STUFFY;
    static class Stuffiness{
        public void influence() {
            if (TYPE1 == State.STUFFY & TYPE2 == State.UNBEARABLY) {
                System.out.println("было нестерпимо душно");
            }
        }
    }

}