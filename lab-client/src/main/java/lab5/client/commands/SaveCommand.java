package lab5.client.commands;

import lab5.client.util.CollectionManager;
import lab5.client.util.Parser;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SaveCommand extends Command{
    public SaveCommand(){
        parametersCount = 0;
    }
    @Override
    public String getName(){
        return "save";
    }
    @Override
    public String getInfo(){
        return "сохраняет коллекцию в файл";
    }
    @Override
    public void execute(String s, Scanner scanner){
        Parser.writeTreeMapToFile(CollectionManager.getFlatCollection());
        System.out.println("Коллекция добавлена в файл 1.csv.");
        System.out.println(separatorString);
    }
}
