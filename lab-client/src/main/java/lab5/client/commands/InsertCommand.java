package lab5.client.commands;

import lab5.client.data.Flat;
import lab5.client.exceptions.NumberOutOfBoundsException;
import lab5.client.exceptions.WrongAmountOfCoordinatesException;
import lab5.client.util.UserInterface;

import java.util.Scanner;
import lab5.client.util.*;

public class InsertCommand extends Command{
    public InsertCommand(){
        isElementRequired = true;
        parametersCount = 1;
        setParameters("key");
    }
    @Override
    public String getName(){
        return "insert";
    }

    @Override
    public String getInfo(){
        return "добавляет новый элемент в коллекцию";
    }
    @Override
    public void execute(String s, Scanner scanner) throws NumberOutOfBoundsException, WrongAmountOfCoordinatesException{
        Flat flat = UserInterface.getElement(scanner);
        s = s.split(" ")[1];
        ValidationClass.checkLong(s,false, true, Long.MIN_VALUE);
        if (flat == null){
            System.out.println("Ввод элемента прекращен пользователем.");
        }else{
            Long longKey = Long.valueOf(s);
            CollectionManager.add(longKey, flat);
            System.out.println("Элемент было добавлен в коллекцию");
            System.out.println(separatorString);


        }
    }

}
