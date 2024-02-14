import Pokemons.Aerodactyl;
import Pokemons.Cherrim;
import Pokemons.Cherubi;
import Pokemons.Gastly;
import Pokemons.Gengar;
import Pokemons.Haunter;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Aerodactyl p1 = new Aerodactyl("yung lean", 1);
        Cherrim p2 = new Cherrim("bladee", 1);
        Cherubi p3 = new Cherubi("Thaiboy_digital", 1);
        Gastly p4 = new Gastly("ecco2k", 1);
        Gengar p5 = new Gengar("white armor", 1);
        Haunter p6 = new Haunter("yung gud", 1);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}