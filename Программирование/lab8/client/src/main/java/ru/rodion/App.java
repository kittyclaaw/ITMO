package ru.rodion;


import ru.rodion.commandLine.ConsoleOutput;
import ru.rodion.commandLine.PrintConsole;
import ru.rodion.commandLine.Printable;
import ru.rodion.commands.*;
import ru.rodion.exceptions.IllegalArgumentsException;
import ru.rodion.gui.GuiManager;
import ru.rodion.utility.Client;

public class App {
    private static String host;
    private static int port;
    private static Printable console = new PrintConsole();

    private static CommandManager commandManager = new CommandManager();

    public static CommandManager getCommandManager() {
        return commandManager;
    }

    public static boolean parseHostPort(String[] args) {
        try {
            if (args.length != 2) throw new IllegalArgumentsException("Передайте хост и порт в аргументы " +
                    "командной строки в формате <host> <port>");
            host = args[0];
            port = Integer.parseInt(args[1]);
            if (port < 0) throw new IllegalArgumentsException("Порт должен быть натуральным числом");
            return true;
        } catch (IllegalArgumentsException e) {
            console.printError(e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        if (!parseHostPort(args)) return;


        console = new ConsoleOutput();
        Client client = new Client(host, port, console);
        commandManager.addCommand(new Add(console));
        commandManager.addCommand(new Update(console));
        commandManager.addCommand(new AddIfMin(console));
        commandManager.addCommand(new RemoveLower(console));

        new GuiManager(client);
    }
}
