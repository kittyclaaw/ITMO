package ru.rodion.commands;

import ru.rodion.asks.AskSpaceMarine;
import ru.rodion.commandLine.Printable;
import ru.rodion.exceptions.IllegalArgumentsException;
import ru.rodion.exceptions.InvalidFormException;
import ru.rodion.models.SpaceMarine;

public class RemoveLower extends Command {
    private final Printable console;

    public RemoveLower(Printable console) {
        super("remove_lower", "удаляет элементы, если его значение меньше, чем у наименьшего элемента ");
        this.console = console;
    }

    public SpaceMarine execute(String args) throws InvalidFormException, IllegalArgumentsException {
        if (!args.isBlank()) throw new IllegalArgumentsException();
        SpaceMarine spaceMarine = new AskSpaceMarine(console).build();
        if (!spaceMarine.validate()) throw new InvalidFormException();
        return spaceMarine;
    }
}
