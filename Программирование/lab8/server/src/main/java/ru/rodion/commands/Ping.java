package ru.rodion.commands;


import ru.rodion.exceptions.IllegalArgumentsException;
import ru.rodion.network.Request;
import ru.rodion.network.Response;
import ru.rodion.network.ResponseStatus;

/**
 * Команда 'ping'
 * пингануть сервак
 */
public class Ping extends Command {
    public Ping() {
        super("ping", ": пингануть сервер");
    }

    /**
     * Исполнить команду
     *
     * @param request запрос клиента
     * @throws ru.rodion.exceptions.IllegalArgumentsException неверные аргументы команды
     */
    @Override
    public Response execute(Request request) throws IllegalArgumentsException {
        return new Response(ResponseStatus.OK, "pong");
    }
}
