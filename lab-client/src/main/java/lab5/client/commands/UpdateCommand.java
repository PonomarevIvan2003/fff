package lab5.client.commands;

import lab5.client.data.Flat;
import lab5.client.exceptions.NumberOutOfBoundsException;
import lab5.client.exceptions.WrongAmountOfCoordinatesException;
import lab5.client.util.CollectionManager;
import lab5.client.util.UserInterface;
import lab5.client.util.ValidationClass;

import java.util.Scanner;
import java.util.TreeMap;

public class UpdateCommand extends Command{
    public UpdateCommand(){
        parametersCount = 1;
    }
    @Override
    public String getName(){
        return "update";
    }
    @Override
    public String getInfo(){
        return "Обновляет значение элемента коллекции с заданным id";
    }
    @Override
    public void execute(String s, Scanner scanner) throws NumberOutOfBoundsException, WrongAmountOfCoordinatesException {
        Flat flat = null;
        boolean isChanged = false;
        s = s.split(" ")[1];
        ValidationClass.checkLong(s, false, true,0L);
        Long longId = Long.valueOf(s);
        TreeMap<Long,Flat> flatCollection = CollectionManager.getFlatCollection();
        for(Long key: flatCollection.keySet()){
            if(flatCollection.get(key).getId().equals(longId)){
                isChanged = true;
                break;
            }
        }
        if (!isChanged){
            System.out.println("Не найден элемент с заданным id.");
        }
        else{
            flat = UserInterface.getElement(scanner);
        }
        for (Long key: flatCollection.keySet()){
            if(flatCollection.get(key).getId().equals(longId)){
                CollectionManager.add(key,flat);
                System.out.println("Элемент с ключом " + key + " был обновлен.");
                break;
            }
        }
        System.out.println(separatorString);
    }

}
