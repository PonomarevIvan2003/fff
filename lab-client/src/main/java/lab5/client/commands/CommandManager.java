package lab5.client.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private static List<Command> commands = new ArrayList<>();

    public static void setCommands(){
        commands.add( new InsertCommand());
        commands.add(new ClearCommand());
        commands.add(new ShowCommand());
        commands.add(new RemoveKeyCommand());
        commands.add(new HelpCommand());
        commands.add(new InfoCommand());
        commands.add(new ExitCommand());
        commands.add(new SaveCommand());
        commands.add(new RemoveGreaterKeyCommand());
        commands.add(new RemoveLowerCommand());
        commands.add(new RemoveGreaterCommand());
        commands.add(new UpdateCommand());
        commands.add(new FilterLessThanNewnessCommand());
        commands.add(new FilterByTransportCommand());
        commands.add(new PrintFieldAscendingHeightCommand());
        commands.add(new ExecuteScriptCommand());
    }

    public static List<Command> getCommands(){
        return commands;
    }
}
