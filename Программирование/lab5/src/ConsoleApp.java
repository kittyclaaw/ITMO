import CommandProvider.CommandManager;

import static CommandProvider.Commands.Help.HelpCommand;
import static Cities.SimpleScanner.Scan;

public class ConsoleApp {
    public static void main(String[] args) {
        CommandManager server = new CommandManager();
        HelpCommand();

        while(true){
            server.CommandChecker(Scan());
        }
    }
}
