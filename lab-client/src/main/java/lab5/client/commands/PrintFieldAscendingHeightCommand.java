package lab5.client.commands;

import lab5.client.data.Flat;
import lab5.client.exceptions.NumberOutOfBoundsException;
import lab5.client.exceptions.WrongAmountOfCoordinatesException;
import lab5.client.util.CollectionManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class PrintFieldAscendingHeightCommand extends Command{
    public PrintFieldAscendingHeightCommand(){
        parametersCount = 0;
    }
    @Override
    public String getName(){
        return "print_field_ascending_height";
    }
    @Override
    public String getInfo(){
        return "Выводит значение поля height всех элементов коллекции.";
    }
    @Override
    public void execute(String s, Scanner scanner) throws NumberOutOfBoundsException, WrongAmountOfCoordinatesException {
        ArrayList<Long> list = new ArrayList<>();
        if (!CollectionManager.getFlatCollection().isEmpty()) {
            for (Map.Entry<Long, Flat> entry : CollectionManager.getFlatCollection().entrySet()) {
                list.add(entry.getKey());
            }
            Collections.sort(list);
            for (Long i : list) {
                System.out.println("У элемента с id = " + i + " height: " + CollectionManager.getFlatCollection().get(i).getHeight());
                System.out.println(separatorString);
            }
        }
        else{
            System.out.println("Коллекция пуста.");
        }
    }
}
