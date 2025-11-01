package ru.rodion.commands;

import ru.rodion.asks.AskSpaceMarine;
import ru.rodion.commandLine.Printable;
import ru.rodion.exceptions.FIleFieldException;
import ru.rodion.exceptions.IllegalArgumentsException;
import ru.rodion.models.SpaceMarine;

public class AddIfMin extends Command {
    private final Printable console;

    public AddIfMin(Printable console) {
        super("add_if_min", "добавление элемента, если он наименьший");
        this.console = console;
    }

    public SpaceMarine execute(String args) throws IllegalArgumentsException {
        if (!args.isBlank()) throw new IllegalArgumentsException();
        SpaceMarine spaceMarine = new AskSpaceMarine(console).build();
        if (!spaceMarine.validate()) throw new FIleFieldException();
        return spaceMarine;

    }
}
