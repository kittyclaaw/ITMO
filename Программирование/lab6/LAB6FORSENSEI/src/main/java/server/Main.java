package server;
import global.tools.Console;
import server.commands.*;
import global.tools.StandartConsole;
import server.commands.Add;
import server.commands.Clear;
import server.managers.SocketServer;
import server.rulers.CollectionManager;
import server.rulers.CommandManager;
import server.tools.CSVparser;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        if (args.length < 2) {
            System.err.println("Usage: java -jar server.jar <dataFileName> <port>");
            return;
        }

        String dataFileName = args[0]; // Имя файла из аргумента
        int port; // Порт из аргумента
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Error: Port must be an integer.");
            return;
        }

        Console console = new StandartConsole();
        CSVparser csVparser = new CSVparser(dataFileName, console);
        CollectionManager collectionManager = new CollectionManager(csVparser);
        CommandManager commandManager = new CommandManager();
        if (!collectionManager.loadCollection()) {
            System.err.println("Error: Collection could not be loaded!");
            return;
        }

        commandManager.register("add", new Add(collectionManager));
        commandManager.register("clear", new Clear(console, collectionManager));
        commandManager.register("save", new Save(collectionManager));
        commandManager.register("show", new Show(console, collectionManager));
        commandManager.register("help", new Help(commandManager));
        commandManager.register("updateByID", new UpdateById(console, collectionManager));
        commandManager.register("history", new History(commandManager));
        commandManager.register("exit", new Exit());
        commandManager.register("info", new Info(collectionManager));
        commandManager.register("removeHead", new RemoveHead(collectionManager));
        commandManager.register("printAscending", new PrintAscending(console, collectionManager));
        commandManager.register("removeById", new RemoveById(console, collectionManager));
        commandManager.register("printFieldAscendingDistance", new PrintFieldAsсendingDistance(console, collectionManager));

        new SocketServer("localhost", port, commandManager).start(); // Использование заданного порта
    }
}



