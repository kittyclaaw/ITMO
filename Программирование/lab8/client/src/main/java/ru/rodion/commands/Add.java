package ru.rodion.commands;


import ru.rodion.asks.AskSpaceMarine;
import ru.rodion.commandLine.Printable;
import ru.rodion.exceptions.IllegalArgumentsException;
import ru.rodion.models.SpaceMarine;

public class Add extends Command {
    private final Printable console;


    public Add(Printable console) {
        super("add", "добавление элемента");
        this.console = console;
    }


    public SpaceMarine execute(String args) throws IllegalArgumentsException {
        if (!args.isBlank()) throw new IllegalArgumentsException();
        return new AskSpaceMarine(console).build();
    }


}
