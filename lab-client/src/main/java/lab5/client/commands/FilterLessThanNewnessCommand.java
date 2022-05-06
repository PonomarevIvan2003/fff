package lab5.client.commands;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lab5.client.data.Flat;
import lab5.client.util.CollectionManager;
import lab5.client.util.FieldSetterClass;
import lab5.client.util.ValidationClass;

import java.util.Objects;
import java.util.Scanner;

import org.apache.commons.lang3.BooleanUtils;

public class FilterLessThanNewnessCommand  extends Command{
    public FilterLessThanNewnessCommand(){
        parametersCount = 1;
    }
    @Override
    public String getName(){
        return "filter_less_than_newness";
    }
    @Override
    public String getInfo(){
        return "выводит элементы, значение поля newness которых меньше заданного";
    }
    @Override
    public void execute(String s, Scanner scanner){
        s = s.split(" ")[1];
        int counter = 0;
        ValidationClass.checkBoolean(s,true);
        Boolean newness = Boolean.valueOf(s);
        for (Flat flat : CollectionManager.getFlatCollection().values()){
            if(BooleanUtils.toInteger(flat.getNewness()) < BooleanUtils.toInteger(newness)){
                counter +=1;
                System.out.println(flat.toString());
            }
        }
        if (counter == 0){
            System.out.println("Подходящих элементов нет");
        }
        System.out.println(separatorString);
    }
}
