package ru.rodion.commands;

import ru.rodion.managers.CollectionManager;
import ru.rodion.network.Request;
import ru.rodion.network.Response;
import ru.rodion.network.ResponseStatus;
import ru.rodion.utility.DatabaseHandler;

public class AddToDB {

    public static Response Add(Request request, CollectionManager collectionManager){
        int new_id = DatabaseHandler.getDatabaseManager().addObject(request.getObject(), request.getUser());
        if (new_id == -1) return new Response(ResponseStatus.ERROR, "Объект добавить не удалось");
        request.getObject().setId((long) new_id);
        request.getObject().setUserLogin(request.getUser().name());
        collectionManager.addElement(request.getObject());
        return new Response(ResponseStatus.OK, "Объект успешно добавлен");
    }
}
