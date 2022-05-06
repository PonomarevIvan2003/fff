package lab5.client.commands;

import lab5.client.exceptions.NumberOutOfBoundsException;
import lab5.client.util.CollectionManager;
import lab5.client.util.ValidationClass;

import java.util.Scanner;

public class RemoveKeyCommand extends Command{
    public RemoveKeyCommand(){
        parametersCount = 1;
        setParameters("key");
    }
    @Override
    public String getName(){
        return "remove_key";
    }
    @Override
    public String getInfo(){
        return "Удаляет элемент из коллекции по ключу.";
    }
    public void execute(String s, Scanner scanner) throws NumberOutOfBoundsException {
        s = s.split(" ")[1];
        ValidationClass.checkLong(s, false, true, Long.MIN_VALUE);
        Long longKey = Long.valueOf(s);
        CollectionManager.remove(longKey);
        System.out.println(separatorString);
    }
}
