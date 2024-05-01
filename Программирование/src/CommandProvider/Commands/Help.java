package CommandProvider.Commands;

public class Help {

    /**
     * display help on available commands
     * */

    public static void HelpCommand() {
        System.out.println("\n====================\n");

        System.out.println("help: выводит справку по доступным командам");
        System.out.println("info: выводит в стандартный поток вывода информацию о коллекции");
        System.out.println("show: выводит в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element}: добавляет новый элемент в коллекцию");
        System.out.println("update id {element}: обновляет значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id: удаляет элемент из коллекции по его id");
        System.out.println("clear: очищает коллекцию");
        System.out.println("save: сохраняет коллекцию в файл");
        System.out.println("execute_script file_name: считает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit: завершает программу (без сохранения в файл)");
        System.out.println("add_if_max {element}: добавляет новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        System.out.println("add_if_min {element}: добавляет новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        System.out.println("remove_greater {element}: удаляет из коллекции все элементы, превышающие заданный");
        System.out.println("remove_any_by_car_code carCode: удаляет из коллекции один элемент, значение поля carCode которого эквивалентно заданному");
        System.out.println("count_less_than_standard_of_living standardOfLiving: выводит количество элементов, значение поля standardOfLiving которых меньше заданного");
        System.out.println("load - загрузить файл");

        System.out.println("\n====================\n");
    }
}
