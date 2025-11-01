package ru.rodion.commands;


import ru.rodion.exceptions.IllegalArgumentsException;
import ru.rodion.managers.CommandManager;
import ru.rodion.network.Request;
import ru.rodion.network.Response;
import ru.rodion.network.ResponseStatus;

/**
 * Команда 'help'
 * Вывести справку по доступным командам
 */
public class Help extends Command {
    private final CommandManager commandManager;


    public Help(CommandManager commandManager) {
        super("help", ": вывести справку по доступным командам");
        this.commandManager = commandManager;

    }

    /**
     * Исполнить команду
     *
     * @param request аргументы команды
     * @throws IllegalArgumentsException неверные аргументы команды
     */

    @Override
    public Response execute(Request request) throws IllegalArgumentsException {
        if (!request.getArgs().isBlank()) throw new IllegalArgumentsException();
        return new Response(ResponseStatus.OK,
                String.join("\n",
                        commandManager.getCommands()
                                .stream().map(Command::toString).toList()));
    }
}