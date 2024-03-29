package CommandProvider;

import Data.DataProvider;
import Cities.City;

import java.util.LinkedHashSet;
import java.util.LinkedList;

import static CommandProvider.Commands.Add.AddCommand;
import static CommandProvider.Commands.AddMax.AddMaxCommand;
import static CommandProvider.Commands.AddMin.AddMinCommand;
import static CommandProvider.Commands.Clear.ClearCommand;
import static CommandProvider.Commands.Count.CountLessCommand;
import static CommandProvider.Commands.Help.HelpCommand;
import static CommandProvider.Commands.Info.InfoCommand;
import static CommandProvider.Commands.Remove.RemoveCommand;
import static CommandProvider.Commands.RemoveCode.RemoveCodeCommand;
import static CommandProvider.Commands.RemoveGreater.RemoveGreaterCommand;
import static CommandProvider.Commands.Show.ShowCommand;
import static CommandProvider.Commands.Update.UpdateCommand;
import static CommandProvider.Commands.Execute.ExecuteScriptCommand;
import static CommandProvider.Commands.Print.PrintCommand;

public class CommandManager {
    private DataProvider dp = new DataProvider();
    private LinkedHashSet<City> collection = new LinkedHashSet<City>();
    LinkedList commandList = new LinkedList();
    CompareCity CSM = new CompareCity();

    public void CommandChecker(String userString) {

        String[] commandToWords = userString.split(" ");
        String command = commandToWords[0];
        if (command.equals("help") && commandToWords.length == 1) {
            HelpCommand();
            addCommand(command);
        } else if (command.equals("info") && commandToWords.length == 1) {
            InfoCommand(collection);
            addCommand(command);
        }else if (command.equals("save") && commandToWords.length==1) {
            //dp.Save(collection, SaveCommand(collection));
            System.out.println("Сохранено");
            addCommand(command);
        } else if (command.equals("add") && commandToWords.length == 1) { //не совсем понятно, что за элемент надо добавлять по этому мы создаем его
            AddCommand(collection, CSM);
            addCommand(command);
        } else if (command.equals("show") && commandToWords.length == 1) {
            ShowCommand(collection);
            addCommand(command);
        } else if (command.equals("print_ascending ") && commandToWords.length == 1) {
            PrintCommand(collection);
            addCommand(command);
        } else if(command.equals("count_less_than_standard_of_living") && commandToWords.length==2){
            CountLessCommand(collection, commandToWords[1]);
            addCommand(command);
        }else if (command.equals("clear") && commandToWords.length == 1) {
            ClearCommand(collection);
            addCommand(command);
        } else if (command.equals("update") && commandToWords.length == 3) {
            UpdateCommand(collection, commandToWords);
            addCommand(command);
        } else if (command.equals("remove_by_id") && commandToWords.length == 2) {
            RemoveCommand(collection, commandToWords);
            addCommand(command);
        } else if (command.equals("remove_greater") && commandToWords.length == 2) {
            RemoveGreaterCommand(collection, commandToWords);
            addCommand(command);
        } else if (command.equals("remove_any_by_car_code") && commandToWords.length == 2) {
            RemoveCodeCommand(collection, commandToWords);
            addCommand(command);
        } else if (command.equals("exit") && commandToWords.length == 1) {
            System.exit(0);
            addCommand(command);
        } else if(command.equals("add_if_max") && commandToWords.length==1){
            AddMaxCommand(collection);
            addCommand(command);
        } else if(command.equals("add_if_min") && commandToWords.length==1){
            AddMinCommand(collection);
            addCommand(command);
        }else if(command.equals("cls") && commandToWords.length==1){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }else if(userString.replaceAll(" ", "")==""){
            System.out.print("");
        }else if(command.equals("execute_script") && commandToWords.length==2){
            ExecuteScriptCommand(commandToWords[1], dp);
            addCommand(command);
        }else{
            System.out.println("Такой команды нет. Введите help для списка команд");
        }
    }
    private void addCommand(String command) {
        if (commandList.size() == 6) {
            commandList.removeFirst();
        }
        commandList.addLast(command);
    }
}