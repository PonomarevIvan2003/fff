package lab5.client.commands;

import lab5.client.data.Flat;
import lab5.client.util.CollectionManager;

import java.util.Scanner;

public class ShowCommand extends Command{
    public ShowCommand(){
        parametersCount = 0;
    }
    @Override
    public String getName(){
        return "show";
    }
    @Override
    public String getInfo(){
        return "Выводит все элементы коллекции в строковом представлении";
    }
    public void execute(String s, Scanner scanner){
        if(CollectionManager.getFlatCollection().size() == 0){
            System.out.println("На данный момент в коллекции нет элементов.");
        }
        for (Flat flat: CollectionManager.getFlatCollection().values()){
            System.out.println(flat.toString());
            System.out.println();
        }
        System.out.println(separatorString);
    }
}
