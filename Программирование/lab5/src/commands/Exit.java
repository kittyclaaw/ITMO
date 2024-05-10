package commands;

import utility.Console;

/**
 * Команда 'exit'. Завершает выполнение.
 */

public class Exit extends Command {
    private final Console console;

    public Exit(Console console) {
        super("exit", "завершить программу (без сохранения в файл)");
        this.console = console;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */

    public boolean apply(String[] args) {
        if (!args[1].isEmpty()) {
            console.println("Неправильное количество аргументов");
            console.println("Использование: '" + getName() + "'");
            return false;
        }

        console.println("Завершение выполнения");
        return true;
    }
}