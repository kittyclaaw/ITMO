package ru.rodion.commands;


import ru.rodion.managers.CollectionManager;
import ru.rodion.models.SpaceMarine;
import ru.rodion.network.Request;
import ru.rodion.network.Response;
import ru.rodion.network.ResponseStatus;
import ru.rodion.utility.DatabaseHandler;

/**
 * Команда 'remove_head'
 * Выводит первый элемент коллекции и удаляет его
 */

public class RemoveHead extends Command implements CollectionEditor {
    private final CollectionManager collectionManager;

    public RemoveHead(CollectionManager collectionManager) {
        super("remove_head", " вывести первый элемент коллекции и удалить его");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request) {
        if (collectionManager.getCollection() == null || collectionManager.getCollection().isEmpty()) {
            return new Response(ResponseStatus.ERROR, "коллекш из емпти");
        } else {
            SpaceMarine spaceMarine = collectionManager.getCollection().poll();
            DatabaseHandler.getDatabaseManager().deleteObject(Math.toIntExact(spaceMarine.getId()), request.getUser());
            return new Response(ResponseStatus.OK, "данный элемент удалён: " + spaceMarine);
        }
    }


}
