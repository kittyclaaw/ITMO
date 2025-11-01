package ru.rodion;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.rodion.commands.*;
import ru.rodion.managers.CollectionManager;
import ru.rodion.managers.CommandManager;
import ru.rodion.utility.DatabaseHandler;
import ru.rodion.utility.Server;

import java.util.List;

public class App extends Thread {


    public static int PORT = 6734;
    public static final Logger rootLogger = LogManager.getLogger(App.class);


    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();

        rootLogger.info("¯\\_(ツ)_/¯¯\\_(ツ)_/¯(◕‿◕)ЗАПУСК СЕРВЕРА В КОСМОС(◕‿◕)¯\\_(ツ)_/¯¯\\_(ツ)_/¯");


        CommandManager commandManager = new CommandManager(DatabaseHandler.getDatabaseManager());
        commandManager.addCommand(List.of(
                new Help(commandManager),
                new Show(collectionManager),
                new AddElement(collectionManager),
                new AddIfMin(collectionManager),
                new Clear(collectionManager),
                new ExecuteScript(),
                new Exit(),
                new History(commandManager),
                new Info(collectionManager),
                new UpdateId(collectionManager),
                new RemoveById(collectionManager),
                new AverageOfHeight(collectionManager),
                new PrintAsceding(collectionManager),
                new RemoveAllByWeaponType(collectionManager),
                new RemoveHead(collectionManager),
                new RemoveLower(collectionManager),
                new Ping(),
                new Register(DatabaseHandler.getDatabaseManager())

        ));
        App.rootLogger.debug("Создан объект менеджера команд");

        Server server = new Server(commandManager, DatabaseHandler.getDatabaseManager());
        App.rootLogger.debug("Создан объект сервера");

        server.run();

    }
}
