package lab5.client.commands;

import lab5.client.data.Flat;
import lab5.client.exceptions.NumberOutOfBoundsException;
import lab5.client.exceptions.WrongAmountOfCoordinatesException;
import lab5.client.util.CollectionManager;
import lab5.client.util.UserInterface;

import java.util.Iterator;
import java.util.Scanner;

public class RemoveGreaterCommand extends Command{
    public RemoveGreaterCommand(){
        parametersCount = 0;
    }
    @Override
    public String getName(){
        return "remove_greater";
    }
    @Override
    public String getInfo(){
        return "Удаляет из коллекции элементы, больше, чем заданный";
    }
    @Override
    public void execute(String s, Scanner scanner) throws NumberOutOfBoundsException, WrongAmountOfCoordinatesException {
        Flat flat;
        int counter = 0;
        if(!s.isEmpty()){
            flat = UserInterface.getElement(scanner);
            Iterator<Flat> iterator = CollectionManager.getFlatCollection().values().iterator();
            while (iterator.hasNext()){
                Flat entry = iterator.next();
                if(entry.compareTo(flat) > 0){
                    iterator.remove();
                    counter+=1;
                }
            }
            System.out.println("Количество удаленных элементов = " + counter);
            System.out.println(separatorString);
        }
    }
}
