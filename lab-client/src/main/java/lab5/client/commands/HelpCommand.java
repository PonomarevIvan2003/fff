package lab5.client.commands;

import java.util.Scanner;

public class HelpCommand extends Command{
    public void HelpCommand(){
        parametersCount = 0;
    }
    @Override
    public String getName(){
        return "help";
    }
    @Override
    public String getInfo(){
        return "выводит справку по доступным командам";
    }
    @Override
    public void execute(String s, Scanner scanner){
        for (Command command : CommandManager.getCommands()){
            System.out.println(command.getName() + " - " + command.getInfo());
        }
        System.out.println(separatorString);
    }
}
