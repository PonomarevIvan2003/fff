package lab5.client.commands;

import lab5.client.exceptions.NumberOutOfBoundsException;
import lab5.client.util.CollectionManager;
import lab5.client.util.ValidationClass;

import java.util.Scanner;

public class RemoveGreaterKeyCommand extends Command{
    public RemoveGreaterKeyCommand(){
        parametersCount = 1;
        setParameters("key");
    }
    @Override
    public String getName(){
        return "remove_greater_key";
    }
    @Override
    public String getInfo(){
        return "Удаляет из коллекции все элементы, ключ которых превышает заданный";
    }
    @Override
    public void execute(String s, Scanner scanner) throws NumberOutOfBoundsException {
        s =s.split(" ")[1];
        long counter = 0;
        ValidationClass.checkLong(s, false, true, Long.MIN_VALUE);
        Long longKey = Long.valueOf(s);
        for (Long k : CollectionManager.getFlatCollection().keySet()){
            if (longKey < k){
                CollectionManager.remove(k);
                counter+=1;
            }
        }
        System.out.println("Количество удаленных элементов - " + counter);
        System.out.println(separatorString);
    }

}
