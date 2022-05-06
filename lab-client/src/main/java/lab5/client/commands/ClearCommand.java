package lab5.client.commands;

import lab5.client.util.CollectionManager;

import java.util.Scanner;

public class ClearCommand extends Command{
    public ClearCommand(){
        parametersCount = 0;
        setParameters();
    }
    @Override
    public String getName(){
        return "clear";
    }
    @Override
    public String getInfo(){
        return "очищает коллекцию";
    }
    public void execute(String s, Scanner scanner){
        CollectionManager.clear();
        System.out.println("Коллекция очищена");
        System.out.println(separatorString);
    }
}
