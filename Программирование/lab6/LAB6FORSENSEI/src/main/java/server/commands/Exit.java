package server.commands;
import global.facility.Response;
import global.facility.Route;

/**
 * Команда выхода
 */
public class Exit extends Command  {


    public Exit(){
        super("exit","завершить программу");
    }
    /**
     * Метод выполняет команду
     *
     * @return возвращает сообщение об успешности выполнения команды
     */
    @Override
    public Response apply(String[] arguments , Route ticket){
        if(!arguments[1].isEmpty()){
            console.println("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
            return new Response("");
        }

        console.println("завершение программы");
        System.exit(1);
        return new Response("");
    }

}