package lab5.client.commands;

import lab5.client.exceptions.NumberOutOfBoundsException;
import lab5.client.exceptions.WrongAmountOfCoordinatesException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class Command {
    boolean isElementRequired;

    List<String> parameters = new ArrayList<>();
    //Строка для разделения выводов.
    public final String separatorString = "-----------------------";

    protected int parametersCount;

    public int getParametersCount(){
        return parametersCount;
    }

    public abstract String getName();

    public abstract String getInfo();

    public abstract void execute(String s, Scanner scanner) throws NumberOutOfBoundsException, WrongAmountOfCoordinatesException;

    void setParameters(String...param){
        parameters.addAll(Arrays.asList(param));
    }
    public String getParameters(){
        String conc ="";
        for(String s : parameters){
            conc = conc + s + " ";
        }
        return conc;
    }
}
