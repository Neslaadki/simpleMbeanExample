package services;

import commands.Command;

import java.util.TreeMap;

public class Invoker {

    private final TreeMap<String, Command> commandMap = new TreeMap<>();

    public void setCommandMap(String commandName, Command command) {
        commandMap.put(commandName, command);

    }

    public TreeMap<String, Command> getCommandMap() {
        return commandMap;
    }

    public void execute(String commandName, TreeMap<String, Command> commandMap, PointsHandler handler, String... args)  {
        Command command = commandMap.get(commandName);
        if (command == null) throw new IllegalStateException("Команды с названием " + commandName + " не существует");
        command.execute(commandMap, handler, this, args);
    }

    public void execute(String commandName, TreeMap<String, Command> commandMap, PointsHandler handler)  {
        Command command = commandMap.get(commandName);
        if (command == null) throw new IllegalStateException("Команды с названием " + commandName + " не существует");
        command.execute(commandMap, handler, this);
    }



}
