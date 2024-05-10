package commands;

import utility.Console;

/**
 * Команда 'execute_script'. Выполнить скрипт из файла.
 */

public class ExecuteScript extends Command {
    private final Console console;

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */

    public ExecuteScript(Console console) {
        super("execute_script file_name", "исполнить скрипт из указанного файла");
        this.console = console;
    }

    public boolean apply(String[] args) {
        if (args[1].isEmpty()) {
            console.println("Неправильное количество аргументов");
            console.println("Использование: '" + getName() + "'");
            return false;
        }

        console.println("Выполнение скрипта '" + args[1] + "'");
        return true;
    }
}
