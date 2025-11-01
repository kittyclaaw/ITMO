package ru.rodion.commands;

import ru.rodion.exceptions.IllegalArgumentsException;
import ru.rodion.exceptions.InvalidFormException;
import ru.rodion.exceptions.NoCommandException;
import ru.rodion.models.SpaceMarine;

import java.util.HashMap;

public class CommandManager {

    private final HashMap<String, Command> commands = new HashMap<>();


    public void addCommand(Command command) {
        commands.put(command.getName(), command);
    }

    public boolean containsCommand(String name) {
        return commands.containsKey(name);
    }

    public Command getCommand(String name) {
        return commands.get(name);
    }


    public SpaceMarine execute(Command command, String args) throws NoCommandException, InvalidFormException, IllegalArgumentsException {
        Command execute_command = commands.get(command.getName());
        if (execute_command == null) {
            throw new NoCommandException();
        }
        return execute_command.execute(args);
    }
}