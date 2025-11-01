package ru.rodion.commands;


import ru.rodion.exceptions.IllegalArgumentsException;
import ru.rodion.managers.CollectionManager;
import ru.rodion.network.Request;
import ru.rodion.network.Response;
import ru.rodion.network.ResponseStatus;

/**
 * Команда 'info'
 * Выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 */
public class Info extends Command {
    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        super("info", ": вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
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
        String lastInitTime = (collectionManager.getLastInitTime() == null)
                ? "В сессии коллекция не инициализирована"
                : collectionManager.getLastInitTime();
        String lastSaveTime = (collectionManager.getLastSaveTime() == null)
                ? "В сессии коллекция не инициализирована "
                : collectionManager.getLastSaveTime();
        String stringBuilder = "Сведения о коллекции: \n" +
                "Тип: " + collectionManager.collectionType() + "\n" +
                "Количество элементов: " + collectionManager.collectionSize() + "\n" +
                "Дата последней инициализации: " + lastInitTime + "\n" +
                "Дата последнего изменения: " + lastSaveTime + "\n";
        return new Response(ResponseStatus.OK, stringBuilder);
    }
}
