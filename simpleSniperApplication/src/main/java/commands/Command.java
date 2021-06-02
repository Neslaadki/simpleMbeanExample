package commands;

import services.Invoker;
import services.PointsHandler;

import java.util.TreeMap;

public class Command {

    private String name;
    private String description;
    private String args = "";


    public void execute(TreeMap<String, Command> hashMap, PointsHandler handler,
                        Invoker commandManager, String... args) {
    }
    public void execute(TreeMap<String, Command> hashMap, PointsHandler handler,
                        Invoker commandManager){

    }

    public String getArgs() {
        return args;
    }

    public String getDescription() {
        return description;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
