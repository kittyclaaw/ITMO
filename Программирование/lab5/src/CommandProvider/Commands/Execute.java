package CommandProvider.Commands;

import CommandProvider.CommandManager;
import Data.DataProvider;
import java.util.LinkedHashSet;

public class Execute {
    public static void ExecuteScriptCommand(String fileName, DataProvider dp){

        LinkedHashSet<String> lines = dp.LoadScript(fileName);
        CommandManager cm = new CommandManager();

        for(String s: lines){
            cm.CommandChecker(s);
        }
    }
}
