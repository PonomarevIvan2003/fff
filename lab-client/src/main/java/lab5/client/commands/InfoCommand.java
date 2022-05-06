package lab5.client.commands;

import lab5.client.util.CollectionManager;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InfoCommand extends Command{
    public InfoCommand(){
        parametersCount = 0;
    }
    @Override
    public String getName(){
        return "info";
    }
    @Override
    public String getInfo(){
        return "Выводит информацию о коллекции.";
    }
    @Override
    public void execute(String s, Scanner scanner){
        System.out.println("Тип - " + CollectionManager.getType());
        System.out.println("Дата инициализации - " + CollectionManager.getInitTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("Количество элементов - " + CollectionManager.getFlatCollection().size());
    }
}
