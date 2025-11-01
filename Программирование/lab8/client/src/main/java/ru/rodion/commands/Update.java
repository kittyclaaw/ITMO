package ru.rodion.commands;


import ru.rodion.asks.AskSpaceMarine;
import ru.rodion.commandLine.Printable;
import ru.rodion.exceptions.FIleFieldException;
import ru.rodion.exceptions.IllegalArgumentsException;
import ru.rodion.models.SpaceMarine;

public class Update extends Command {
    private final Printable console;

    public Update(Printable console) {
        super("update", "обновление по id");
        this.console = console;
    }


    public SpaceMarine execute(String args) throws IllegalArgumentsException {
        if (args.isBlank()) throw new IllegalArgumentsException();
        SpaceMarine spaceMarine = new AskSpaceMarine(console).build();
        if (!spaceMarine.validate()) throw new FIleFieldException();
        return spaceMarine;

    }
}
