package ru.rodion.commands;


import ru.rodion.exceptions.IllegalArgumentsException;
import ru.rodion.managers.CollectionManager;
import ru.rodion.models.SpaceMarine;
import ru.rodion.network.Request;
import ru.rodion.network.Response;
import ru.rodion.network.ResponseStatus;

import java.util.Collection;

/**
 * Команда 'show'
 * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class Show extends Command {
    private final CollectionManager collectionManager;


    public Show(CollectionManager collectionManager) {
        super("show", ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager = collectionManager;

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
        Collection<SpaceMarine> collection = collectionManager.getCollection();
        if (collection == null || collection.isEmpty()) {
            return new Response(ResponseStatus.ERROR, "Коллекция еще не инициализирована");
        }
        return new Response(ResponseStatus.OK, "Коллекция: ", collection);
    }
}
